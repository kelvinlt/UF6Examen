package leekelvinuf6pe1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import objectes.Client;
import objectes.Producte;

public class LeeKelvinUf6Pe1 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int opcionObj = 0;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LeePU");
        EntityManager em = emf.createEntityManager();

        try {
            while (opcionObj != 6) {
                mmenu();
                opcionObj = Integer.parseInt(br.readLine());
                System.out.println("------------------------------------------------------------------------");

                switch (opcionObj) {
                    case 1:

                        System.out.println("1-Afegir un nou Producte");
                        System.out.println("Introdueix un nom:");
                        String nPNom = br.readLine();
                        System.out.println("Introdueix un preu:");
                        Double nPPreu = Double.parseDouble(br.readLine());

                        if (producteRepetit(em, nPNom) == true) {
                            System.out.println("Ya existeix un producte aixi en la base de dades");
                        } else {
                            Producte nProducte = new Producte(nPNom, nPPreu);
                            em.getTransaction().begin();
                            em.persist(nProducte);
                            em.getTransaction().commit();
                        }

                        break;
                    case 2:
                        System.out.println("2-Afegir un nou Client");
                        System.out.println("Introdueix un nom:");
                        String nCNom = br.readLine();

                        Client nCLient = new Client(nCNom);
                        em.getTransaction().begin();
                        em.persist(nCLient);
                        em.getTransaction().commit();
                        break;
                    case 3:
                        System.out.println("3-Afegir una nova Comanda");

                        break;
                    case 4:
                        System.out.println("4-Llistar tots els Productes");

                        TypedQuery<Producte> consulta = em.createQuery("SELECT t FROM Producte t", Producte.class);
                        List<Producte> Productes = consulta.getResultList();

                        for (Producte t : Productes) {
                            System.out.println(t.getNom());
                        }

                        break;
                    case 5:
                        System.out.println("5-Llistar les dades d'un Client i totes les seves Comandes");

                        break;
                    case 6:
                        System.out.println("6-Sortida del programa");

                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void mmenu() {
        System.out.println("------------------------------------------------------------------------");
        System.out.println("---------------------------Menu Principal-------------------------------");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("1-Afegir un nou Producte");
        System.out.println("2-Afegir un nou Client");
        System.out.println("3-Afegir una nova Comanda");
        System.out.println("4-Llistar tots els Productes");
        System.out.println("5-Llistar les dades d'un Client i totes les seves Comandes");
        System.out.println("6-Sortida del programa");
        System.out.println("------------------------------------------------------------------------");
    }

    public static boolean producteRepetit(EntityManager em, String nom) {
        TypedQuery<Producte> findByNameProducte = em.createNamedQuery("Producte.findByNom", Producte.class);
        Producte algo = null;
       // algo = findByNameProducte.setParameter("nom", nom).getResultList();
        System.out.println("algo");
        if(algo == null) {
            return false;
        }else {
            return true;
        }
    }
}

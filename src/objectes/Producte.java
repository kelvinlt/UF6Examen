/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectes;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author x2382383c
 */
@Entity
@Table(name = "producte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producte.findAll", query = "SELECT p FROM Producte p")
    , @NamedQuery(name = "Producte.findByNom", query = "SELECT p FROM Producte p WHERE p.nom = :nom")
    , @NamedQuery(name = "Producte.findByPreu", query = "SELECT p FROM Producte p WHERE p.preu = :preu")})
public class Producte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @Column(name = "preu")
    private double preu;

    public Producte() {
    }

    public Producte(String nom) {
        this.nom = nom;
    }

    public Producte(String nom, double preu) {
        this.nom = nom;
        this.preu = preu;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nom != null ? nom.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producte)) {
            return false;
        }
        Producte other = (Producte) object;
        if ((this.nom == null && other.nom != null) || (this.nom != null && !this.nom.equals(other.nom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "objectes.Producte[ nom=" + nom + " ]";
    }
    
}

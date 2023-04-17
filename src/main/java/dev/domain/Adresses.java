package dev.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "ADRESSE")

public class Adresses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAdr;
    @Column(name = "VILLE")
    private String ville;
    @Column(name = "ETAT")
    private String etat;
    @Column(name = "PAYS")
    private String pays;


    public Adresses() {
    }

    public Adresses(Integer idAdr, String ville, String etat, String pays) {
        this.idAdr = idAdr;
        this.ville = ville;
        this.etat = etat;
        this.pays = pays;
    }

    public Integer getId() {
        return idAdr;
    }

    public void setId(Integer idAdr) {
        this.idAdr = idAdr;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "idAdr=" + idAdr +
                ", ville='" + ville + '\'' +
                ", etat='" + etat + '\'' +
                ", pays='" + pays + '\'' +
                '}';
    }
}
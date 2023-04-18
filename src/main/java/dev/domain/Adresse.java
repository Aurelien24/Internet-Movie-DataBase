package dev.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ADRESSE")

public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "VILLE")
    private String ville;
    @Column(name = "ETAT")
    private String etat;
    @Column(name = "PAYS")
    private String pays;





    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "adresse")
    private List<Acteur> acteur = new ArrayList<>();









    public Adresse() {
    }

    public Adresse(Integer idAdr, String ville, String etat, String pays) {
        this.id = idAdr;
        this.ville = ville;
        this.etat = etat;
        this.pays = pays;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer idAdr) {
        this.id = idAdr;
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
                "idAdr=" + id +
                ", ville='" + ville + '\'' +
                ", etat='" + etat + '\'' +
                ", pays='" + pays + '\'' +
                '}';
    }
}
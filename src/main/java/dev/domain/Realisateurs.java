package dev.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "REALISATEURS")
public class Realisateurs extends Personnes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRea;

    public Realisateurs() {
    }


    public Realisateurs(Integer id, String nom, String prenom, String url, Integer idRea) {
        super(id, nom, prenom, url);
        this.idRea = idRea;
    }

    public Integer getIdRea() {
        return idRea;
    }

    public void setIdRea(Integer idRea) {
        this.idRea = idRea;
    }

    @Override
    public String toString() {
        return "Realisateur{" +
                "idRea=" + idRea +
                '}';
    }
}
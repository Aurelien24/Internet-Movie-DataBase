package dev.domain;

import jakarta.persistence.*;

@Entity
@Table (name = "LANGUES")
public class Langues {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idL;

    @Column(name = "LIBELLE")
    private String libL;


    public Langues() {
    }

    public Langues(Integer idL, String libL) {
        this.idL = idL;
        this.libL = libL;
    }

    public Integer getIdL() {
        return idL;
    }

    public void setIdL(Integer idL) {
        this.idL = idL;
    }

    public String getLibL() {
        return libL;
    }

    public void setLibL(String libL) {
        this.libL = libL;
    }

    @Override
    public String toString() {
        return "Langue{" +
                "idL=" + idL +
                ", libL='" + libL + '\'' +
                '}';
    }
}
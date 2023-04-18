package dev.domain;

import jakarta.persistence.*;

@Entity
@Table (name = "LANGUES")
public class Langue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "LIBELLE")
    private String libL;


    public Langue() {
    }

    public Langue(Integer id, String libL) {
        this.id = id;
        this.libL = libL;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer idL) {
        this.id = idL;
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
                "idL=" + id +
                ", libL='" + libL + '\'' +
                '}';
    }
}
package dev.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "GENRES")
public class Genres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "LIBELLE")
    private String libG;

    public Genres() {
    }

    public Genres(Integer id, String libG) {
        this.id = id;
        this.libG = libG;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibG() {
        return libG;
    }

    public void setLibG(String libG) {
        this.libG = libG;
    }
}
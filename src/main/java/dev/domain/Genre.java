package dev.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "GENRES")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "LIBELLE")
    private String lib;

    public Genre() {
    }

    public Genre(Integer id, String lib) {
        this.id = id;
        this.lib = lib;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLib() {
        return lib;
    }

    public void setLib(String libG) {
        this.lib = libG;
    }
}
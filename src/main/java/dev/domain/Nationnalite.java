package dev.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@Entity
@Table (name = "NATIONNALITE")
public class Nationnalite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "LIBELLE")
    private String libN;

    @Column(name = "URL")
    private String urlN;



    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "nationnalite")
    private List<Film> film = new ArrayList<>();




    public Nationnalite() {
    }

    public Nationnalite(Integer id, String libN, String urlN) {
        this.id = id;
        this.libN = libN;
        this.urlN = urlN;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibN() {
        return libN;
    }

    public void setLibN(String libN) {
        this.libN = libN;
    }

    public String getUrlN() {
        return urlN;
    }

    public void setUrlN(String urlN) {
        this.urlN = urlN;
    }

    @Override
    public String toString() {
        return "Nationnalite{" +
                "id=" + id +
                ", libN='" + libN + '\'' +
                ", urlN='" + urlN + '\'' +
                '}';
    }
}

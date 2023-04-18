package dev.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "FILMS")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NOM")
    private String nom;
    @Column(name = "ANNEE")
    private String annee;
    @Column(name = "URL")
    private String url;
    @Column(name = "DESCRIPTION")
    private String desc;


    public Film() {
    }

    public Film(Integer id, String nom, String annee, String url, String desc) {
        this.id = id;
        this.nom = nom;
        this.annee = annee;
        this.url = url;
        this.desc = desc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer idFilm) {
        this.id = idFilm;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nomF) {
        this.nom = nomF;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String anneeF) {
        this.annee = anneeF;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String urlF) {
        this.url = urlF;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String descF) {
        this.desc = descF;
    }

    @Override
    public String toString() {
        return "Film{" +
                "idFilm=" + id +
                ", nomF='" + nom + '\'' +
                ", anneeF='" + annee + '\'' +
                ", urlF='" + url + '\'' +
                ", descF='" + desc + '\'' +
                '}';
    }
}
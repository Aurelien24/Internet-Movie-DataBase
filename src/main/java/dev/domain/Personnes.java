package dev.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "PERSONNE")
public class Personnes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPers;
    @Column(name = "NOM")
    private String nom;
    @Column(name = "PRENOM")
    private String prenom;
    @Column(name = "URL")
    private String url;

    public Personnes() {
    }

    public Personnes(Integer idPers, String nom, String prenom, String url) {
        this.idPers = idPers;
        this.nom = nom;
        this.prenom = prenom;
        this.url = url;
    }

    public Integer getId() {
        return idPers;
    }

    public void setId(Integer id) {
        this.idPers = idPers;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "idPers=" + idPers +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
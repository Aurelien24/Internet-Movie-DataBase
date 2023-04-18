package dev.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "PERSONNE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "NOM")
    private String nom;
    @Column(name = "PRENOM")
    private String prenom;
    @Column(name = "URL")
    private String url;

    public Personne() {
    }

    public Personne(String nom, String prenom, String url) {
    }

    public Personne(Integer id, String nom, String prenom, String url) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = this.id;
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
                "idPers=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
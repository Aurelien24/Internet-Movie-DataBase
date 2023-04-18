package dev.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "ACTEURS")
public class Acteur extends Personne {

    @Column (name = "dateNaiss")
    private Date dateNaiss;

    public Acteur() {
    }

    public Acteur(Date dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public Acteur(Integer idPers, String nom, String prenom, String url) {
        super(idPers, nom, prenom, url);
    }

    public Acteur(String nom, String prenom, String url, Integer idAct, Date dateNaiss) {
        super(nom, prenom, url);
        this.dateNaiss = dateNaiss;
    }

    public Date getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(Date dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    @Override
    public String toString() {
        return "Acteur{" +
                ", dateNaiss=" + dateNaiss +
                '}';
    }
}
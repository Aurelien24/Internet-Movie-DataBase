package dev.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "ACTEURS")
public class Acteurs extends Personnes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAct;

    @Column (name = "dateNaiss")
    private Date dateNaiss;

    public Acteurs() {
    }

    public Acteurs(Integer id, String nom, String prenom, String url, Integer idAct, Date dateNaiss) {
        super(id, nom, prenom, url);
        this.idAct = idAct;
        this.dateNaiss = dateNaiss;
    }

    @Override
    public Integer getId() {
        return idAct;
    }

    @Override
    public void setId(Integer idAct) {
        this.idAct = idAct;
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
                "idAct=" + idAct +
                ", dateNaiss=" + dateNaiss +
                '}';
    }
}
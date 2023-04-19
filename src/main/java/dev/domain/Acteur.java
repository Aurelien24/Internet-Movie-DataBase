package dev.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ACTEURS")
public class Acteur extends Personne {

    @Column (name = "dateNaiss")
    private Date dateNaiss;




    @ManyToOne
    @JoinColumn(name = "adresse_id")
    private Adresse adresse;

    @ManyToMany
    @JoinTable(
            name = "CASTING",
            joinColumns = @JoinColumn(name = "films_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "acteurs_id", referencedColumnName = "id")
    )
    private Set<Film> film;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "acteur")
    private List<Role> role = new ArrayList<>();



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
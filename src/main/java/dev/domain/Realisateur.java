package dev.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "REALISATEURS")
public class Realisateur extends Personne {

    @ManyToMany
    @JoinTable(
        name = "realiser",
        joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "realisateurs_id", referencedColumnName = "id")
    )
    private Set<Film> film;

}
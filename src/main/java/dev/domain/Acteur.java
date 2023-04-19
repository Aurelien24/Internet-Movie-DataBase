package dev.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class Acteur extends Personne{

    @Column(name = "dateNaiss")
    private String dateNaiss;









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


}
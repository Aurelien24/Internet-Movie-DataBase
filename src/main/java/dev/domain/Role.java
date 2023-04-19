package dev.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.io.Serializable;

@Entity
@Table(name = "ROLES")
public class Role {

    @EmbeddedId
    RoleKey id;

    @ManyToOne
    @MapsId("film_id")
    @JoinColumn(name = "films_id")
    Film film;

    @ManyToOne
    @MapsId("acteur_id")
    @JoinColumn(name = "acteurs_id")
    Acteur acteur;

    String nom_personnage;





}
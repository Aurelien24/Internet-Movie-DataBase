package dev.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Embeddable
public class RoleKey implements Serializable{
    @Column(name = "film_id")
    Integer film_id;

    @Column(name = "acteur_id")
    Integer acteur_id;
}

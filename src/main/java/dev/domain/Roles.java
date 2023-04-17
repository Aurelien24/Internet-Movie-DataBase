package dev.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "ROLES")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


}
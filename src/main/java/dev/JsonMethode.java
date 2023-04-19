package dev;

import dev.domain.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.Date;

public class JsonMethode {
    public void addFilm(Integer id, Nationnalite nationnalite, String nom, String annee, String url, String desc){
        // + Une langue, une nationnalité
        System.out.println("Ajout de film en cours !");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mainPersistence");
        System.out.println("Entity Manager Factory Fait !");
        EntityManager em = entityManagerFactory.createEntityManager();

        Film film = new Film();
        //Nationnalite nationnalite1 = new Nationnalite();
        film.setId(id);
        nationnalite.setId(id);
        film.setNom(nom);
        film.setAnnee(annee);
        film.setUrl(url);
        film.setDesc(desc);

        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(film);
        et.commit();
        em.close();
    }

    public void addLangue(String libelle){
        System.out.println("Ajout de langue !");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mainPersistence");
        System.out.println("Entity Manager Factory Fait !");
        EntityManager em = entityManagerFactory.createEntityManager();

        Langue langue = new Langue();
        langue.setLibL(libelle);

        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(langue);
        et.commit();
        em.close();
    }

    public void addGenre(String[] genres){
        System.out.println("Ajout de Genre !");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mainPersistence");
        System.out.println("Entity Manager Factory Fait !");
        EntityManager em = entityManagerFactory.createEntityManager();

        EntityTransaction et = em.getTransaction();
        et.begin();

        for (String lib : genres){
            Genre genre = new Genre();
            genre.setLib(lib);
            em.persist(genre);
        }

        et.commit();
        em.close();
    }

    public void addAdresse(String ville, String etat, String pays){
        System.out.println("Ajout d'adresse !");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mainPersistence");
        System.out.println("Entity Manager Factory Fait !");
        EntityManager em = entityManagerFactory.createEntityManager();

        Adresse adresse = new Adresse();
        adresse.setEtat(etat);
        adresse.setPays(pays);
        adresse.setVille(ville);

        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(adresse);
        et.commit();
        em.close();
    }

    public void addActeur(Acteur personne, Date dateNaiss, Adresse adresse){
        System.out.println("Ajout d'une personne !");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mainPersistence");
        System.out.println("Entity Manager Factory Fait !");
        EntityManager em = entityManagerFactory.createEntityManager();

        //Acteur acteur = new Acteur();
       // acteur.set;
        //acteur.setPrenom(prenom);
        //acteur.setUrl(url);

        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(personne);
        et.commit();
        em.close();
    }

    public void addNation(String libelle, String url){
        System.out.println("Ajout d'une nationnalité !");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mainPersistence");
        System.out.println("Entity Manager Factory Fait !");
        EntityManager em = entityManagerFactory.createEntityManager();

        Nationnalite nationnalite = new Nationnalite();
        nationnalite.setLibN(libelle);
        nationnalite.setUrlN(url);

        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(nationnalite);
        et.commit();
        em.close();
    }

}


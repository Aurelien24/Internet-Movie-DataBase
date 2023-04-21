package dev;

import dev.domain.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.Date;

public class JsonMethode {
    public void addFilm(Integer id, Nationnalite nationnalite, String nom, String annee, String url, String desc){
        System.out.println("Ajout de film en cours !");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mainPersistence");
        System.out.println("Entity Manager Factory Fait !");
        EntityManager em = entityManagerFactory.createEntityManager();

        Film film = new Film();
        Nationnalite nationnalite1 = new Nationnalite();
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

    public static void addLangue(String libelle, EntityManager em){

        Langue lg = new Langue();
        lg.setLibL(libelle);

        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(lg);
        et.commit();


    }

    public void addGenre(String lib){
        System.out.println("Ajout de Genre !");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mainPersistence");
        System.out.println("Entity Manager Factory Fait !");
        EntityManager em = entityManagerFactory.createEntityManager();

        Genre genre = new Genre();
        genre.setLib(lib);

        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(genre);
        et.commit();
        em.close();
    }

    public void addAdresse(String ville, String pays, String etat){
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

    public void addActeur(Integer id, String nom, String prenom, String url){
        System.out.println("Ajout d'une personne !");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mainPersistence");
        System.out.println("Entity Manager Factory Fait !");
        EntityManager em = entityManagerFactory.createEntityManager();

        Personne personne = new Acteur();
        personne.setId(id);
        personne.setNom(nom);
        personne.setPrenom(prenom);
        personne.setUrl(url);

        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(personne);
        et.commit();
        em.close();
    }

    /*public void addActeur(Personne personne, Date dateNaiss, Adresse adresse){
        System.out.println("Ajout d'un acteur !");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mainPersistence");
        System.out.println("Entity Manager Factory Fait !");
        EntityManager em = entityManagerFactory.createEntityManager();

        Acteur acteur = new Acteur(dateNaiss);
        acteur.setDateNaiss(dateNaiss);

        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(acteur);
        et.commit();
        em.close();
    }*/

    public void addNation(Integer id, String libelle, String url){
        System.out.println("Ajout d'une nationnalité !");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mainPersistence");
        System.out.println("Entity Manager Factory Fait !");
        EntityManager em = entityManagerFactory.createEntityManager();

        Nationnalite nationnalite = new Nationnalite();
        nationnalite.setId(id);
        nationnalite.setLibN(libelle);
        nationnalite.setUrlN(url);

        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(nationnalite);
        et.commit();
        em.close();
    }

}

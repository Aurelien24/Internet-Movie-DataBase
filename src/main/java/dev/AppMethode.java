package dev;

import dev.domain.Acteurs;
import dev.domain.Langues;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class AppMethode {
    public void cree_langue(String langue){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mainPersistence");
        System.out.println("Entity Manager Factory Fait !");
        EntityManager em = entityManagerFactory.createEntityManager();

        //code
        Langues langueObjet = new Langues();
        langueObjet.setLibL(langue);

        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(langueObjet);
        et.commit();
        em.close();
    }

    public void filmographieActeur(String prenom, String nom){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mainPersistence");
        EntityManager em = entityManagerFactory.createEntityManager();

        // CODE
        em.find();

        EntityTransaction et = em.getTransaction();
        et.begin();
        //em.persist(langueObjet);
        et.commit();
        em.close();
    }

    public void castingFilm(String filme){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mainPersistence");
        EntityManager em = entityManagerFactory.createEntityManager();

        // CODE
        //em.find(Films.class, ID) -> Comment le faire avec le nom et non avec l'id? Comment obtenir l'id ?
        // Prendre tout les

        EntityTransaction et = em.getTransaction();
        et.begin();
        //em.persist(langueObjet);
        et.commit();
        em.close();
    }

    public void filmsSortisEntre(int année1, int année2){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mainPersistence");
        EntityManager em = entityManagerFactory.createEntityManager();

        // CODE

        EntityTransaction et = em.getTransaction();
        et.begin();
        //em.persist(langueObjet);
        et.commit();
        em.close();
    }

    public void  filmsCommuns(String acteur1Prenom, String acteur1Nom, String acteur2Prenom, String acteur2Nom){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mainPersistence");
        EntityManager em = entityManagerFactory.createEntityManager();

        // CODE

        EntityTransaction et = em.getTransaction();
        et.begin();
        //em.persist(langueObjet);
        et.commit();
        em.close();
    }

    public void acteursCommuns(String filmes1, String filmes2){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mainPersistence");
        EntityManager em = entityManagerFactory.createEntityManager();

        // CODE

        EntityTransaction et = em.getTransaction();
        et.begin();
        //em.persist(langueObjet);
        et.commit();
        em.close();
    }

    // Le point 6 Affichage des films sortis entre 2 années données et qui ont un acteur/actrice donné au
    //casting regroupe le 4 et le 5
}

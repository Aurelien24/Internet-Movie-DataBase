package dev;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class AppMethode {
    public void cree_langue(String langue){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mainPersistence");
        EntityManager em = entityManagerFactory.createEntityManager();

        //code
        Langue langueObjet = new Langue();
        langueObjet.setLangue(langue);

        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(langueObjet);
        et.commit();
        em.close();
    }

    public void filmographieActeur(){

    }

    public void castingFilm(){

    }

    public void filmsSortisEntre(){

    }

    public void  filmsCommuns(){

    }

    public void acteursCommuns(){

    }

    // Le point 6 Affichage des films sortis entre 2 années données et qui ont un acteur/actrice donné au
    //casting regroupe le 4 et le 5
}

package dev;

import dev.domain.Adresse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class AppMethode {
    public void cree_client(String nom, String prenom, int numero, String rue, int codePostal, String ville){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("formation-pu");
        EntityManager em = entityManagerFactory.createEntityManager();

        //code

        EntityTransaction et = em.getTransaction();
        et.begin();
        et.commit();
        em.close();
    }
}

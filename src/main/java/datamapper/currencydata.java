/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamapper;

import entity.Currency;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Emil
 */
public class currencydata {

    public static void createcurrecy(Currency cur) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ca3");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(cur);
        em.getTransaction().commit();
        em.close();
    }

    public static void flush() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ca3");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.flush();
        em.close();
    }
}

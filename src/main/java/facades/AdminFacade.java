/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author LouiseB
 */
public class AdminFacade
{
        public List<User> getUsers(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ca3");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        List<User> users = null;

        try
        {
            em.getTransaction().begin();
            users = em.createQuery("Select u from userName u").getResultList();
            em.getTransaction().commit();
            return users;
        } finally
        {
            em.close();
        }

    }
}

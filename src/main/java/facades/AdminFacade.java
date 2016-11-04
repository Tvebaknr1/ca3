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

    public List<User> getUsers()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ca3");
        EntityManager em = emf.createEntityManager();
        try
        {

            List<User> users;
            em.getTransaction().begin();
            users =  em.createQuery("Select u.Id, u.userName from User u").getResultList();
            return users;
        } finally
        {
            em.close();
        }

    }

    public void deleteuserbyid(int i)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ca3");
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            User user = em.find(User.class, i);
            em.remove(user);
            em.getTransaction().commit();

        } finally
        {
            em.close();
        }
    }
}

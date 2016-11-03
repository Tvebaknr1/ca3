/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamapper;

import entity.Currency;
import entity.User;
import facades.UserFacade;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import security.PasswordStorage;

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
}

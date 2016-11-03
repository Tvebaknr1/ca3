/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import datamapper.currencydata;
import entity.Currency;
import entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Emil
 */
public class currencyFacade {
    public static void createcurrency(Currency cur){
        currencydata.createcurrecy(cur);
    }
    public static List<Currency> getCurrency()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ca3");
        EntityManager em = emf.createEntityManager();
        try
        {

            List<Currency> currency = null;

            em.getTransaction().begin();
            currency =  em.createQuery("Select c.code, c.description, c.rate from Currency c").getResultList();
            return currency;
        } finally
        {
            em.close();
        }

    }
}

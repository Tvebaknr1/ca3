/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import com.google.gson.Gson;
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
            currency =  em.createQuery("Select c.code, c.description, c.rate from Currency c",Currency.class).getResultList();
            
            return currency;
        } finally
        {
            em.close();
        }
        

    }
    public static List<Currency> getnewCurrency()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ca3");
        EntityManager em = emf.createEntityManager();
        try
        {

            List<Currency> currency = null;

            em.getTransaction().begin();
            currency =  em.createQuery("from Currency c",Currency.class).getResultList();
            
            return currency;
        } finally
        {
            em.close();
        }
        

    }
    public static double convertCurrency(int i,String from,String to){
        List<Currency> cur = getnewCurrency();
        Currency curfrom = null;
        Currency curto = null;
        double res = 0;
        
        for (Currency currency : cur) {
            System.out.println(currency.getCode());
            if(currency.getDescription().equals(from))
            {
                curfrom = currency;
            }
            else if(currency.getDescription().equals(to))
            {
                curto = currency;
            }
            
        }
        if(curfrom!=null && curto!=null)
        {
            res = i * curfrom.getRate() / curto.getRate();
        }
        System.out.println(curfrom);
        System.out.println(curto);
        return res;
    }
}

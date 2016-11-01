/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entity.User;
import facades.UserFacade;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import security.IUser;
import security.PasswordStorage;

/**
 *
 * @author Emil
 */
public class main {

    private static final Map<String, IUser> users = new HashMap<>();
    private static String salt = "salt";
    public static void main(String[] args) {
        HashMap<String, Object> puproperties = new HashMap();

//        puproperties.put("javax.persistence.sql-load-script-source", "scripts/ClearDB.sql");

        //Persistence.generateSchema("lam_seedMaven_war_1.0-SNAPSHOTPU", puproperties);
        Persistence.generateSchema("ca3", null);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ca3");
        EntityManager em = emf.createEntityManager();
        try {

            em.getTransaction().begin();
            em.flush();

            em.persist(new User("user", PasswordStorage.createHash("test" + salt)));

            em.getTransaction().commit();
        } catch (PasswordStorage.CannotPerformOperationException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            em.close();
        }
        //Test Users
        User user = new User("user", "test");
        user.addRole("User");
        users.put(user.getUserName(), user);
        em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(new User("admin", PasswordStorage.createHash("test" + salt)));
            em.getTransaction().commit();
        } catch (PasswordStorage.CannotPerformOperationException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            em.close();
        }
        User admin = new User("admin", "test");
        admin.addRole("Admin");
        users.put(admin.getUserName(), admin);
        em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(new User("user_admin", PasswordStorage.createHash("test" + salt)));
            em.getTransaction().commit();
        } catch (PasswordStorage.CannotPerformOperationException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            em.close();
        }
        User both = new User("user_admin", "test");
        both.addRole("User");
        both.addRole("Admin");
        users.put(both.getUserName(), both);
    }

}

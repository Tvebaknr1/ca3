package facades;

import security.IUserFacade;
import entity.User;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import security.IUser;
import security.PasswordStorage;

public class UserFacade implements IUserFacade {

    /*When implementing your own database for this seed, you should NOT touch any of the classes in the security folder
    Make sure your new facade implements IUserFacade and keeps the name UserFacade, and that your Entity User class implements 
    IUser interface, then security should work "out of the box" with users and roles stored in your database */
    private final Map<String, IUser> users = new HashMap<>();
    private String salt = "salt";

    public UserFacade() {
        //Test Users
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

    @Override
    public IUser getUserByUserId(String id) {
        return users.get(id);
    }

    /*
  Return the Roles if users could be authenticated, otherwise null
     */
    @Override
    public List<String> authenticateUser(String userName, String password) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ca3");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        System.out.println("test");
        User query;
        query = (User) em.createQuery("SELECT i FROM User i WHERE i.userName = :userName").setParameter("userName", userName).getResultList().get(0);
        System.out.println("test");
        em.getTransaction().commit();
        System.out.println("test");
        em.close();
        boolean bool = false;
        try {
            bool = PasswordStorage.verifyPassword(password + salt, query.getPassword());
        } catch (PasswordStorage.CannotPerformOperationException | PasswordStorage.InvalidHashException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return query != null && bool ? query.getRolesAsStrings() : null;
    }

}

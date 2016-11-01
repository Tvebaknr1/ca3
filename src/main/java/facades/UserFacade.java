package facades;

import entity.User;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import security.IUser;
import security.IUserFacade;
import security.PasswordStorage;

public class UserFacade implements IUserFacade {

    /*When implementing your own database for this seed, you should NOT touch any of the classes in the security folder
    Make sure your new facade implements IUserFacade and keeps the name UserFacade, and that your Entity User class implements 
    IUser interface, then security should work "out of the box" with users and roles stored in your database */
    
    private String salt = "salt";

    public UserFacade() {
        //Test Users
        
    }

//    @Override
//    public IUser getUserByUserId(String id) {
//        return //users.get(id);
//    }

    /**
     *
     * puttes user in database return true if success
     * @param user
     * @return succus
     */

    public void createUser(User user){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ca3");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        try {
            em.persist(new User(user.getUserName(), PasswordStorage.createHash(user.getPassword() + salt)));
            em.getTransaction().commit();
        } catch (PasswordStorage.CannotPerformOperationException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
  Return the Roles if users could be authenticated, otherwise null
     */
    @Override
    public List<String> authenticateUser(String userName, String password) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ca3");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        User query;
        query = (User) em.createQuery("SELECT i FROM User i WHERE i.userName = :userName").setParameter("userName", userName).getResultList().get(0);
        
        em.getTransaction().commit();
        em.close();
        boolean bool = false;
        try {
            bool = PasswordStorage.verifyPassword(password + salt, query.getPassword());
        } catch (PasswordStorage.CannotPerformOperationException | PasswordStorage.InvalidHashException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return query != null && bool ? query.getRolesAsStrings() : null;
    }

    @Override
    public IUser getUserByUserId(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

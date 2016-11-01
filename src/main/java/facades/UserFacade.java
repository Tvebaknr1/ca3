package facades;

import datamapper.userdata;
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
     * @param userName
     * @param password
     * @return succus
     */

    public void createUser(String userName,String password){
        userdata.createUser(userName,password,salt);
        
    }
    /*
  Return the Roles if users could be authenticated, otherwise null
     */
    @Override
    public List<String> authenticateUser(String userName, String password) {
        User user = userdata.getUserByUsername(userName);
        boolean bool = false;
        try {
            bool = PasswordStorage.verifyPassword(password + salt, user.getPassword());
        } catch (PasswordStorage.CannotPerformOperationException | PasswordStorage.InvalidHashException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user != null && bool ? user.getRolesAsStrings() : null;
    }

    @Override
    public IUser getUserByUserId(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

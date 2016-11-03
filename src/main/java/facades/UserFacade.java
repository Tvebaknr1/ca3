package facades;

import datamapper.userdata;
import entity.User;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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


    public void createUser(User user) throws Exception{
        userdata.createUser(user.getUserName(),user.getPassword(),salt);
        
    }
    public void createAdmin(User user){
        userdata.createAdmin(user.getUserName(),user.getPassword(),salt);
        
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
        return userdata.getUserByUsername(id);
    }

}

package rest;

import com.google.gson.Gson;
import facades.UserFacade;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("demouser")
@RolesAllowed("User")
public class User
{
    UserFacade userFacade = new UserFacade();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getSomething()
    {
        return "{\"message\" : \"REST call accesible by only authenticated USERS\"}";
    }

    @POST
    @Path("add")
    @Produces(MediaType.APPLICATION_JSON)
    public void postPerson(String content)
    {
        System.out.println("add person metode");
        userFacade.createUser(new Gson().fromJson(content, entity.User.class));
    }
}

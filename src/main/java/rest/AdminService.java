/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import facades.AdminFacade;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author LouiseB
 */
@Path("admin")
public class AdminService
{

    AdminFacade adminFacade = new AdminFacade();

    @Context
    private UriInfo context;

    public AdminService()
    {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("users")
    public String getUsers()
    {
//        List<Object> users =  adminFacade.getUsers();
//        JsonArray JSONUsers = new JsonArray();
//        
//        for (int i = 0; i < users.size(); i++)
//        {
//            JsonObject jo = new JsonObject();
//            jo.addProperty("Id", ((entity.User) users.get(i)).getId());
//            jo.addProperty("userName", ((entity.User)users.get(i)).getUserName());
//            List<String> roles = ((entity.User)users.get(i)).getRoles();
//        
//            JsonArray j = new JsonArray();
//            for (int k = 0; k < roles.size(); k++)
//            {
//                JsonObject jo1 = new JsonObject();
//                jo1.addProperty("role", ((entity.User)users.get(k)).getRoles().get(i));
//                j.add(jo1);
//            }
//            
//            jo.add("roles", j);
//            JSONUsers.add(jo);
//        }
//
        return new Gson().toJson(adminFacade.getUsers());

    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("deleteUser/{id}")
    public void deleteUser(@PathParam("id") int id)
    {
        System.out.println("deletePerson");
        adminFacade.deleteuserbyid(id);
    }

    
}

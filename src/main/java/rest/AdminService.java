/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
        
    }

}

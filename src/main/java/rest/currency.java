/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import facades.currencyFacade;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Emil
 */
@Path("currency")
@RolesAllowed("User")
public class currency {
    @GET
    @Path("dailyrates")
    @Produces(MediaType.APPLICATION_JSON)
    public String getdaliyrates(String content) throws Exception
    {
        return new Gson().toJson(currencyFacade.getCurrency());
    }
    @GET
    @Path("calculator")
    @Produces(MediaType.APPLICATION_JSON)
    public static String postPerson(String amount,String fromcurrency,String tocurrency) throws Exception
    {
        int iamount = Integer.parseInt(amount);
        return new Gson().toJson(currencyFacade.getCurrency());
    }
    public static void main(String[] args) throws Exception {
        System.out.println(postPerson("100", "AUD", "BRL"));
    }
}

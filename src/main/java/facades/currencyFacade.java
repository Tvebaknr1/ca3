/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import datamapper.currencydata;
import entity.Currency;

/**
 *
 * @author Emil
 */
public class currencyFacade {
    public static void createcurrency(Currency cur){
        currencydata.createcurrecy(cur);
    }
}

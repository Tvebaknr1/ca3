/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.HashMap;
import javax.persistence.Persistence;

/**
 *
 * @author Emil
 */
public class main {

    public static void main(String[] args) {
        //HashMap<String, Object> puproperties = new HashMap();

//        puproperties.put("javax.persistence.sql-load-script-source", "scripts/ClearDB.sql");

        //Persistence.generateSchema("lam_seedMaven_war_1.0-SNAPSHOTPU", puproperties);
        Persistence.generateSchema("ca3", null);
    }

}

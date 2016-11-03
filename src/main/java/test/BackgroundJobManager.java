/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entity.Currency;
import entity.Currency_;
import facades.currencyFacade;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author ehn19
 */
@Singleton
public class BackgroundJobManager {

    
    public static void main(String[] args) {
        Updatecurrentcy();
        ArrayList<Currency> array;
        array = XmlReaderDemo.getoutput();
        System.out.println(array);
        for (Currency currency : array) {
            currencyFacade.createcurrency(currency);
        }
        
    }
    @Schedule(hour = "0", minute = "0", second = "0", persistent = false)
    public static XMLReader Updatecurrentcy() {
        try {
            XMLReader xr = XMLReaderFactory.createXMLReader();
            xr.setContentHandler(new XmlReaderDemo());
            URL url = new URL("http://www.nationalbanken.dk/_vti_bin/DN/DataService.svc/CurrencyRatesXML?lang=en");
            xr.parse(new InputSource(url.openStream()));
            return xr;
        } catch (SAXException | IOException ex) {
            Logger.getLogger(BackgroundJobManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

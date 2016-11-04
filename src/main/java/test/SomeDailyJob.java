/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entity.Currency;
import facades.currencyFacade;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author Emil
 */
public class SomeDailyJob implements Runnable {

    @Override
    public void run() {
        try {
            XMLReader xr = XMLReaderFactory.createXMLReader();
            xr.setContentHandler(new XmlReaderDemo());
            URL url = new URL("http://www.nationalbanken.dk/_vti_bin/DN/DataService.svc/CurrencyRatesXML?lang=en");
            xr.parse(new InputSource(url.openStream()));
            ArrayList<Currency> array;
            array = XmlReaderDemo.getoutput();
            array.add(new Currency("Danske Kroner", "DKK", "1"));
            for (Currency currency : array) {
                currencyFacade.createcurrency(currency);
            }
        } catch (SAXException | IOException ex) {
            Logger.getLogger(BackgroundJobManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

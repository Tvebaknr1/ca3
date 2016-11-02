/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entity.Currency;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author ehn19
 */
public class XmlReaderDemo extends DefaultHandler {

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start Document (Sax-event)");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End Document (Sax-event)");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.print("Element: " + localName + ": ");
        ArrayList<Currency> currencyList = new ArrayList();
        for (int i = 0; i < attributes.getLength(); i++) {
            Currency currency = new Currency();
            //currency.setCode(qName);
            System.out.print("[Atribute: NAME: " + attributes.getQName(i)+" ");
                    System.out.println("VALUE: " + attributes.getValue(i)+" ");
            
            
        }
        System.out.println("");
        
    }

    public static void main(String[] argv) {
        try {
            XMLReader xr = XMLReaderFactory.createXMLReader();
            xr.setContentHandler(new XmlReaderDemo());
            URL url = new URL("http://www.nationalbanken.dk/_vti_bin/DN/DataService.svc/CurrencyRatesXML?lang=en");
            xr.parse(new InputSource(url.openStream()));
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }

    }
}

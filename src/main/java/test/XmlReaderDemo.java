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
import java.util.logging.Level;
import java.util.logging.Logger;
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

    private static ArrayList<Currency> output = new ArrayList<>();

    ;

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

        for (int i = 0; i < attributes.getLength(); i += 3) {
            if (localName.equals("currency") && !attributes.getValue(i).equals("ISK")) {
//                System.out.println(attributes.getValue(i).equals("ISK"));
//            System.out.println(i);
                System.out.println(attributes.getValue(i + 1) + attributes.getValue(i) + attributes.getValue(i + 2));
                output.add(new Currency(attributes.getValue(i + 1), attributes.getValue(i), attributes.getValue(i + 2)));
            }

        }
    }

    public static ArrayList getoutput() {
        return output;
    }
}

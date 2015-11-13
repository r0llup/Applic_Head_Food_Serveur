/**
 * SAXParsing
 *
 * Copyright (C) 2012 Sh1fT
 *
 * This file is part of Applic_Head_Food_Serveur.
 *
 * Applic_Head_Food_Serveur is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published
 * by the Free Software Foundation; either version 3 of the License,
 * or (at your option) any later version.
 *
 * Applic_Head_Food_Serveur is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Applic_Head_Food_Serveur; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307
 * USA
 */

package applic_head_food_serveur;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Manage a {@link SAXParsing}
 * @author Sh1fT
 */
public class SAXParsing {
    private String xmlFilename;
    private File xmlFile;
    private InputSource xmlSource;
    private DefaultHandler gestionnaire;

    /**
     * Create a new {@link SAXParsing} instance
     * @param xmlFilename
     * @param gestionnaire 
     */
    public SAXParsing(String xmlFilename, DefaultHandler gestionnaire) {
        this.setXmlFilename(xmlFilename);
        this.setXmlFile(null);
        this.setXmlSource(null);
        this.setGestionnaire(gestionnaire);
        this.parseSAX();
    }

    /**
     * Create a new {@link SAXParsing} instance
     * @param xmlFile
     * @param gestionnaire 
     */
    public SAXParsing(File xmlFile, DefaultHandler gestionnaire) {
        this.setXmlFilename(null);
        this.setXmlFile(xmlFile);
        this.setXmlSource(null);
        this.setGestionnaire(gestionnaire);
        this.parseSAX();
    }

    /**
     * Create a new {@link SAXParsing} instance
     * @param xmlSource
     * @param gestionnaire 
     */
    public SAXParsing(InputSource xmlSource, DefaultHandler gestionnaire) {
        this.setXmlFilename(null);
        this.setXmlFile(null);
        this.setXmlSource(xmlSource);
        this.setGestionnaire(gestionnaire);
        this.parseSAX();
    }

    /**
     * Create a new {@link SAXParsing} instance
     * @param xmlFilename
     */
    public SAXParsing(String xmlFilename) {
        this.setXmlFilename(xmlFilename);
        this.setXmlFile(null);
        this.setXmlSource(null);
        this.setGestionnaire(new MenuHandler());
        this.parseSAX();
    }

    /**
     * Create a new {@link SAXParsing} instance
     * @param xmlFile
     */
    public SAXParsing(File xmlFile) {
        this.setXmlFilename(null);
        this.setXmlFile(xmlFile);
        this.setXmlSource(null);
        this.setGestionnaire(new MenuHandler());
        this.parseSAX();
    }

    /**
     * Create a new {@link SAXParsing} instance
     * @param xmlSource
     */
    public SAXParsing(InputSource xmlSource) {
        this.setXmlFilename(null);
        this.setXmlFile(null);
        this.setXmlSource(xmlSource);
        this.setGestionnaire(new MenuHandler());
        this.parseSAX();
    }

    public String getXmlFilename() {
        return this.xmlFilename;
    }

    private void setXmlFilename(String xmlFilename) {
        this.xmlFilename = xmlFilename;
    }

    public File getXmlFile() {
        return this.xmlFile;
    }

    private void setXmlFile(File xmlFile) {
        this.xmlFile = xmlFile;
    }

    public InputSource getXmlSource() {
        return this.xmlSource;
    }

    private void setXmlSource(InputSource xmlSource) {
        this.xmlSource = xmlSource;
    }

    public DefaultHandler getGestionnaire() {
        return this.gestionnaire;
    }

    private void setGestionnaire(DefaultHandler gestionnaire) {
        this.gestionnaire = gestionnaire;
    }

    /**
     * Permet le parsing d'un fichier XML par SAX
     */
    public void parseSAX() {
        try {
            SAXParserFactory fabrique = SAXParserFactory.newInstance();
            fabrique.setValidating(true);
            SAXParser parseur = fabrique.newSAXParser();
            if (this.getXmlFilename() != null)
                parseur.parse(new File(this.getXmlFilename()), this.getGestionnaire());
            if (this.getXmlFile() != null)
                parseur.parse(this.getXmlFile(), this.getGestionnaire());
            if (this.getXmlSource() != null)
                parseur.parse(this.getXmlSource(), this.getGestionnaire());
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println("Error: " + ex.getLocalizedMessage());
            System.exit(1);
        }
    }
}
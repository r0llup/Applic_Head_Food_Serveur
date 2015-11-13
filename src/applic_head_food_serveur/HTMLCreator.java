/**
 * HTMLCreator
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
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * Manage a {@link HTMLCreator}
 * @author Sh1fT
 */
public class HTMLCreator {
    private String xmlFilename;
    private InputSource xmlSource;
    private String xslFilename;
    private String htmlFilename;

    /**
     * Create a new {@link HTMLCreator} instance
     * @param xmlFilename
     * @param xslFilename
     * @param htmlFilename 
     */
    public HTMLCreator(String xmlFilename, String xslFilename, String htmlFilename) {
        this.setXmlFilename(xmlFilename);
        this.setXmlSource(null);
        this.setXslFilename(xslFilename);
        this.setHtmlFilename(htmlFilename);
        this.saveHTML();
    }

    /**
     * Create a new {@link HTMLCreator} instance
     * @param xmlSource
     * @param xslFilename
     * @param htmlFilename 
     */
    public HTMLCreator(InputSource xmlSource, String xslFilename, String htmlFilename) {
        this.setXmlFilename(null);
        this.setXmlSource(xmlSource);
        this.setXslFilename(xslFilename);
        this.setHtmlFilename(htmlFilename);
        this.saveHTML();
    }

    public String getXmlFilename() {
        return this.xmlFilename;
    }

    public void setXmlFilename(String xmlFilename) {
        this.xmlFilename = xmlFilename;
    }

    public InputSource getXmlSource() {
        return xmlSource;
    }

    public void setXmlSource(InputSource xmlSource) {
        this.xmlSource = xmlSource;
    }

    public String getXslFilename() {
        return this.xslFilename;
    }

    public void setXslFilename(String xslFilename) {
        this.xslFilename = xslFilename;
    }

    public String getHtmlFilename() {
        return this.htmlFilename;
    }

    public void setHtmlFilename(String htmlFilename) {
        this.htmlFilename = htmlFilename;
    }

    /**
     * Save To HTML
     */
    public void saveHTML() {
        try {
            DocumentBuilderFactory fabriqueD = DocumentBuilderFactory.newInstance();
            DocumentBuilder constructeur;
            constructeur = fabriqueD.newDocumentBuilder();
            fabriqueD.setValidating(true);
            Document document = null;
            if (this.getXmlFilename() != null)
                document = constructeur.parse(this.getXmlFilename());
            if (this.getXmlSource() != null)
                document = constructeur.parse(this.getXmlSource());
            Source source = new DOMSource(document);
            // Création du fichier de sortie
            File fileHtml = new File(this.getHtmlFilename());
            Result resultat = new StreamResult(fileHtml);
            // Configuration du transformer
            TransformerFactory fabriqueT = TransformerFactory.newInstance();
            StreamSource stylesource = new StreamSource(this.getXslFilename());
            Transformer transformer = fabriqueT.newTransformer(stylesource);
            transformer.setOutputProperty(OutputKeys.METHOD, "html");
            // Transformation
            transformer.transform(source, resultat);
        } catch (ParserConfigurationException | SAXException | IOException |
                TransformerException ex) {
            System.out.println("Error: " + ex.getLocalizedMessage());
            System.exit(1);
        }
    }
}
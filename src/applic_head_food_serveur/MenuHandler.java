/**
 * MenuHandler
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

import contents.Dessert;
import contents.Entree;
import contents.Ingredient;
import contents.Menu;
import contents.Plat;
import java.util.LinkedList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Manage a {@link MenuHandler}
 * @author Sh1fT
 */
public class MenuHandler extends DefaultHandler {
    private Menu menu;
    private Entree entree;
    private Plat plat;
    private Dessert dessert;
    private Ingredient ingredient;
    private Boolean inMenu;
    private Boolean inEntree;
    private Boolean inPlat;
    private Boolean inDessert;
    private Boolean inIngredient;
    private StringBuffer buffer;

    /**
     * Create a new {@link MenuHandler} instance
     */
    public MenuHandler() {
        super();
        this.setBuffer(new StringBuffer());
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Entree getEntree() {
        return entree;
    }

    public void setEntree(Entree entree) {
        this.entree = entree;
    }

    public Plat getPlat() {
        return plat;
    }

    public void setPlat(Plat plat) {
        this.plat = plat;
    }

    public Dessert getDessert() {
        return dessert;
    }

    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Boolean getInMenu() {
        return inMenu;
    }

    public void setInMenu(Boolean inMenu) {
        this.inMenu = inMenu;
    }

    public Boolean getInEntree() {
        return inEntree;
    }

    public void setInEntree(Boolean inEntree) {
        this.inEntree = inEntree;
    }

    public Boolean getInPlat() {
        return inPlat;
    }

    public void setInPlat(Boolean inPlat) {
        this.inPlat = inPlat;
    }

    public Boolean getInDessert() {
        return inDessert;
    }

    public void setInDessert(Boolean inDessert) {
        this.inDessert = inDessert;
    }

    public Boolean getInIngredient() {
        return inIngredient;
    }

    public void setInIngredient(Boolean inIngredient) {
        this.inIngredient = inIngredient;
    }

    public StringBuffer getBuffer() {
        return buffer;
    }

    public void setBuffer(StringBuffer buffer) {
        this.buffer = buffer;
    }

    /**
     * Détection d'ouverture de balises
     * @param uri
     * @param localName
     * @param qName
     * @param attributes
     * @throws SAXException 
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equals("Menu")) {
            this.setMenu(new Menu());
            this.getMenu().setNom(attributes.getValue("name"));
            this.getMenu().setVedetteDuJour(attributes.getValue("vedetteDuJour"));
            this.setInMenu(true);
        } else if (qName.equals("Entree")) {
            this.getMenu().setEntree(new Entree());
            this.getMenu().getEntree().setNom(attributes.getValue("name"));
            this.getMenu().getEntree().setType(attributes.getValue("type"));
            this.getMenu().getEntree().setIngredients(new LinkedList<Ingredient>());
            this.setInEntree(true);
        } else if (qName.equals("Plat")) {
            this.getMenu().setPlat(new Plat());
            this.getMenu().getPlat().setNom(attributes.getValue("name"));
            this.getMenu().getPlat().setType(attributes.getValue("type"));
            this.getMenu().getPlat().setIngredients(new LinkedList<Ingredient>());
            this.setInPlat(true);
        } else if (qName.equals("Dessert")) {
            this.getMenu().setDessert(new Dessert());
            this.getMenu().getDessert().setNom(attributes.getValue("name"));
            this.getMenu().getDessert().setType(attributes.getValue("type"));
            this.getMenu().getDessert().setIngredients(new LinkedList<Ingredient>());
            this.setInDessert(true);
        } else if (qName.equals("Ingredient")) {
            Ingredient i = new Ingredient();
            i.setNom(attributes.getValue("value"));
            if (this.getInEntree())
                this.getMenu().getEntree().getIngredients().add(i);
            else if (this.getInPlat())
                this.getMenu().getPlat().getIngredients().add(i);
            else if (this.getInDessert())
                this.getMenu().getDessert().getIngredients().add(i);
            this.setInIngredient(true);
        }
    }

    /**
     * Détection fin de balise
     * @param uri
     * @param localName
     * @param qName
     * @throws SAXException
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("Menu"))
            this.setInMenu(false);
    	else if (qName.equals("Entree"))
            this.setInEntree(false);
    	else if (qName.equals("Plat"))
            this.setInPlat(false);
    	else if (qName.equals("Dessert"))
            this.setInDessert(false);
        else if (qName.equals("Ingredient"))
            this.setInIngredient(false);
    }

    /**
     * Détection de caractères
     * @param ch
     * @param start
     * @param length
     * @throws SAXException
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String lecture = new String(ch, start, length);
        if(buffer != null)
            buffer.append(lecture);       
    }

    /**
     * Début du parsing
     * @throws SAXException
     */
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Début du parsing");
    }

    /**
     * Fin du parsing
     * @throws SAXException
     */
    @Override
    public void endDocument() throws SAXException {
        System.out.println("Fin du parsing");
        System.out.println("Resultats du parsing");
        System.out.println(this.getMenu().toString());
    }
}
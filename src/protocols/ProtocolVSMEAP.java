/**
 * ProtocolVSMEAP
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

package protocols;

import applic_head_food_serveur.Applic_Head_Food_Serveur;
import beans.BeanDBAccessCSV;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Manage a {@link ProtocolVSMEAP}
 * @author Sh1fT
 */
public class ProtocolVSMEAP implements interfaces.ProtocolVSMEAP {
    private Applic_Head_Food_Serveur parent;
    private BeanDBAccessCSV bdbac;
    public static final int TYPE_ENTREE = 1;
    public static final int TYPE_PLAT = 2;
    public static final int TYPE_DESSERT = 3;
    public static final int LOGIN_OK = 100;
    public static final int LOGIN_KO = 600;

    /**
     * Create a new {@link ProtocolVSMEAP} instance
     * @param parent 
     */
    public ProtocolVSMEAP(Applic_Head_Food_Serveur parent) {
        this.setParent(parent);
        this.setBdbac(new BeanDBAccessCSV(
                System.getProperty("file.separator") +"properties" +
                System.getProperty("file.separator") + "BeanDBAccessCSV.properties"));
    }

    public Applic_Head_Food_Serveur getParent() {
        return parent;
    }

    public void setParent(Applic_Head_Food_Serveur parent) {
        this.parent = parent;
    }

    public BeanDBAccessCSV getBdbac() {
        return bdbac;
    }

    public void setBdbac(BeanDBAccessCSV bdbac) {
        this.bdbac = bdbac;
    }

    /**
     * Effectue la connexion pour un utilisateur
     * @param name
     * @param password
     * @return 
     */
    @Override
    public Integer loginHead(String name, String password) {
        try {
            String query = "SELECT * FROM " + this.getParent().getLoginsFilename() +
                    " WHERE nom LIKE '" + name + "' AND password LIKE '" + password +
                    "' AND head LIKE 'oui'";
            ResultSet rs = this.getBdbac().executeQuery(query);
            if (rs.next())
                return ProtocolVSMEAP.LOGIN_OK;
            return ProtocolVSMEAP.LOGIN_KO;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getLocalizedMessage());
            this.getBdbac().stop();
            System.exit(1);
        }
        return null;
    }

    /**
     * Effectue la connexion pour un utilisateur
     * @param name
     * @param password
     * @return 
     */
    @Override
    public Integer loginVillage(String name, String password) {
        try {
            String query = "SELECT * FROM " + this.getParent().getLoginsFilename() +
                    " WHERE nom LIKE '" + name + "' AND password LIKE '" + password +
                    "' AND village LIKE 'oui'";
            ResultSet rs = this.getBdbac().executeQuery(query);
            if (rs.next())
                return ProtocolVSMEAP.LOGIN_OK;
            return ProtocolVSMEAP.LOGIN_KO;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getLocalizedMessage());
            this.getBdbac().stop();
            System.exit(1);
        }
        return null;
    }

    /**
     * Demande le téléchargement de la liste des denrées
     * @param type
     * @return 
     */
    @Override
    public List<String> downProd(Integer type) {
        try {
            ArrayList<String> ingredients = new ArrayList<String>();
            String query = "SELECT * FROM ";
            switch (type) {
                case ProtocolVSMEAP.TYPE_ENTREE:
                    query += this.getParent().getEntreesIngredientsFilename();
                    break;
                case ProtocolVSMEAP.TYPE_PLAT:
                    query += this.getParent().getPlatsIngredientsFilename();
                    break;
                case ProtocolVSMEAP.TYPE_DESSERT:
                    query += this.getParent().getDessertsIngredientsFilename();
                    break;
            }
            ResultSet rs = this.getBdbac().executeQuery(query);
            while (rs.next())
                ingredients.add(rs.getString("nom"));
            return ingredients;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getLocalizedMessage());
            this.getBdbac().stop();
            System.exit(1);
        }
        return null;
    }

    @Override
    public String upMenu(String menu, Integer type) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String sendMenu(Integer type) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String downMenu(String menu, Integer type) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
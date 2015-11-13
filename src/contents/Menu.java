/**
 * Menu
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

package contents;

/**
 * Manage a {@link Menu}
 * @author Sh1fT
 */
public class Menu {
    private String nom;
    private String vedetteDuJour;
    private Entree entree;
    private Plat plat;
    private Dessert dessert;

    /**
     * Create a new {@link Menu} instance
     */
    public Menu() {}

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVedetteDuJour() {
        return vedetteDuJour;
    }

    public void setVedetteDuJour(String vedetteDuJour) {
        this.vedetteDuJour = vedetteDuJour;
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

    @Override
    public String toString() {
        return new StringBuilder("\nNom: ").append(this.getNom())
            .append("\nVedette du jour: ").append(this.getVedetteDuJour())
            .append("\nEntrée:").append(this.getEntree())
            .append("\nPlat:").append(this.getPlat())
            .append("\nDessert:").append(this.getDessert()).toString();
    }
}
/**
 * Miam
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

import java.util.List;

/**
 * Manage a {@link Miam}
 * @author Sh1fT
 */
public abstract class Miam {
    private String nom;
    private String type;
    private List<Ingredient> ingredients;

    /**
     * Create a new {@link Miam} instance
     */
    public Miam() {}

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append(("\n\tNom: " + this.getNom()));
        buf.append("\n\tType: " + this.getType());
        for (Ingredient i : this.getIngredients())
            buf.append("\n\tIngredients:").append(i);
        return buf.toString();
    }
}
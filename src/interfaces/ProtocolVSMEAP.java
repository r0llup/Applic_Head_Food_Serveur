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

package interfaces;

import java.util.List;

/**
 * Manage a {@link ProtocolVSMEAP}
 * @author Sh1fT
 */
public interface ProtocolVSMEAP {
    public Integer loginHead(String name, String password);
    public Integer loginVillage(String name, String password);
    public List<String> downProd(Integer type);
    public String upMenu(String menu, Integer type);
    public String sendMenu(Integer type);
    public String downMenu(String menu, Integer type);
}
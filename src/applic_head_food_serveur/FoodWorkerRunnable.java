/**
 * FoodWorkerRunnable
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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import org.xml.sax.InputSource;
import protocols.ProtocolVSMEAP;

/**
 * Manage a {@link FoodWorkerRunnable}
 * @author Sh1fT
 */
public class FoodWorkerRunnable implements Runnable {
    private Applic_Head_Food_Serveur parent;
    private Socket cSocket;

    /**
     * Create a new {@link FoodWorkerRunnable} instance
     * @param parent
     * @param cSocket 
     */
    public FoodWorkerRunnable(Applic_Head_Food_Serveur parent, Socket cSocket) {
        this.setParent(parent);
        this.setcSocket(cSocket);
    }

    public Applic_Head_Food_Serveur getParent() {
        return parent;
    }

    public void setParent(Applic_Head_Food_Serveur parent) {
        this.parent = parent;
    }

    public Socket getcSocket() {
        return cSocket;
    }

    public void setcSocket(Socket cSocket) {
        this.cSocket = cSocket;
    }

    public void run() {
        try {
            this.getParent().getClientLabel().setText(
                    this.getcSocket().getInetAddress().getHostAddress());
            InputSource is = new InputSource(new InputStreamReader(
                    this.getcSocket().getInputStream()));
            BufferedReader br = new BufferedReader(is.getCharacterStream());
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(
                    this.getcSocket().getOutputStream()), true);
            String cmd = br.readLine();
            if (cmd.contains("LOGINVILLAGE")) {
                String username = cmd.split(":")[1];
                String password = cmd.split(":")[2];
                Integer res = this.getParent().getProtocolVSMEAP().
                        loginVillage(username, password);
                switch (res) {
                    case ProtocolVSMEAP.LOGIN_OK:
                        pw.println("OK");
                        break;
                    case ProtocolVSMEAP.LOGIN_KO:
                        pw.println("KO");
                        break;
                    default:
                        pw.println("KO");
                        break;
                }
            } else if (cmd.contains("DOWNMENU")) {
                File inputFile = new File(this.getParent().getOutputHTMLFilename());
                File outputFile = new File(this.getParent().getServerHTMLFilename());
                FileReader in = new FileReader(inputFile);
                FileWriter out = new FileWriter(outputFile);
                int c;
                while ((c = in.read()) != -1)
                    out.write(c);
                in.close();
                out.close();
                pw.println(this.getParent().getServerURI());
            }
            pw.close();
            br.close();
            this.getcSocket().close();
            this.getParent().getClientLabel().setText("aucun");
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getLocalizedMessage());
            System.exit(1);
        }
    }
}
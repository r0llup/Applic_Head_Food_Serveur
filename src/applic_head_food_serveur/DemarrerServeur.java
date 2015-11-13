/**
 * DemarrerServeur
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
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import org.xml.sax.InputSource;
import protocols.ProtocolVSMEAP;

/**
 * Manage a {@link DemarrerServeur}
 * @author Sh1fT
 */
public class DemarrerServeur extends Thread {
    private Applic_Head_Food_Serveur parent;
    private ServerSocket sSocket;
    private Socket cSocket;
    private Boolean stop;

    /**
     * Create a new {@link DemarrerServeur} instance
     * @param parent 
     */
    public DemarrerServeur(Applic_Head_Food_Serveur parent) {
        this.setParent(parent);
        this.setsSocket(null);
        this.setcSocket(null);
        this.setStop(false);
    }

    public Applic_Head_Food_Serveur getParent() {
        return this.parent;
    }

    public void setParent(Applic_Head_Food_Serveur parent) {
        this.parent = parent;
    }

    public ServerSocket getsSocket() {
        return sSocket;
    }

    public void setsSocket(ServerSocket sSocket) {
        this.sSocket = sSocket;
    }

    public Socket getcSocket() {
        return cSocket;
    }

    public void setcSocket(Socket cSocket) {
        this.cSocket = cSocket;
    }

    public Boolean getStop() {
        return stop;
    }

    public void setStop(Boolean stop) {
        this.stop = stop;
    }

    @Override
    public void run() {
        try {
            this.setsSocket(new ServerSocket(this.getParent().getServerHeadPort()));
            while (!this.getStop()) {
                this.setcSocket(this.getsSocket().accept());
                this.getParent().getClientLabel().setText(
                        this.getcSocket().getInetAddress().getHostAddress());
                InputSource is = new InputSource(new InputStreamReader(
                        this.getcSocket().getInputStream()));
                BufferedReader br = new BufferedReader(is.getCharacterStream());
                PrintWriter pw = new PrintWriter(new OutputStreamWriter(
                        this.getcSocket().getOutputStream()), true);
                String cmd = br.readLine();
                if (cmd.contains("LOGINHEAD")) {
                    String username = cmd.split(":")[1];
                    String password = cmd.split(":")[2];
                    Integer res = this.getParent().getProtocolVSMEAP().
                            loginHead(username, password);
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
                } else if (cmd.contains("DOWNPROD")) {
                    Integer type = Integer.parseInt(cmd.split(":")[1]);
                    List<String> ingredients =
                            this.getParent().getProtocolVSMEAP().downProd(type);
                    for (String ingredient : ingredients)
                        pw.println(ingredient);
                } else if (cmd.contains("UPMENU")) {
                    String ligne, message = "";
                    while ((ligne = br.readLine()) != null)
                        message += ligne;
                    this.getParent().setSaxParsing(new SAXParsing(
                            new InputSource(new StringReader(message))));
                    this.getParent().setMenu(((MenuHandler) this.getParent().
                            getSaxParsing().getGestionnaire()).getMenu());
                    System.out.println(this.getParent().getMenu());
                    this.getParent().setHtmlCreator(new HTMLCreator(
                    new InputSource(new StringReader(message)),
                    this.getParent().getOutputXSLFilename(),
                    this.getParent().getOutputHTMLFilename()));
                }
                pw.close();
                br.close();
                this.getcSocket().close();
                this.getParent().getClientLabel().setText("aucun");
            }
        } catch (BindException ex) {
            System.out.println("Error: " + ex.getLocalizedMessage());
            this.setStop(true);
        } catch (IOException  ex) {
            System.out.println("Error: " + ex.getLocalizedMessage());
            this.setStop(true);
            System.exit(1);
        }
    }
}
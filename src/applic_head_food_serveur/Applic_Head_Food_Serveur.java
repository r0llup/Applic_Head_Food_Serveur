/**
 * Applic_Head_Food_Serveur
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

import contents.Menu;
import java.awt.Color;
import java.awt.Frame;
import java.util.Properties;
import javax.swing.JDialog;
import javax.swing.JLabel;
import protocols.ProtocolVSMEAP;
import utils.PropertiesLauncher;

/**
 * Manage an {@link Applic_Head_Food_Serveur}
 * @author Sh1fT
 */
public class Applic_Head_Food_Serveur extends JDialog {
    private ProtocolVSMEAP protocolVSMEAP;
    private DemarrerServeur demarrerServeur;
    private DemarrerServeur2 demarrerServeur2;
    private Menu menu;
    private PropertiesLauncher propertiesLauncher;
    private SAXParsing saxParsing;
    private HTMLCreator htmlCreator;

    /**
     * Create a new {@link Applic_Head_Food_Serveur} instance
     * @param parent
     * @param modal 
     */
    public Applic_Head_Food_Serveur(Frame parent, boolean modal) {
        super(parent, modal);
        this.initComponents();
        this.setProtocolVSMEAP(new ProtocolVSMEAP(this));
        this.setDemarrerServeur(null);
        this.setDemarrerServeur2(null);
        this.setMenu(null);
        this.setPropertiesLauncher(new PropertiesLauncher(
                System.getProperty("file.separator") + "properties" +
                System.getProperty("file.separator") + "Applic_Head_Food_Serveur.properties"));
        this.setSaxParsing(null);
        this.setHtmlCreator(null);
    }

    public ProtocolVSMEAP getProtocolVSMEAP() {
        return protocolVSMEAP;
    }

    public void setProtocolVSMEAP(ProtocolVSMEAP protocolVSMEAP) {
        this.protocolVSMEAP = protocolVSMEAP;
    }

    public DemarrerServeur getDemarrerServeur() {
        return demarrerServeur;
    }

    public void setDemarrerServeur(DemarrerServeur demarrerServeur) {
        this.demarrerServeur = demarrerServeur;
    }

    public DemarrerServeur2 getDemarrerServeur2() {
        return demarrerServeur2;
    }

    public void setDemarrerServeur2(DemarrerServeur2 demarrerServeur2) {
        this.demarrerServeur2 = demarrerServeur2;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public PropertiesLauncher getPropertiesLauncher() {
        return propertiesLauncher;
    }

    public void setPropertiesLauncher(PropertiesLauncher propertiesLauncher) {
        this.propertiesLauncher = propertiesLauncher;
    }

    public SAXParsing getSaxParsing() {
        return saxParsing;
    }

    public void setSaxParsing(SAXParsing saxParsing) {
        this.saxParsing = saxParsing;
    }

    public HTMLCreator getHtmlCreator() {
        return htmlCreator;
    }

    public void setHtmlCreator(HTMLCreator htmlCreator) {
        this.htmlCreator = htmlCreator;
    }

    public JLabel getClientLabel() {
        return this.clientLabel;
    }

    public Properties getProperties() {
        return this.getPropertiesLauncher().getProperties();
    }

    public String getOutputXMLFilename() {
        return this.getProperties().getProperty("outputXMLFilename");
    }

    public String getOutputDTDFilename() {
        return this.getProperties().getProperty("outputDTDFilename");
    }

    public String getOutputXSLFilename() {
        return this.getProperties().getProperty("outputXSLFilename");
    }

    public String getOutputHTMLFilename() {
        return this.getProperties().getProperty("outputHTMLFilename");
    }

    public Integer getServerHeadPort() {
        return Integer.parseInt(this.getProperties().getProperty("serverHeadPort"));
    }

    public Integer getServerFoodPort() {
        return Integer.parseInt(this.getProperties().getProperty("serverFoodPort"));
    }

    public String getBaseDir() {
        return this.getProperties().getProperty("baseDir");
    }

    public String getEntreesIngredientsFilename() {
        return this.getProperties().getProperty("entreesIngredientsFilename");
    }

    public String getPlatsIngredientsFilename() {
        return this.getProperties().getProperty("platsIngredientsFilename");
    }

    public String getDessertsIngredientsFilename() {
        return this.getProperties().getProperty("dessertsIngredientsFilename");
    }

    public String getLoginsFilename() {
        return this.getProperties().getProperty("loginsFilename");
    }

    public String getServerURI() {
        return this.getProperties().getProperty("serverURI");
    }

    public String getServerHTMLFilename() {
        return this.getProperties().getProperty("serverHTMLFilename");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toggleButtonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        demarrerToggleButton = new javax.swing.JToggleButton();
        arreterToggleButton = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        etatLabel = new javax.swing.JLabel();
        clientLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        quitterButton = new javax.swing.JButton();

        this.toggleButtonGroup.add(this.demarrerToggleButton);
        this.toggleButtonGroup.add(this.arreterToggleButton);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Applic_Head_Food_Serveur");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Actions", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 10), java.awt.Color.darkGray)); // NOI18N

        demarrerToggleButton.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        demarrerToggleButton.setText("Démarrer");
        demarrerToggleButton.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        demarrerToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                demarrerToggleButtonActionPerformed(evt);
            }
        });

        arreterToggleButton.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        arreterToggleButton.setText("Arrêter");
        arreterToggleButton.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        arreterToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arreterToggleButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addComponent(demarrerToggleButton)
                .addGap(18, 18, 18)
                .addComponent(arreterToggleButton)
                .addContainerGap(115, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(arreterToggleButton)
                    .addComponent(demarrerToggleButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informations", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 10), java.awt.Color.darkGray)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel1.setText("Client connecté :");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel2.setText("État du serveur :");

        etatLabel.setFont(new java.awt.Font("Verdana", 2, 11)); // NOI18N
        etatLabel.setText("inconnu");

        clientLabel.setFont(new java.awt.Font("Verdana", 2, 11)); // NOI18N
        clientLabel.setText("aucun");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(etatLabel))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(clientLabel)))
                .addContainerGap(225, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(etatLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(clientLabel)))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        quitterButton.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        quitterButton.setText("Quitter");
        quitterButton.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        quitterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitterButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(quitterButton)
                .addContainerGap(175, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(quitterButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void demarrerToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_demarrerToggleButtonActionPerformed
        if ((this.getDemarrerServeur() == null) &&
                (this.getDemarrerServeur2() == null)) {
            this.setDemarrerServeur(new DemarrerServeur(this));
            this.getDemarrerServeur().start();
            this.setDemarrerServeur2(new DemarrerServeur2(this));
            this.getDemarrerServeur2().start();
            this.etatLabel.setForeground(Color.green);
            this.etatLabel.setText("démarré");
        }
    }//GEN-LAST:event_demarrerToggleButtonActionPerformed

    private void arreterToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arreterToggleButtonActionPerformed
        if ((this.getDemarrerServeur() != null) &&
                (this.getDemarrerServeur2() != null)) {
            this.getDemarrerServeur().interrupt();
            this.setDemarrerServeur(null);
            this.getDemarrerServeur2().interrupt();
            this.setDemarrerServeur2(null);
            this.etatLabel.setForeground(Color.red);
            this.etatLabel.setText("arrêté");
            this.clientLabel.setText("");
        }
    }//GEN-LAST:event_arreterToggleButtonActionPerformed

    private void quitterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitterButtonActionPerformed
        if ((this.getDemarrerServeur() != null) &&
                (this.getDemarrerServeur2() != null)) {
            this.getDemarrerServeur().interrupt();
            this.getDemarrerServeur2().interrupt();
        }
        System.exit(0);
    }//GEN-LAST:event_quitterButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            System.out.println("Error: " + ex.getLocalizedMessage());
            System.exit(1);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Applic_Head_Food_Serveur dialog = new Applic_Head_Food_Serveur(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton arreterToggleButton;
    private javax.swing.JLabel clientLabel;
    private javax.swing.JToggleButton demarrerToggleButton;
    private javax.swing.JLabel etatLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton quitterButton;
    private javax.swing.ButtonGroup toggleButtonGroup;
    // End of variables declaration//GEN-END:variables
}
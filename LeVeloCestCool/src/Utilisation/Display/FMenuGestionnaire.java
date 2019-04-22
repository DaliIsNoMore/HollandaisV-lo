/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilisation.Display;
import javax.swing.JFrame;
import Utilisation.*;
import Source.*;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author GREGO
 */
public class FMenuGestionnaire extends javax.swing.JFrame {

    /**
     * Creates new form FMenuGestionnaire
     */
    private static GestionAbonne ga;
    private static GestionTechnicien gt;
    private static GestionGestionnaire gg;
    
    public FMenuGestionnaire(Gestionnaire g) {
        initComponents();
        ga = GestionFinal.getGa();
        gt = GestionFinal.getGt();
        gg = GestionFinal.getGg();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BoutonFermer = new javax.swing.JButton();
        BoutonRetour = new javax.swing.JButton();
        BoutonMessageRetard = new javax.swing.JButton();
        BoutonLoadnSendVelo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabVeloRep = new javax.swing.JTable();
        lblGestionAbonne = new javax.swing.JLabel();
        lblGestionVelo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        BoutonFermer.setText("Fermer");
        BoutonFermer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BoutonFermerMouseClicked(evt);
            }
        });

        BoutonRetour.setText("Retour");
        BoutonRetour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BoutonRetourMouseClicked(evt);
            }
        });

        BoutonMessageRetard.setText("Message de rappel");
        BoutonMessageRetard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BoutonMessageRetardMouseClicked(evt);
            }
        });

        BoutonLoadnSendVelo.setText("Générer et envoyer");

        TabVeloRep.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(TabVeloRep);

        lblGestionAbonne.setText("Gestion Abonné");

        lblGestionVelo.setText("Gestion Vélo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BoutonRetour)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BoutonFermer))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BoutonMessageRetard)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(lblGestionAbonne)))
                        .addGap(136, 136, 136)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblGestionVelo)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 231, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BoutonLoadnSendVelo)
                .addGap(392, 392, 392))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BoutonFermer)
                            .addComponent(BoutonRetour))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblGestionVelo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(lblGestionAbonne)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BoutonMessageRetard)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(BoutonLoadnSendVelo)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 987, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 513, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BoutonRetourMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BoutonRetourMouseClicked
        // TODO add your handling code here:
        
        this.dispose();
    }//GEN-LAST:event_BoutonRetourMouseClicked

    private void BoutonFermerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BoutonFermerMouseClicked
        // TODO add your handling code here:
        
        System.exit(0);
    }//GEN-LAST:event_BoutonFermerMouseClicked

    private void BoutonMessageRetardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BoutonMessageRetardMouseClicked
        // TODO add your handling code here:
        
        ArrayList<Location>listeLocation = ga.getListeLocation();
        ArrayList<Abonne>listeAbonne;
        int i = 0;
        String message = "";
        DialogRecapitulatif d;
        
        
        
        //Envoie du message de rappel d'arrivée à expiration
        listeLocation = gg.rappelAbonne(listeLocation);
        
        ga.setListeLocation(listeLocation);
        
        //Envoie du message de rappel de retard
        listeAbonne = gg.abonneRetard(listeLocation);
        
        
        
        if (!listeAbonne.isEmpty()){
            for(i=0;i<listeAbonne.size();i++ ){
                ga.rechercheAbonne(listeAbonne.get(i).getLogin()).setMessage("Votre location à expiré, vous êtes priez de rendre votre vélo");
                message = message + "\n\n" +  listeAbonne.get(i).getInfo();
            }
        }
        else{
            message ="Pas de locations en retard";
        }
        
        d= new DialogRecapitulatif(this,true, message);
        d.setVisible(true);
        
    }//GEN-LAST:event_BoutonMessageRetardMouseClicked

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FMenuGestionnaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FMenuGestionnaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FMenuGestionnaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FMenuGestionnaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new FMenuGestionnaire().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BoutonFermer;
    private javax.swing.JButton BoutonLoadnSendVelo;
    private javax.swing.JButton BoutonMessageRetard;
    private javax.swing.JButton BoutonRetour;
    private javax.swing.JTable TabVeloRep;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblGestionAbonne;
    private javax.swing.JLabel lblGestionVelo;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nr_consult;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author tojo
 */
public class ajout_admin_1 extends javax.swing.JFrame {
  Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
     int xMouse;
      int yMouse;
  
    /**
     * Creates new form ajout_admin
     */
    public ajout_admin_1() {
     conn = ConexionBD.Conexion();
        initComponents();
         
    }
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_admin = new javax.swing.JTextField();
        mdp_admin = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Retour = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(816, 573));
        setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().add(txt_admin);
        txt_admin.setBounds(240, 70, 180, 30);
        getContentPane().add(mdp_admin);
        mdp_admin.setBounds(240, 140, 180, 30);

        jLabel1.setFont(new java.awt.Font("Tekton Pro Ext", 0, 18)); // NOI18N
        jLabel1.setText("Mot de passe");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(100, 140, 150, 30);

        jButton1.setFont(new java.awt.Font("Tekton Pro Ext", 0, 18)); // NOI18N
        jButton1.setText("Ajouter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(100, 210, 130, 40);

        jLabel3.setFont(new java.awt.Font("Tekton Pro Ext", 0, 18)); // NOI18N
        jLabel3.setText("Nom d'utilisateur");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(70, 60, 180, 30);

        Retour.setFont(new java.awt.Font("Tekton Pro Ext", 0, 18)); // NOI18N
        Retour.setText("Annuler");
        Retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetourActionPerformed(evt);
            }
        });
        getContentPane().add(Retour);
        Retour.setBounds(270, 210, 150, 40);

        jLabel4.setFont(new java.awt.Font("Tekton Pro Ext", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 255));
        jLabel4.setText("              Ajouter un administrateur");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
        });
        jLabel4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel4MouseDragged(evt);
            }
        });
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 520, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nr/imageNR/6.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-6, 0, 530, 300);

        setSize(new java.awt.Dimension(518, 297));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 if (txt_admin.getText().equals("") || mdp_admin.getText().equals("") ) {
            JOptionPane.showMessageDialog(this, "SVP entrer les informations complete");
        } else {
        try {
           
           String requete = "insert into admin (nom_utilisateur,mdp_admin) values (?,?)";
            ps = conn.prepareStatement(requete);
            ps.setString(1, txt_admin.getText());
            ps.setString(2, mdp_admin.getText());
          
            ps.execute();

            JOptionPane.showMessageDialog(null, "Enregistrement avec succès");
 ps.close();
                rs.close();
           

        } catch (Exception e) {
            System.out.println("--> SQLException : " + e);
            txt_admin.setText("");
        mdp_admin.setText("");
        }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void RetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetourActionPerformed
admin k =new admin();
k.setVisible(true) ;
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_RetourActionPerformed

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MousePressed

    private void jLabel4MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation( x - xMouse , y - yMouse);            // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseDragged

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
            java.util.logging.Logger.getLogger(ajout_admin_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ajout_admin_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ajout_admin_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ajout_admin_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ajout_admin_1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Retour;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField mdp_admin;
    private javax.swing.JTextField txt_admin;
    // End of variables declaration//GEN-END:variables
}

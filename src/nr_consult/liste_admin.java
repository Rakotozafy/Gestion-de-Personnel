/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nr_consult;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;
import nr_consult.ConexionBD;
import nr_consult.admin;
import static nr_consult.pointage.test;

/**
 *
 * @author tojo
 */
public class liste_admin extends javax.swing.JFrame {
  Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
 static  String test;
 int xMouse;
      int yMouse;
    /**
     * Creates new form ajout_admin
     */
    public liste_admin() {
     conn = ConexionBD.Conexion();
        initComponents();
         
          Affichage();
          btnajout.setEnabled(true);
        btnmodif.setEnabled(false);
        btnsuppr.setEnabled(false);
    }
 public void Affichage() {
        try {
            String requete = "Select* from admin ";
            ps = conn.prepareStatement(requete);
            rs = ps.executeQuery();
            table_admin.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            System.out.println(e);
        }
        }
 public void Deplace() {
        try {

            int row = table_admin.getSelectedRow();
            this.test = (table_admin.getModel().getValueAt(row, 0).toString());
            String requet = " select * from  admin where id_admin = '" + test + "' ";
            ps = conn.prepareStatement(requet);
            rs = ps.executeQuery();

            if (rs.next()) {
                String t1 = rs.getString("id_admin");
                txt_id.setText(t1);
               String t2 = rs.getString("nom_utilisateur");
                txt_admin.setText(t2);
                String t3 = rs.getString("mdp_admin");
                mdp_admin.setText(t3);
               
                
//                byte[] imagedata =rs.getBytes("image");
//                Format = new ImageIcon(imagedata);
//                image.setIcon(Format);
                
            }
ps.close();
                rs.close();
        } catch (Exception e) {
            System.out.println(e);
            
        }finally {

            try {
                ps.close();
                rs.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "erreur BD");
            }
        }
    }

    public String gettableresult() {
        return test;
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
        jLabel2 = new javax.swing.JLabel();
        btnajout = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_admin = new javax.swing.JTable();
        btnmodif = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnsuppr = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().add(txt_admin);
        txt_admin.setBounds(340, 390, 140, 30);
        getContentPane().add(mdp_admin);
        mdp_admin.setBounds(340, 430, 140, 30);

        jLabel1.setFont(new java.awt.Font("Tekton Pro Ext", 0, 14)); // NOI18N
        jLabel1.setText("Mot de passe");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(230, 440, 120, 15);

        jLabel2.setFont(new java.awt.Font("Tekton Pro Ext", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 255));
        jLabel2.setText("Ajouter un administrateur");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(230, 0, 350, 30);

        btnajout.setFont(new java.awt.Font("Tekton Pro Ext", 0, 18)); // NOI18N
        btnajout.setText("Ajouter");
        btnajout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnajoutActionPerformed(evt);
            }
        });
        getContentPane().add(btnajout);
        btnajout.setBounds(60, 470, 105, 40);

        jLabel3.setFont(new java.awt.Font("Tekton Pro Ext", 0, 14)); // NOI18N
        jLabel3.setText("Id utilisateur");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(230, 340, 150, 20);

        table_admin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_admin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_adminMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                table_adminMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table_admin);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(60, 70, 680, 240);

        btnmodif.setFont(new java.awt.Font("Tekton Pro Ext", 0, 18)); // NOI18N
        btnmodif.setText("Modifier");
        btnmodif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodifActionPerformed(evt);
            }
        });
        getContentPane().add(btnmodif);
        btnmodif.setBounds(190, 470, 140, 40);

        jButton3.setFont(new java.awt.Font("Tekton Pro Ext", 0, 18)); // NOI18N
        jButton3.setText("Actualiser");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(550, 470, 180, 40);

        btnsuppr.setFont(new java.awt.Font("Tekton Pro Ext", 0, 18)); // NOI18N
        btnsuppr.setText("Supprimer");
        btnsuppr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsupprActionPerformed(evt);
            }
        });
        getContentPane().add(btnsuppr);
        btnsuppr.setBounds(360, 470, 160, 40);

        jLabel4.setFont(new java.awt.Font("Tekton Pro Ext", 0, 14)); // NOI18N
        jLabel4.setText("Nom d'utilisateur");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(200, 390, 150, 20);
        getContentPane().add(txt_id);
        txt_id.setBounds(340, 340, 140, 30);

        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel6MousePressed(evt);
            }
        });
        jLabel6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel6MouseDragged(evt);
            }
        });
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 770, 30);

        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel19);
        jLabel19.setBounds(780, 0, 40, 40);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nr/imageNR/4.jpg"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 820, 570);

        setSize(new java.awt.Dimension(816, 573));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnajoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnajoutActionPerformed
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
    }//GEN-LAST:event_btnajoutActionPerformed

    private void table_adminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_adminMouseClicked
btnajout.setEnabled(false);
btnmodif.setEnabled(true);
btnsuppr.setEnabled(true);
        Deplace();        // TODO add your handling code here:
    }//GEN-LAST:event_table_adminMouseClicked

    private void table_adminMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_adminMouseReleased
Deplace();        // TODO add your handling code here:
    }//GEN-LAST:event_table_adminMouseReleased

    private void btnmodifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodifActionPerformed
String t1 = txt_id.getText();

        try { 
            String requete = "update admin set id_admin=?, nom_utilisateur=?, mdp_admin=? where  id_admin ='" + t1 + "'";
       
            ps = conn.prepareStatement(requete);
            ps.setString(1, txt_id.getText());
            ps.setString(2, txt_admin.getText());
           ps.setString(3, mdp_admin.getText());
           
           ps.execute();
            ps.execute();
            txt_id.setText("");
            txt_admin.setText("");
            mdp_admin.setText("");
            Affichage();
            JOptionPane.showMessageDialog(null, "Modification avec succès");
 ps.close();
                rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }finally {

            try {
                ps.close();
                rs.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "errer");
            }
        }           // TODO add your handling code here:
    }//GEN-LAST:event_btnmodifActionPerformed

    private void btnsupprActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsupprActionPerformed
  try {
            if (JOptionPane.showConfirmDialog(null, "attention vous devez suprimer un administrateur ,est ce que vous êtes sur?",
                    "Supprimer Administrateur", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                if (txt_id.getText().length() != 0) {

                    String requete = "delete from admin where id_admin = ?";
                    ps = conn.prepareStatement(requete);
                    ps.setString(1, txt_id.getText());
                    ps.execute();
                    System.out.println("deleted");
                    //JOptionPane.showMessageDialog(null,"deleted");
                   txt_id.setText("");
            txt_admin.setText("");
            mdp_admin.setText("");
            Affichage();
                } else {
                    JOptionPane.showMessageDialog(null, "veuillez choisir  un administrateur !");
                }
            }
              ps.close();
                rs.close();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "erreur de supprimer \n" + e.getMessage());
        }finally {

            try {
                ps.close();
                rs.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "erreur BD");
            }
        }         // TODO add your handling code here:
    }//GEN-LAST:event_btnsupprActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
btnajout.setEnabled(true);
        btnmodif.setEnabled(false);
        btnsuppr.setEnabled(false);    
txt_id.setText("");
        txt_admin.setText("");
        mdp_admin.setText("");
        Affichage();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MousePressed

    private void jLabel6MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation( x - xMouse , y - yMouse);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseDragged

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
admin f = new admin();
f.setVisible(true);
        this.dispose();      // TODO add your handling code here:
    }//GEN-LAST:event_jLabel19MouseClicked

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
            java.util.logging.Logger.getLogger(liste_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(liste_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(liste_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(liste_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new liste_admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnajout;
    private javax.swing.JButton btnmodif;
    private javax.swing.JButton btnsuppr;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField mdp_admin;
    private javax.swing.JTable table_admin;
    private javax.swing.JTextField txt_admin;
    private javax.swing.JTextField txt_id;
    // End of variables declaration//GEN-END:variables
}

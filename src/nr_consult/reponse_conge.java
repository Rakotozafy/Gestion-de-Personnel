/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nr_consult;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author tojo
 */
public class reponse_conge extends javax.swing.JFrame {
Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    static String test ;
    public static String t15;
    public static String t1;
    int xMouse;
      int yMouse;
    /**
     * Creates new form reponse_conge
     */
    public reponse_conge() {
        conn = ConexionBD.Conexion();
        initComponents();
        
        recuperutlisateur();
        Affichage();
    }
public void recuperutlisateur() {
        Authentification lo = new Authentification();

        try {
            String recp = lo.utilisateur();
            String requet = "select * from employe where id_employe = '" + recp + "'";
            ps = conn.prepareStatement(requet);
            rs = ps.executeQuery();
            if (rs.next()) {
               
               
                String t4 = rs.getString("nom");
                txt_nom.setText(t4);
                String t5 = rs.getString("prenom");
                txt_prenom.setText(t5);
                
            }
        } catch (Exception e) {
            System.out.println(e);
        } 
    }
    public String utilisateurs() {
        return t15;
    }
public void Affichage() {
     

        try {
            String r1 = txt_nom.getText();
            
            String requete5 = "select * from conge where nom_employe = '" + r1 + "'";
            ps = conn.prepareStatement(requete5);

            rs = ps.executeQuery();
     
                table_conge.setModel(DbUtils.resultSetToTableModel(rs));
             
        } catch (Exception e) {
            
            System.out.println(e);
        }
        }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table_conge = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        txt_nom = new javax.swing.JTextField();
        txt_prenom = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        table_conge.setModel(new javax.swing.table.DefaultTableModel(
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
        table_conge.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_congeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_conge);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 140, 700, 180);

        jButton1.setFont(new java.awt.Font("Tekton Pro Ext", 0, 24)); // NOI18N
        jButton1.setText("Fermer");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(270, 340, 220, 40);

        txt_nom.setEditable(false);
        txt_nom.setBackground(new java.awt.Color(255, 255, 255));
        txt_nom.setFont(new java.awt.Font("Tekton Pro Ext", 0, 18)); // NOI18N
        txt_nom.setBorder(null);
        txt_nom.setOpaque(false);
        getContentPane().add(txt_nom);
        txt_nom.setBounds(270, 100, 230, 30);

        txt_prenom.setEditable(false);
        txt_prenom.setBackground(new java.awt.Color(255, 255, 255));
        txt_prenom.setFont(new java.awt.Font("Tekton Pro Ext", 0, 18)); // NOI18N
        txt_prenom.setBorder(null);
        txt_prenom.setOpaque(false);
        getContentPane().add(txt_prenom);
        txt_prenom.setBounds(30, 100, 230, 30);

        jLabel1.setFont(new java.awt.Font("Tekton Pro Ext", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 255));
        jLabel1.setText("                        Reponse du congé");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });
        jLabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel1MouseDragged(evt);
            }
        });
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 780, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nr/imageNR/6.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 780, 420);

        setSize(new java.awt.Dimension(781, 420));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void table_congeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_congeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_table_congeMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
    xMouse = evt.getX();
        yMouse = evt.getY();         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MousePressed

    private void jLabel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseDragged
 int x = evt.getXOnScreen();
       int y = evt.getYOnScreen();
       this.setLocation( x - xMouse , y - yMouse);            // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseDragged

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
  // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked
public String utilisateur() {
        return t1;
    }
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
            java.util.logging.Logger.getLogger(reponse_conge.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reponse_conge.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reponse_conge.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reponse_conge.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new reponse_conge().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_conge;
    private javax.swing.JTextField txt_nom;
    private javax.swing.JTextField txt_prenom;
    // End of variables declaration//GEN-END:variables
}

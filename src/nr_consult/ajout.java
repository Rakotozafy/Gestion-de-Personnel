/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nr_consult;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author tojo
 */
public class ajout extends javax.swing.JFrame {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    public String sexee;
    public String etat;
    public ImageIcon Format = null;
    int s = 0;
    int xMouse;
      int yMouse;
    public static byte[] photo;
 byte[] imagedata;
 
    public ajout() {
        
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("logo.png")).getImage());
    conn = ConexionBD.Conexion();
  
    }
public void clear(){
        try{  txt_id.setText("");
        txt_mdp.setText("");
            txt_cin.setText("");
             txt_nom.setText("");
          txt_prenom.setText("");
           txtdtnaissance.setDate(null);
          
          txt_age.setText("");
          com_sex.setSelectedItem("");
          txt_etat.setText("");
          txt_ad.setText("");
          txt_tel.setText("");
          txtdtentrer.setDate(null);
          com_s.setSelectedItem("");
          com_f.setSelectedItem("");
           ImageIcon img202 = new ImageIcon(getClass().getResource("file_image_1.png"));
        image.setIcon(img202);
          txt_img.setText("");
            
        }catch (Exception e) {
           
            System.out.println("--> SQLException : " + e);
        }
    }
      public void imagess() {
        ConexionBD v = new ConexionBD();
        v.filen();
        String vpath = v.getp();
        try {
        if (vpath == null) {

        } else {
            image.setIcon(new ImageIcon(vpath));
            txt_img.setText(vpath);
      } 
            }catch (Exception e) {
                e.printStackTrace();
        }

    }
      public void combodata() {

        try {
            String requete4 = "select * from service ";
            ps = conn.prepareStatement(requete4);

            rs = ps.executeQuery();
            while (rs.next()) {
                String cinm = rs.getString("service");
                com_s.addItem(cinm);

            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }
      public void combodata1() {

        try {
            String requete4 = "select * from fonction ";
            ps = conn.prepareStatement(requete4);

            rs = ps.executeQuery();
            while (rs.next()) {
                String cinm = rs.getString("fonction");
                com_f.addItem(cinm);

            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        image = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txt_img = new javax.swing.JTextField();
        btnpath = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_tel = new javax.swing.JTextField();
        txt_ad = new javax.swing.JTextField();
        txt_etat = new javax.swing.JTextField();
        txt_prenom = new javax.swing.JTextField();
        txt_nom = new javax.swing.JTextField();
        txt_cin = new javax.swing.JTextField();
        txt_mdp = new javax.swing.JTextField();
        txt_id = new javax.swing.JTextField();
        com_f = new javax.swing.JComboBox();
        txtdtentrer = new com.toedter.calendar.JDateChooser();
        com_s = new javax.swing.JComboBox();
        txtdtnaissance = new com.toedter.calendar.JDateChooser();
        txt_age = new javax.swing.JTextField();
        com_sex = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Photo Employé  :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tempus Sans ITC", 1, 12))); // NOI18N

        jScrollPane1.setViewportView(image);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(470, 130, 249, 240);
        jPanel3.getAccessibleContext().setAccessibleName("Photo Employé :");

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        btnpath.setText("Parcourir");
        btnpath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpathActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_img, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnpath, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_img, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnpath)
                .addContainerGap())
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(510, 390, 158, 87);

        jLabel16.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 102, 255));
        jLabel16.setText("Identifiant         :");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(70, 130, 140, 30);

        jLabel15.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 102, 255));
        jLabel15.setText("Mot de passe :");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(70, 170, 140, 30);

        jLabel14.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 102, 255));
        jLabel14.setText("CIN                         :");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(70, 210, 140, 30);

        jLabel13.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 102, 255));
        jLabel13.setText("Nom                      :");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(70, 250, 140, 30);

        jLabel12.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 102, 255));
        jLabel12.setText("Prenom               :");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(70, 290, 140, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 102, 255));
        jLabel11.setText("Date de  naissance :");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(70, 330, 140, 40);

        jLabel10.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 102, 255));
        jLabel10.setText("Age                        :");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(70, 370, 140, 30);

        jLabel9.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 102, 255));
        jLabel9.setText("Sexe                     :");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(70, 410, 140, 30);

        jLabel8.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 102, 255));
        jLabel8.setText("Etat civil           :");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(70, 460, 140, 30);

        jLabel7.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 102, 255));
        jLabel7.setText("Adresse            :");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(70, 510, 140, 30);

        jLabel6.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 102, 255));
        jLabel6.setText("Telephone        :");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(70, 560, 140, 30);

        jLabel5.setFont(new java.awt.Font("Tekton Pro Ext", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 102, 255));
        jLabel5.setText("Date d'entrer  :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(70, 610, 140, 30);

        jLabel4.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 102, 255));
        jLabel4.setText("Sevice               :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(70, 650, 140, 30);

        jLabel3.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 102, 255));
        jLabel3.setText("Fonction         :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(70, 700, 140, 30);

        txt_tel.setBackground(new java.awt.Color(32, 142, 205));
        txt_tel.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txt_tel.setOpaque(false);
        txt_tel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_telKeyTyped(evt);
            }
        });
        getContentPane().add(txt_tel);
        txt_tel.setBounds(220, 560, 230, 30);

        txt_ad.setBackground(new java.awt.Color(32, 142, 205));
        txt_ad.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txt_ad.setOpaque(false);
        getContentPane().add(txt_ad);
        txt_ad.setBounds(220, 510, 230, 30);

        txt_etat.setBackground(new java.awt.Color(32, 142, 205));
        txt_etat.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txt_etat.setOpaque(false);
        getContentPane().add(txt_etat);
        txt_etat.setBounds(220, 460, 230, 30);

        txt_prenom.setBackground(new java.awt.Color(32, 142, 205));
        txt_prenom.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txt_prenom.setOpaque(false);
        getContentPane().add(txt_prenom);
        txt_prenom.setBounds(220, 290, 230, 30);

        txt_nom.setBackground(new java.awt.Color(32, 142, 205));
        txt_nom.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txt_nom.setOpaque(false);
        getContentPane().add(txt_nom);
        txt_nom.setBounds(220, 250, 230, 30);

        txt_cin.setBackground(new java.awt.Color(32, 142, 205));
        txt_cin.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txt_cin.setOpaque(false);
        txt_cin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cinKeyTyped(evt);
            }
        });
        getContentPane().add(txt_cin);
        txt_cin.setBounds(220, 210, 230, 30);

        txt_mdp.setBackground(new java.awt.Color(32, 142, 205));
        txt_mdp.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txt_mdp.setOpaque(false);
        txt_mdp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_mdpActionPerformed(evt);
            }
        });
        getContentPane().add(txt_mdp);
        txt_mdp.setBounds(220, 170, 230, 30);

        txt_id.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txt_id.setOpaque(false);
        getContentPane().add(txt_id);
        txt_id.setBounds(220, 130, 230, 30);

        com_f.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                com_fMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                com_fMouseReleased(evt);
            }
        });
        com_f.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                com_fItemStateChanged(evt);
            }
        });
        com_f.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                com_fPropertyChange(evt);
            }
        });
        getContentPane().add(com_f);
        com_f.setBounds(220, 700, 230, 30);

        txtdtentrer.setDateFormatString("yyyy-MM-dd");
        txtdtentrer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtdtentrerMouseReleased(evt);
            }
        });
        txtdtentrer.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                txtdtentrerComponentAdded(evt);
            }
        });
        txtdtentrer.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                txtdtentrerAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        txtdtentrer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdtentrerKeyReleased(evt);
            }
        });
        getContentPane().add(txtdtentrer);
        txtdtentrer.setBounds(220, 610, 230, 30);

        com_s.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                com_sMouseClicked(evt);
            }
        });
        com_s.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                com_sPropertyChange(evt);
            }
        });
        getContentPane().add(com_s);
        com_s.setBounds(220, 650, 230, 30);

        txtdtnaissance.setDateFormatString("yyyy-MM-dd");
        txtdtnaissance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtdtnaissanceMouseReleased(evt);
            }
        });
        txtdtnaissance.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                txtdtnaissanceComponentAdded(evt);
            }
        });
        txtdtnaissance.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                txtdtnaissanceAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        txtdtnaissance.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdtnaissanceKeyReleased(evt);
            }
        });
        getContentPane().add(txtdtnaissance);
        txtdtnaissance.setBounds(220, 330, 230, 30);

        txt_age.setEditable(false);
        txt_age.setBackground(new java.awt.Color(32, 142, 205));
        txt_age.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txt_age.setOpaque(false);
        txt_age.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_ageMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_ageMouseEntered(evt);
            }
        });
        getContentPane().add(txt_age);
        txt_age.setBounds(220, 370, 230, 30);

        com_sex.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Homme", "Femme" }));
        getContentPane().add(com_sex);
        com_sex.setBounds(220, 410, 230, 30);

        jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel17);
        jLabel17.setBounds(170, 780, 130, 30);

        jLabel18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel18);
        jLabel18.setBounds(480, 780, 130, 30);

        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });
        jLabel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel2MouseDragged(evt);
            }
        });
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 720, 30);

        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel19);
        jLabel19.setBounds(730, 0, 40, 40);

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nr/imageNR/22.jpg"))); // NOI18N
        getContentPane().add(jLabel20);
        jLabel20.setBounds(0, 0, 780, 820);

        setSize(new java.awt.Dimension(779, 816));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnpathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpathActionPerformed
        imagess();
    }//GEN-LAST:event_btnpathActionPerformed

    private void txt_mdpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_mdpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_mdpActionPerformed

    private void txtdtentrerMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtdtentrerMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdtentrerMouseReleased

    private void txtdtentrerComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_txtdtentrerComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdtentrerComponentAdded

    private void txtdtentrerAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txtdtentrerAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdtentrerAncestorAdded

    private void txtdtentrerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdtentrerKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdtentrerKeyReleased

    private void txtdtnaissanceMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtdtnaissanceMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdtnaissanceMouseReleased

    private void txtdtnaissanceComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_txtdtnaissanceComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdtnaissanceComponentAdded

    private void txtdtnaissanceAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txtdtnaissanceAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdtnaissanceAncestorAdded

    private void txtdtnaissanceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdtnaissanceKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdtnaissanceKeyReleased

    private void txt_ageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_ageMouseEntered
     
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ageMouseEntered

    private void txt_ageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_ageMouseClicked
   try {
            Date actuelle = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy");
            String date = dateFormat.format(actuelle);
            String dc = date;

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy", Locale.getDefault());
            String d = sdf.format(txtdtnaissance.getDate());

            int d1 = Integer.parseInt(dc);
            int d2 = Integer.parseInt(d);

            int r = (d1 - d2);
            String resultat = String.valueOf(r);
            txt_age.setText(resultat);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Taper la Date de Naissance");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ageMouseClicked

    private void com_sMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_com_sMouseClicked
combodata();      // TODO add your handling code here:
    }//GEN-LAST:event_com_sMouseClicked

    private void com_fItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_com_fItemStateChanged
     // TODO add your handling code here:
    }//GEN-LAST:event_com_fItemStateChanged

    private void com_fPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_com_fPropertyChange
           // TODO add your handling code here:
    }//GEN-LAST:event_com_fPropertyChange

    private void com_fMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_com_fMouseReleased
       // TODO add your handling code here:
    }//GEN-LAST:event_com_fMouseReleased

    private void com_sPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_com_sPropertyChange
          // TODO add your handling code here:
    }//GEN-LAST:event_com_sPropertyChange

    private void txt_cinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cinKeyTyped
  char t = evt.getKeyChar();
        if (!(Character.isDigit(t) || (t == KeyEvent.VK_BACK_SPACE) || (t == KeyEvent.VK_DELETE))) {
            evt.consume();  }      // TODO add your handling code here:
    }//GEN-LAST:event_txt_cinKeyTyped

    private void txt_telKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telKeyTyped
 char t = evt.getKeyChar();
        if (!(Character.isDigit(t) || (t == KeyEvent.VK_BACK_SPACE) || (t == KeyEvent.VK_DELETE))) {
            evt.consume();  }          // TODO add your handling code here:
    }//GEN-LAST:event_txt_telKeyTyped

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        
      Date actuelle = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(actuelle);
        String dc = date;
     //  String com_service = (String) com_s.getSelectedItem();
       //String com_fonction = (String) com_f.getSelectedItem();
        if (txt_cin.getText().equals("") || txt_nom.getText().equals("")|| txt_prenom.getText().equals("") || txt_age.getText().equals("")|| txt_ad.getText().equals("")   || txt_mdp.getText().equals("")   ) {
            JOptionPane.showMessageDialog(this, "SVP entrer les informations complete");
        } else {
        try {
             String requete = "INSERT INTO employe(mdp, cin, nom, prenom, date_naiss, age, sexe, photo, etat_civil, adresse, tel, date_entrer, service, fonction) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
           
            ps = conn.prepareStatement(requete);
            ps.setString(1, txt_mdp.getText());
            ps.setString(2, txt_cin.getText());
            ps.setString(3, txt_nom.getText());
            ps.setString(4, txt_prenom.getText());
            ps.setString(5, ((JTextField) txtdtnaissance.getDateEditor().getUiComponent()).getText());
            ps.setString(6, txt_age.getText());
            ps.setString(7, com_sex.getSelectedItem().toString());
            ps.setString(8, txt_img.getText());
            ps.setString(9, txt_etat.getText());
            ps.setString(10, txt_ad.getText());
            ps.setString(11, txt_tel.getText());
            ps.setString(12, ((JTextField) txtdtentrer.getDateEditor().getUiComponent()).getText());
            ps.setString(13, com_s.getSelectedItem().toString());
            ps.setString(14, com_f.getSelectedItem().toString());
           
           ps.execute();

            JOptionPane.showMessageDialog(null, "Enregistrement avec succès");
            ps.close();
            rs.close();
            clear();

        } catch (Exception e) {
            System.out.println("--> SQLException : " + e);
            
          
        }
        }       // TODO add your handling code here:
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
clear();
admin v = new admin();
v.setVisible(true);
this.dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
admin v = new admin();
v.setVisible(true);
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
     xMouse = evt.getX();
        yMouse = evt.getY();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MousePressed

    private void jLabel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseDragged
  int x = evt.getXOnScreen();
       int y = evt.getYOnScreen();
       this.setLocation( x - xMouse , y - yMouse);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseDragged

    private void com_fMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_com_fMouseClicked
 combodata1();        // TODO add your handling code here:
    }//GEN-LAST:event_com_fMouseClicked

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
            java.util.logging.Logger.getLogger(ajout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ajout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ajout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ajout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ajout().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnpath;
    private javax.swing.JComboBox com_f;
    private javax.swing.JComboBox com_s;
    private javax.swing.JComboBox com_sex;
    private javax.swing.JLabel image;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_ad;
    private javax.swing.JTextField txt_age;
    private javax.swing.JTextField txt_cin;
    private javax.swing.JTextField txt_etat;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_img;
    private javax.swing.JTextField txt_mdp;
    private javax.swing.JTextField txt_nom;
    private javax.swing.JTextField txt_prenom;
    private javax.swing.JTextField txt_tel;
    private com.toedter.calendar.JDateChooser txtdtentrer;
    private com.toedter.calendar.JDateChooser txtdtnaissance;
    // End of variables declaration//GEN-END:variables
}

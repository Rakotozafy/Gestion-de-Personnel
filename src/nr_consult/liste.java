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
import java.text.MessageFormat;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;
import nr_consult.ConexionBD;
import nr_consult.admin;

/**
 *
 * @author tojo
 */
public class liste extends javax.swing.JFrame {
 Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
     static String test;
    static String te;
    /**
     * Creates new form liste
     */
    
    
    public liste() {
         conn = ConexionBD.Conexion();
        initComponents();
         
          Affichage();
          btnajout.setEnabled(true);

        modifierbtn.setEnabled(false);
        btnsupprimer.setEnabled(false);
    }
 public void Affichage() {
        try {
            String requete = "Select * from employe ";
            ps = conn.prepareStatement(requete);
            rs = ps.executeQuery();
            Table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            System.out.println(e);
        }
        }
 
 public void Deplace() {
        try {

            int row = Table.getSelectedRow();
            this.test = (Table.getModel().getValueAt(row, 0).toString());
            String requet = " select * from  employe where id_employe = '" + test + "' ";
            ps = conn.prepareStatement(requet);
            rs = ps.executeQuery();

            if (rs.next()) {
                String t1 = rs.getString("id_employe");
                txt_id.setText(t1);
                String t2 = rs.getString("mdp");
                txt_mdp.setText(t2);
                String t3 = rs.getString("cin");
                txt_cin.setText(t3);
                String t4 = rs.getString("nom");
                txt_nom.setText(t4);
                String t5 = rs.getString("prenom");
                txt_prenom.setText(t5);
                String t6 = rs.getString("date_naiss");
                txt_naiss.setText(t6);
                String t7 = rs.getString("age");
                txt_age.setText(t7);
                String t8 = rs.getString("sexe");
                txt_sexe.setText(t8);
                String t9 =rs.getString("photo");
                if(t9.equals("")){
                    ImageIcon img202 = new ImageIcon(getClass().getResource("file_image_1.png"));
        image.setIcon(img202);
                }else{
                    image.setIcon(new ImageIcon(t9));
                }
                
                String t10 = rs.getString("etat_civil");
                txt_etat.setText(t10);
                String t11 = rs.getString("adresse");
                txt_ad.setText(t11);
                String t12 = rs.getString("tel");
                txt_tel.setText(t12);
                 String t13 = rs.getString("date_entrer");
                txt_date.setText(t13);
                 String t14 = rs.getString("service");
                txt_service.setText(t14);
                String t15 = rs.getString("fonction");
                txt_fonction.setText(t15);
                
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
    public void clear(){
        try{  txt_id.setText("");
        txt_mdp.setText("");
            txt_cin.setText("");
             txt_nom.setText("");
          txt_prenom.setText("");
          
          txt_naiss.setText("");
          txt_age.setText("");
          txt_sexe.setText("");
          txt_etat.setText("");
          txt_ad.setText("");
          txt_tel.setText("");
          txt_date.setText("");
          txt_service.setText("");
          txt_fonction.setText("");
           ImageIcon img202 = new ImageIcon(getClass().getResource("file_image_1.png"));
        image.setIcon(img202);
          txt_image.setText("");
            
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
            txt_image.setText(vpath);
      } 
            }catch (Exception e) {
                e.printStackTrace();
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
        Table = new javax.swing.JTable();
        txtrechercher = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_mdp = new javax.swing.JTextField();
        txt_cin = new javax.swing.JTextField();
        txt_nom = new javax.swing.JTextField();
        txt_prenom = new javax.swing.JTextField();
        txt_naiss = new javax.swing.JTextField();
        txt_age = new javax.swing.JTextField();
        txt_sexe = new javax.swing.JTextField();
        txt_etat = new javax.swing.JTextField();
        txt_ad = new javax.swing.JTextField();
        txt_tel = new javax.swing.JTextField();
        txt_date = new javax.swing.JTextField();
        txt_service = new javax.swing.JTextField();
        txt_fonction = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnsupprimer = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnajout = new javax.swing.JButton();
        modifierbtn = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        image = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txt_image = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id employé", "Mot de passe", "CIN", "Nom", "Prenom", "Date de naissance", "Age", "Sexe", "Photo", "Etat civil", "Adresse", "Telephone", "Date d'entrer", "Service", "Fonction"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TableMouseReleased(evt);
            }
        });
        Table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(Table);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 90, 1150, 260);

        txtrechercher.setBorder(null);
        txtrechercher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtrechercherMouseClicked(evt);
            }
        });
        txtrechercher.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtrechercherKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtrechercherKeyTyped(evt);
            }
        });
        getContentPane().add(txtrechercher);
        txtrechercher.setBounds(910, 20, 230, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nr_consult/z22.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(900, 10, 280, 40);

        txt_id.setBackground(new java.awt.Color(32, 142, 205));
        txt_id.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_id.setForeground(new java.awt.Color(204, 255, 255));
        txt_id.setOpaque(false);
        txt_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_idKeyTyped(evt);
            }
        });
        getContentPane().add(txt_id);
        txt_id.setBounds(180, 370, 230, 30);

        txt_mdp.setBackground(new java.awt.Color(32, 142, 205));
        txt_mdp.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_mdp.setForeground(new java.awt.Color(204, 255, 255));
        txt_mdp.setOpaque(false);
        txt_mdp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_mdpActionPerformed(evt);
            }
        });
        getContentPane().add(txt_mdp);
        txt_mdp.setBounds(180, 410, 230, 30);

        txt_cin.setBackground(new java.awt.Color(32, 142, 205));
        txt_cin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_cin.setForeground(new java.awt.Color(204, 255, 255));
        txt_cin.setOpaque(false);
        txt_cin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cinKeyTyped(evt);
            }
        });
        getContentPane().add(txt_cin);
        txt_cin.setBounds(180, 450, 230, 30);

        txt_nom.setBackground(new java.awt.Color(32, 142, 205));
        txt_nom.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_nom.setForeground(new java.awt.Color(204, 255, 255));
        txt_nom.setOpaque(false);
        getContentPane().add(txt_nom);
        txt_nom.setBounds(180, 490, 230, 30);

        txt_prenom.setBackground(new java.awt.Color(32, 142, 205));
        txt_prenom.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_prenom.setForeground(new java.awt.Color(204, 255, 255));
        txt_prenom.setOpaque(false);
        getContentPane().add(txt_prenom);
        txt_prenom.setBounds(180, 530, 230, 30);

        txt_naiss.setBackground(new java.awt.Color(32, 142, 205));
        txt_naiss.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_naiss.setForeground(new java.awt.Color(204, 255, 255));
        txt_naiss.setOpaque(false);
        getContentPane().add(txt_naiss);
        txt_naiss.setBounds(180, 570, 230, 30);

        txt_age.setBackground(new java.awt.Color(32, 142, 205));
        txt_age.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_age.setForeground(new java.awt.Color(204, 255, 255));
        txt_age.setOpaque(false);
        txt_age.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_ageKeyTyped(evt);
            }
        });
        getContentPane().add(txt_age);
        txt_age.setBounds(180, 610, 230, 30);

        txt_sexe.setBackground(new java.awt.Color(32, 142, 205));
        txt_sexe.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_sexe.setForeground(new java.awt.Color(204, 255, 255));
        txt_sexe.setOpaque(false);
        getContentPane().add(txt_sexe);
        txt_sexe.setBounds(180, 650, 230, 30);

        txt_etat.setBackground(new java.awt.Color(32, 142, 205));
        txt_etat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_etat.setForeground(new java.awt.Color(204, 255, 255));
        txt_etat.setOpaque(false);
        getContentPane().add(txt_etat);
        txt_etat.setBounds(590, 380, 230, 30);

        txt_ad.setBackground(new java.awt.Color(32, 142, 205));
        txt_ad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_ad.setForeground(new java.awt.Color(204, 255, 255));
        txt_ad.setOpaque(false);
        getContentPane().add(txt_ad);
        txt_ad.setBounds(590, 430, 230, 30);

        txt_tel.setBackground(new java.awt.Color(32, 142, 205));
        txt_tel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_tel.setForeground(new java.awt.Color(204, 255, 255));
        txt_tel.setOpaque(false);
        txt_tel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_telKeyTyped(evt);
            }
        });
        getContentPane().add(txt_tel);
        txt_tel.setBounds(590, 480, 230, 30);

        txt_date.setBackground(new java.awt.Color(32, 142, 205));
        txt_date.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_date.setForeground(new java.awt.Color(204, 255, 255));
        txt_date.setOpaque(false);
        getContentPane().add(txt_date);
        txt_date.setBounds(590, 530, 230, 30);

        txt_service.setBackground(new java.awt.Color(32, 142, 205));
        txt_service.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_service.setForeground(new java.awt.Color(204, 255, 255));
        txt_service.setOpaque(false);
        getContentPane().add(txt_service);
        txt_service.setBounds(590, 570, 230, 30);

        txt_fonction.setBackground(new java.awt.Color(32, 142, 205));
        txt_fonction.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_fonction.setForeground(new java.awt.Color(204, 255, 255));
        txt_fonction.setOpaque(false);
        getContentPane().add(txt_fonction);
        txt_fonction.setBounds(590, 620, 230, 30);

        jLabel3.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fonction         :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(440, 620, 140, 30);

        jLabel4.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Sevice               :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(440, 570, 140, 30);

        jLabel5.setFont(new java.awt.Font("Tekton Pro Ext", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Date d'entrer  :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(440, 530, 140, 30);

        jLabel6.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Telephone        :");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(440, 480, 140, 30);

        jLabel18.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Adresse            :");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(440, 430, 140, 30);

        jLabel8.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Etat civil           :");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(440, 380, 140, 30);

        jLabel9.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Sexe                     :");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(30, 650, 140, 30);

        jLabel10.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Age                        :");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(30, 610, 140, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Date de  naissance :");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(30, 570, 140, 40);

        jLabel12.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Prenom               :");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(30, 530, 140, 30);

        jLabel13.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Nom                      :");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(30, 490, 140, 30);

        jLabel14.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("CIN                         :");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(30, 450, 140, 30);

        jLabel15.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Mot de passe :");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(30, 410, 140, 30);

        jLabel16.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Identifiant         :");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(30, 370, 140, 30);

        jButton1.setFont(new java.awt.Font("Tekton Pro Ext", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 153, 255));
        jButton1.setText("Retour");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(30, 10, 190, 40);

        btnsupprimer.setBackground(new java.awt.Color(204, 204, 204));
        btnsupprimer.setFont(new java.awt.Font("Tekton Pro Ext", 0, 18)); // NOI18N
        btnsupprimer.setForeground(new java.awt.Color(51, 153, 255));
        btnsupprimer.setText("Supprimer");
        btnsupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsupprimerActionPerformed(evt);
            }
        });
        getContentPane().add(btnsupprimer);
        btnsupprimer.setBounds(450, 710, 190, 50);

        jButton3.setBackground(new java.awt.Color(204, 204, 204));
        jButton3.setFont(new java.awt.Font("Tekton Pro Ext", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 153, 255));
        jButton3.setText("Actualiser");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(650, 710, 190, 50);

        btnajout.setBackground(new java.awt.Color(204, 204, 204));
        btnajout.setFont(new java.awt.Font("Tekton Pro Ext", 0, 18)); // NOI18N
        btnajout.setForeground(new java.awt.Color(51, 153, 255));
        btnajout.setText("Ajouter");
        btnajout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnajoutActionPerformed(evt);
            }
        });
        getContentPane().add(btnajout);
        btnajout.setBounds(30, 710, 190, 50);

        modifierbtn.setBackground(new java.awt.Color(204, 204, 204));
        modifierbtn.setFont(new java.awt.Font("Tekton Pro Ext", 0, 18)); // NOI18N
        modifierbtn.setForeground(new java.awt.Color(51, 153, 255));
        modifierbtn.setText("Modifier");
        modifierbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierbtnActionPerformed(evt);
            }
        });
        getContentPane().add(modifierbtn);
        modifierbtn.setBounds(240, 710, 190, 50);

        jButton6.setBackground(new java.awt.Color(204, 204, 204));
        jButton6.setFont(new java.awt.Font("Tekton Pro Ext", 0, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(51, 153, 255));
        jButton6.setText("Imprimer");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(880, 710, 190, 50);

        jLabel7.setFont(new java.awt.Font("Tempus Sans ITC", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 255));
        jLabel7.setText("Liste Des employés");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(430, 10, 300, 40);

        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nr_consult/file_image_1.png"))); // NOI18N
        getContentPane().add(image);
        image.setBounds(860, 380, 230, 200);

        jButton2.setFont(new java.awt.Font("Tekton Pro Ext", 0, 14)); // NOI18N
        jButton2.setText("Parcourir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(920, 640, 110, 30);

        txt_image.setBackground(new java.awt.Color(32, 142, 205));
        txt_image.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_image.setForeground(new java.awt.Color(204, 255, 255));
        txt_image.setOpaque(false);
        getContentPane().add(txt_image);
        txt_image.setBounds(860, 600, 230, 30);

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nr/imageNR/aj.jpg"))); // NOI18N
        getContentPane().add(jLabel19);
        jLabel19.setBounds(0, 0, 1200, 900);

        setSize(new java.awt.Dimension(1207, 804));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked

btnajout.setEnabled(false);
Deplace();        // TODO add your handling code here:
    }//GEN-LAST:event_TableMouseClicked

    private void TableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TableKeyReleased
      if((evt.getKeyCode()==KeyEvent.VK_UP)||(evt.getKeyCode()==KeyEvent.VK_DOWN)){
                  ImageIcon img202 = new ImageIcon(getClass().getResource("file_image_1.png"));
              image.setIcon(img202);
                       Deplace();

            }        // TODO add your handling code here:
    }//GEN-LAST:event_TableKeyReleased

    private void txt_mdpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_mdpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_mdpActionPerformed

    private void modifierbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierbtnActionPerformed
 String t1 = txt_id.getText();

        try { 
            String requete = "update employe set id_employe=? ,mdp=?, cin =?,nom =?,prenom=?,date_naiss=?,age =?,sexe =?,photo =?,etat_civil=?, adresse=?,tel=?,date_entrer=?,service=?,fonction=? where  id_employe ='" + t1 + "'";
       
            ps = conn.prepareStatement(requete);
            ps.setString(1, txt_id.getText());
            ps.setString(2, txt_mdp.getText());
            ps.setString(3, txt_cin.getText());
            ps.setString(4, txt_nom.getText());
            ps.setString(5, txt_prenom.getText());
           ps.setString(6, txt_naiss.getText());
            ps.setString(7, txt_age.getText());
            ps.setString(8, txt_sexe.getText());
            ps.setString(9, txt_image.getText());
            ps.setString(10, txt_etat.getText());
            ps.setString(11, txt_ad.getText());
            ps.setString(12, txt_tel.getText());
            ps.setString(13, txt_date.getText());
            ps.setString(14, txt_service.getText());
            ps.setString(15, txt_fonction.getText());
           
           ps.execute();
            ps.execute();
            JOptionPane.showMessageDialog(null, "Modification avec succès");
 ps.close();
                rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }finally {

            try {
                ps.close();
                rs.close();
                clear();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "errer");
            }
        }       // TODO add your handling code here:
    }//GEN-LAST:event_modifierbtnActionPerformed

    private void TableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseReleased
 btnsupprimer.setEnabled(true);
        modifierbtn.setEnabled(true);
       
//        btninscri.setEnabled(true);
        ImageIcon img202 = new ImageIcon(getClass().getResource("file_image_1.png"));
        image.setIcon(img202);
        Deplace();        // TODO add your handling code here:
    }//GEN-LAST:event_TableMouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 admin k = new admin();
k.setVisible(true);
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnsupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsupprimerActionPerformed
     try {
            if (JOptionPane.showConfirmDialog(null, "attention vous devez suprimer un employé,est ce que vous êtes sur?",
                    "Supprimer Employé", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                if (txt_id.getText().length() != 0) {

                    String requete = "delete from employe where id_employe = ?";
                    ps = conn.prepareStatement(requete);
                    ps.setString(1, txt_id.getText());
                    ps.execute();
                    System.out.println("deleted");
                    //JOptionPane.showMessageDialog(null,"deleted");
                    
                } else {
                    JOptionPane.showMessageDialog(null, "veuillez choisir  un employé !");
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
        } clear();
        btnsupprimer.setEnabled(false);
        modifierbtn.setEnabled(false);
       
//        btninscri.setEnabled(false);
        Affichage();
       
              // TODO add your handling code here:
    }//GEN-LAST:event_btnsupprimerActionPerformed

    private void btnajoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnajoutActionPerformed
ajout p  =  new ajout();
p.setVisible(true);
this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_btnajoutActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
imagess();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        MessageFormat header = new MessageFormat("Liste des Employes :");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        try {
            Table.print(JTable.PrintMode.NORMAL, header, footer);

        } catch (java.awt.print.PrinterException e) {
            System.err.format("Erreur d'impression ", e.getMessage());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
  Affichage();
        
        clear();
        btnajout.setEnabled(true);

        modifierbtn.setEnabled(false);
        btnsupprimer.setEnabled(false);
          ImageIcon img202 = new ImageIcon(getClass().getResource("file_image_1.png"));
        image.setIcon(img202);
// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtrechercherKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtrechercherKeyReleased
try {
String requete = "select * from  employe where id_employe LIKE ?" ;
            ps = conn.prepareStatement(requete);
            ps.setString(1, "%"+txtrechercher.getText()+"%");
            rs = ps.executeQuery();
            Table.setModel(DbUtils.resultSetToTableModel(rs));
//             byte[] imagedata =rs.getBytes("image");
//                Format = new ImageIcon(imagedata);
//                image.setIcon(Format);
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
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtrechercherKeyReleased

    private void txtrechercherKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtrechercherKeyTyped
 clear();        // TODO add your handling code here:
    }//GEN-LAST:event_txtrechercherKeyTyped

    private void txtrechercherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtrechercherMouseClicked
Affichage();  
clear();        // TODO add your handling code here:
    }//GEN-LAST:event_txtrechercherMouseClicked

    private void txt_cinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cinKeyTyped
 char t = evt.getKeyChar();
        if (!(Character.isDigit(t) || (t == KeyEvent.VK_BACK_SPACE) || (t == KeyEvent.VK_DELETE))) {
            evt.consume();  }        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cinKeyTyped

    private void txt_idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_idKeyTyped
 char t = evt.getKeyChar();
        if (!(Character.isDigit(t) || (t == KeyEvent.VK_BACK_SPACE) || (t == KeyEvent.VK_DELETE))) {
            evt.consume();  }        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idKeyTyped

    private void txt_ageKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ageKeyTyped
 char t = evt.getKeyChar();
        if (!(Character.isDigit(t) || (t == KeyEvent.VK_BACK_SPACE) || (t == KeyEvent.VK_DELETE))) {
            evt.consume();  }        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ageKeyTyped

    private void txt_telKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telKeyTyped
 char t = evt.getKeyChar();
        if (!(Character.isDigit(t) || (t == KeyEvent.VK_BACK_SPACE) || (t == KeyEvent.VK_DELETE))) {
            evt.consume();  }        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telKeyTyped

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
            java.util.logging.Logger.getLogger(liste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(liste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(liste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(liste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new liste().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JButton btnajout;
    private javax.swing.JButton btnsupprimer;
    private javax.swing.JLabel image;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modifierbtn;
    private javax.swing.JTextField txt_ad;
    private javax.swing.JTextField txt_age;
    private javax.swing.JTextField txt_cin;
    private javax.swing.JTextField txt_date;
    private javax.swing.JTextField txt_etat;
    private javax.swing.JTextField txt_fonction;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_image;
    private javax.swing.JTextField txt_mdp;
    private javax.swing.JTextField txt_naiss;
    private javax.swing.JTextField txt_nom;
    private javax.swing.JTextField txt_prenom;
    private javax.swing.JTextField txt_service;
    private javax.swing.JTextField txt_sexe;
    private javax.swing.JTextField txt_tel;
    private javax.swing.JTextField txtrechercher;
    // End of variables declaration//GEN-END:variables
}

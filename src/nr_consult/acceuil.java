/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nr_consult;

import java.awt.Color;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static nr_consult.acceuil.t15;

/**
 *
 * @author tojo
 */
public class acceuil extends javax.swing.JFrame {

    public static String re;
    public static String t15;
    public static String t1;
    
    public ImageIcon Format = null;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;

    /**
     * Creates new form acceuil
     */
    public acceuil() {
        initComponents();
        datecourante();
        this.setIconImage(new ImageIcon(getClass().getResource("logo.png")).getImage());
        conn = ConexionBD.Conexion();
        recuperutlisateur();
        reste();
     
    }

    public void datecourante() {
        Thread clock = new Thread() {
            public void run() {
                for (;;) {
                    Calendar Cal = new GregorianCalendar();

                    int sconde = Cal.get(Calendar.SECOND);
                    int minute = Cal.get(Calendar.MINUTE);
                    int heure = Cal.get(Calendar.HOUR);
                    int AM_PM = Cal.get(Calendar.AM_PM);
                    String pa;
                    if (AM_PM == 1) {
                        pa = "PM";
                    } else {
                        pa = "AM";
                    }

                    labDate.setText(+heure + ":" + (minute) + ":" + sconde + " " + pa);

                    int mois = Cal.get(Calendar.MONTH);
                    int annee = Cal.get(Calendar.YEAR);
                    int jour = Cal.get(Calendar.DAY_OF_MONTH);

                    labdate2.setText(+annee + "-" + (mois + 1) + "-" + jour);

                    try {
                        sleep(1000);

                    } catch (InterruptedException ex) {
                        Logger.getLogger(Calendar.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }

        };

        clock.start();
    }

    public void recuperutlisateur() {
        Authentification lo = new Authentification();

        try {
            String recp = lo.utilisateur();
            String requet = "select * from employe where id_employe = '" + recp + "'";
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
                String t9 = rs.getString("photo");
                if (t9.equals("")) {
                    ImageIcon img202 = new ImageIcon(getClass().getResource("file_image_1.png"));
                    image.setIcon(img202);
                } else {
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
                this.t15 = rs.getString("fonction");
                txt_fonction.setText(t15);

                ps.close();
                rs.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {

            try {
                ps.close();
                rs.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "erreur BD");
            }
        }
    }

    public String utilisateurs() {
        return t15;
    }

    public void reste() {

        String r1 = txt_nom.getText();

        try {
            String requete4 = "select MIN(reste) from conge where nom_employe='" + r1 + "'";
            ps = conn.prepareStatement(requete4);

            rs = ps.executeQuery();
            while (rs.next()) {
                String reste = rs.getString("MIN(reste)");
                if(reste==null){
                    
                 j_reste.setText("30");
                }
                else{
                j_reste.setText(reste);
                ps.close();
                rs.close();
            }}

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void kajy() {

        java.util.Date d1 = date_deb1.getDate();
        java.util.Date d2 = date_ret1.getDate();

        long jour1 = (d1.getTime() / (1000 * 60 * 60 * 24));
        long jour2 = (d2.getTime() / (1000 * 60 * 60 * 24));

        if (jour2 < jour1) {
            JOptionPane.showMessageDialog(this, "Impossible de demander un congé car la date de retour est infferieur a la date de debut");
            nbj1.setText("");
        } else {
            long jour = jour1 - jour2;
            if (jour < 0) {
                jour *= -1;
            }

            nbj1.setText("" + Long.toString(jour));

        }
    }
    public void vert(){
         
        try {
            while (rs.next()) {
                btnpresence.setEnabled(false);
            }

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

        txt_admin = new javax.swing.JTextField();
        mdp_admin = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
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
        txt_id = new javax.swing.JTextField();
        labDate = new javax.swing.JLabel();
        labdate2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        date_deb = new com.toedter.calendar.JDateChooser();
        date_ret1 = new com.toedter.calendar.JDateChooser();
        nbj1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btnpresence = new javax.swing.JButton();
        nbj = new javax.swing.JTextField();
        date_ret = new com.toedter.calendar.JDateChooser();
        date_deb1 = new com.toedter.calendar.JDateChooser();
        jButton8 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        labpre = new javax.swing.JLabel();
        image = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        motif = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        motif1 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        j_reste = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        txt_admin.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        txt_admin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_admin.setBorder(null);
        txt_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_adminActionPerformed(evt);
            }
        });
        getContentPane().add(txt_admin);
        txt_admin.setBounds(950, 500, 110, 17);

        mdp_admin.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        mdp_admin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mdp_admin.setBorder(null);
        getContentPane().add(mdp_admin);
        mdp_admin.setBounds(950, 550, 110, 17);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tekton Pro", 0, 24)); // NOI18N
        jButton1.setText("Connexion");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(950, 600, 160, 40);

        jLabel2.setFont(new java.awt.Font("Tekton Pro Ext", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Bienvenue");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 0, 210, 40);

        jLabel3.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fonction         :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 640, 140, 30);

        jLabel4.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Sevice               :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 590, 140, 30);

        jLabel5.setFont(new java.awt.Font("Tekton Pro Ext", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Date d'entrer  :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 550, 140, 30);

        jLabel6.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Telephone        :");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(30, 500, 140, 30);

        jLabel7.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nombre de jour :");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(470, 220, 160, 30);

        jLabel8.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Etat civil           :");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(30, 400, 140, 30);

        jLabel9.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Sexe                     :");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(30, 350, 140, 30);

        jLabel10.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Age                        :");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(30, 310, 140, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Date de  naissance :");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(30, 270, 140, 40);

        jLabel12.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Prenom               :");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(30, 230, 140, 30);

        jLabel13.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Nom                      :");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(30, 190, 140, 30);

        jLabel14.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("CIN                         :");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(30, 150, 140, 30);

        jLabel15.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Mot de passe :");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(30, 110, 140, 30);

        jLabel16.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Identifiant         :");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(30, 70, 140, 30);

        txt_mdp.setEditable(false);
        txt_mdp.setBackground(new java.awt.Color(32, 142, 205));
        txt_mdp.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_mdp.setForeground(new java.awt.Color(255, 255, 255));
        txt_mdp.setOpaque(false);
        txt_mdp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_mdpActionPerformed(evt);
            }
        });
        getContentPane().add(txt_mdp);
        txt_mdp.setBounds(180, 110, 230, 30);

        txt_cin.setEditable(false);
        txt_cin.setBackground(new java.awt.Color(32, 142, 205));
        txt_cin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_cin.setForeground(new java.awt.Color(255, 255, 255));
        txt_cin.setOpaque(false);
        getContentPane().add(txt_cin);
        txt_cin.setBounds(180, 150, 230, 30);

        txt_nom.setEditable(false);
        txt_nom.setBackground(new java.awt.Color(32, 142, 205));
        txt_nom.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_nom.setForeground(new java.awt.Color(255, 255, 255));
        txt_nom.setOpaque(false);
        getContentPane().add(txt_nom);
        txt_nom.setBounds(180, 190, 230, 30);

        txt_prenom.setEditable(false);
        txt_prenom.setBackground(new java.awt.Color(32, 142, 205));
        txt_prenom.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_prenom.setForeground(new java.awt.Color(255, 255, 255));
        txt_prenom.setOpaque(false);
        getContentPane().add(txt_prenom);
        txt_prenom.setBounds(180, 230, 230, 30);

        txt_naiss.setEditable(false);
        txt_naiss.setBackground(new java.awt.Color(32, 142, 205));
        txt_naiss.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_naiss.setForeground(new java.awt.Color(255, 255, 255));
        txt_naiss.setOpaque(false);
        getContentPane().add(txt_naiss);
        txt_naiss.setBounds(180, 270, 230, 30);

        txt_age.setEditable(false);
        txt_age.setBackground(new java.awt.Color(32, 142, 205));
        txt_age.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_age.setForeground(new java.awt.Color(255, 255, 255));
        txt_age.setOpaque(false);
        getContentPane().add(txt_age);
        txt_age.setBounds(180, 310, 230, 30);

        txt_sexe.setEditable(false);
        txt_sexe.setBackground(new java.awt.Color(32, 142, 205));
        txt_sexe.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_sexe.setForeground(new java.awt.Color(255, 255, 255));
        txt_sexe.setOpaque(false);
        getContentPane().add(txt_sexe);
        txt_sexe.setBounds(180, 350, 230, 30);

        txt_etat.setEditable(false);
        txt_etat.setBackground(new java.awt.Color(32, 142, 205));
        txt_etat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_etat.setForeground(new java.awt.Color(255, 255, 255));
        txt_etat.setOpaque(false);
        getContentPane().add(txt_etat);
        txt_etat.setBounds(180, 400, 230, 30);

        txt_ad.setEditable(false);
        txt_ad.setBackground(new java.awt.Color(32, 142, 205));
        txt_ad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_ad.setForeground(new java.awt.Color(255, 255, 255));
        txt_ad.setOpaque(false);
        getContentPane().add(txt_ad);
        txt_ad.setBounds(180, 450, 230, 30);

        txt_tel.setEditable(false);
        txt_tel.setBackground(new java.awt.Color(32, 142, 205));
        txt_tel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_tel.setForeground(new java.awt.Color(255, 255, 255));
        txt_tel.setOpaque(false);
        getContentPane().add(txt_tel);
        txt_tel.setBounds(180, 500, 230, 30);

        txt_date.setEditable(false);
        txt_date.setBackground(new java.awt.Color(32, 142, 205));
        txt_date.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_date.setForeground(new java.awt.Color(255, 255, 255));
        txt_date.setOpaque(false);
        getContentPane().add(txt_date);
        txt_date.setBounds(180, 550, 230, 30);

        txt_service.setEditable(false);
        txt_service.setBackground(new java.awt.Color(32, 142, 205));
        txt_service.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_service.setForeground(new java.awt.Color(255, 255, 255));
        txt_service.setOpaque(false);
        getContentPane().add(txt_service);
        txt_service.setBounds(180, 590, 230, 30);

        txt_fonction.setEditable(false);
        txt_fonction.setBackground(new java.awt.Color(32, 142, 205));
        txt_fonction.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_fonction.setForeground(new java.awt.Color(255, 255, 255));
        txt_fonction.setOpaque(false);
        getContentPane().add(txt_fonction);
        txt_fonction.setBounds(180, 640, 230, 30);

        txt_id.setEditable(false);
        txt_id.setBackground(new java.awt.Color(32, 142, 205));
        txt_id.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_id.setForeground(new java.awt.Color(255, 255, 255));
        txt_id.setOpaque(false);
        getContentPane().add(txt_id);
        txt_id.setBounds(180, 70, 230, 30);

        labDate.setFont(new java.awt.Font("Tekton Pro", 1, 24)); // NOI18N
        labDate.setForeground(new java.awt.Color(255, 255, 255));
        labDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labDate.setText("10:15:30 PM");
        getContentPane().add(labDate);
        labDate.setBounds(620, 10, 180, 30);

        labdate2.setFont(new java.awt.Font("Tekton Pro", 1, 24)); // NOI18N
        labdate2.setForeground(new java.awt.Color(255, 255, 255));
        labdate2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labdate2.setText("2018-02-28");
        getContentPane().add(labdate2);
        labdate2.setBounds(790, 10, 150, 30);

        jButton2.setText("Déconnexion");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(960, 10, 100, 30);

        jLabel17.setFont(new java.awt.Font("Tekton Pro Ext", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("S'absanter");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(660, 60, 170, 40);

        date_deb.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(date_deb);
        date_deb.setBounds(650, 120, 230, 30);

        date_ret1.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(date_ret1);
        date_ret1.setBounds(650, 460, 230, 30);

        nbj1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nbj1MouseClicked(evt);
            }
        });
        nbj1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nbj1ActionPerformed(evt);
            }
        });
        nbj1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                nbj1PropertyChange(evt);
            }
        });
        getContentPane().add(nbj1);
        nbj1.setBounds(650, 510, 230, 30);

        jLabel18.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Adresse            :");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(30, 450, 140, 30);

        jLabel19.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Date du debut    :");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(470, 120, 160, 30);

        jLabel20.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Date de retour  :");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(470, 170, 160, 30);

        jButton3.setFont(new java.awt.Font("Tekton Pro Ext", 0, 18)); // NOI18N
        jButton3.setText("Envoyer");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(650, 310, 120, 40);

        jButton4.setFont(new java.awt.Font("Tekton Pro Ext", 0, 18)); // NOI18N
        jButton4.setText("Reponse");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(770, 640, 115, 40);

        jButton5.setFont(new java.awt.Font("Tekton Pro Ext", 0, 18)); // NOI18N
        jButton5.setText("Reponse");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(770, 310, 115, 40);

        btnpresence.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nr/imageNR/icon vert.jpg"))); // NOI18N
        btnpresence.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnpresence.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnpresenceMouseClicked(evt);
            }
        });
        btnpresence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpresenceActionPerformed(evt);
            }
        });
        getContentPane().add(btnpresence);
        btnpresence.setBounds(560, 10, 30, 30);

        nbj.setEditable(false);
        nbj.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nbjMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nbjMouseEntered(evt);
            }
        });
        nbj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nbjActionPerformed(evt);
            }
        });
        getContentPane().add(nbj);
        nbj.setBounds(650, 220, 230, 30);

        date_ret.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(date_ret);
        date_ret.setBounds(650, 170, 230, 30);

        date_deb1.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(date_deb1);
        date_deb1.setBounds(650, 420, 230, 30);

        jButton8.setFont(new java.awt.Font("Tekton Pro Ext", 0, 18)); // NOI18N
        jButton8.setText("Envoyer");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8);
        jButton8.setBounds(650, 640, 120, 40);

        jLabel25.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Date du debut    :");
        getContentPane().add(jLabel25);
        jLabel25.setBounds(490, 420, 160, 30);

        jLabel26.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Date de retour  :");
        getContentPane().add(jLabel26);
        jLabel26.setBounds(490, 460, 160, 30);

        jLabel21.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Nombre de  jour :");
        getContentPane().add(jLabel21);
        jLabel21.setBounds(490, 510, 160, 30);

        jLabel22.setFont(new java.awt.Font("Tekton Pro Ext", 0, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Demander un congé");
        getContentPane().add(jLabel22);
        jLabel22.setBounds(580, 370, 290, 40);

        labpre.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        labpre.setForeground(new java.awt.Color(255, 255, 255));
        labpre.setText("Cliquer ici en premier pour faire le pointage -->");
        getContentPane().add(labpre);
        labpre.setBounds(300, 10, 260, 30);
        getContentPane().add(image);
        image.setBounds(910, 120, 190, 180);

        jLabel23.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Motif                       :");
        getContentPane().add(jLabel23);
        jLabel23.setBounds(470, 270, 160, 30);

        motif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motifActionPerformed(evt);
            }
        });
        getContentPane().add(motif);
        motif.setBounds(650, 270, 230, 30);

        jLabel27.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Motif                       :");
        getContentPane().add(jLabel27);
        jLabel27.setBounds(490, 600, 160, 30);

        motif1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motif1ActionPerformed(evt);
            }
        });
        getContentPane().add(motif1);
        motif1.setBounds(650, 600, 230, 30);

        jLabel28.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Jour restant    :");
        getContentPane().add(jLabel28);
        jLabel28.setBounds(490, 560, 160, 30);

        j_reste.setEditable(false);
        j_reste.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                j_resteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                j_resteMouseEntered(evt);
            }
        });
        j_reste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j_resteActionPerformed(evt);
            }
        });
        j_reste.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                j_restePropertyChange(evt);
            }
        });
        getContentPane().add(j_reste);
        j_reste.setBounds(650, 560, 230, 30);

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nr/imageNR/logo.jpg"))); // NOI18N
        getContentPane().add(jLabel24);
        jLabel24.setBounds(980, 370, 100, 70);

        jButton6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton6.setText("?");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(1077, 10, 40, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nr/imageNR/acceuil A.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1130, 720);

        setSize(new java.awt.Dimension(1142, 739));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_adminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_adminActionPerformed

    private void txt_mdpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_mdpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_mdpActionPerformed

    private void nbj1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nbj1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nbj1ActionPerformed

    private void nbjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nbjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nbjActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String requete = "select * from admin where nom_utilisateur = ? and mdp_admin =? ";
        try {

            ps = conn.prepareStatement(requete);
            ps.setString(1, txt_admin.getText());
            ps.setString(2, mdp_admin.getText());
            rs = ps.executeQuery();
            if (rs.next()) {
                this.t1 = rs.getString("nom_utilisateur");
//          System.out.println(t1 ) ;  
//          JOptionPane.showMessageDialog(null, t1);

                new admin().setVisible(true);

            }

        } catch (Exception e) {
            System.out.println("--> Exception : " + e);

        }
        //Description.setForeground(Color.red);
        //Description.setText("Choix invalide");

        //txtlogin.setBackground(Color.red);
        // txtlogin.setForeground(Color.red);
        txt_admin.setText("");
        mdp_admin.setText("");
        System.out.println(" Erreur de l'authentification");
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        String t1 = txt_nom.getText();
        String t2 = labdate2.getText();

        try {
            String requete = "update pointage set heure_sortie=?, nom_employe=?  where date_entre ='" + t2 + "' ORDER by   nom_employe ='" + t1 + "'";

            ps = conn.prepareStatement(requete);
            ps.setString(1, labDate.getText());
            ps.setString(2, txt_nom.getText());

            ps.execute();
            ps.execute();

            ps.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {

            try {
                ps.close();
                rs.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "errer");
            }
        }
        if (JOptionPane.showConfirmDialog(null, "Attention vous devez déconnecter une session,est ce que vous êtes sur?",
                "Déconnexion", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
            Authentification l = new Authentification();
            l.setVisible(true);
            this.dispose();
        }
// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnpresenceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnpresenceMouseClicked
String z = "Connecté"; 
       
        labpre.setText(z);
      
        
        vert();      // TODO add your handling code here:
    }//GEN-LAST:event_btnpresenceMouseClicked

    private void btnpresenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpresenceActionPerformed
        String c = txt_nom.getText();
        labpre.setText(c);
        btnpresence.setEnabled(false);

        if (txt_nom.getText().equals("") || txt_prenom.getText().equals("") || labDate.getText().equals("") || labdate2.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "SVP entrer les informations complete");
        } else {
            try {
                String requete = "INSERT INTO pointage(nom_employe, prenom_employe, date_entre, heure_entre) VALUES (?,?,?,?)";

                ps = conn.prepareStatement(requete);
                ps.setString(1, txt_nom.getText());
                ps.setString(2, txt_prenom.getText());
                ps.setString(3, labdate2.getText());
                ps.setString(4, labDate.getText());
                ps.execute();

                JOptionPane.showMessageDialog(null, "Pointage effectué");
                ps.close();
                rs.close();

            } catch (Exception e) {
                System.out.println("--> SQLException : " + e);

            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnpresenceActionPerformed

    private void motifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motifActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_motifActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (txt_nom.getText().equals("") || txt_prenom.getText().equals("") || nbj.getText().equals("") || motif.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "SVP entrer les informations complete");
        } else {
            try {
                String requete = "INSERT INTO abs(nom_employe,prenom_employe,date_debut,date_retour,nombre_jour,motif) VALUES (?,?,?,?,?,?)";

                ps = conn.prepareStatement(requete);
                ps.setString(1, txt_nom.getText());
                ps.setString(2, txt_prenom.getText());
                ps.setString(3, ((JTextField) date_deb.getDateEditor().getUiComponent()).getText());
                ps.setString(4, ((JTextField) date_ret.getDateEditor().getUiComponent()).getText());
                ps.setString(5, nbj.getText());
                ps.setString(6, motif.getText());

                ps.execute();

                JOptionPane.showMessageDialog(null, "Demande envoyé");
                ps.close();
                rs.close();
nbj.setText("");
        motif.setText("");
        j_reste.setText("");
        date_deb.setDate(null);
        date_ret.setDate(null);

            } catch (Exception e) {
                System.out.println("--> SQLException : " + e);

            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void nbjMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nbjMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_nbjMouseEntered

    private void nbjMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nbjMouseClicked
        java.util.Date d1 = date_deb.getDate();
        java.util.Date d2 = date_ret.getDate();

        long jour1 = (d1.getTime() / (1000 * 60 * 60 * 24));
        long jour2 = (d2.getTime() / (1000 * 60 * 60 * 24));

        if (jour2 < jour1) {
            JOptionPane.showMessageDialog(this, "Impossible de s'absenter la date de retour est infferieur a la date de debut");
            nbj1.setText("");
        } else {
            long jour = jour1 - jour2;
            if (jour < 0) {
                jour *= -1;
            }

            nbj.setText("" + Long.toString(jour));

        }      // TODO add your handling code here:
    }//GEN-LAST:event_nbjMouseClicked

    private void motif1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motif1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_motif1ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if (txt_nom.getText().equals("") || txt_prenom.getText().equals("") || nbj1.getText().equals("") || motif1.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "SVP entrer les informations complete");
        } else {
            try {
                String requete = "INSERT INTO conge(nom_employe,prenom_employe,date_demande,date_debut,date_retour,nombre_jour,reste,motif) VALUES (?,?,?,?,?,?,?,?)";

                ps = conn.prepareStatement(requete);
                ps.setString(1, txt_nom.getText());
                ps.setString(2, txt_prenom.getText());
                ps.setString(3, labdate2.getText());
                ps.setString(4, ((JTextField) date_deb1.getDateEditor().getUiComponent()).getText());
                ps.setString(5, ((JTextField) date_ret1.getDateEditor().getUiComponent()).getText());
                ps.setString(6, nbj1.getText());
                ps.setString(7, j_reste.getText());
                ps.setString(8, motif1.getText());

                ps.execute();
                

                JOptionPane.showMessageDialog(null, "Demande envoyé");
                nbj1.setText("");
        motif1.setText("");
        j_reste.setText("");
        date_deb1.setDate(null);
        date_ret1.setDate(null);
        
                ps.close();
                rs.close();

                reste();

            } catch (Exception e) {
                System.out.println("--> SQLException : " + e);

            }
        }
        

// TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void nbj1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nbj1MouseClicked
        kajy();
    }//GEN-LAST:event_nbj1MouseClicked

    private void j_resteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j_resteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_j_resteActionPerformed

    private void j_resteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_j_resteMouseClicked

        try {

            String v = j_reste.getText();
            String n = nbj1.getText();

            int n1 = Integer.parseInt(n);
            int v1 = Integer.parseInt(v);
            if ((v1 - n1) < 0) {
                JOptionPane.showMessageDialog(null, "Vous avez dépassé la limite de congé ");
            } else {
                int r = (v1 - n1);

                String resultat = String.valueOf(r);
                j_reste.setText(resultat);
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Veuillez entrez les date ");
        }
    }//GEN-LAST:event_j_resteMouseClicked

    private void j_restePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_j_restePropertyChange
reste();           // TODO add your handling code here:
    }//GEN-LAST:event_j_restePropertyChange

    private void nbj1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_nbj1PropertyChange

// TODO add your handling code here:
    }//GEN-LAST:event_nbj1PropertyChange

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        reponse_conge c = new reponse_conge();
        c.setVisible(true);
        
// TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        reponse_abs b = new reponse_abs();
        b.setVisible(true);
     
// TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void j_resteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_j_resteMouseEntered
       // TODO add your handling code here:
    }//GEN-LAST:event_j_resteMouseEntered

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
apropos1 p = new apropos1();
p.setVisible(true);
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed
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
            java.util.logging.Logger.getLogger(acceuil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(acceuil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(acceuil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(acceuil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new acceuil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnpresence;
    private com.toedter.calendar.JDateChooser date_deb;
    private com.toedter.calendar.JDateChooser date_deb1;
    private com.toedter.calendar.JDateChooser date_ret;
    private com.toedter.calendar.JDateChooser date_ret1;
    private javax.swing.JLabel image;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField j_reste;
    private javax.swing.JLabel labDate;
    private javax.swing.JLabel labdate2;
    private javax.swing.JLabel labpre;
    private javax.swing.JPasswordField mdp_admin;
    private javax.swing.JTextField motif;
    private javax.swing.JTextField motif1;
    private javax.swing.JTextField nbj;
    private javax.swing.JTextField nbj1;
    private javax.swing.JTextField txt_ad;
    private javax.swing.JTextField txt_admin;
    private javax.swing.JTextField txt_age;
    private javax.swing.JTextField txt_cin;
    private javax.swing.JTextField txt_date;
    private javax.swing.JTextField txt_etat;
    private javax.swing.JTextField txt_fonction;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_mdp;
    private javax.swing.JTextField txt_naiss;
    private javax.swing.JTextField txt_nom;
    private javax.swing.JTextField txt_prenom;
    private javax.swing.JTextField txt_service;
    private javax.swing.JTextField txt_sexe;
    private javax.swing.JTextField txt_tel;
    // End of variables declaration//GEN-END:variables
}

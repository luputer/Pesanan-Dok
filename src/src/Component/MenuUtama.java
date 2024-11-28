package src.Component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.text.MessageFormat.format;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Saidi
 */
public class MenuUtama extends javax.swing.JFrame {

    private String userLevel;
    private String userName;
    private int idPasien;
    private int idDokter;
    private String namaPasien;
    private String jenisKelamin;
    private String alamat;

    /**
     * Creates new form MenuUtama
     */
    public MenuUtama(String username, String level, int idPasien, int idDokter, String namaPasien, String jenisKelamin, String alamat) {

        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.userName = username;
        this.userLevel = level;
        this.idPasien = idPasien;
        this.idDokter = idDokter;
        this.namaPasien = namaPasien;
        this.jenisKelamin = jenisKelamin;
        this.alamat = alamat;

        // Set user info in sidebar  
        jLabel3.setText(username);
        jLabel2.setText(level); // No need to convert level to String since it's already a String  

        // Convert level to integer for comparison  
        int userLevel = Integer.parseInt(level); // Assuming level is a String representation of an integer  
        // Set text based on the user level
        switch (userLevel) {
            case 3 ->
                jLabel2.setText("admin"); // Assuming jLabel1 is declared
            case 2 ->
                jLabel2.setText("dokter"); // Set text for level 2
            case 1 ->
                jLabel2.setText("user"); // Set text for level 3
            default ->
                jLabel2.setText("unknown"); // Handle unexpected levels
        }

        // Execute any additional necessary functions  
        execute();
        date();
        startClock();

    }

    private void startClock() {
        Timer timer = new Timer(1000, e -> date());
        timer.start(); // Start the timer  
    }

    //methot tanggal
    private void date() {
        Date tanggalSekarang = new Date();
        SimpleDateFormat TanggalWaktu = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String tanggal = TanggalWaktu.format(tanggalSekarang);
        lb_tanggal.setText(tanggal);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_sidebar = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pn_menu = new javax.swing.JPanel();
        pn_navbar = new javax.swing.JPanel();
        lb_tanggal = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pn_conten = new javax.swing.JPanel();
        pn_utama = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        pn_sidebar.setBackground(new java.awt.Color(220, 232, 243));
        pn_sidebar.setPreferredSize(new java.awt.Dimension(250, 495));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);

        pn_menu.setBackground(new java.awt.Color(220, 232, 243));
        pn_menu.setLayout(new javax.swing.BoxLayout(pn_menu, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(pn_menu);

        javax.swing.GroupLayout pn_sidebarLayout = new javax.swing.GroupLayout(pn_sidebar);
        pn_sidebar.setLayout(pn_sidebarLayout);
        pn_sidebarLayout.setHorizontalGroup(
            pn_sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_sidebarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addContainerGap())
        );
        pn_sidebarLayout.setVerticalGroup(
            pn_sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_sidebarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        getContentPane().add(pn_sidebar, java.awt.BorderLayout.LINE_START);

        pn_navbar.setBackground(new java.awt.Color(195, 224, 253));

        lb_tanggal.setBackground(new java.awt.Color(255, 255, 255));
        lb_tanggal.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        lb_tanggal.setForeground(new java.awt.Color(0, 0, 0));
        lb_tanggal.setText("Tanggal dan waktu");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/Elegant_and_Minimalist_Medical_Logo__1_-removebg-preview 2 (3).png"))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Level");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nama");

        javax.swing.GroupLayout pn_navbarLayout = new javax.swing.GroupLayout(pn_navbar);
        pn_navbar.setLayout(pn_navbarLayout);
        pn_navbarLayout.setHorizontalGroup(
            pn_navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_navbarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 645, Short.MAX_VALUE)
                .addComponent(lb_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pn_navbarLayout.setVerticalGroup(
            pn_navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_navbarLayout.createSequentialGroup()
                .addGroup(pn_navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_navbarLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(lb_tanggal))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_navbarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(45, 45, 45))
        );

        getContentPane().add(pn_navbar, java.awt.BorderLayout.PAGE_START);

        pn_utama.setBackground(new java.awt.Color(255, 255, 255));
        pn_utama.setLayout(new javax.swing.BoxLayout(pn_utama, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout pn_contenLayout = new javax.swing.GroupLayout(pn_conten);
        pn_conten.setLayout(pn_contenLayout);
        pn_contenLayout.setHorizontalGroup(
            pn_contenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_utama, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pn_contenLayout.setVerticalGroup(
            pn_contenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_utama, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 721, Short.MAX_VALUE)
        );

        getContentPane().add(pn_conten, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        pn_utama.add(new Content_bg());
        pn_utama.repaint();
        pn_utama.revalidate();

    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MenuUtama().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_tanggal;
    private javax.swing.JPanel pn_conten;
    private javax.swing.JPanel pn_menu;
    private javax.swing.JPanel pn_navbar;
    private javax.swing.JPanel pn_sidebar;
    private javax.swing.JPanel pn_utama;
    // End of variables declaration//GEN-END:variables

    private void execute() {

        //tempat naro icon
        ImageIcon iconUser    = new ImageIcon(getClass().getResource("/asset/iconuser.png"));
        ImageIcon iconHome    = new ImageIcon(getClass().getResource("/asset/iconhome.png"));   
        ImageIcon iconDokter   = new ImageIcon(getClass().getResource("/asset/icondokter.png"));
        ImageIcon iconPasien  = new ImageIcon(getClass().getResource("/asset/iconPasien.png"));
        ImageIcon iconkonsul  = new ImageIcon(getClass().getResource("/asset/iconkonsul.png"));
        ImageIcon icondatakonsul   = new ImageIcon(getClass().getResource("/asset/icondatakonsul.png"));
        ImageIcon iconAbout    = new ImageIcon(getClass().getResource("/asset/Abouticon.png"));
        ImageIcon iconExit    = new ImageIcon(getClass().getResource("/asset/exit.png"));
        
        

        //nav children
        //nav utamahalaman Home
        MenuItem menuHome = new MenuItem(iconHome, false, null, "Home", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pn_utama.removeAll();
                pn_utama.add(new Content_bg());
                pn_utama.repaint();
                pn_utama.revalidate();
            }
        });

        //halaman ke menuUser
        MenuItem menuUser = new MenuItem(iconUser, false, null, "User",
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pn_utama.removeAll();
                pn_utama.add(new Form_User());
                pn_utama.repaint();
                pn_utama.revalidate();
            }
        });

        //halaman ke menudokter
        MenuItem menuDokter = new MenuItem(iconDokter, false, null, "Dokter", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pn_utama.removeAll();
                pn_utama.add(new Form_Dokter());
                pn_utama.repaint();
                pn_utama.revalidate();
            }
        });

        //halaman pasient
        MenuItem dataPasient = new MenuItem(null, true, icondatakonsul, "Biodata", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pn_utama.removeAll();
                pn_utama.add(new Form_DataPasient());
                pn_utama.repaint();
                pn_utama.revalidate();

            }
        });

        MenuItem DataKonsul = new MenuItem(null, true, iconkonsul, "konsul", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pn_utama.removeAll();
                pn_utama.add(new Form_DataKonsul());
                pn_utama.repaint();
                pn_utama.revalidate();
            }
        });

        MenuItem MenuPasient = new MenuItem(iconPasien, false, null, "Pasient", null, dataPasient, DataKonsul);

        MenuItem menuProfilDokter = new MenuItem(iconUser, false, null, "profil", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pn_utama.removeAll();
                pn_utama.add(new Form_profilDokters(idDokter));
                pn_utama.repaint();
                pn_utama.revalidate();
            }
        });

        MenuItem menuDokterKonsul = new MenuItem(iconkonsul, false, null, "konsultasi", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pn_utama.removeAll();
                pn_utama.add(new Form_DokterKonsul(idDokter));
                pn_utama.repaint();
                pn_utama.revalidate();
            }
        });

        MenuItem menuProfilPasien = new MenuItem(iconUser, false, null, "profil", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pn_utama.removeAll();
                pn_utama.add(new Form_profilPasien(idPasien, namaPasien, jenisKelamin, alamat));
                pn_utama.repaint();
                pn_utama.revalidate();
            }
        });

        MenuItem menuKonsulPasien = new MenuItem(iconkonsul, false, null, "konsultasi", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pn_utama.removeAll();
                pn_utama.add(new Form_PasienKonsul(idPasien));
                pn_utama.repaint();
                pn_utama.revalidate();
            }
        });

        //halaman about
        MenuItem MenuAbout = new MenuItem(iconAbout, false, null, "About", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pn_utama.removeAll();
                pn_utama.add(new About());
                pn_utama.repaint();
                pn_utama.revalidate();
            }
        });

        MenuItem MenuExit = new MenuItem(iconExit, false, null, "Exit", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        //menu multi user
//    addMenu(menuHome, menuUser, menuDokter, MenuPasient, menuProfilDokter, menuDokterKonsul,menuProfilPasien, menuKonsulPasien,   MenuAbout, MenuExit);
        switch (userLevel) {
            case "3": //  Admin
                addMenu(menuHome, menuUser, menuDokter, MenuPasient, MenuAbout, MenuExit);
                break;

            case "2": // dokter
                addMenu(menuHome, menuProfilDokter, menuDokterKonsul, MenuAbout, MenuExit);
                break;

            case "1": // User
                addMenu(menuHome, menuProfilPasien, menuKonsulPasien, MenuAbout, MenuExit);
                break;

        }

    }

    private void addMenu(MenuItem... menus) {
        for (MenuItem menu : menus) {
            pn_menu.add(menu);
            for (MenuItem sub : menu.getSubMenu()) {
                addMenu(sub);
            }
        }
        pn_menu.revalidate();
        pn_menu.repaint();
    }

}

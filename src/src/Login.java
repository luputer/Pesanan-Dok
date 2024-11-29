/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package src;

import javax.swing.JOptionPane;
import model.Config;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static model.Config.writeLog;
import src.Component.MenuUtama;

/**
 *
 * @author Saidi
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_login = new javax.swing.JButton();
        lblDaftar = new javax.swing.JLabel();
        lblDaftar1 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Menjaga kesahatan anda, itu tugas kami");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, -1, -1));

        txtPassword.setBackground(new java.awt.Color(195, 224, 253));
        txtPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPassword.setText("*****");
        txtPassword.setBorder(null);
        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPasswordFocusLost(evt);
            }
        });
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 280, 250, 40));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/dokter_login-removebg-preview 1 (2).png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 160, 500, 330));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/padlock 1.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 275, 40, 40));

        txtUsername.setBackground(new java.awt.Color(195, 224, 253));
        txtUsername.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsername.setText("username");
        txtUsername.setBorder(null);
        txtUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsernameFocusLost(evt);
            }
        });
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        jPanel1.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 180, 260, 40));

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Exit");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 360, 130, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/HEALINK (2).png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 252, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/user 1 (1).png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 185, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/Rectangle 5 (2).png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 540));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/Rectangle 1 (1).png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 267, 340, 60));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/Rectangle 1 (1).png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 170, -1, -1));

        btn_login.setBackground(new java.awt.Color(129, 179, 251));
        btn_login.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_login.setForeground(new java.awt.Color(0, 0, 0));
        btn_login.setText("Login");
        btn_login.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                btn_loginComponentMoved(evt);
            }
        });
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        jPanel1.add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 360, 130, 50));

        lblDaftar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDaftar.setForeground(new java.awt.Color(0, 0, 0));
        lblDaftar.setText("Daftar Sekarang");
        lblDaftar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDaftarMouseClicked(evt);
            }
        });
        jPanel1.add(lblDaftar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 440, 100, -1));

        lblDaftar1.setForeground(new java.awt.Color(0, 0, 0));
        lblDaftar1.setText("Belum Punya Akun? ");
        lblDaftar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDaftar1MouseClicked(evt);
            }
        });
        jPanel1.add(lblDaftar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 440, -1, -1));

        jLabel63.setBackground(new java.awt.Color(102, 102, 255));
        jLabel63.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(0, 0, 0));
        jLabel63.setText("Login ");
        jPanel1.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 120, 120, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 540));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        // TODO add your handling code here:
        String username = txtUsername.getText();
        String password = txtPassword.getText();

        if (username.equals("username") || password.equals("Password")) {
            JOptionPane.showMessageDialog(null, "Silahkan masukkan username dan password!");
            return;
        }

        String sql = "SELECT username, level FROM t_user WHERE username = ? AND password = ?";
        try {
            java.sql.Connection conn = Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);
            java.sql.ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int level = rs.getInt("level"); // Ambil level sebagai angka
                JOptionPane.showMessageDialog(null, "Selamat datang " + username);

                // Mengonversi level yang berupa angka ke string
                String levelString = String.valueOf(level);  // Mengubah angka menjadi string

                switch (level) {
                    case 1: // Pasien
                        String sqlPasien = "SELECT * FROM t_pasien WHERE username = ?";
                        PreparedStatement pstPasien = conn.prepareStatement(sqlPasien);
                        pstPasien.setString(1, username);
                        ResultSet rsPasien = pstPasien.executeQuery();

                        if (rsPasien.next()) {
                            // Ambil data pasien dari hasil query
                            int idPasien = rsPasien.getInt("idPasien");
                            String namaPasien = rsPasien.getString("namaPasien");
                            String jenisKelamin = rsPasien.getString("jenisKelamin");
                            String alamat = rsPasien.getString("alamat");

                            // Kirim data pasien ke frame MenuUtama
                            MenuUtama menuPasien = new MenuUtama(username, levelString, idPasien, -1, namaPasien, jenisKelamin, alamat);
                            menuPasien.setVisible(true);
                            this.dispose(); // Close login form
                        } else {
                            JOptionPane.showMessageDialog(null, "Akun Anda belum terdaftar sebagai pasien. Harap daftar terlebih dahulu.");
                        }
                        break;

                    case 2: // Dokter
                        // Query untuk mendapatkan ID Dokter berdasarkan username
                        String sqlDokter = "SELECT idDokter FROM t_dokter WHERE username = ?";
                        PreparedStatement pstDokter = conn.prepareStatement(sqlDokter);
                        pstDokter.setString(1, username);
                        ResultSet rsDokter = pstDokter.executeQuery();

                        if (rsDokter.next()) {
                            int idDokter = rsDokter.getInt("idDokter");

                            // Kirim data dokter ke frame MenuUtama (hanya idDokter)
                            MenuUtama menuDokter = new MenuUtama(username, levelString, -1, idDokter, "", "", "");
                            menuDokter.setVisible(true);
                            this.dispose(); // Close login form
                        } else {
                            JOptionPane.showMessageDialog(null, "Data dokter tidak ditemukan!");
                        }
                        break;

                    case 3: // Admin
                        // Admin tidak memerlukan validasi data pasien atau dokter
                        MenuUtama menuAdmin = new MenuUtama(username, levelString, -1, -1, "", "", "");
                        menuAdmin.setVisible(true);
                        this.dispose();
                        break;

                    default: // Jika level tidak dikenali
                        JOptionPane.showMessageDialog(null, "Level pengguna tidak dikenali! Hubungi administrator.");
                        break;
                }

            } else {
                JOptionPane.showMessageDialog(null, "Username atau password salah!");
                txtUsername.setText("username");
                txtPassword.setText("Password");
                txtUsername.requestFocus();
            }
        } catch (java.sql.SQLException e) {  
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            writeLog("Login Error: " + e.getMessage());
        }

    }//GEN-LAST:event_btn_loginActionPerformed

    private void txtUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusGained
        // TODO add your handling code here:
        String user = txtUsername.getText();
        if (user.equals("username")) {
            txtUsername.setText("");
        }
    }//GEN-LAST:event_txtUsernameFocusGained

    private void txtUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusLost
        // TODO add your handling code here:
        String user = txtUsername.getText();
        if (user.equals("") || user.equals("username")) {
            txtUsername.setText("username");
        }
    }//GEN-LAST:event_txtUsernameFocusLost

    private void lblDaftarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDaftarMouseClicked
        // TODO add your handling code here:

        Register register = new Register();
        register.setVisible(true);
        dispose();
    }//GEN-LAST:event_lblDaftarMouseClicked

    private void lblDaftar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDaftar1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblDaftar1MouseClicked

    private void btn_loginComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_btn_loginComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_loginComponentMoved

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusGained
        // TODO add your handling code here:
         String pass = txtPassword.getText();
        if (pass.equals("*****")) {
            txtPassword.setText("");
        }
    }//GEN-LAST:event_txtPasswordFocusGained

    private void txtPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusLost
        // TODO add your handling code here:
        String pass = txtPassword.getText();
        if (pass.equals("") || pass.equals("*****")) {
            txtPassword.setText("*****");
        }
    }//GEN-LAST:event_txtPasswordFocusLost

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1MouseClicked

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_login;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDaftar;
    private javax.swing.JLabel lblDaftar1;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}

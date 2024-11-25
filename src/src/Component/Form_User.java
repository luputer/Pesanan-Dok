/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package src.Component;

import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Config;
import static model.Config.writeLog;

/**
 *
 * @author Saidi
 */
public class Form_User extends javax.swing.JPanel {

    private void load_table() {
        // membuat tampilan model tabel
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Username");
        model.addColumn("Password");
        model.addColumn("Level");
        //menampilkan data database kedalam tabel
        try {
            int no = 1;
            String sql = "select * from t_user";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                model.addRow(new Object[]{no++, res.getString(1), res.getString(2),
                    res.getString(3)});
            }
            tblUser.setModel(model);
            writeLog("Tampilkan data ke Frame " + getClass().getSimpleName());
        } catch (Exception e) {
            writeLog("Data tidak dapat ditampilkan : " + e.getMessage());
        }
    }

    private void bersihkan() {
        txtUsername.setText(null);
        txtPassword.setText(null);
        cbLevel.setSelectedIndex(0);
    }

    /**
     * Creates new form Form_User
     */
    public Form_User() {
        initComponents();
        load_table();
        txtHiddenUsername.setVisible(false); // Menyembunyikan JTextField
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        dataUser = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUser = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btTambah = new javax.swing.JButton();
        bt_edit = new javax.swing.JButton();
        btHapus = new javax.swing.JButton();
        editUSer = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btEditSimpan = new javax.swing.JButton();
        btBatal1 = new javax.swing.JButton();
        cbEditLevel = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtEditUsername = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtEditPassword = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cbLevel3 = new javax.swing.JComboBox<>();
        TambahUser = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btSimpan = new javax.swing.JButton();
        btBatal = new javax.swing.JButton();
        cbLevel = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbLevel1 = new javax.swing.JComboBox<>();

        setLayout(new java.awt.CardLayout());

        mainPanel.setLayout(new java.awt.CardLayout());

        dataUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblUser.setModel(new javax.swing.table.DefaultTableModel(
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
        tblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUser);

        dataUser.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1470, 360));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Data User");
        dataUser.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 177, -1));

        btTambah.setText("Tambah");
        btTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTambahActionPerformed(evt);
            }
        });
        dataUser.add(btTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 94, -1));

        bt_edit.setText("Edit");
        bt_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_editActionPerformed(evt);
            }
        });
        dataUser.add(bt_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 94, -1));

        btHapus.setText("Hapus");
        btHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHapusActionPerformed(evt);
            }
        });
        dataUser.add(btHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 94, -1));

        mainPanel.add(dataUser, "card2");

        editUSer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setText("Edit User");
        editUSer.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 240, -1));

        btEditSimpan.setText("Simpan");
        btEditSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditSimpanActionPerformed(evt);
            }
        });
        editUSer.add(btEditSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 73, 100, 30));

        btBatal1.setText("Batal");
        btBatal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBatal1ActionPerformed(evt);
            }
        });
        editUSer.add(btBatal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 73, 100, 30));

        cbEditLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Level 1 (User)", "Level 2 (Pegawai)", "Level 3 (Admin)" }));
        cbEditLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEditLevelActionPerformed(evt);
            }
        });
        editUSer.add(cbEditLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 460, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("Password");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setText("Username");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Level");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtEditPassword)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtEditUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 1447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEditUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEditPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        editUSer.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        cbLevel3.setBackground(new java.awt.Color(153, 153, 255));
        cbLevel3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Level 1 (User)", "Level 2 (Pegawai)", "Level 3 (Admin)" }));
        editUSer.add(cbLevel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 224, 364, -1));

        mainPanel.add(editUSer, "card2");

        TambahUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setText("Tambah User");
        TambahUser.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 240, -1));

        btSimpan.setText("Simpan");
        btSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSimpanActionPerformed(evt);
            }
        });
        TambahUser.add(btSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 73, 100, 30));

        btBatal.setText("Batal");
        btBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBatalActionPerformed(evt);
            }
        });
        TambahUser.add(btBatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 73, 100, 30));

        cbLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Level 1 (User)", "Level 2 (Pegawai)", "Level 3 (Admin)" }));
        TambahUser.add(cbLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 390, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Password");

        txtUsername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUsernameMouseClicked(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setText("Username");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Level");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(1314, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtUsername, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPassword))
                        .addGap(25, 25, 25))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TambahUser.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        cbLevel1.setBackground(new java.awt.Color(153, 153, 255));
        cbLevel1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Level 1 (User)", "Level 2 (Pegawai)", "Level 3 (Admin)" }));
        TambahUser.add(cbLevel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 224, 364, -1));

        mainPanel.add(TambahUser, "card2");

        add(mainPanel, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSimpanActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.add(dataUser);
        mainPanel.repaint();
        mainPanel.revalidate();
        try {
            String sql = "INSERT INTO t_user VALUES ('" + txtUsername.getText()
                    + "','" + txtPassword.getText()
                    + "','" + (cbLevel.getSelectedIndex() + 1) + "')";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
            writeLog("Penyimpanan Data Berhasil dengan Username " + txtUsername.getText());
            load_table();
            bersihkan();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            writeLog("Data gagal disimpan : " + e.getMessage());
        }
    }//GEN-LAST:event_btSimpanActionPerformed

    private void btTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTambahActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        mainPanel.add(TambahUser);
        mainPanel.repaint();
        mainPanel.revalidate();


    }//GEN-LAST:event_btTambahActionPerformed

    private void btBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBatalActionPerformed
        // TODO add your handling code here:

        mainPanel.removeAll();
        mainPanel.add(dataUser);
        mainPanel.repaint();
        mainPanel.revalidate();

    }//GEN-LAST:event_btBatalActionPerformed

    private void tblUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserMouseClicked
        // TODO add your handling code here:
        int baris = tblUser.rowAtPoint(evt.getPoint());
        String username = tblUser.getValueAt(baris, 1).toString();
        String password = tblUser.getValueAt(baris, 2).toString();
        String level = tblUser.getValueAt(baris, 3).toString().trim(); // Ambil nilai level (1, 2, atau 3)
        // Konversi nilai level (angka) ke indeks untuk JComboBox
        int levelIndex = Integer.parseInt(level) - 1; // Karena indeks JComboBox dimulai dari 0
        txtEditUsername.setText(username);
        txtHiddenUsername.setText(username);
        txtEditPassword.setText(password);
        // Set JComboBox ke indeks yang sesuai
        cbEditLevel.setSelectedIndex(levelIndex);

    }//GEN-LAST:event_tblUserMouseClicked

    private void btEditSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditSimpanActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.add(dataUser);
        mainPanel.repaint();
        mainPanel.revalidate();

        try {
            if ("".equals(txtEditUsername.getText())) {
                JOptionPane.showMessageDialog(this, "Isikan Username terlebih dahulu");
            } else {
                String sql = "UPDATE t_user SET username = '" + txtEditUsername.getText()
                        + "', password= '" + txtEditPassword.getText()
                        + "', level = '" + (cbEditLevel.getSelectedIndex() + 1)
                        + "' WHERE t_user.username = '" + txtHiddenUsername.getText() + "'";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Data Berhasil Diperbaharui dengan Username" + txtEditUsername.getText());
                writeLog("Data Berhasil Diperbaharui dengan NIM " + txtEditUsername.getText());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Perubahan Data Gagal" + e.getMessage());
            writeLog("Perubahan Data Gagal : " + e.getMessage());
        }
        load_table();
    }//GEN-LAST:event_btEditSimpanActionPerformed

    private void btBatal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBatal1ActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.add(dataUser);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_btBatal1ActionPerformed

    private void bt_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_editActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.add(editUSer);
        mainPanel.repaint();
        mainPanel.revalidate();


    }//GEN-LAST:event_bt_editActionPerformed

    private void cbEditLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEditLevelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbEditLevelActionPerformed

    private void btHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHapusActionPerformed
        // TODO add your handling code here:
        try {
            if ("".equals(txtEditUsername.getText())) {
                JOptionPane.showMessageDialog(this, "Pilih Data Yang ingin dihapus terlebih dahulu");
            } else {
                // Menampilkan konfirmasi sebelum menghapus data
                int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus data dengan Username: " + txtEditUsername.getText(),
                        "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

                // Jika pengguna memilih YES, lanjutkan menghapus
                if (confirm == JOptionPane.YES_OPTION) {
                    String sql = "DELETE FROM t_user WHERE username='" + txtEditUsername.getText() + "'";
                    java.sql.Connection conn = (Connection) Config.configDB();
                    java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                    pst.execute();
                    JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus dengan Username " + txtEditUsername.getText());
                    writeLog("Data Berhasil Dihapus dengan Username " + txtEditUsername.getText());
                } else {
                    // Jika pengguna memilih NO, tidak melakukan apa-apa
//                    JOptionPane.showMessageDialog(this, "Data Tidak Dihapus");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            writeLog("Data gagal dihapus : " + e.getMessage());
        }
        load_table();

    }//GEN-LAST:event_btHapusActionPerformed

    private void txtUsernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsernameMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel TambahUser;
    private javax.swing.JButton btBatal;
    private javax.swing.JButton btBatal1;
    private javax.swing.JButton btEditSimpan;
    private javax.swing.JButton btHapus;
    private javax.swing.JButton btSimpan;
    private javax.swing.JButton btTambah;
    private javax.swing.JButton bt_edit;
    private javax.swing.JComboBox<String> cbEditLevel;
    private javax.swing.JComboBox<String> cbLevel;
    private javax.swing.JComboBox<String> cbLevel1;
    private javax.swing.JComboBox<String> cbLevel3;
    private javax.swing.JPanel dataUser;
    private javax.swing.JPanel editUSer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTable tblUser;
    private javax.swing.JTextField txtEditPassword;
    private javax.swing.JTextField txtEditUsername;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}

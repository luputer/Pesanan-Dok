/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package src.Component;

import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Config;
import static model.Config.writeLog;

/**
 *
 * @author Saidi
 */
public class Form_DataPasient extends javax.swing.JPanel {

    private void load_table() {
        // membuat tampilan model tabel
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Nama Pasien");
        model.addColumn("Jenis Kelamin");
        model.addColumn("Alamat");
         model.addColumn("ID Pasien"); 

        //menampilkan data database kedalam tabel
        try {
            int no = 1;
            String sql = "SELECT idPasien, namaPasien, jenisKelamin, alamat FROM t_pasien";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                model.addRow(new Object[]{
                    no++,
                    res.getString("namaPasien"),
                    res.getString("jenisKelamin"),
                    res.getString("alamat"),
                    res.getString("idPasien") // ID Pasien tetap ada tapi akan disembunyikan

                });
            }
            // Sembunyikan kolom `idPasien`
            tblPasien.setModel(model);
            tblPasien.getColumnModel().getColumn(4).setMinWidth(0);
            tblPasien.getColumnModel().getColumn(4).setMaxWidth(0);
            tblPasien.getColumnModel().getColumn(4).setWidth(0);
            writeLog("Tampilkan data ke Frame " + getClass().getSimpleName());
        } catch (Exception e) {
            writeLog("Data tidak dapat ditampilkan : " + e.getMessage());
        }
    }

    private void bersihkan() {
        txtTambahNama.setText(null);
        txtTambahAlamat.setText(null);
        cbTambahJenisKelamin.setSelectedIndex(0);
    }

    /**
     * Creates new form Form_Dokter
     */
    public Form_DataPasient() {
        initComponents();
        load_table();
        // Mengatur lebar kolom tabel
        txtHiddenIdPasien.setVisible(false); // Menyembunyikan JTextField

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        btBatal1 = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();
        dataDokter = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPasien = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btTambah = new javax.swing.JButton();
        bt_edit = new javax.swing.JButton();
        btHapus = new javax.swing.JButton();
        tambahPasient = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbTambahJenisKelamin = new javax.swing.JComboBox<>();
        txtTambahNama = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtTambahAlamat = new javax.swing.JTextArea();
        btBatal = new javax.swing.JButton();
        btSimpan = new javax.swing.JButton();
        cbLevel1 = new javax.swing.JComboBox<>();
        jLabel63 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        editPasient = new javax.swing.JPanel();
        btEditPasien = new javax.swing.JButton();
        btBatal2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cbJenisKelamin = new javax.swing.JComboBox<>();
        txtEditNamaPasien = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtHiddenIdPasien = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtEditAlamat = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        btBatal1.setBackground(new java.awt.Color(204, 255, 255));
        btBatal1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btBatal1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/Group 2802.png"))); // NOI18N
        btBatal1.setText("Batal");
        btBatal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBatal1ActionPerformed(evt);
            }
        });

        setLayout(new java.awt.CardLayout());

        mainPanel.setLayout(new java.awt.CardLayout());

        dataDokter.setBackground(new java.awt.Color(255, 255, 255));
        dataDokter.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblPasien.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPasien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPasienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPasien);

        dataDokter.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 1050, 380));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Data Pasient");
        dataDokter.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 140, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/image 12.png"))); // NOI18N
        dataDokter.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 520, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/pngtree-blue-plus-concept-icon-on-white-background-png-image_8159235-removebg-preview 1_1.png"))); // NOI18N
        dataDokter.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 520, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/image 10.png"))); // NOI18N
        dataDokter.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 520, -1, -1));

        btTambah.setBackground(new java.awt.Color(195, 224, 253));
        btTambah.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        btTambah.setText("Tambah");
        btTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTambahActionPerformed(evt);
            }
        });
        dataDokter.add(btTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 510, 140, 50));

        bt_edit.setBackground(new java.awt.Color(129, 179, 251));
        bt_edit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_edit.setText("Edit");
        bt_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_editActionPerformed(evt);
            }
        });
        dataDokter.add(bt_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 510, 130, 50));

        btHapus.setBackground(new java.awt.Color(195, 224, 253));
        btHapus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btHapus.setText("Hapus");
        btHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHapusActionPerformed(evt);
            }
        });
        dataDokter.add(btHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 510, 130, 50));

        mainPanel.add(dataDokter, "card2");

        tambahPasient.setBackground(new java.awt.Color(255, 255, 255));
        tambahPasient.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("jenis kelamin");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("Alamat");

        cbTambahJenisKelamin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-laki", "Perempuan" }));

        txtTambahNama.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtTambahNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTambahNamaActionPerformed(evt);
            }
        });

        txtTambahAlamat.setColumns(20);
        txtTambahAlamat.setRows(5);
        jScrollPane2.setViewportView(txtTambahAlamat);

        btBatal.setBackground(new java.awt.Color(204, 255, 255));
        btBatal.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/Group 2802.png"))); // NOI18N
        btBatal.setText("Batal");
        btBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBatalActionPerformed(evt);
            }
        });

        btSimpan.setBackground(new java.awt.Color(195, 224, 253));
        btSimpan.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/Vector.png"))); // NOI18N
        btSimpan.setText("Simpan");
        btSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSimpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbTambahJenisKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTambahNama, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(btBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1621, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txtTambahNama, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(cbTambahJenisKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        tambahPasient.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 380));

        cbLevel1.setBackground(new java.awt.Color(153, 153, 255));
        cbLevel1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Level 1 (User)", "Level 2 (Pegawai)", "Level 3 (Admin)" }));
        tambahPasient.add(cbLevel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 224, 364, -1));

        jLabel63.setBackground(new java.awt.Color(102, 102, 255));
        jLabel63.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(51, 51, 255));
        jLabel63.setText("Input Data Pasien");
        tambahPasient.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setText("Nama");
        tambahPasient.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 139, -1));

        mainPanel.add(tambahPasient, "card2");

        editPasient.setBackground(new java.awt.Color(255, 255, 255));
        editPasient.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btEditPasien.setBackground(new java.awt.Color(195, 224, 253));
        btEditPasien.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btEditPasien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/Vector.png"))); // NOI18N
        btEditPasien.setText("Simpan");
        btEditPasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditPasienActionPerformed(evt);
            }
        });
        editPasient.add(btEditPasien, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 100, 40));

        btBatal2.setBackground(new java.awt.Color(204, 255, 255));
        btBatal2.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btBatal2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/Group 2802.png"))); // NOI18N
        btBatal2.setText("Batal");
        btBatal2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBatal2ActionPerformed(evt);
            }
        });
        editPasient.add(btBatal2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 500, 100, 40));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setText("jenis kelamin");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        cbJenisKelamin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "laki-laki", "Perempuan" }));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel15.setText("Alamat");

        txtEditAlamat.setColumns(20);
        txtEditAlamat.setRows(5);
        jScrollPane3.setViewportView(txtEditAlamat);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(340, 340, 340)
                                .addComponent(txtHiddenIdPasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(txtEditNamaPasien, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbJenisKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtEditNamaPasien, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbJenisKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHiddenIdPasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        editPasient.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 380));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 255));
        jLabel8.setText("Edit data Pasien");
        editPasient.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 290, -1));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel13.setText("Nama");
        editPasient.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 139, -1));

        mainPanel.add(editPasient, "card2");

        add(mainPanel, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSimpanActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.add(dataDokter);
        mainPanel.repaint();
        mainPanel.revalidate();

        try {
            String sql = "INSERT INTO t_pasien VALUES (NULL, '" + txtTambahNama.getText()
                    + "','" + cbTambahJenisKelamin.getSelectedItem()
                    + "','" + txtTambahAlamat.getText() + "')";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
            writeLog("Penyimpanan Data Berhasil dengan Nama Pasien " + txtTambahNama.getText());
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

        mainPanel.add(tambahPasient);
        mainPanel.repaint();
        mainPanel.revalidate();


    }//GEN-LAST:event_btTambahActionPerformed

    private void btBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBatalActionPerformed
        // TODO add your handling code here:

        mainPanel.removeAll();
        mainPanel.add(dataDokter);
        mainPanel.repaint();
        mainPanel.revalidate();

    }//GEN-LAST:event_btBatalActionPerformed

    private void tblPasienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPasienMouseClicked
        // TODO add your handling code here:
        // Mendapatkan baris yang diklik
    int baris = tblPasien.rowAtPoint(evt.getPoint());

    // Ambil idPasien dari kolom kedua yang sesuai (indeks 1)
    String idPasien = tblPasien.getValueAt(baris, 4).toString();  
    String namaPasien = tblPasien.getValueAt(baris, 1).toString();
    String jenisKelamin = tblPasien.getValueAt(baris, 2).toString();
    String alamat = tblPasien.getValueAt(baris, 3).toString();

    // Set data ke form edit
    txtEditNamaPasien.setText(namaPasien);
    txtEditAlamat.setText(alamat);
    txtHiddenIdPasien.setText(idPasien);  // ID Pasien diset di sini
    cbJenisKelamin.setSelectedItem(jenisKelamin);
    }//GEN-LAST:event_tblPasienMouseClicked

    private void bt_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_editActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.add(editPasient);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_bt_editActionPerformed

    private void btHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHapusActionPerformed
        // TODO add your handling code here:
        try {
            if ("".equals(txtHiddenIdPasien.getText())) {
                JOptionPane.showMessageDialog(this, "Pilih Data Yang ingin dihapus terlebih dahulu");
            } else {
                // Menampilkan konfirmasi sebelum menghapus data
                int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus data dengan Nama Pasien: " + txtEditNamaPasien.getText(),
                        "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

                // Jika pengguna memilih YES, lanjutkan menghapus
                if (confirm == JOptionPane.YES_OPTION) {
                    String sql = "DELETE FROM t_pasien WHERE idPasien='" + txtHiddenIdPasien.getText() + "'";
                    java.sql.Connection conn = (Connection) Config.configDB();
                    java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                    pst.execute();
                    JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus dengan Nama Pasien " + txtEditNamaPasien.getText());
                    writeLog("Data Berhasil Dihapus dengan Nama Pasien " + txtEditNamaPasien.getText());
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

    private void txtTambahNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTambahNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTambahNamaActionPerformed

    private void btBatal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBatal1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btBatal1ActionPerformed

    private void btBatal2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBatal2ActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.add(dataDokter);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_btBatal2ActionPerformed

    private void btEditPasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditPasienActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.add(dataDokter);
        mainPanel.repaint();
        mainPanel.revalidate();

        try {
            if ("".equals(txtEditNamaPasien.getText())) {
                JOptionPane.showMessageDialog(this, "Isikan Nama Pasien terlebih dahulu");
            } else {
                String sql = "UPDATE t_pasien SET namaPasien = '" + txtEditNamaPasien.getText()
                + "', jenisKelamin = '" + cbJenisKelamin.getSelectedItem()
                + "', alamat = '" + txtEditAlamat.getText()
                + "' WHERE idPasien = '" + txtHiddenIdPasien.getText() + "'";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Data Berhasil Diperbaharui dengan Nama Pasien" + txtEditNamaPasien.getText());
                writeLog("Data Berhasil Diperbaharui dengan Nama Pasien " + txtEditNamaPasien.getText());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Perubahan Data Gagal" + e.getMessage());
            writeLog("Perubahan Data Gagal : " + e.getMessage());
        }
        load_table();
    }//GEN-LAST:event_btEditPasienActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBatal;
    private javax.swing.JButton btBatal1;
    private javax.swing.JButton btBatal2;
    private javax.swing.JButton btEditPasien;
    private javax.swing.JButton btHapus;
    private javax.swing.JButton btSimpan;
    private javax.swing.JButton btTambah;
    private javax.swing.JButton bt_edit;
    private javax.swing.JComboBox<String> cbJenisKelamin;
    private javax.swing.JComboBox<String> cbLevel1;
    private javax.swing.JComboBox<String> cbTambahJenisKelamin;
    private javax.swing.JPanel dataDokter;
    private javax.swing.JPanel editPasient;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel tambahPasient;
    private javax.swing.JTable tblPasien;
    private javax.swing.JTextArea txtEditAlamat;
    private javax.swing.JTextField txtEditNamaPasien;
    private javax.swing.JTextField txtHiddenIdPasien;
    private javax.swing.JTextArea txtTambahAlamat;
    private javax.swing.JTextField txtTambahNama;
    // End of variables declaration//GEN-END:variables
}

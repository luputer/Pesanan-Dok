/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package src.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Config;
import static model.Config.writeLog;

/**
 *
 * @author Saidi
 */
public class Form_PasienKonsul extends javax.swing.JPanel {

    private void load_table(int idPasien) {
        // Membuat tampilan model tabel
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("ID Konsultasi"); // Kolom ini akan disembunyikan
        model.addColumn("Nama Pasien");
        model.addColumn("Nama Dokter");
        model.addColumn("Waktu Konsultasi");
        model.addColumn("Catatan");
        model.addColumn("Keperluan Pasien");

        // Menampilkan data database ke dalam tabel
        try {
            int no = 1;
            String sql = "SELECT k.idKonsultasi, p.namaPasien, d.namaDokter, k.waktuKonsultasi, k.catatan, k.keperluanPasien "
                    + "FROM t_konsultasi k "
                    + "JOIN t_pasien p ON k.idPasien = p.idPasien "
                    + "JOIN t_dokter d ON k.idDokter = d.idDokter "
                    + "WHERE k.idPasien = ?"; // Hanya data sesuai idPasien yang login

            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, idPasien); // Sesuaikan dengan metode Anda untuk mendapatkan idPasien login
            java.sql.ResultSet res = pst.executeQuery();

            while (res.next()) {
                model.addRow(new Object[]{
                    no++,
                    res.getString("idKonsultasi"),
                    res.getString("namaPasien"),
                    res.getString("namaDokter"),
                    res.getString("waktuKonsultasi"),
                    res.getString("catatan"),
                    res.getString("keperluanPasien")
                });
            }

            tblKonsul.setModel(model);

            // Menyembunyikan kolom ID Konsultasi
            tblKonsul.getColumnModel().getColumn(1).setMinWidth(0);
            tblKonsul.getColumnModel().getColumn(1).setMaxWidth(0);
            tblKonsul.getColumnModel().getColumn(1).setWidth(0);

            writeLog("Tampilkan data konsultasi ke Frame " + getClass().getSimpleName());
        } catch (Exception e) {
            writeLog("Data tidak dapat ditampilkan : " + e.getMessage());
        }
    }

    private HashMap<String, Integer> dokterMap = new HashMap<>();

    private void relasiDokter() {
        try {
            // Buka koneksi ke database
            Connection conn = Config.configDB();

            // Query untuk mengambil idDokter dan namaDokter dari tabel t_dokter
            String sql = "SELECT idDokter, namaDokter FROM t_dokter";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            // Bersihkan ComboBox sebelum mengisinya
            dokterMap.clear(); // Kosongkan peta

            // Loop untuk memasukkan nama dokter ke dalam comboBox dan map
            while (rs.next()) {
                int idDokter = rs.getInt("idDokter");
                String namaDokter = rs.getString("namaDokter");

                // Simpan hubungan antara namaDokter dan idDokter
                dokterMap.put(namaDokter, idDokter);

                // Tambahkan namaDokter ke ComboBox
                cbNamaDokter.addItem(namaDokter);
                cbEditNamaDokter.addItem(namaDokter);
            }

            // Tutup koneksi
            rs.close();
            pst.close();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Terjadi kesalahan saat memuat data dokter: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

// Kelas untuk menyimpan ID dan nama dokter
    private void setNamaPasien(int idPasien) {
        try {
            // Query untuk mendapatkan data pasien berdasarkan idPasien
            String sqlSelect = "SELECT * FROM t_pasien WHERE idPasien = ?";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstSelect = conn.prepareStatement(sqlSelect);
            pstSelect.setInt(1, idPasien); // Menggunakan idPasien untuk filter
            java.sql.ResultSet rs = pstSelect.executeQuery();

            if (rs.next()) {
                // Set text field dengan data pasien yang diambil
                txtNamaPasien.setText(rs.getString("namaPasien"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal memuat data pasien: " + e.getMessage());
        }
    }

    /**
     * Creates new form Form_DataKonsul
     */
    public Form_PasienKonsul(int idPasien) {
        initComponents();
        relasiDokter();
        txtHiddenIdPasien.setVisible(false);
        txtHiddenIdKonsul.setVisible(false);
        txtHiddenIdPasien.setText(String.valueOf(idPasien));
        setNamaPasien(idPasien);
        load_table(idPasien);
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
        mainPanel = new javax.swing.JPanel();
        dataKonsul = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKonsul = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btTambah = new javax.swing.JButton();
        jLabel64 = new javax.swing.JLabel();
        editKonsul = new javax.swing.JPanel();
        btSimpanKonsul = new javax.swing.JButton();
        btBatalKonsul = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbEditNamaDokter = new javax.swing.JComboBox<>();
        jTextField9 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtEditPasien = new javax.swing.JTextField();
        txtEditWaktuKonsul = new javax.swing.JTextField();
        txtHiddenIdKonsul = new javax.swing.JTextField();
        cbLevel3 = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        tambahKonsul = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblRelasiPdanD = new javax.swing.JLabel();
        lblPdanD = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbNamaDokter = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtHiddenIdPasien = new javax.swing.JTextField();
        txtWaktu = new javax.swing.JTextField();
        btSimpan = new javax.swing.JButton();
        btBatal = new javax.swing.JButton();
        txtNamaPasien = new javax.swing.JTextField();
        txtKeluhan1 = new javax.swing.JTextField();
        cbLevel1 = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        mainPanel.setLayout(new java.awt.CardLayout());

        dataKonsul.setBackground(new java.awt.Color(255, 255, 255));
        dataKonsul.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblKonsul.setModel(new javax.swing.table.DefaultTableModel(
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
        tblKonsul.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKonsulMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKonsul);

        dataKonsul.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 1040, 360));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/pngtree-blue-plus-concept-icon-on-white-background-png-image_8159235-removebg-preview 1_1.png"))); // NOI18N
        dataKonsul.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 460, 30, 30));

        btTambah.setBackground(new java.awt.Color(195, 224, 253));
        btTambah.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btTambah.setText("Tambah");
        btTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTambahActionPerformed(evt);
            }
        });
        dataKonsul.add(btTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 450, 110, 50));

        jLabel64.setBackground(new java.awt.Color(102, 102, 255));
        jLabel64.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(51, 51, 255));
        jLabel64.setText("Konsulatasi");
        dataKonsul.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        mainPanel.add(dataKonsul, "card2");

        editKonsul.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btSimpanKonsul.setText("Simpan");
        btSimpanKonsul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSimpanKonsulActionPerformed(evt);
            }
        });
        editKonsul.add(btSimpanKonsul, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 73, 100, 30));

        btBatalKonsul.setText("Batal");
        btBatalKonsul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBatalKonsulActionPerformed(evt);
            }
        });
        editKonsul.add(btBatalKonsul, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 73, 100, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("Nama Dokter");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("Nama Pasien");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setText("Keluhan");

        cbEditNamaDokter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setText("Waktu Konsultasi");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cbEditNamaDokter, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(94, 94, 94)
                                .addComponent(txtHiddenIdKonsul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 865, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField9)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtEditPasien, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtEditWaktuKonsul, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEditPasien, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbEditNamaDokter, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHiddenIdKonsul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEditWaktuKonsul, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        editKonsul.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 430));

        cbLevel3.setBackground(new java.awt.Color(153, 153, 255));
        cbLevel3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Level 1 (User)", "Level 2 (Pegawai)", "Level 3 (Admin)" }));
        editKonsul.add(cbLevel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 224, 364, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel17.setText("Edit Data Konsultasi");
        editKonsul.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        mainPanel.add(editKonsul, "card2");

        tambahKonsul.setBackground(new java.awt.Color(255, 255, 255));
        tambahKonsul.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblRelasiPdanD.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblRelasiPdanD.setText("Nama Dokter");

        lblPdanD.setBackground(new java.awt.Color(255, 255, 255));
        lblPdanD.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblPdanD.setText("Nama Pasien");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("Keluhan");

        cbNamaDokter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Dokter" }));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setText("Waktu Konsultasi");

        txtWaktu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtWaktu.setToolTipText("");
        txtWaktu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 255, 0)));
        txtWaktu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWaktuActionPerformed(evt);
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

        btBatal.setBackground(new java.awt.Color(204, 255, 255));
        btBatal.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/image 10.png"))); // NOI18N
        btBatal.setText("Batal");
        btBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBatalActionPerformed(evt);
            }
        });

        txtNamaPasien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNamaPasien.setToolTipText("");
        txtNamaPasien.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 255, 0)));
        txtNamaPasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaPasienActionPerformed(evt);
            }
        });

        txtKeluhan1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtKeluhan1.setToolTipText("");
        txtKeluhan1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 255, 0)));
        txtKeluhan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKeluhan1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPdanD, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(489, 1223, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbNamaDokter, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHiddenIdPasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblRelasiPdanD, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKeluhan1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamaPasien, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(btBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtWaktu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblPdanD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNamaPasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(txtHiddenIdPasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblRelasiPdanD)
                        .addGap(12, 12, 12)
                        .addComponent(cbNamaDokter, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtKeluhan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(25, 25, 25)
                .addComponent(txtWaktu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        tambahKonsul.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 430));

        cbLevel1.setBackground(new java.awt.Color(153, 153, 255));
        cbLevel1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Level 1 (User)", "Level 2 (Pegawai)", "Level 3 (Admin)" }));
        tambahKonsul.add(cbLevel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 224, 364, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        tambahKonsul.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, -1));

        jLabel65.setBackground(new java.awt.Color(102, 102, 255));
        jLabel65.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(51, 51, 255));
        jLabel65.setText("Tambah Konsulatasi");
        tambahKonsul.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        mainPanel.add(tambahKonsul, "card2");

        add(mainPanel, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSimpanActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.add(dataKonsul);
        mainPanel.repaint();
        mainPanel.revalidate();
        try {
            String selectedNamaDokter = cbNamaDokter.getSelectedItem().toString();

            if ("Pilih Dokter".equals(selectedNamaDokter)) {
                JOptionPane.showMessageDialog(this, "Silakan pilih dokter!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Dapatkan idDokter dari map
            Integer idDokter = dokterMap.get(selectedNamaDokter);
            if (idDokter == null) {
                JOptionPane.showMessageDialog(this, "Dokter tidak valid!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Query untuk menyisipkan data ke tabel t_konsultasi
            String sqlInsert = "INSERT INTO t_konsultasi (idPasien, idDokter, keperluanPasien, waktuKonsultasi) VALUES (?, ?, ?, ?)";
            java.sql.Connection conn = Config.configDB();
            java.sql.PreparedStatement pstInsert = conn.prepareStatement(sqlInsert);

            // Ambil data dari input form
            int idPasien = Integer.parseInt(txtHiddenIdPasien.getText());
            String keluhan = txtWaktu.getText();
            String tanggalKonsultasi = txtWaktu.getText(); // Format tanggal sesuai dengan tipe di database

            // Set nilai parameter untuk query
            pstInsert.setInt(1, idPasien);
            pstInsert.setInt(2, idDokter);
            pstInsert.setString(3, keluhan);
            pstInsert.setString(4, tanggalKonsultasi);

            // Eksekusi query
            pstInsert.executeUpdate();
            JOptionPane.showMessageDialog(null, "Penyimpanan Data Konsultasi Berhasil");

            // Tutup koneksi
            pstInsert.close();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Data gagal disimpan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btSimpanActionPerformed

    private void btTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTambahActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        mainPanel.add(tambahKonsul);
        mainPanel.repaint();
        mainPanel.revalidate();


    }//GEN-LAST:event_btTambahActionPerformed

    private void btBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBatalActionPerformed
        // TODO add your handling code here:

        mainPanel.removeAll();
        mainPanel.add(dataKonsul);
        mainPanel.repaint();
        mainPanel.revalidate();

    }//GEN-LAST:event_btBatalActionPerformed

    private void tblKonsulMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKonsulMouseClicked
        // TODO add your handling code here:
//        int baris = tblKonsul.rowAtPoint(evt.getPoint());
//
//// Ambil nilai dari kolom yang sesuai dengan pemeriksaan null
//        String idKonsultasi = (tblKonsul.getValueAt(baris, 1) != null) ? tblKonsul.getValueAt(baris, 1).toString() : ""; // ID Konsultasi
//        String idPasien = (tblKonsul.getValueAt(baris, 2) != null) ? tblKonsul.getValueAt(baris, 2).toString() : ""; // ID Pasien
//        String idDokter = (tblKonsul.getValueAt(baris, 3) != null) ? tblKonsul.getValueAt(baris, 3).toString() : ""; // ID Dokter
//        String waktuKonsultasi = (tblKonsul.getValueAt(baris, 4) != null) ? tblKonsul.getValueAt(baris, 4).toString() : ""; // Waktu Konsultasi
//        String catatan = (tblKonsul.getValueAt(baris, 5) != null) ? tblKonsul.getValueAt(baris, 5).toString() : ""; // Catatan
//        String keperluanPasien = (tblKonsul.getValueAt(baris, 6) != null) ? tblKonsul.getValueAt(baris, 6).toString() : ""; // Keperluan Pasien
//
//// Menampilkan data yang dipilih ke field yang sesuai
//        txtHiddenIdKonsul.setText(idKonsultasi); // Menyimpan ID Konsultasi
//        
//        cbEditNamaDokter.setSelectedItem(idDokter); // Menyimpan ID Dokter
//
//// Menampilkan data lainnya yang relevan ke field yang sesuai
//        txtWaktu.setText(waktuKonsultasi);
//        txtKeluhan.setText(keperluanPasien);
//
//// Jika perlu menampilkan nama dokter, bisa ditambahkan pencarian nama berdasarkan ID Dokter
////        String namaDokter = getNamaDokterById(Integer.parseInt(idDokter)); // Misalkan ada metode untuk mendapatkan nama dokter berdasarkan ID
////        cbEditNamaDokter.setSelectedItem(namaDokter); // Menetapkan nama dokter di comboBox


    }//GEN-LAST:event_tblKonsulMouseClicked

    private void btSimpanKonsulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSimpanKonsulActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.add(editKonsul);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_btSimpanKonsulActionPerformed

    private void btBatalKonsulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBatalKonsulActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.add(editKonsul);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_btBatalKonsulActionPerformed

    private void txtWaktuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWaktuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtWaktuActionPerformed

    private void txtNamaPasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaPasienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaPasienActionPerformed

    private void txtKeluhan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKeluhan1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKeluhan1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBatal;
    private javax.swing.JButton btBatalKonsul;
    private javax.swing.JButton btSimpan;
    private javax.swing.JButton btSimpanKonsul;
    private javax.swing.JButton btTambah;
    private javax.swing.JComboBox<String> cbEditNamaDokter;
    private javax.swing.JComboBox<String> cbLevel1;
    private javax.swing.JComboBox<String> cbLevel3;
    private javax.swing.JComboBox<String> cbNamaDokter;
    private javax.swing.JPanel dataKonsul;
    private javax.swing.JPanel editKonsul;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel lblPdanD;
    private javax.swing.JLabel lblRelasiPdanD;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel tambahKonsul;
    private javax.swing.JTable tblKonsul;
    private javax.swing.JTextField txtEditPasien;
    private javax.swing.JTextField txtEditWaktuKonsul;
    private javax.swing.JTextField txtHiddenIdKonsul;
    private javax.swing.JTextField txtHiddenIdPasien;
    private javax.swing.JTextField txtKeluhan1;
    private javax.swing.JTextField txtNamaPasien;
    private javax.swing.JTextField txtWaktu;
    // End of variables declaration//GEN-END:variables
}

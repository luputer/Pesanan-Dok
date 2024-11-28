/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package src.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Config;
import static model.Config.writeLog;

/**
 *
 * @author Saidi
 */
public class Form_DokterKonsul extends javax.swing.JPanel {

    private void load_table(int idDokter) {
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
                    + "WHERE k.idDokter = ?"; // Hanya data sesuai idPasien yang login

            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, idDokter); // Sesuaikan dengan metode Anda untuk mendapatkan idPasien login
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

            tblDokterKonsul.setModel(model);

            // Menyembunyikan kolom ID Konsultasi
            tblDokterKonsul.getColumnModel().getColumn(1).setMinWidth(0);
            tblDokterKonsul.getColumnModel().getColumn(1).setMaxWidth(0);
            tblDokterKonsul.getColumnModel().getColumn(1).setWidth(0);

            writeLog("Tampilkan data konsultasi ke Frame " + getClass().getSimpleName());
        } catch (Exception e) {
            writeLog("Data tidak dapat ditampilkan : " + e.getMessage());
        }
    }
    private HashMap<String, Integer> dokterMap = new HashMap<>();

    private void relasiPasien() {
        try {
            // Buka koneksi ke database
            Connection conn = Config.configDB();

            // Query untuk mengambil idDokter dan namaDokter dari tabel t_dokter
            String sql = "SELECT idPasien, namaPasien FROM t_pasien";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            // Bersihkan ComboBox sebelum mengisinya
            dokterMap.clear(); // Kosongkan peta

            // Loop untuk memasukkan nama dokter ke dalam comboBox dan map
            while (rs.next()) {
                int idPasien = rs.getInt("idPasien");
                String namaPasien = rs.getString("namaPasien");

                // Simpan hubungan antara namaDokter dan idDokter
                dokterMap.put(namaPasien, idPasien);

                // Tambahkan namaDokter ke ComboBox
                cbNamaPasien.addItem(namaPasien);
//                cbEditNamaDokter.addItem(namaDokter);
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
    private void setNamaDokter(int idDokter) {
        try {
            // Query untuk mendapatkan data pasien berdasarkan idPasien
            String sqlSelect = "SELECT * FROM t_dokter WHERE idDokter = ?";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstSelect = conn.prepareStatement(sqlSelect);
            pstSelect.setInt(1, idDokter); // Menggunakan idPasien untuk filter
            java.sql.ResultSet rs = pstSelect.executeQuery();

            if (rs.next()) {
                // Set text field dengan data pasien yang diambil
                txtEditNamaDokter.setText(rs.getString("namaDokter"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal memuat data dokter: " + e.getMessage());
        }
    }

    /**
     * Creates new form Form_DataKonsul
     */
    public Form_DokterKonsul(int idDokter) {
        initComponents();
        load_table(idDokter);
        txtHiddenIdDokter.setVisible(false);
        txtHiddenIdKonsul.setVisible(false);
        txtHiddenIdDokter.setText(String.valueOf(idDokter));
        setNamaDokter(idDokter);
        relasiPasien();
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
        tblDokterKonsul = new javax.swing.JTable();
        jLabel64 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        bt_edit = new javax.swing.JButton();
        editKonsul = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbNamaPasien = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtHiddenIdDokter = new javax.swing.JTextField();
        txtHiddenIdKonsul = new javax.swing.JTextField();
        btSimpanKonsul = new javax.swing.JButton();
        btBatalKonsul = new javax.swing.JButton();
        txtEditNamaDokter = new javax.swing.JTextField();
        txtKeluhan = new javax.swing.JTextField();
        txtCatatan = new javax.swing.JTextField();
        txtWaktu = new javax.swing.JTextField();
        cbLevel3 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        tambahKonsul = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField6 = new javax.swing.JTextField();
        txtNamaDokter1 = new javax.swing.JTextField();
        btSimpan = new javax.swing.JButton();
        btBatal = new javax.swing.JButton();
        cbLevel1 = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        mainPanel.setLayout(new java.awt.CardLayout());

        dataKonsul.setBackground(new java.awt.Color(255, 255, 255));
        dataKonsul.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDokterKonsul.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDokterKonsul.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDokterKonsulMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDokterKonsul);

        dataKonsul.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 980, 370));

        jLabel64.setBackground(new java.awt.Color(102, 102, 255));
        jLabel64.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(51, 51, 255));
        jLabel64.setText("data konsultasi");
        dataKonsul.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/image 12.png"))); // NOI18N
        dataKonsul.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 470, -1, -1));

        bt_edit.setBackground(new java.awt.Color(129, 179, 251));
        bt_edit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bt_edit.setText("Edit");
        bt_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_editActionPerformed(evt);
            }
        });
        dataKonsul.add(bt_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 460, 120, 50));

        mainPanel.add(dataKonsul, "card2");

        editKonsul.setBackground(new java.awt.Color(255, 255, 255));
        editKonsul.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("Nama Dokter");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setText("Keluhan");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setText("Catatan");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setText("Waktu");

        btSimpanKonsul.setBackground(new java.awt.Color(195, 224, 253));
        btSimpanKonsul.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btSimpanKonsul.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/Vector.png"))); // NOI18N
        btSimpanKonsul.setText("Simpan");
        btSimpanKonsul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSimpanKonsulActionPerformed(evt);
            }
        });

        btBatalKonsul.setBackground(new java.awt.Color(204, 255, 255));
        btBatalKonsul.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btBatalKonsul.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/Group 2803.png"))); // NOI18N
        btBatalKonsul.setText("Batal");
        btBatalKonsul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBatalKonsulActionPerformed(evt);
            }
        });

        txtEditNamaDokter.setEditable(false);
        txtEditNamaDokter.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEditNamaDokter.setToolTipText("");
        txtEditNamaDokter.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 255, 0)));
        txtEditNamaDokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEditNamaDokterActionPerformed(evt);
            }
        });

        txtKeluhan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtKeluhan.setToolTipText("");
        txtKeluhan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 255, 0)));
        txtKeluhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKeluhanActionPerformed(evt);
            }
        });

        txtCatatan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCatatan.setToolTipText("");
        txtCatatan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 255, 0)));
        txtCatatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCatatanActionPerformed(evt);
            }
        });

        txtWaktu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtWaktu.setToolTipText("");
        txtWaktu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 255, 0)));
        txtWaktu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWaktuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEditNamaDokter, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(234, 234, 234)
                                        .addComponent(txtHiddenIdKonsul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtHiddenIdDokter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(cbNamaPasien, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtKeluhan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                                .addComponent(txtCatatan, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtWaktu, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btSimpanKonsul)
                        .addGap(55, 55, 55)
                        .addComponent(btBatalKonsul, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 725, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cbNamaPasien, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEditNamaDokter, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(txtHiddenIdKonsul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtHiddenIdDokter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtKeluhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCatatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(txtWaktu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSimpanKonsul, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBatalKonsul, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        editKonsul.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, 490));

        cbLevel3.setBackground(new java.awt.Color(153, 153, 255));
        cbLevel3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Level 1 (User)", "Level 2 (Pegawai)", "Level 3 (Admin)" }));
        editKonsul.add(cbLevel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 224, 364, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("Nama Pasien");
        editKonsul.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 243, -1));

        jLabel22.setBackground(new java.awt.Color(102, 102, 255));
        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(51, 51, 255));
        jLabel22.setText("Edit Data Konsultasi");
        editKonsul.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 390, -1));

        mainPanel.add(editKonsul, "card2");

        tambahKonsul.setBackground(new java.awt.Color(255, 255, 255));
        tambahKonsul.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Nama Dokter");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("Keluhan");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setText("Catatan");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jTextField6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField6.setToolTipText("");
        jTextField6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 255, 0)));
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        txtNamaDokter1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNamaDokter1.setToolTipText("");
        txtNamaDokter1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 255, 0)));
        txtNamaDokter1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaDokter1ActionPerformed(evt);
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
        btBatal.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/image 10.png"))); // NOI18N
        btBatal.setText("Batal");
        btBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBatalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNamaDokter1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(btSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(892, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNamaDokter1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        tambahKonsul.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 430));

        cbLevel1.setBackground(new java.awt.Color(153, 153, 255));
        cbLevel1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Level 1 (User)", "Level 2 (Pegawai)", "Level 3 (Admin)" }));
        tambahKonsul.add(cbLevel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 224, 364, -1));

        jLabel23.setBackground(new java.awt.Color(102, 102, 255));
        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(51, 51, 255));
        jLabel23.setText("Tambah Data Konsultasi");
        tambahKonsul.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 390, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setText("Nama Pasien");
        tambahKonsul.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 243, -1));

        mainPanel.add(tambahKonsul, "card2");

        add(mainPanel, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSimpanActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.add(dataKonsul);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_btSimpanActionPerformed

    private void btBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBatalActionPerformed
        // TODO add your handling code here:

        mainPanel.removeAll();
        mainPanel.add(dataKonsul);
        mainPanel.repaint();
        mainPanel.revalidate();

    }//GEN-LAST:event_btBatalActionPerformed

    private void tblDokterKonsulMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDokterKonsulMouseClicked
        // TODO add your handling code here:
        int baris = tblDokterKonsul.rowAtPoint(evt.getPoint());

// Ambil nilai dari kolom yang sesuai dengan pemeriksaan null
        String idKonsultasi = (tblDokterKonsul.getValueAt(baris, 1) != null) ? tblDokterKonsul.getValueAt(baris, 1).toString() : ""; // ID Konsultasi
        String namaPasien = (tblDokterKonsul.getValueAt(baris, 2) != null) ? tblDokterKonsul.getValueAt(baris, 2).toString() : ""; // ID Pasien
        String idDokter = (tblDokterKonsul.getValueAt(baris, 3) != null) ? tblDokterKonsul.getValueAt(baris, 3).toString() : ""; // ID Dokter
        String waktuKonsultasi = (tblDokterKonsul.getValueAt(baris, 4) != null) ? tblDokterKonsul.getValueAt(baris, 4).toString() : ""; // Waktu Konsultasi
        String catatan = (tblDokterKonsul.getValueAt(baris, 5) != null) ? tblDokterKonsul.getValueAt(baris, 5).toString() : ""; // Catatan
        String keperluanPasien = (tblDokterKonsul.getValueAt(baris, 6) != null) ? tblDokterKonsul.getValueAt(baris, 6).toString() : ""; // Keperluan Pasien

// Menampilkan data yang dipilih ke field yang sesuai
        txtHiddenIdKonsul.setText(idKonsultasi); // Menyimpan ID Konsultasi
        txtCatatan.setText(catatan); // Menyimpan ID Konsultasi

// Mencari nama pasien berdasarkan ID Pasien dan mengatur ComboBox
//        String namaPasien = txtHiddenIdDokter.getText();
        cbNamaPasien.setSelectedItem(namaPasien); // Set nama pasien di ComboBox

// Menampilkan data lainnya yang relevan ke field yang sesuai
        txtWaktu.setText(waktuKonsultasi);
        txtKeluhan.setText(keperluanPasien);

    }//GEN-LAST:event_tblDokterKonsulMouseClicked

    private void bt_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_editActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.add(editKonsul);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_bt_editActionPerformed

    private void btSimpanKonsulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSimpanKonsulActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.add(editKonsul);
        mainPanel.repaint();
        mainPanel.revalidate();

        try {
            // Ambil data dari input pengguna
            String idKonsultasi = txtHiddenIdKonsul.getText();
            String namaPasien = (String) cbNamaPasien.getSelectedItem();
            String waktuKonsultasi = txtWaktu.getText();
            String keperluanPasien = txtKeluhan.getText();
            String catatan = txtCatatan.getText(); // Pastikan ada komponen untuk catatan

            // Validasi data input
            if (idKonsultasi.isEmpty() || namaPasien.isEmpty() || waktuKonsultasi.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Harap isi semua data yang diperlukan.", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Dapatkan ID Pasien dari nama pasien
            int idPasien = dokterMap.get(namaPasien);

            // Update data di database
            String sqlUpdate = "UPDATE t_konsultasi SET idPasien = ?, waktuKonsultasi = ?,  catatan = ? ,keperluanPasien = ? WHERE idKonsultasi = ?";
            Connection conn = Config.configDB();
            PreparedStatement pst = conn.prepareStatement(sqlUpdate);
            pst.setInt(1, idPasien);
            pst.setString(2, waktuKonsultasi);
            pst.setString(3, catatan);
            pst.setString(4, keperluanPasien);
            pst.setString(5, idKonsultasi);

            int rowsUpdated = pst.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Data konsultasi berhasil diperbarui.", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                load_table(Integer.parseInt(txtHiddenIdDokter.getText())); // Refresh tabel
            } else {
                JOptionPane.showMessageDialog(this, "Gagal memperbarui data konsultasi.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            }

            // Tutup koneksi
            pst.close();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btSimpanKonsulActionPerformed

    private void btBatalKonsulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBatalKonsulActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.add(editKonsul);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_btBatalKonsulActionPerformed

    private void txtEditNamaDokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEditNamaDokterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEditNamaDokterActionPerformed

    private void txtKeluhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKeluhanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKeluhanActionPerformed

    private void txtCatatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCatatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCatatanActionPerformed

    private void txtWaktuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWaktuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtWaktuActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void txtNamaDokter1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaDokter1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaDokter1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBatal;
    private javax.swing.JButton btBatalKonsul;
    private javax.swing.JButton btSimpan;
    private javax.swing.JButton btSimpanKonsul;
    private javax.swing.JButton bt_edit;
    private javax.swing.JComboBox<String> cbLevel1;
    private javax.swing.JComboBox<String> cbLevel3;
    private javax.swing.JComboBox<String> cbNamaPasien;
    private javax.swing.JPanel dataKonsul;
    private javax.swing.JPanel editKonsul;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel tambahKonsul;
    private javax.swing.JTable tblDokterKonsul;
    private javax.swing.JTextField txtCatatan;
    private javax.swing.JTextField txtEditNamaDokter;
    private javax.swing.JTextField txtHiddenIdDokter;
    private javax.swing.JTextField txtHiddenIdKonsul;
    private javax.swing.JTextField txtKeluhan;
    private javax.swing.JTextField txtNamaDokter1;
    private javax.swing.JTextField txtWaktu;
    // End of variables declaration//GEN-END:variables
}

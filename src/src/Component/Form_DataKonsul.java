/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package src.Component;

/**
 *
 * @author Saidi
 */
public class Form_DataKonsul extends javax.swing.JPanel {

    /**
     * Creates new form Form_DataKonsul
     */
    public Form_DataKonsul() {
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

        jTextField3 = new javax.swing.JTextField();
        mainPanel = new javax.swing.JPanel();
        dataKonsul = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKonsultasi = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btTambah = new javax.swing.JButton();
        bt_edit = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        editKonsul = new javax.swing.JPanel();
        btSimpanKonsul = new javax.swing.JButton();
        btBatalKonsul = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbLevel2 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        txtid2 = new javax.swing.JTextField();
        cbLevel3 = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        tambahKonsul = new javax.swing.JPanel();
        btSimpan = new javax.swing.JButton();
        btBatal = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbLevel = new javax.swing.JComboBox<>();
        jTextField6 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        cbLevel1 = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        mainPanel.setLayout(new java.awt.CardLayout());

        dataKonsul.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblKonsultasi.setModel(new javax.swing.table.DefaultTableModel(
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
        tblKonsultasi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKonsultasiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKonsultasi);

        dataKonsul.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1470, 360));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Data Hasil Konsulatasi");
        dataKonsul.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 400, -1));

        btTambah.setText("Tambah");
        btTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTambahActionPerformed(evt);
            }
        });
        dataKonsul.add(btTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 94, -1));

        bt_edit.setText("Edit");
        bt_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_editActionPerformed(evt);
            }
        });
        dataKonsul.add(bt_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 94, -1));

        jButton3.setText("Hapus");
        dataKonsul.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 94, -1));

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

        cbLevel2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setText("Catatan");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        txtid2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtid2.setToolTipText("");
        txtid2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 255, 0)));
        txtid2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtid2txtid1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbLevel2, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(txtid2, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbLevel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtid2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
        );

        editKonsul.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 430));

        cbLevel3.setBackground(new java.awt.Color(153, 153, 255));
        cbLevel3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Level 1 (User)", "Level 2 (Pegawai)", "Level 3 (Admin)" }));
        editKonsul.add(cbLevel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 224, 364, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel17.setText("Edit Data Konsultasi");
        editKonsul.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        mainPanel.add(editKonsul, "card2");

        tambahKonsul.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btSimpan.setText("Simpan");
        btSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSimpanActionPerformed(evt);
            }
        });
        tambahKonsul.add(btSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 73, 100, 30));

        btBatal.setText("Batal");
        btBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBatalActionPerformed(evt);
            }
        });
        tambahKonsul.add(btBatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 73, 100, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Nama Dokter");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setText("Nama Pasien");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("Keluhan");

        cbLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setText("Catatan");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 1041, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
        );

        tambahKonsul.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 430));

        cbLevel1.setBackground(new java.awt.Color(153, 153, 255));
        cbLevel1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Level 1 (User)", "Level 2 (Pegawai)", "Level 3 (Admin)" }));
        tambahKonsul.add(cbLevel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 224, 364, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel16.setText("Tambah Data Konsultasi");
        tambahKonsul.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

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

    private void tblKonsultasiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKonsultasiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblKonsultasiMouseClicked

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
    }//GEN-LAST:event_btSimpanKonsulActionPerformed

    private void btBatalKonsulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBatalKonsulActionPerformed
        // TODO add your handling code here:
          mainPanel.removeAll();
          mainPanel.add(editKonsul);
          mainPanel.repaint();
          mainPanel.revalidate();
    }//GEN-LAST:event_btBatalKonsulActionPerformed

    private void txtid2txtid1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtid2txtid1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtid2txtid1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBatal;
    private javax.swing.JButton btBatalKonsul;
    private javax.swing.JButton btSimpan;
    private javax.swing.JButton btSimpanKonsul;
    private javax.swing.JButton btTambah;
    private javax.swing.JButton bt_edit;
    private javax.swing.JComboBox<String> cbLevel;
    private javax.swing.JComboBox<String> cbLevel1;
    private javax.swing.JComboBox<String> cbLevel2;
    private javax.swing.JComboBox<String> cbLevel3;
    private javax.swing.JPanel dataKonsul;
    private javax.swing.JPanel editKonsul;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel tambahKonsul;
    private javax.swing.JTable tblKonsultasi;
    private javax.swing.JTextField txtid2;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package src.Component;

import java.awt.Dimension;  
import java.awt.event.ActionListener;  
import java.util.ArrayList;  
import javax.swing.Icon;  
import javax.swing.JLabel;

/**
 *
 * @author Saidi
 */
public class MenuItem extends javax.swing.JPanel {

    /**
     * @return the subMenu
     */
    public ArrayList<MenuItem> getSubMenu() {
        return subMenu;
    }

    /**
     * Creates new form MenuItem
     */
     // Menghapus pengulangan kata kunci 'private' pada deklarasi  
    private final ArrayList<MenuItem> subMenu = new ArrayList<>();  
    private ActionListener act;  
    private boolean showing = false;  

    
    public MenuItem(Icon icon, boolean sbm, Icon iconSub, String menuName, ActionListener act, MenuItem...subMenu) {
        initComponents();
        
        
        lb_icon.setIcon(icon);
        lb_menuName.setText(menuName);
        
        
          if (iconSub != null) {
            lb_iconSub.setIcon(iconSub);
        }
        lb_iconSub.setVisible(sbm);

        if (act != null) {
            this.act = act;
        }
        
        this.setSize(new Dimension(Integer.MAX_VALUE, 45));
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
        this.setMinimumSize(new Dimension(Integer.MAX_VALUE, 45));

        // Menambahkan submenu
        for (MenuItem item : subMenu) {
            this.subMenu.add(item);
            item.setVisible(false);
            this.add(item);
        }
           
        
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_menuName = new javax.swing.JLabel();
        lb_iconSub = new javax.swing.JLabel();
        lb_icon = new javax.swing.JLabel();

        setBackground(new java.awt.Color(220, 232, 243));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        lb_menuName.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lb_menuName.setText("Menu Item");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lb_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_iconSub, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb_menuName)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(lb_menuName, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lb_icon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lb_iconSub, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
           // Jalankan aksi yang terkait dengan menu jika ada
    if (act != null) {
        act.actionPerformed(null);
    }
    
    resetOtherMenus();

    // Tampilkan atau sembunyikan submenu berdasarkan status 'showing'
    if (showing) {
        hidenMenu();
    } else {
        showMenu();
    }

   
    this.setBackground(new java.awt.Color(0xB4D2FF)); // Warna gelap untuk menu yang aktif

//     this.setBackground(new java.awt.Color(102, 102, 102));
    
    }//GEN-LAST:event_formMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lb_icon;
    private javax.swing.JLabel lb_iconSub;
    private javax.swing.JLabel lb_menuName;
    // End of variables declaration//GEN-END:variables

    private void hidenMenu() {
       new Thread(() -> {
        for (int i = subMenu.size() - 1; i >= 0; i--) {
            sleep();
            subMenu.get(i).setVisible(false);
            subMenu.get(i).hidenMenu(); // Rekursif untuk menyembunyikan submenu anak
        }
        showing = false;
        getParent().repaint();
        getParent().revalidate();
    }).start();
    }

     private void showMenu() {
       new Thread(() -> {
        for (MenuItem item : subMenu) {
            sleep();
            item.setVisible(true);
        }
        showing = true;
        getParent().repaint();
        getParent().revalidate();
    }).start();
    }
    
     private void sleep() {
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void resetOtherMenus() {
        if (this.getParent() instanceof javax.swing.JPanel parent) {
        for (java.awt.Component comp : parent.getComponents()) {
            if (comp instanceof MenuItem menuItem && menuItem != this) {
                menuItem.setBackground(new java.awt.Color(0x0DCE8F3));
            }
        }
    }
    }
    
    
    
}

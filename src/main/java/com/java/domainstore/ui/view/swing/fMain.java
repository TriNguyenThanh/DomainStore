/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.java.domainstore.ui.view.swing;

import com.java.domainstore.utils.ImageUtils;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author tring
 */
public class fMain extends javax.swing.JFrame {
    
    private int x;
    private int y;
    
    public fMain() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        setLocationRelativeTo(null);
        this.setTitle("DomainStore");
        this.setIconImage(ImageUtils.getImage("/icon/utc2.png", 128, 128).getImage());
        this.moving();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnBG1 = new com.java.domainstore.ui.view.container.pnBG();
        btExit = new com.java.domainstore.ui.view.component.MyButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        btExit.setText("x");
        btExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnBG1Layout = new javax.swing.GroupLayout(pnBG1);
        pnBG1.setLayout(pnBG1Layout);
        pnBG1Layout.setHorizontalGroup(
            pnBG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBG1Layout.createSequentialGroup()
                .addContainerGap(1134, Short.MAX_VALUE)
                .addComponent(btExit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnBG1Layout.setVerticalGroup(
            pnBG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBG1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btExit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(764, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnBG1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnBG1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_btExitActionPerformed
    private void moving() {
        pnBG1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();
            }
        });

        pnBG1.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
            }

        });
    }

    public static void start() {
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
            java.util.logging.Logger.getLogger(fMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.java.domainstore.ui.view.component.MyButton btExit;
    private com.java.domainstore.ui.view.container.pnBG pnBG1;
    // End of variables declaration//GEN-END:variables
}

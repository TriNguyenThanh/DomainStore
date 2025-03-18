package com.java.domainstore.ui.view.swing;

import com.java.domainstore.ui.controller.LoginController;
import com.java.domainstore.ui.model.LoginModel;
import com.java.domainstore.utils.ImageUtils;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class fLogin extends javax.swing.JFrame {
    private int x;
    private int y;
    
    public fLogin() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        setLocationRelativeTo(null);
        this.setTitle("Đăng nhập");
        this.setIconImage(ImageUtils.getImage("/icon/utc2.png", 128, 128).getImage());
        this.moving();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnBG1 = new com.java.domainstore.ui.view.container.pnBG();
        lbApp = new com.java.domainstore.ui.view.component.MyTitle();
        btExit = new com.java.domainstore.ui.view.component.MyButton();
        tfUserName = new com.java.domainstore.ui.view.component.MyTextField();
        lbTitle = new com.java.domainstore.ui.view.component.MyTitle();
        cbSHow = new com.java.domainstore.ui.view.component.MyCB();
        lbUser = new com.java.domainstore.ui.view.component.MyContent();
        lbPass = new com.java.domainstore.ui.view.component.MyContent();
        tfPass = new com.java.domainstore.ui.view.component.MyPasswordField();
        lbErrUser = new com.java.domainstore.ui.view.component.MyErr();
        lbErrPass = new com.java.domainstore.ui.view.component.MyErr();
        btLogin = new com.java.domainstore.ui.view.component.MyButton(Color.WHITE, Color.GREEN);
        myLink2 = new com.java.domainstore.ui.view.component.MyLink();
        myPanel1 = new com.java.domainstore.ui.view.container.MyPanel();
        myErr1 = new com.java.domainstore.ui.view.component.MyErr();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setUndecorated(true);

        lbApp.setForeground(new java.awt.Color(255, 255, 255));
        lbApp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logo48.png"))); // NOI18N
        lbApp.setText("UTC2 Domain Store");

        btExit.setText("Thoát");
        btExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExitActionPerformed(evt);
            }
        });

        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("Đăng nhập");
        lbTitle.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N

        cbSHow.setText("Show password");
        cbSHow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cbSHow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSHowActionPerformed(evt);
            }
        });

        lbUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user32.png"))); // NOI18N
        lbUser.setText("SĐT     ");

        lbPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/key32.png"))); // NOI18N
        lbPass.setText("Password");

        tfPass.setText("");

        lbErrUser.setText(" ");

        lbErrPass.setText(" ");

        btLogin.setText("Đăng nhập");
        btLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoginActionPerformed(evt);
            }
        });

        myLink2.setText("Chưa có tài khoản? Đăng ký tài khoản ở đây");
        myLink2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                myLink2MouseClicked(evt);
            }
        });

        myPanel1.setOpaque(true);

        myErr1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/loginBG.png"))); // NOI18N
        myErr1.setText("");
        myErr1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        myErr1.setOpaque(true);

        javax.swing.GroupLayout myPanel1Layout = new javax.swing.GroupLayout(myPanel1);
        myPanel1.setLayout(myPanel1Layout);
        myPanel1Layout.setHorizontalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(myErr1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        myPanel1Layout.setVerticalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(myErr1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout pnBG1Layout = new javax.swing.GroupLayout(pnBG1);
        pnBG1.setLayout(pnBG1Layout);
        pnBG1Layout.setHorizontalGroup(
            pnBG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBG1Layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addComponent(myPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(pnBG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBG1Layout.createSequentialGroup()
                        .addComponent(lbUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnBG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbErrUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBG1Layout.createSequentialGroup()
                        .addComponent(btExit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addGroup(pnBG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbSHow, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBG1Layout.createSequentialGroup()
                        .addComponent(lbPass, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnBG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbErrPass, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)))
                    .addComponent(lbApp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBG1Layout.createSequentialGroup()
                        .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addComponent(myLink2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );
        pnBG1Layout.setVerticalGroup(
            pnBG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBG1Layout.createSequentialGroup()
                .addGroup(pnBG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnBG1Layout.createSequentialGroup()
                        .addContainerGap(31, Short.MAX_VALUE)
                        .addComponent(myPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnBG1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbApp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112)
                        .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(lbErrUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnBG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lbErrPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnBG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbSHow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(pnBG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(myLink2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
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

    private void btLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLoginActionPerformed
        LoginController lgctrl = new LoginController();
        switch (lgctrl.verify(new LoginModel(tfUserName.getText(), tfPass.getPassword()))) {
            case 1:
                lbErrUser.setText("* Tên đăng nhập không được để trống");
                break;
            case 2:
                lbErrUser.setText(" ");
                lbErrPass.setText("* Mật khẩu không được để trống");
                break;
            case 3:
                lbErrUser.setText("* Tên đăng nhập hoặc mật khẩu không đúng");
                lbErrPass.setText("* Tên đăng nhập hoặc mật khẩu không đúng");
                break;
            case 0:
                lbErrUser.setText(" ");
                lbErrPass.setText(" ");
                fMain.start();
                this.dispose();
                break;
        }
    }//GEN-LAST:event_btLoginActionPerformed

    private void cbSHowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSHowActionPerformed
        if (cbSHow.isSelected()) {
            tfPass.show();
        } else {
            tfPass.hide();
        }
    }//GEN-LAST:event_cbSHowActionPerformed
    private void btExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_btExitActionPerformed

    private void myLink2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myLink2MouseClicked
        fRegister.start();
        this.dispose();
    }//GEN-LAST:event_myLink2MouseClicked

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
                setLocation(e.getXOnScreen() - x,e.getYOnScreen() - y);
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

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.java.domainstore.ui.view.component.MyButton btExit;
    private com.java.domainstore.ui.view.component.MyButton btLogin;
    private com.java.domainstore.ui.view.component.MyCB cbSHow;
    private com.java.domainstore.ui.view.component.MyTitle lbApp;
    private com.java.domainstore.ui.view.component.MyErr lbErrPass;
    private com.java.domainstore.ui.view.component.MyErr lbErrUser;
    private com.java.domainstore.ui.view.component.MyContent lbPass;
    private com.java.domainstore.ui.view.component.MyTitle lbTitle;
    private com.java.domainstore.ui.view.component.MyContent lbUser;
    private com.java.domainstore.ui.view.component.MyErr myErr1;
    private com.java.domainstore.ui.view.component.MyLink myLink2;
    private com.java.domainstore.ui.view.container.MyPanel myPanel1;
    private com.java.domainstore.ui.view.container.pnBG pnBG1;
    private com.java.domainstore.ui.view.component.MyPasswordField tfPass;
    private com.java.domainstore.ui.view.component.MyTextField tfUserName;
    // End of variables declaration//GEN-END:variables
}

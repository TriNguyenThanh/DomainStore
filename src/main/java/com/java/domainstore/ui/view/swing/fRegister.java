package com.java.domainstore.ui.view.swing;

import com.java.domainstore.ui.controller.RegisterController;
import com.java.domainstore.ui.model.RegisterModel;
import com.java.domainstore.utils.ImageUtils;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;


public class fRegister extends javax.swing.JFrame {

    private int x;
    private int y;

    public fRegister() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        setLocationRelativeTo(null);
        this.setTitle("Register");
        this.setIconImage(ImageUtils.getImage("/icon/utc2.png", 128, 128).getImage());
        this.moving();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnBG1 = new com.java.domainstore.ui.view.container.pnBG();
        lbTitle = new com.java.domainstore.ui.view.component.MyTitle();
        lbName = new com.java.domainstore.ui.view.component.MyContent();
        lbErrName = new com.java.domainstore.ui.view.component.MyErr();
        tfName = new com.java.domainstore.ui.view.component.MyTextField();
        lbPhone = new com.java.domainstore.ui.view.component.MyContent();
        lbErrPhone = new com.java.domainstore.ui.view.component.MyErr();
        tfPhone = new com.java.domainstore.ui.view.component.MyTextField();
        lbEmail = new com.java.domainstore.ui.view.component.MyContent();
        lbErrEmail = new com.java.domainstore.ui.view.component.MyErr();
        tfEmail = new com.java.domainstore.ui.view.component.MyTextField();
        tfPsID = new com.java.domainstore.ui.view.component.MyTextField();
        lbPsID = new com.java.domainstore.ui.view.component.MyContent();
        lbErrPsID = new com.java.domainstore.ui.view.component.MyErr();
        lbPass = new com.java.domainstore.ui.view.component.MyContent();
        lbErrPass = new com.java.domainstore.ui.view.component.MyErr();
        tfPass = new com.java.domainstore.ui.view.component.MyPasswordField();
        lbConfirmPass = new com.java.domainstore.ui.view.component.MyContent();
        lbErrConfirmPass = new com.java.domainstore.ui.view.component.MyErr();
        tfConfirmPass = new com.java.domainstore.ui.view.component.MyPasswordField();
        cbShow = new com.java.domainstore.ui.view.component.MyCB();
        btConfirm = new com.java.domainstore.ui.view.component.MyButton(Color.WHITE, Color.decode("#40fa40"));
        btCancel = new com.java.domainstore.ui.view.component.MyButton();
        lbApp = new com.java.domainstore.ui.view.component.MyTitle();
        myDescription1 = new com.java.domainstore.ui.view.component.MyDescription();
        pbIMG = new com.java.domainstore.ui.view.container.MyPanel();
        myErr1 = new com.java.domainstore.ui.view.component.MyErr();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        lbTitle.setText("Đăng ký tài khoản");
        lbTitle.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N

        lbName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbName.setText("Họ và tên");

        lbErrName.setText(" ");

        lbPhone.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPhone.setText("Số điện thoại");

        lbErrPhone.setText(" ");

        lbEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbEmail.setText("Email");

        lbErrEmail.setText(" ");

        tfPsID.setForeground(new java.awt.Color(0, 0, 0));

        lbPsID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPsID.setText("SỐ CCCD");

        lbErrPsID.setText(" ");

        lbPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPass.setText("Mật khẩu");

        lbErrPass.setText(" ");

        tfPass.setForeground(new java.awt.Color(0, 0, 0));
        tfPass.setText("");

        lbConfirmPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbConfirmPass.setText("Xác nhận MK");

        lbErrConfirmPass.setText(" ");

        tfConfirmPass.setForeground(new java.awt.Color(0, 0, 0));
        tfConfirmPass.setText("");

        cbShow.setText("show password");
        cbShow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cbShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbShowActionPerformed(evt);
            }
        });

        btConfirm.setText("Xác nhận");
        btConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmActionPerformed(evt);
            }
        });

        btCancel.setText("Hủy");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        lbApp.setForeground(new java.awt.Color(255, 255, 255));
        lbApp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logo48.png"))); // NOI18N
        lbApp.setText("UTC2 Domain Store");

        myDescription1.setText("Mật khẩu có độ dài 8-16 ký tự, bao gồm a - z, A - Z, 0 - 9, @, _, .");

        myErr1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/registerBg.png"))); // NOI18N
        myErr1.setText("");
        myErr1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout pbIMGLayout = new javax.swing.GroupLayout(pbIMG);
        pbIMG.setLayout(pbIMGLayout);
        pbIMGLayout.setHorizontalGroup(
            pbIMGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pbIMGLayout.createSequentialGroup()
                .addComponent(myErr1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pbIMGLayout.setVerticalGroup(
            pbIMGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pbIMGLayout.createSequentialGroup()
                .addComponent(myErr1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnBG1Layout = new javax.swing.GroupLayout(pnBG1);
        pnBG1.setLayout(pnBG1Layout);
        pnBG1Layout.setHorizontalGroup(
            pnBG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBG1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnBG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnBG1Layout.createSequentialGroup()
                        .addGap(0, 30, Short.MAX_VALUE)
                        .addComponent(lbApp, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnBG1Layout.createSequentialGroup()
                        .addComponent(pbIMG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(pnBG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnBG1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(pnBG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnBG1Layout.createSequentialGroup()
                                .addComponent(btCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addComponent(btConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnBG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cbShow, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pnBG1Layout.createSequentialGroup()
                                    .addGroup(pnBG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lbName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbPsID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbConfirmPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(pnBG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tfName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbErrName, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                        .addComponent(lbErrPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                        .addComponent(tfPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbErrEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                        .addComponent(tfEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tfPsID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbErrPsID, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                        .addComponent(lbErrPass, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                        .addComponent(lbErrConfirmPass, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                        .addComponent(tfPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tfConfirmPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(lbTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)))
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(pnBG1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(myDescription1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnBG1Layout.setVerticalGroup(
            pnBG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBG1Layout.createSequentialGroup()
                .addGroup(pnBG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnBG1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbErrName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnBG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbErrPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnBG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbErrEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnBG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbErrPsID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnBG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfPsID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbPsID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbErrPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnBG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbErrConfirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnBG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbConfirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfConfirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(cbShow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnBG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(myDescription1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnBG1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbApp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pbIMG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        fLogin.start();
        this.dispose();
    }//GEN-LAST:event_btCancelActionPerformed

    private void cbShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbShowActionPerformed
        if (cbShow.isSelected()) {
            tfPass.show();
            tfConfirmPass.show();
        } else {
            tfPass.hide();
            tfConfirmPass.hide();
        }
    }//GEN-LAST:event_cbShowActionPerformed

    private void btConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmActionPerformed
        RegisterController gcrtl = new RegisterController();
        List<Integer> errorList = gcrtl.verify(new RegisterModel(tfName.getText(),
                tfPhone.getText(),
                tfEmail.getText(),
                tfPsID.getText(),
                tfPass.getPassword(),
                tfConfirmPass.getPassword()));
        if (errorList.contains(1)) {
            lbErrName.setText("* Thiếu họ va tên");
        } else {
            lbErrName.setText(" ");
        }
        if (errorList.contains(2)) {
            lbErrPhone.setText("* Số điện thoại không hợp lệ");
        } else {
            lbErrPhone.setText(" ");
        }
        if (errorList.contains(3)) {
            lbErrEmail.setText("* Email không hợp lệ");
        } else {
            lbErrEmail.setText(" ");
        }
        if (errorList.contains(4)) {
            lbErrPsID.setText("* Số CCCD không hợp lệ");
        } else {
            lbErrPsID.setText(" ");
        }
        if (errorList.contains(5)) {
            lbErrPass.setText("* Mật khẩu không hợp lệ");
        } else {
            lbErrPass.setText(" ");
        }
        if (errorList.contains(6)) {
            lbErrConfirmPass.setText("* Xác nhận mật khẩu không trùng khớp");
        } else {
            lbErrConfirmPass.setText(" ");
        }
        if (errorList.isEmpty()){
            lbErrName.setText(" ");
            lbErrPhone.setText(" ");
            lbErrEmail.setText(" ");
            lbErrPsID.setText(" ");
            lbErrPass.setText(" ");
            lbErrConfirmPass.setText(" ");
            JOptionPane.showMessageDialog(null, "Tạo tài khoản mới thành công");
            this.dispose();
            fLogin.start();
        }
        if (errorList.contains(7)){
            lbErrName.setText(" ");
            lbErrPhone.setText(" ");
            lbErrEmail.setText(" ");
            lbErrPsID.setText(" ");
            lbErrPass.setText(" ");
            lbErrConfirmPass.setText(" ");
            JOptionPane.showMessageDialog(null, "Tạo tài khoản mới thất bại, hãy kiểm tra kết nối");
        }
    }//GEN-LAST:event_btConfirmActionPerformed
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
                new fRegister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.java.domainstore.ui.view.component.MyButton btCancel;
    private com.java.domainstore.ui.view.component.MyButton btConfirm;
    private com.java.domainstore.ui.view.component.MyCB cbShow;
    private com.java.domainstore.ui.view.component.MyTitle lbApp;
    private com.java.domainstore.ui.view.component.MyContent lbConfirmPass;
    private com.java.domainstore.ui.view.component.MyContent lbEmail;
    private com.java.domainstore.ui.view.component.MyErr lbErrConfirmPass;
    private com.java.domainstore.ui.view.component.MyErr lbErrEmail;
    private com.java.domainstore.ui.view.component.MyErr lbErrName;
    private com.java.domainstore.ui.view.component.MyErr lbErrPass;
    private com.java.domainstore.ui.view.component.MyErr lbErrPhone;
    private com.java.domainstore.ui.view.component.MyErr lbErrPsID;
    private com.java.domainstore.ui.view.component.MyContent lbName;
    private com.java.domainstore.ui.view.component.MyContent lbPass;
    private com.java.domainstore.ui.view.component.MyContent lbPhone;
    private com.java.domainstore.ui.view.component.MyContent lbPsID;
    private com.java.domainstore.ui.view.component.MyTitle lbTitle;
    private com.java.domainstore.ui.view.component.MyDescription myDescription1;
    private com.java.domainstore.ui.view.component.MyErr myErr1;
    private com.java.domainstore.ui.view.container.MyPanel pbIMG;
    private com.java.domainstore.ui.view.container.pnBG pnBG1;
    private com.java.domainstore.ui.view.component.MyPasswordField tfConfirmPass;
    private com.java.domainstore.ui.view.component.MyTextField tfEmail;
    private com.java.domainstore.ui.view.component.MyTextField tfName;
    private com.java.domainstore.ui.view.component.MyPasswordField tfPass;
    private com.java.domainstore.ui.view.component.MyTextField tfPhone;
    private com.java.domainstore.ui.view.component.MyTextField tfPsID;
    // End of variables declaration//GEN-END:variables
}

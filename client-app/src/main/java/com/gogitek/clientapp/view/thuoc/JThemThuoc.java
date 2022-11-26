/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.gogitek.clientapp.view.thuoc;

import com.gogitek.clientapp.JsonUtils;
import com.gogitek.clientapp.controller.SocketConnection;
import com.gogitek.clientapp.model.CongDung;
import com.gogitek.clientapp.model.dto.ServerResponse;
import com.gogitek.clientapp.service.CongDungService;
import com.gogitek.clientapp.service.CongDungServiceImpl;
import com.gogitek.clientapp.service.ThuocService;
import com.gogitek.clientapp.service.ThuocServiceImpl;
import com.gogitek.clientapp.view.congdung.JCongDung;

import javax.swing.*;
import java.util.*;

public class JThemThuoc extends javax.swing.JFrame {
    private final CongDungService congDungService = new CongDungServiceImpl();
    private final ThuocService thuocService = new ThuocServiceImpl();
    private static final Map<String, Long> congDungEntity = new HashMap<>();

    public JThemThuoc() {
        initComponents();
        init();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void init() {
        List<CongDung> list = new ArrayList<>();
        try {
            list = JsonUtils.stringToArray(congDungService.findListCongDungByKey("").getResult().toString(), CongDung[].class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        for (CongDung congDung : list) {
            congDungName.addItem(congDung.getId() + "");
        }

        List<String> dangThuocList = new ArrayList<>();
        dangThuocList.add("NUOC");
        dangThuocList.add("VIEN");
        dangThuocList.add("BOT");

        for (String c : dangThuocList) {
            dangThuoc.addItem(c + "");
        }

    }

    private void initComponents() {

        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        jLabelDangThuoc = new javax.swing.JLabel();
        inputMaThuoc = new javax.swing.JTextField();
        inputTenThuoc = new javax.swing.JTextField();
        inputGiaThuoc = new javax.swing.JTextField();
        // Variables declaration - do not modify//GEN-BEGIN:variables
        javax.swing.JButton btnAdd = new javax.swing.JButton();
        javax.swing.JButton btnBack = new javax.swing.JButton();
        javax.swing.JLabel jLabel7 = new javax.swing.JLabel();
        congDungName = new javax.swing.JComboBox<>();
        dangThuoc = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("THÊM THUỐC");

        jLabel2.setText("Mã thuốc:");

        jLabel3.setText("Tên Thuốc:");

        jLabel5.setText("Giá Thuốc:");

        jLabelDangThuoc.setText("Dạng Thuốc");

        inputTenThuoc.addActionListener(this::inputTenThuocActionPerformed);

        btnAdd.setText("Thêm");
        btnAdd.addActionListener(this::btnAddActionPerformed);

        btnBack.setText("Trở về");
        btnBack.addActionListener(this::btnBackActionPerformed);

        jLabel7.setText("Công Dụng");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(142, 142, 142)
                                                .addComponent(jLabel1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(88, 88, 88)
                                                .addComponent(btnAdd)
                                                .addGap(68, 68, 68)
                                                .addComponent(btnBack)))
                                .addContainerGap(94, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                .addComponent(jLabelDangThuoc)
                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                .addGap(46, 46, 46))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(84, 84, 84)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(inputMaThuoc)
                                        .addComponent(inputTenThuoc)
                                        .addComponent(inputGiaThuoc)
                                        .addComponent(congDungName, 0, 189, Short.MAX_VALUE)
                                        .addComponent(dangThuoc, 0, 189, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel1)
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(inputMaThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(inputTenThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(inputGiaThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelDangThuoc)
                                        .addComponent(dangThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(congDungName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnAdd)
                                        .addComponent(btnBack))
                                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputTenThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputTenThuocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputTenThuocActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String maThuoc = inputMaThuoc.getText();
        String tenThuoc = inputTenThuoc.getText();
        if (maThuoc.length() <= 15 && maThuoc.matches("\\w+")) {
            if (tenThuoc.length() <= 50) {
                Double giaDat = null;
                try {
                    giaDat = Double.parseDouble(inputGiaThuoc.getText());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Giá món ăn phải là dạng số");
                    inputGiaThuoc.requestFocus();
                }


                String dangThuocRes = null;
                try {
                    dangThuocRes = Objects.requireNonNull(dangThuoc.getSelectedItem()).toString();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Công dụng không hợp lệ");
                    dangThuoc.requestFocus();
                }


                Long congDung = null;
                try {
                    congDung = Long.parseLong(Objects.requireNonNull(congDungName.getSelectedItem()).toString());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Công dụng không hợp lệ");
                    congDungName.requestFocus();
                }
                SocketConnection socketConnection = thuocService.updateThuoc(null, maThuoc, dangThuocRes, giaDat, tenThuoc, congDung);
                try {
                    JOptionPane.showMessageDialog(this, "Thêm thông tin Thuốc thành công!");
                    setVisible(false);
                    new JThuoc().setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                socketConnection.closeConnection();
            } else {
                JOptionPane.showMessageDialog(this, "Tên món ăn không đúng kích thước hoặc chứa ký tự đặc biệt");
                inputTenThuoc.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Mã món ăn không đúng kích thước hoặc chứa ký tự đặc biệt");
            inputMaThuoc.requestFocus();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        setVisible(false);
        new JThuoc().setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        new JThuoc().setVisible(true);
    }//GEN-LAST:event_formWindowClosed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JThemThuoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new JThemThuoc().setVisible(true));
    }

    private javax.swing.JComboBox<String> congDungName;
    private javax.swing.JComboBox<String> dangThuoc;
    private javax.swing.JLabel jLabelDangThuoc;
    private javax.swing.JTextField inputGiaThuoc;
    private javax.swing.JTextField inputMaThuoc;
    private javax.swing.JTextField inputTenThuoc;
    // End of variables declaration//GEN-END:variables
}

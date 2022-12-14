/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.gogitek.clientapp.view.thuoc;

import com.gogitek.clientapp.JsonUtils;
import com.gogitek.clientapp.controller.SocketConnection;
import com.gogitek.clientapp.model.CongDung;
import com.gogitek.clientapp.model.Thuoc;
import com.gogitek.clientapp.model.dto.ServerResponse;
import com.gogitek.clientapp.service.ThuocService;
import com.gogitek.clientapp.service.ThuocServiceImpl;
import com.gogitek.clientapp.view.congdung.JCongDung;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JEditThuoc extends javax.swing.JFrame {

    private final ThuocService thuocService = new ThuocServiceImpl();
    public JEditThuoc(){
    }

    public JEditThuoc(Thuoc thuoc) {
        initComponents();
        init(thuoc);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void init(Thuoc thuoc) {
        inputID.setText(thuoc.getId() + "");
        inputMaThuoc.setText(thuoc.getMaThuoc());
        inputTenThuoc.setText(thuoc.getTenThuoc());
        inputCongDung.setSelectedItem(thuoc.getCongDungId());
        inputGia.setText(thuoc.getGiaThuoc() + "");
        inputDangThuoc.setSelectedItem(thuoc.getDangThuoc());
        List<Thuoc> list = new ArrayList<>();
        try {
            list = JsonUtils.stringToArray(thuocService.findListThuocByKey(null).getResult().toString(), Thuoc[].class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        for (int i = 0; i < list.size(); i++) {
            inputCongDung.addItem(list.get(i).getId() + "");
            if (Objects.equals(list.get(i).getId(), thuoc.getCongDungId())) {
                inputCongDung.setSelectedIndex(i);
            }
        }

        List<String> dangThuocList = new ArrayList<>();
        dangThuocList.add("NUOC");
        dangThuocList.add("VIEN");
        dangThuocList.add("BOT");

        for(String c : dangThuocList){
            inputDangThuoc.addItem(c + "");
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        inputID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        inputMaThuoc = new javax.swing.JTextField();
        inputTenThuoc = new javax.swing.JTextField();
        inputGia = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        inputCongDung = new javax.swing.JComboBox<>();
        inputDangThuoc = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        inputID.setEditable(false);

        jLabel5.setText("Gi?? Thu???c:");

        btnDelete.setText("X??a");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel6.setText("D???ng Thu???c");

        jLabel8.setText("C??ng D???ng");

        inputTenThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputTenThuocActionPerformed(evt);
            }
        });

        jLabel1.setText("S???A TH??NG TIN THU???C");

        btnUpdate.setText("L??u");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel2.setText("M?? Thu???c:");

        btnCancel.setText("Tr??? v???");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel3.setText("T??n Thu???c:");

        jLabel7.setText("ID:");

        inputCongDung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputCongDungActionPerformed(evt);
            }
        });

        inputDangThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputDangThuocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(53, 53, 53)
                            .addComponent(btnUpdate)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(83, 83, 83)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(inputGia)
                    .addComponent(inputID, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addComponent(btnCancel)
                        .addGap(11, 11, 11))
                    .addComponent(inputCongDung, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputMaThuoc, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputTenThuoc, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputDangThuoc, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(inputID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(inputMaThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(inputTenThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(inputGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(inputDangThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(inputCongDung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnCancel))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        Long id = Long.valueOf(inputID.getText());
        int i = JOptionPane.showConfirmDialog(this, "B???n ch???c ch???n mu???n x??a id " + id + " kh??ng?", "DELETE MON AN", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            try {
                thuocService.deleteThuocById(id);
                JOptionPane.showMessageDialog(this, "X??a th??nh c??ng!");
                setVisible(false);
                new JThuoc().setVisible(true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void inputTenThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputTenThuocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputTenThuocActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String maThuoc = inputMaThuoc.getText();
        String tenThuoc = inputTenThuoc.getText();
        Long id = Long.parseLong(inputID.getText());
        if (maThuoc.length() <= 15 && maThuoc.matches("\\w+")) {
            if (tenThuoc.length() <= 50) {
                Double giaDat = null;
                try {
                    giaDat = Double.parseDouble(inputGia.getText());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Gi?? thu???c ph???i l?? d???ng s???");
                    inputGia.requestFocus();
                }

                String dangThuoc = Objects.requireNonNull(inputDangThuoc.getSelectedItem()).toString();

                Long congDung = null;
                try {
                    congDung = Long.parseLong(Objects.requireNonNull(inputCongDung.getSelectedItem()).toString());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "C??ng d???ng kh??ng h???p l???");
                    inputDangThuoc.requestFocus();
                }
                SocketConnection socketConnection = thuocService.updateThuoc(id, maThuoc, dangThuoc, giaDat, tenThuoc, congDung);

                try {
                    JOptionPane.showMessageDialog(this, "S???a th??ng tin Thu???c th??nh c??ng!");
                    setVisible(false);
                    new JThuoc().setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                socketConnection.closeConnection();
            } else {
                JOptionPane.showMessageDialog(this, "T??n thu???c kh??ng ????ng k??ch th?????c ho???c ch???a k?? t??? ?????c bi???t");
                inputTenThuoc.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(this, "M?? thu???c kh??ng ????ng k??ch th?????c ho???c ch???a k?? t??? ?????c bi???t");
            inputMaThuoc.requestFocus();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new JThuoc().setVisible(true);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        new JThuoc().setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void inputCongDungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputCongDungActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputCongDungActionPerformed

    private void inputDangThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputDangThuocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputDangThuocActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JEditThuoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JEditThuoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JEditThuoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JEditThuoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new JEditThuoc().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> inputCongDung;
    private javax.swing.JComboBox<String> inputDangThuoc;
    private javax.swing.JTextField inputGia;
    private javax.swing.JTextField inputID;
    private javax.swing.JTextField inputMaThuoc;
    private javax.swing.JTextField inputTenThuoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.example;

import org.example.blockchain.Block;
import org.example.controller.TransactionController;
import org.example.model.transaction.CampaignStatementTransactionData;

import javax.swing.*;

/**
 *
 * @author Pc
 */
public class Statement extends javax.swing.JFrame {

    private Block currentBlock;

    private CampaignStatementTransactionData statementTransactionData;

    /**
     * Creates new form Statement
     */
    public Statement() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cashAndCashEquivalentLabel = new javax.swing.JLabel();
        prepaidExpensesLabel = new javax.swing.JLabel();
        unconditionalPromisesToGiveLabel = new javax.swing.JLabel();
        equipmentLabel = new javax.swing.JLabel();
        cashAndCashEquivalentsField = new javax.swing.JTextField();
        prepaidExpensesField = new javax.swing.JTextField();
        unconditionalPromisesToGiveField = new javax.swing.JTextField();
        equipmentField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        compensationField = new javax.swing.JTextField();
        refundableAdvancesField = new javax.swing.JTextField();
        debtsField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        unrestrictedFIeld = new javax.swing.JTextField();
        temporaryRestrictedField = new javax.swing.JTextField();
        permanentlyRestrictedField = new javax.swing.JTextField();
        totalNetAssetsField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        totalAssetsField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        totalLiabilitiesField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        totalNetAssetsAndLiabilitiesField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        totalDonationCollectedAmountField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        finalBalanceField = new javax.swing.JTextField();
        generateButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        calculateButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Final Statement");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Assets");

        cashAndCashEquivalentLabel.setText("Cash and Cash Equivalents");

        prepaidExpensesLabel.setText("Prepaid Expenses");

        unconditionalPromisesToGiveLabel.setText("Unconditional Promises to Give");

        equipmentLabel.setText("Equipment");

        cashAndCashEquivalentsField.setText("0");

        prepaidExpensesField.setText("0");

        unconditionalPromisesToGiveField.setText("0");

        equipmentField.setText("0");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Liabilities");

        jLabel4.setText("Compensation");

        jLabel5.setText("Refundable Advances");

        jLabel6.setText("Debts");

        compensationField.setText("0");

        refundableAdvancesField.setText("0");

        debtsField.setText("0");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setText("Net Assets");

        jLabel8.setText("Unrestricted");

        jLabel9.setText("Temporary Restricted");

        jLabel10.setText("Permanently Restricted");

        unrestrictedFIeld.setText("0");

        temporaryRestrictedField.setText("0");

        permanentlyRestrictedField.setText("0");
        permanentlyRestrictedField.setToolTipText("");

        totalNetAssetsField.setEditable(false);
        totalNetAssetsField.setText("0");
        totalNetAssetsField.setToolTipText("");

        jLabel11.setText("Total Net Assets");

        totalAssetsField.setEditable(false);
        totalAssetsField.setText("0");

        jLabel12.setText("Total Assets");

        totalLiabilitiesField.setEditable(false);
        totalLiabilitiesField.setText("0");

        jLabel13.setText("Total Liabilities");

        jLabel14.setText("Total Net Assets and Liabilities");

        totalNetAssetsAndLiabilitiesField.setEditable(false);
        totalNetAssetsAndLiabilitiesField.setText("0");
        totalNetAssetsAndLiabilitiesField.setToolTipText("");

        jLabel15.setText("Total Donation Collected Amount");

        totalDonationCollectedAmountField.setEditable(false);
        totalDonationCollectedAmountField.setText("0");

        jLabel16.setText("Final Balance");

        finalBalanceField.setEditable(false);
        finalBalanceField.setText("0");

        generateButton.setText("Generate");
        generateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        calculateButton.setText("Calculate");
        calculateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateButtonActionPerformed(evt);
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
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cashAndCashEquivalentLabel)
                                            .addComponent(prepaidExpensesLabel)
                                            .addComponent(unconditionalPromisesToGiveLabel)
                                            .addComponent(equipmentLabel)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10))
                                        .addGap(123, 123, 123))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel12))
                                        .addGap(24, 24, 24))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel16))
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cashAndCashEquivalentsField, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                        .addComponent(prepaidExpensesField)
                                        .addComponent(unconditionalPromisesToGiveField)
                                        .addComponent(equipmentField)
                                        .addComponent(compensationField)
                                        .addComponent(refundableAdvancesField)
                                        .addComponent(debtsField)
                                        .addComponent(unrestrictedFIeld)
                                        .addComponent(temporaryRestrictedField)
                                        .addComponent(permanentlyRestrictedField))
                                    .addComponent(totalAssetsField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(totalLiabilitiesField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(finalBalanceField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                        .addComponent(totalDonationCollectedAmountField, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(totalNetAssetsAndLiabilitiesField, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(totalNetAssetsField, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(generateButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(calculateButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cancelButton)))))))
                .addContainerGap(296, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cashAndCashEquivalentLabel)
                    .addComponent(cashAndCashEquivalentsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(prepaidExpensesLabel)
                    .addComponent(prepaidExpensesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(unconditionalPromisesToGiveLabel)
                    .addComponent(unconditionalPromisesToGiveField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(equipmentLabel)
                    .addComponent(equipmentField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalAssetsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(compensationField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(refundableAdvancesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(debtsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalLiabilitiesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(13, 13, 13)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(unrestrictedFIeld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(temporaryRestrictedField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(permanentlyRestrictedField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalNetAssetsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(totalNetAssetsAndLiabilitiesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(totalDonationCollectedAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(finalBalanceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(generateButton)
                    .addComponent(calculateButton)
                    .addComponent(cancelButton))
                .addContainerGap(87, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateButtonActionPerformed
        // TODO add your handling code here:

        TransactionController.generateStatement(Main.currentUser, currentBlock, statementTransactionData);
        JOptionPane.showMessageDialog(null, "Campaign Id: " + currentBlock.getHeader().getCampaignId() + " statement generated");

        generateButton.setEnabled(false);

        this.setVisible(false);
        Main.organizerViewCampaign.setVisible(true);
        Main.organizerViewCampaign.loadData(currentBlock);
    }//GEN-LAST:event_generateButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:

        this.setVisible(false);
        Main.organizerViewCampaign.setVisible(true);
        Main.organizerViewCampaign.loadData(currentBlock);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void calculateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateButtonActionPerformed
        // TODO add your handling code here:

        try{
            Double cash = Double.parseDouble(cashAndCashEquivalentsField.getText());
            Double prepaid = Double.parseDouble(prepaidExpensesField.getText());
            Double promise = Double.parseDouble(unconditionalPromisesToGiveField.getText());
            Double equipment = Double.parseDouble(equipmentField.getText());

            Double totalAsset = cash+prepaid+promise+equipment;
            totalAssetsField.setText(totalAsset.toString());

            Double compensation = Double.parseDouble(compensationField.getText());
            Double refundable = Double.parseDouble(refundableAdvancesField.getText());
            Double debts = Double.parseDouble(debtsField.getText());

            Double totalLiabilities = compensation+refundable+debts;
            totalLiabilitiesField.setText(totalLiabilities.toString());

            Double unrestricted = Double.parseDouble(unrestrictedFIeld.getText());
            Double temp = Double.parseDouble(temporaryRestrictedField.getText());
            Double permanently = Double.parseDouble(permanentlyRestrictedField.getText());

            Double totalNetAssets = unrestricted+temp+permanently;
            totalNetAssetsField.setText(totalNetAssets.toString());

            Double totalNetAssetsAndLiabilities = totalNetAssets+totalLiabilities;
            totalNetAssetsAndLiabilitiesField.setText(String.valueOf(totalNetAssetsAndLiabilities));

            Double finalBalance = currentBlock.getTotalCollectedAmount()-totalNetAssetsAndLiabilities-totalAsset;
            finalBalanceField.setText(String.valueOf(finalBalance));

            statementTransactionData = CampaignStatementTransactionData.builder()
                    .campaignId(currentBlock.getHeader().getCampaignId())
                    .totalAsset(totalAsset)
                    .totalLiabilities(totalLiabilities)
                    .totalNetAssets(totalNetAssets)
                    .totalNetAssetsAndLiabilities(totalNetAssetsAndLiabilities)
                    .totalDonationCollectionAmount(currentBlock.getTotalCollectedAmount())
                    .finalBalance(finalBalance)
                    .build();

        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_calculateButtonActionPerformed

    public void loadData(Block block){
        this.currentBlock = block;
        totalDonationCollectedAmountField.setText(String.valueOf(currentBlock.getTotalCollectedAmount()));
    }

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
            java.util.logging.Logger.getLogger(Statement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Statement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Statement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Statement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Statement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton calculateButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel cashAndCashEquivalentLabel;
    private javax.swing.JTextField cashAndCashEquivalentsField;
    private javax.swing.JTextField compensationField;
    private javax.swing.JTextField debtsField;
    private javax.swing.JTextField equipmentField;
    private javax.swing.JLabel equipmentLabel;
    private javax.swing.JTextField finalBalanceField;
    private javax.swing.JButton generateButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField permanentlyRestrictedField;
    private javax.swing.JTextField prepaidExpensesField;
    private javax.swing.JLabel prepaidExpensesLabel;
    private javax.swing.JTextField refundableAdvancesField;
    private javax.swing.JTextField temporaryRestrictedField;
    private javax.swing.JTextField totalAssetsField;
    private javax.swing.JTextField totalDonationCollectedAmountField;
    private javax.swing.JTextField totalLiabilitiesField;
    private javax.swing.JTextField totalNetAssetsAndLiabilitiesField;
    private javax.swing.JTextField totalNetAssetsField;
    private javax.swing.JTextField unconditionalPromisesToGiveField;
    private javax.swing.JLabel unconditionalPromisesToGiveLabel;
    private javax.swing.JTextField unrestrictedFIeld;
    // End of variables declaration//GEN-END:variables
}

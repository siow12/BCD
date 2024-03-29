/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.example;

import org.example.blockchain.Block;
import org.example.blockchain.Blockchain;
import org.example.blockchain.Transaction;
import org.example.controller.TransactionController;
import org.example.controller.UserController;
import org.example.cryptography.SignatureService;
import org.example.model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pc
 */
public class OrganizerAddCampaign extends javax.swing.JFrame {


    /**
     * Creates new form Campaign
     */
    public OrganizerAddCampaign() {
        initComponents();
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
                organizerNameField.setText(Main.currentUser.getUserName());
                List<String> beneficiaryName = UserController.findAllBeneficairy()
                        .stream().map(User::getUserName).toList();
                beneficiaryName.forEach(b->beneficiaryList.addItem(b));
            }

            @Override
            public void componentHidden(ComponentEvent e) {
                super.componentHidden(e);
            }
        });
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
        organizerNameLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        startDateLabel = new javax.swing.JLabel();
        organizerNameField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        desLabel = new javax.swing.JLabel();
        endDateLabel = new javax.swing.JLabel();
        campaignNameLabel = new javax.swing.JLabel();
        campaignNameField = new javax.swing.JTextField();
        startDateChooser = new com.toedter.calendar.JDateChooser();
        endDateChooser = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        desTextArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        addressTextArea = new javax.swing.JTextArea();
        beneficiaryLabel = new javax.swing.JLabel();
        beneficiaryList = new javax.swing.JComboBox<>();
        expectedAmountLabel = new javax.swing.JLabel();
        expectedAmountField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Campaign");

        organizerNameLabel.setText("Organizer Name:");

        addressLabel.setText("Address:");

        startDateLabel.setText("Start Date:");

        organizerNameField.setEditable(false);

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        desLabel.setText("Description:");

        endDateLabel.setText("End Date:");

        campaignNameLabel.setText("Campaign Name:");

        desTextArea.setColumns(20);
        desTextArea.setRows(5);
        jScrollPane1.setViewportView(desTextArea);

        addressTextArea.setColumns(20);
        addressTextArea.setRows(5);
        jScrollPane2.setViewportView(addressTextArea);

        beneficiaryLabel.setText("Beneficiary");

        expectedAmountLabel.setText("Expected Amount:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(desLabel))
                            .addComponent(addressLabel)
                            .addComponent(campaignNameLabel)
                            .addComponent(organizerNameLabel)
                            .addComponent(beneficiaryLabel)
                            .addComponent(expectedAmountLabel)
                            .addComponent(startDateLabel)
                            .addComponent(endDateLabel)
                            .addComponent(addButton))
                        .addGap(74, 74, 74)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(beneficiaryList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(organizerNameField)
                                .addComponent(campaignNameField)
                                .addComponent(jScrollPane1)
                                .addComponent(jScrollPane2)
                                .addComponent(expectedAmountField)
                                .addComponent(endDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(startDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(cancelButton))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(organizerNameLabel)
                                            .addComponent(organizerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(desLabel)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(campaignNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(campaignNameLabel))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(addressLabel))
                                        .addGap(18, 18, 18)
                                        .addComponent(beneficiaryList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(beneficiaryLabel))
                                .addGap(18, 18, 18)
                                .addComponent(expectedAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(expectedAmountLabel))
                        .addGap(18, 18, 18)
                        .addComponent(startDateLabel))
                    .addComponent(startDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(endDateLabel)
                    .addComponent(endDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(cancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        organizerNameLabel.getAccessibleContext().setAccessibleName("organizerNameLabel");
        addressLabel.getAccessibleContext().setAccessibleName("addressLabel");
        startDateLabel.getAccessibleContext().setAccessibleName("startDateLabel");
        organizerNameField.getAccessibleContext().setAccessibleName("organizerNameField");
        addButton.getAccessibleContext().setAccessibleName("addButton");
        cancelButton.getAccessibleContext().setAccessibleName("cancelButton");
        desLabel.getAccessibleContext().setAccessibleName("desLabel");
        endDateLabel.getAccessibleContext().setAccessibleName("endDateLabel");
        campaignNameLabel.getAccessibleContext().setAccessibleName("campaignNameLabel");
        campaignNameField.getAccessibleContext().setAccessibleName("campaignNameField");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        try{
            String description = desTextArea.getText();
            String name = campaignNameField.getText();
            String address = addressTextArea.getText();
            String beneficiary = (String)beneficiaryList.getSelectedItem();
            Double expectedAmount = Double.parseDouble(expectedAmountField.getText());
            long startDate = startDateChooser.getDate().getTime();
            long endDate = endDateChooser.getDate().getTime();

            if(
                    description.isEmpty()
                    || name.isEmpty()
                    || address.isEmpty()
                    || (beneficiary == null || beneficiary.isEmpty())
                    || startDate == 0
                    || endDate == 0

            ){
                JOptionPane.showMessageDialog(null, "Incomplete input!!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Blockchain.getBlocks();//Load genesis block;
            Block latestBlock = DBSingleton.getDb(Block.class).getEntityStore().getLast();
            Block.Header latestHeader = latestBlock.getHeader();
            Transaction initialTransaction = Transaction.builder()
                    .transactionId(TransactionController.getNewTransactionId(latestBlock))
                    .from(Main.currentUser.getUserName())
                    .to(null)
                    .timestamp(
                            Instant.now().toEpochMilli())
                    .build();

            initialTransaction.setSignature(SignatureService.sign(initialTransaction.toString(),Main.currentUser.getUserName()));
            Block block = new Block(latestHeader.getIndex() + 1,
                    latestHeader.getCurrentHash(),
                    latestHeader.getCampaignId() + 1,
                    name,
                    description,
                    address,
                    Main.currentUser.getUserName(),
                    beneficiary,
                    expectedAmount,
                    startDate,
                    endDate,
                    new ArrayList<>(List.of(initialTransaction)));

            Blockchain.newBlock(block);
            JOptionPane.showMessageDialog(null, "Campaign " + block.getHeader().getCampaignId() + " added!!");

        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Invalid amount!!", "Error", JOptionPane.ERROR_MESSAGE);
        }


        this.setVisible(false);
        Main.organizerHomePage.setVisible(true);
    }//GEN-LAST:event_addButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Main.organizerHomePage.setVisible(true);
    }//GEN-LAST:event_cancelButtonActionPerformed

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
            java.util.logging.Logger.getLogger(OrganizerAddCampaign.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrganizerAddCampaign.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrganizerAddCampaign.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrganizerAddCampaign.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrganizerAddCampaign().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextArea addressTextArea;
    private javax.swing.JLabel beneficiaryLabel;
    private javax.swing.JComboBox<String> beneficiaryList;
    private javax.swing.JTextField campaignNameField;
    private javax.swing.JLabel campaignNameLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel desLabel;
    private javax.swing.JTextArea desTextArea;
    private com.toedter.calendar.JDateChooser endDateChooser;
    private javax.swing.JLabel endDateLabel;
    private javax.swing.JTextField expectedAmountField;
    private javax.swing.JLabel expectedAmountLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField organizerNameField;
    private javax.swing.JLabel organizerNameLabel;
    private com.toedter.calendar.JDateChooser startDateChooser;
    private javax.swing.JLabel startDateLabel;
    // End of variables declaration//GEN-END:variables
}

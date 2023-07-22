package com.views;

import static com.app.App.ShowJPanel;
import com.app.DAOAccountsImpl;
import com.exceptions.Exceptions;
import com.exceptions.Minimum;
import com.interfaces.DAOAccounts;
import com.models.Account;

public class DepositWithdraw extends javax.swing.JPanel {
    Account account1 = new Account();
    int id;
    float balance;
    String username, password;
    public DepositWithdraw(String action, Account account) {
        initComponents();
        account1 = account;
        if(action.equals("Withdraw")){
            actionBtn.setText("Withdraw");
        } else{
            actionBtn.setText("Deposit");
        }
        balance = account1.getBalance();
        username = account1.getUsername();
        password = account1.getPassword();       
        id = account1.getId();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        amountInput = new javax.swing.JTextField();
        actionBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        cancel = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(390, 55));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(325, 55));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Amount:");

        amountInput.setBackground(new java.awt.Color(255, 255, 255));
        amountInput.setForeground(new java.awt.Color(204, 204, 204));
        amountInput.setBorder(null);
        amountInput.setPreferredSize(new java.awt.Dimension(60, 15));

        actionBtn.setBackground(new java.awt.Color(9, 0, 53));
        actionBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        actionBtn.setForeground(new java.awt.Color(255, 255, 255));
        actionBtn.setText("Withdraw");
        actionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionBtnActionPerformed(evt);
            }
        });

        jSeparator1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSeparator1.setPreferredSize(new java.awt.Dimension(60, 10));

        cancel.setBackground(new java.awt.Color(255, 255, 255));
        cancel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cancel.setForeground(new java.awt.Color(9, 0, 53));
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
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
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(amountInput, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(actionBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(amountInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(actionBtn)
                    .addComponent(cancel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void actionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionBtnActionPerformed
        Account account = new Account();
        try{
            float amount = Float.parseFloat(amountInput.getText());
            DAOAccounts DAO = new DAOAccountsImpl();
            if(actionBtn.getText().equals("Withdraw")){
                balance = balance - amount;
                if(balance < 0) throw new Exceptions("Error");
                    account = DAO.Deposit_Withdraw(id, "Withdraw", amount); 
            } else {
                account = DAO.Deposit_Withdraw(id, "Deposit", amount);
            }
            ShowJPanel(new Dashboard(account));
        } catch (Exceptions e){
            javax.swing.JOptionPane.showMessageDialog(this, "You don't have enough funds.\n", "ERROR", javax.swing.JOptionPane.OK_OPTION);
        } catch (Exception exc){
            javax.swing.JOptionPane.showMessageDialog(this, "You need to enter an amount of money.\n", "ERROR", javax.swing.JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_actionBtnActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        ShowJPanel(new Dashboard(account1));
    }//GEN-LAST:event_cancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actionBtn;
    private javax.swing.JTextField amountInput;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sportsrental;

/**
 *
 *@author Alex & Anna
 */
public class purchasesInfo extends javax.swing.JFrame {
    // Get values from text fields and store them in global variables
        private int customerID;
        private int stockID;
        private sportsRentalDB rentalDB;
        private boolean available;
        private boolean stockAvailability;
        private double priceOfItem;
    /**
     * Creates new form purchasesInfo
     */
    public purchasesInfo() {
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

        popupMenu1 = new java.awt.PopupMenu();
        lblCustomerID = new javax.swing.JLabel();
        txtCustomerID = new javax.swing.JTextField();
        lblStockID = new javax.swing.JLabel();
        txtstockID = new javax.swing.JTextField();
        lblPrice = new javax.swing.JLabel();
        btnCheckPriceandStock = new javax.swing.JButton();
        lblMessage = new javax.swing.JLabel();
        lblFullPrice = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnBuy = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblProductStatus = new javax.swing.JLabel();
        btnReturns = new javax.swing.JButton();

        popupMenu1.setLabel("popupMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblCustomerID.setText("Customer ID:");

        txtCustomerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerIDActionPerformed(evt);
            }
        });

        lblStockID.setText("Stock ID:");

        txtstockID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstockIDActionPerformed(evt);
            }
        });

        lblPrice.setText("Price:");

        btnCheckPriceandStock.setBackground(new java.awt.Color(0, 102, 204));
        btnCheckPriceandStock.setForeground(new java.awt.Color(255, 255, 255));
        btnCheckPriceandStock.setText("Check Price and Stock");
        btnCheckPriceandStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckPriceandStockActionPerformed(evt);
            }
        });

        lblMessage.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblMessage.setForeground(new java.awt.Color(255, 0, 0));

        lblFullPrice.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        btnBack.setBackground(new java.awt.Color(0, 0, 0));
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnBuy.setBackground(new java.awt.Color(51, 153, 0));
        btnBuy.setForeground(new java.awt.Color(255, 255, 255));
        btnBuy.setText("Buy");
        btnBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuyActionPerformed(evt);
            }
        });

        jLabel1.setText("Status:");

        lblProductStatus.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        btnReturns.setBackground(new java.awt.Color(153, 0, 153));
        btnReturns.setForeground(new java.awt.Color(255, 255, 255));
        btnReturns.setText("Return Purchses");
        btnReturns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBack)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnReturns)
                                .addGap(104, 104, 104))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblCustomerID)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(90, 90, 90)
                                        .addComponent(lblStockID))
                                    .addComponent(btnCheckPriceandStock))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnBuy)
                                    .addComponent(txtstockID, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFullPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblProductStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCustomerID)
                    .addComponent(txtstockID, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStockID))
                .addGap(29, 29, 29)
                .addComponent(btnCheckPriceandStock, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblProductStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPrice)
                    .addComponent(lblFullPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnBuy)
                    .addComponent(btnReturns))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtstockIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstockIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstockIDActionPerformed

    private void btnBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuyActionPerformed
        //if global boolean variable is true
        if(available){
           int id = 0;
           rentalDB = new sportsRentalDB();
           //Add purchase to the database and get the purchase ID
           id = rentalDB.addPurchase(customerID, stockID, priceOfItem); 
           lblMessage.setText("Your Purchased ID is: " + id + ", You have 30 Days to Return");
       }
       else{
           lblMessage.setText("Unavailable, Please Check price & stock button first");
       }
    }//GEN-LAST:event_btnBuyActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
            this.dispose();
            login  lpage = new login();
            lpage.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnCheckPriceandStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckPriceandStockActionPerformed
        String customerIDText = txtCustomerID.getText().trim();
        String stockIDText = txtstockID.getText().trim();
         
         //Check if any of the fields are empty
        if (customerIDText.isEmpty() || stockIDText.isEmpty() ) {
            lblMessage.setText("Please fill in all fields.");
            return;
        }
        try {
                    //Convert the values to integers
                    customerID = Integer.parseInt(customerIDText);
                    stockID = Integer.parseInt(stockIDText);
                    
                     rentalDB = new sportsRentalDB();
                     
                     //Get the first name of the customer associated with the customer ID
                     String firstName = rentalDB.getCustomerFirstName(customerID);
                     //Check if the stock is available
                     stockAvailability = rentalDB.checkStockExists(stockID);
                     if(firstName==null)
                     {
                         lblMessage.setText("Invalid customer ID.");
                     }
                     //If stock is available
                     if(stockAvailability){
                          if (firstName == null) {
                             //If customer ID is invalid, display an error message and update availability status
                            lblMessage.setText("Invalid customer ID.");
                            lblProductStatus.setText("Unavailable");
                            lblFullPrice.setText("");
                            available = false;
                        } else {
                            
                            lblMessage.setText("Welcome Back " + firstName+"!");
                            lblProductStatus.setText("Available");
                            available = true;
                            priceOfItem = rentalDB.getEquipmentPrice(stockID);
                            lblFullPrice.setText("€ " +Double.toString(priceOfItem));
                            }
                     }
                     else{
                         lblProductStatus.setText("Stock Unavailable");
                         lblMessage.setText("");
                         lblFullPrice.setText("");
                     }
                      

            } catch (NumberFormatException e) {
        // Handle NumberFormatException if parsing fails
        lblMessage.setText("Please enter valid numbers for Customer ID and Stock ID.");
    }
    }//GEN-LAST:event_btnCheckPriceandStockActionPerformed

    private void txtCustomerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustomerIDActionPerformed

    private void btnReturnsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnsActionPerformed
            this.dispose();
            purchaseReturns  preturns = new purchaseReturns();
            preturns.setVisible(true);
    }//GEN-LAST:event_btnReturnsActionPerformed

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
            java.util.logging.Logger.getLogger(purchasesInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(purchasesInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(purchasesInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(purchasesInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new purchasesInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBuy;
    private javax.swing.JButton btnCheckPriceandStock;
    private javax.swing.JButton btnReturns;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCustomerID;
    private javax.swing.JLabel lblFullPrice;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblProductStatus;
    private javax.swing.JLabel lblStockID;
    private java.awt.PopupMenu popupMenu1;
    private javax.swing.JTextField txtCustomerID;
    private javax.swing.JTextField txtstockID;
    // End of variables declaration//GEN-END:variables
}

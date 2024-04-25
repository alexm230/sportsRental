/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package sportsrental;

import java.util.Map;

/**
 *
 *@author Alex & Anna
 */
public class viewStock extends javax.swing.JFrame {

    /** Creates new form viewStock */
    public viewStock() {
        initComponents();
        populateStockTable();
    }
     private void populateStockTable() {
        sportsRentalDB dbHelper = new sportsRentalDB();
        Map<Integer, Map<String, Object>> stockDictionary = dbHelper.getAllStock();

        //Get the table model
        javax.swing.table.DefaultTableModel stockTableM = (javax.swing.table.DefaultTableModel) tblStock.getModel();

        //Clear existing rows
        stockTableM.setRowCount(0);

        //Iterate through the stock dictionary and add rows to the table
        for (Map.Entry<Integer, Map<String, Object>> entry : stockDictionary.entrySet()) {
            Map<String, Object> stockInfo = entry.getValue();
            stockTableM.addRow(new Object[]{
                //Extract all info
                entry.getKey(), // Stock ID
                stockInfo.get("equipmentName"), //Equipment Name
                stockInfo.get("equipmentAge"), //Equipment Age
                stockInfo.get("equipmentQuality"), //Equipment Quality
                stockInfo.get("equipmentPrice"), //Equipment Price
                stockInfo.get("rentPricePerDay") //Rent Price per Day
            });
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tblScrollStock = new javax.swing.JScrollPane();
        tblStock = new javax.swing.JTable();
        btnRemoveStock = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblStock.setBackground(new java.awt.Color(153, 153, 153));
        tblStock.setForeground(new java.awt.Color(0, 0, 0));
        tblStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Stock ID", "Equipment Name", "Equipment Age (Year/s)", "Equipment Quality", "Equipment Price", "Rent Price per Day"
            }
        ));
        tblScrollStock.setViewportView(tblStock);

        btnRemoveStock.setBackground(new java.awt.Color(102, 0, 102));
        btnRemoveStock.setForeground(new java.awt.Color(255, 255, 255));
        btnRemoveStock.setText("Remove Stock");
        btnRemoveStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveStockActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(0, 0, 0));
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("Take Note of Stock ID in to remove Stock");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tblScrollStock, javax.swing.GroupLayout.PREFERRED_SIZE, 944, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(btnRemoveStock))
                .addGap(79, 79, 79))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tblScrollStock, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(btnRemoveStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemoveStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveStockActionPerformed
            this.dispose();
            removeStock rmStock = new removeStock();
            rmStock.setVisible(true);
    }//GEN-LAST:event_btnRemoveStockActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
            this.dispose();
            stock stock = new stock();
            stock.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(viewStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewStock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRemoveStock;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane tblScrollStock;
    private javax.swing.JTable tblStock;
    // End of variables declaration//GEN-END:variables

}

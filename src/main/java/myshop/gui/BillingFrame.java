/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package myshop.gui;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import myshop.dao.OrdersDAO;
import myshop.dao.ProductsDAO;
import myshop.pojo.ProductsPojo;

/**
 *
 * @author notde
 */
public class BillingFrame extends javax.swing.JFrame {

    ArrayList<ProductsPojo> al=new ArrayList<>();
    DefaultTableModel tm;
    double grandTotal=0.0;                  
    public BillingFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        tm=(DefaultTableModel)jtProductDetails.getModel();
        txtProductId.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtProductId = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProductDetails = new javax.swing.JTable();
        btnGenerateBill = new javax.swing.JButton();
        totalAmount = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(51, 0, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true), "BILLING OPTION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(204, 255, 255))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 255, 255));
        jLabel3.setText("Product ID");

        txtProductId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductIdActionPerformed(evt);
            }
        });

        jButton1.setText("Back");

        jButton2.setText("Logout");

        jtProductDetails.setBackground(new java.awt.Color(0, 51, 51));
        jtProductDetails.setForeground(new java.awt.Color(204, 255, 255));
        jtProductDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Product Name", "Product Company", "Product Price", "Our Price", "Quantity", "Tax", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtProductDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtProductDetailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtProductDetails);
        if (jtProductDetails.getColumnModel().getColumnCount() > 0) {
            jtProductDetails.getColumnModel().getColumn(6).setPreferredWidth(5);
            jtProductDetails.getColumnModel().getColumn(7).setPreferredWidth(8);
        }

        btnGenerateBill.setText("Generate Bill");
        btnGenerateBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateBillActionPerformed(evt);
            }
        });

        totalAmount.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        totalAmount.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel3)
                .addGap(29, 29, 29)
                .addComponent(txtProductId, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 213, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(45, 45, 45))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(310, 310, 310)
                .addComponent(btnGenerateBill)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(totalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtProductId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGenerateBill)
                    .addComponent(totalAmount))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtProductDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProductDetailsMouseClicked
        

    }//GEN-LAST:event_jtProductDetailsMouseClicked

    private void txtProductIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductIdActionPerformed
        if(txtProductId.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Please enter product id");
            return;
        }
        
        loadItemList(txtProductId.getText().trim());
        txtProductId.setText("");
        totalAmount.setText("GRAND TOTAL :"+String.valueOf(grandTotal));
    }//GEN-LAST:event_txtProductIdActionPerformed

    private void btnGenerateBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateBillActionPerformed
        try
        {
            String ordId=OrdersDAO.getNextOrderId();
            
            if(OrdersDAO.addOrder(al, ordId)&& ProductsDAO.updateStocks(al))
            {
                    JOptionPane.showMessageDialog(null,"Order of Rs "+grandTotal+"/- created successfully");
                    
            }
            
            else 
            {
                JOptionPane.showMessageDialog(null,"Order Not Created");
            }
        }
        
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"DB Error");
            ex.printStackTrace();
        }
        
        
    }//GEN-LAST:event_btnGenerateBillActionPerformed

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
            java.util.logging.Logger.getLogger(BillingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BillingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BillingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BillingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BillingFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerateBill;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtProductDetails;
    private javax.swing.JLabel totalAmount;
    private javax.swing.JTextField txtProductId;
    // End of variables declaration//GEN-END:variables

    private void loadItemList(String pid) {
        try
        {
            ProductsPojo p=ProductsDAO.getProductDetails(pid);
            if(p.getProductId()==null)
            {
                JOptionPane.showMessageDialog(null,"Please Enter valid product ID","Error",JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            int index=getProductId(pid);
            if(index==-1)
            {
                Object [] rows=new Object[8];
                int quantity=1;
                double amount=quantity*p.getOurPrice();
                
                p.setQuantity(quantity);
                
                p.setTotal(amount+(amount*p.getTax()/100));
                
                rows[0]=p.getProductId();
                rows[1]=p.getProductName();
                rows[2]=p.getProductCompany();
                rows[3]=p.getProductPrice();
                rows[4]=p.getOurPrice();
                rows[5]=p.getQuantity();
                rows[6]=p.getTax();
                rows[7]=p.getTotal();
                tm.addRow(rows);
                al.add(p);
                grandTotal+=p.getTotal();
            }
            
            else 
            {
                ProductsPojo prd=al.get(index);
                int oldQuantity=(int)tm.getValueAt(index,5);
                double amt=prd.getOurPrice();
                int tax=prd.getTax();
                
                amt=amt+(amt*tax/100);
                
                double total=(double)tm.getValueAt(index,7);
                
                tm.setValueAt(++oldQuantity,index,5);
                tm.setValueAt(total+amt,index,7);
                grandTotal+=amt;
                
                prd.setQuantity(oldQuantity);
                prd.setTotal(total+amt);
                al.set(index, prd);
                
            }
            
            
            
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"DB Error");
            ex.printStackTrace();
        }
    }
    
    private int getProductId(String pid)
    {
        int index=-1;
        for(int i=0;i<al.size();i++)
        {
            ProductsPojo p=al.get(i);
            if(p.getProductId().equals(pid))
            {
                index = i;
                break;
            }
        }
        return index;
    }
}
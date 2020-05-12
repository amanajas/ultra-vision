
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controllers.RentController;
import controllers.UserController;
import controllers.WindowController;
import entities.Rental;
import entities.RentalStatus;
import entities.User;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import utils.NumberUtils;
import utils.keyboard.adapter.EnterKeyListener;
import utils.keyboard.adapter.OnlyNumber;

/**
 *
 * @author thiago.amanajas
 */
public class RentStatusForm extends Window {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -3341956859165788317L;
	public static final String NAME = "rentStatus";
    private final RentController rentController;
    private final UserController userController;
    private RentalStatus rentalStatus;
    
    /**
     * Creates new form RentStatusForm
     */
    public RentStatusForm() {
        super(NAME);
        initComponents();
        this.rentalStatus = null;
        this.rentController = new RentController();
        this.userController = new UserController();
        this.customerIDField.addKeyListener(new OnlyNumber(this.customerIDField));
        this.customerIDField.addKeyListener(new EnterKeyListener(customerIDField, customerNameField, userController));
        this.rentalTitleSearchField.addKeyListener(new EnterKeyListener(rentalTitleSearchField, rentFieldStatus, rentController));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        customerNameField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        customerIDField = new javax.swing.JTextField();
        rentalTitleSearchField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        updateStatusButton = new javax.swing.JToggleButton();
        jLabel4 = new javax.swing.JLabel();
        searchCustomerButton = new javax.swing.JButton();
        searchRentalButton = new javax.swing.JButton();
        rentFieldStatus = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Rent status");
        setAlwaysOnTop(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        customerNameField.setToolTipText("Type the name of the customer");
        customerNameField.setDragEnabled(false);

        jLabel1.setText("Customer name:");

        jLabel2.setText("Customer ID:");

        customerIDField.setToolTipText("Type the ID of the customer");
        customerIDField.setDragEnabled(false);
        customerIDField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerIDFieldActionPerformed(evt);
            }
        });

        rentalTitleSearchField.setToolTipText("Type the rental title");
        rentalTitleSearchField.setDragEnabled(false);

        jLabel3.setText("Rental title:");

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        updateStatusButton.setText("Active");

        jLabel4.setText("Rent status:");

        searchCustomerButton.setText("search");
        searchCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchCustomerButtonActionPerformed(evt);
            }
        });

        searchRentalButton.setText("search");
        searchRentalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchRentalButtonActionPerformed(evt);
            }
        });

        rentFieldStatus.setDragEnabled(false);
        rentFieldStatus.setEnabled(false);

        jLabel5.setText("Rental ID:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(updateStatusButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(customerIDField)
                    .addComponent(rentFieldStatus)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(0, 43, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(customerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(searchCustomerButton)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rentalTitleSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchRentalButton)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customerIDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchCustomerButton))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rentalTitleSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchRentalButton)
                    .addComponent(rentFieldStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(updateStatusButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.rentalStatus = null;
        WindowController.getInstance().showMainWindow();
    }//GEN-LAST:event_formWindowClosed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if (NumberUtils.isNumeric(this.customerIDField.getText()) &&
                NumberUtils.isNumeric(this.rentFieldStatus.getText()) && 
                this.customerNameField.getText().length() > 0) {
            boolean active = this.updateStatusButton.isSelected();
            try {
                int userId = Integer.valueOf(this.customerIDField.getText());
                int rentalId = Integer.valueOf(this.rentFieldStatus.getText());
                if (this.rentController.addRentStatus(this.rentalStatus, userId, rentalId, active)) {
                    JOptionPane.showMessageDialog(this,
                            "Rental updated.",
                            "ok",
                            JOptionPane.WARNING_MESSAGE);
                    WindowController.getInstance().showMainWindow();
                } else {
                    JOptionPane.showMessageDialog(this,
                            "It was not possible to update the rental status.",
                            "warning",
                            JOptionPane.WARNING_MESSAGE);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(RentStatusForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void searchCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchCustomerButtonActionPerformed
        String id = this.customerIDField.getText();
        if (!id.isEmpty() && NumberUtils.isNumeric(id)) {
            try {
                User user = this.userController.getUser(Integer.valueOf(id));
                if (user != null) {
                    this.customerIDField.setText(String.valueOf(user.getId()));
                    this.customerNameField.setText(user.getName());
                } else {
                    JOptionPane.showMessageDialog(this,
                            "It was not possible to find the customer by ID.",
                            "warning",
                            JOptionPane.WARNING_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(RentStatusForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this,
                            "You need to fill in the customer data.",
                            "warning",
                            JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_searchCustomerButtonActionPerformed

    private void customerIDFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerIDFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerIDFieldActionPerformed

    private void searchRentalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchRentalButtonActionPerformed
        String title = this.rentalTitleSearchField.getText();
        if (!title.isEmpty()) {
            try {
                Rental rental = this.rentController.getRentByTitle(title);
                if (rental != null) {
                    this.rentFieldStatus.setText(String.valueOf(rental.getId()));
                } else {
                    this.rentFieldStatus.setText("ID not found");
                    JOptionPane.showMessageDialog(this,
                            "It was not possible to find the rental by title.",
                            "warning",
                            JOptionPane.WARNING_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(RentStatusForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this,
                            "Type the title of the rental first.",
                            "Inane warning",
                            JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_searchRentalButtonActionPerformed


    @Override
    public Window copy() {
        return new RentStatusForm();
    }

    @Override
    public void clear() {
        this.customerIDField.setText("");
        this.customerNameField.setText("");
        this.rentalTitleSearchField.setText("");
        this.rentFieldStatus.setText("");
        this.customerIDField.setEnabled(true);
        this.updateStatusButton.setSelected(true);
        this.customerNameField.setEnabled(false);
        this.rentalTitleSearchField.setEnabled(true);
        this.searchRentalButton.setEnabled(true);
        this.rentalStatus = null;
    }

    public void setSelectedRentStatus(RentalStatus rentalStatus) {
        this.rentalStatus = rentalStatus;
        this.customerIDField.setText(String.valueOf(rentalStatus.getUser().getId()));
        this.customerNameField.setText(String.valueOf(rentalStatus.getUser().getName()));
        this.rentalTitleSearchField.setText(rentalStatus.getRental().getTitle());
        this.customerIDField.setEnabled(false);
        this.customerNameField.setEnabled(false);
        this.rentalTitleSearchField.setEnabled(false);
        this.updateStatusButton.setSelected(rentalStatus.getStatus());
        this.rentFieldStatus.setText(String.valueOf(this.rentalStatus.getRental().getId()));
        this.searchRentalButton.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField customerIDField;
    private javax.swing.JTextField customerNameField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField rentFieldStatus;
    private javax.swing.JTextField rentalTitleSearchField;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton searchCustomerButton;
    private javax.swing.JButton searchRentalButton;
    private javax.swing.JToggleButton updateStatusButton;
    // End of variables declaration//GEN-END:variables

}

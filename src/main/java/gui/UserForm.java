/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controllers.MembershipController;
import controllers.UserController;
import controllers.WindowController;
import entities.IEntity;
import entities.Membership;
import entities.User;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author thiago.amanajas
 */
public class UserForm extends Window {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6058448480821053779L;
	public static final String NAME = "userForm";
    private final MembershipController membershipController;
    private final UserController userController;
    private User user;
    /**
     * Creates new form UserForm
     */
    public UserForm() {
        super(NAME);
        initComponents();
        this.user = null;
        this.userController = new UserController();
        this.membershipController = new MembershipController();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        membershipTypeCombo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        cancelButton = new javax.swing.JButton();
        cancelButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		formWindowClosed(null);
        	}
        });
        saveButton = new javax.swing.JButton();
        saveButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String name = nameField.getText();
        		String password = String.valueOf(passwordField.getPassword());
        		Membership membership;
				try {
					membership = membershipController.getMembership((String) membershipTypeCombo.getSelectedItem());
	        		boolean operation;
	        		if (user == null) {
	        			operation = userController.addUser(name, password, membership);
	        		} else {
	        			operation = userController.updateUser(user, name, password, membership);
	        		}
	        		if (!operation) {
	        			JOptionPane.showMessageDialog(UserForm.this,
	                            "It was not possible to save the customer.",
	                            "warning",
	                            JOptionPane.ERROR_MESSAGE);
	        		} else {
	        			JOptionPane.showMessageDialog(UserForm.this,
	                            "The customer was saved.",
	                            "info",
	                            JOptionPane.PLAIN_MESSAGE);
	        			formWindowClosed(null);
	        		}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Customer form");
        setAlwaysOnTop(true);
        setLocationByPlatform(true);
        setResizable(false);

        membershipTypeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        membershipTypeCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                membershipTypeComboActionPerformed(evt);
            }
        });

        jLabel1.setText("Membership type");

        jLabel2.setText("Name");

        jLabel3.setText("Password");

        cancelButton.setText("Cancel");

        saveButton.setText("Save");
        
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                        .addComponent(saveButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(nameField, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(passwordField)
                            .addComponent(membershipTypeCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(membershipTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(saveButton))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.user = null;
        WindowController.getInstance().showMainWindow();
    }//GEN-LAST:event_formWindowClosed
    
    private void membershipTypeComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_membershipTypeComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_membershipTypeComboActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox<String> membershipTypeCombo;
    private javax.swing.JTextField nameField;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void clear() {
        this.nameField.setText("");
        this.passwordField.setText("");
        refreshCombo();
        this.membershipTypeCombo.setSelectedIndex(0);
    }
    
    public void openUser(User user) {
        this.user = user;
        this.nameField.setText(user.getName());
        refreshCombo(user.getMembership());
    }

    @Override
    public Window copy() {
        return new UserForm();
    }

    private void refreshCombo() {
        try {
            ComboModel model = new ComboModel();
            List<IEntity> list = List.copyOf(this.membershipController.getAll());
            model.setOptionList(list);
            this.membershipTypeCombo.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void refreshCombo(Membership membership) {
        refreshCombo();
        this.membershipTypeCombo.setSelectedItem(membership.getDescription());
    }

}

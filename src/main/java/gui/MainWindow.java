/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controllers.RentController;
import controllers.WindowController;
import db.Database;
import entities.Rental;
import entities.RentalStatus;
import entities.User;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author thiago.amanajas
 */
public class MainWindow extends Window {
    
    public static final String NAME = "main";
    private User user;
    private RentController rentController;

    public MainWindow(User user) {
        super(NAME);
        initComponents();
        this.user = user;
        this.rentController = new RentController();
        refreshList();
    }
    
    public final void refreshList() {
        try {
            this.rentStatusTable.setModel(new RentStatusTable(
                    this.rentController.getAllRents()));
        } catch (SQLException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public final void refreshList(List<RentalStatus> list) {
        this.rentStatusTable.setModel(new RentStatusTable(list));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        rentStatusTableScroll = new javax.swing.JScrollPane();
        rentStatusTable = new javax.swing.JTable();
        searchRentStatusField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        editSelectedRentButton = new javax.swing.JButton();
        addRentButton = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exportDataMenuItem = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        exitMenuItem = new javax.swing.JMenuItem();
        customerMenu = new javax.swing.JMenu();
        searchCustomerMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        addCustomerMenuItem = new javax.swing.JMenuItem();
        updateCustomerMenuItem = new javax.swing.JMenuItem();
        deleteCustomerMenuItem = new javax.swing.JMenuItem();
        rentalMenu = new javax.swing.JMenu();
        searchRentalMenuItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        updateRentalMenuItem = new javax.swing.JMenuItem();
        addRentalMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ultra-Vision");
        setAlwaysOnTop(true);
        setName("frameWindow");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        desktopPane.setBackground(java.awt.Color.white);

        rentStatusTable.setFocusable(false);
        rentStatusTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        rentStatusTable.getTableHeader().setReorderingAllowed(false);
        rentStatusTableScroll.setViewportView(rentStatusTable);
        rentStatusTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        searchRentStatusField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        searchRentStatusField.setToolTipText("Search rent status by Title or Customer name");

        jLabel1.setText("Search rent status:");

        editSelectedRentButton.setText("Edit selected value");
        editSelectedRentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editSelectedRentButtonActionPerformed(evt);
            }
        });

        addRentButton.setText("Add rent");
        addRentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRentButtonActionPerformed(evt);
            }
        });

        desktopPane.setLayer(rentStatusTableScroll, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(searchRentStatusField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(editSelectedRentButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(addRentButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        
        searchRentStatusButton = new JButton();
        searchRentStatusButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String searhRentText = searchRentStatusField.getText();
        		try {
					List<RentalStatus> list = rentController.getRentStatusByDescription(searhRentText);
					refreshList(list);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        searchRentStatusButton.setText("Search");

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPaneLayout.setHorizontalGroup(
        	desktopPaneLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(desktopPaneLayout.createSequentialGroup()
        			.addGroup(desktopPaneLayout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(rentStatusTableScroll, GroupLayout.PREFERRED_SIZE, 900, GroupLayout.PREFERRED_SIZE)
        				.addGroup(desktopPaneLayout.createSequentialGroup()
        					.addGap(12)
        					.addGroup(desktopPaneLayout.createParallelGroup(Alignment.LEADING)
        						.addGroup(desktopPaneLayout.createSequentialGroup()
        							.addComponent(searchRentStatusField, GroupLayout.PREFERRED_SIZE, 455, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(searchRentStatusButton)
        							.addGap(82)
        							.addComponent(editSelectedRentButton)
        							.addPreferredGap(ComponentPlacement.RELATED, 1, Short.MAX_VALUE)
        							.addComponent(addRentButton))
        						.addComponent(jLabel1))))
        			.addContainerGap(114, Short.MAX_VALUE))
        );
        desktopPaneLayout.setVerticalGroup(
        	desktopPaneLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(desktopPaneLayout.createSequentialGroup()
        			.addGap(22)
        			.addComponent(jLabel1)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(desktopPaneLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(searchRentStatusField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
        				.addComponent(editSelectedRentButton)
        				.addComponent(addRentButton)
        				.addComponent(searchRentStatusButton))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(rentStatusTableScroll, GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE))
        );
        desktopPane.setLayout(desktopPaneLayout);

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        exportDataMenuItem.setMnemonic('a');
        exportDataMenuItem.setText("Export data ...");
        fileMenu.add(exportDataMenuItem);
        fileMenu.add(jSeparator3);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        customerMenu.setMnemonic('e');
        customerMenu.setText("Customer");

        searchCustomerMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK));
        searchCustomerMenuItem.setText("Search");
        customerMenu.add(searchCustomerMenuItem);
        customerMenu.add(jSeparator1);

        addCustomerMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK));
        addCustomerMenuItem.setMnemonic('y');
        addCustomerMenuItem.setText("Add");
        customerMenu.add(addCustomerMenuItem);

        updateCustomerMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.ALT_MASK));
        updateCustomerMenuItem.setMnemonic('p');
        updateCustomerMenuItem.setText("Update");
        customerMenu.add(updateCustomerMenuItem);

        deleteCustomerMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_MASK));
        deleteCustomerMenuItem.setMnemonic('d');
        deleteCustomerMenuItem.setText("Delete");
        customerMenu.add(deleteCustomerMenuItem);

        menuBar.add(customerMenu);

        rentalMenu.setMnemonic('h');
        rentalMenu.setText("Rental");

        searchRentalMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK));
        searchRentalMenuItem.setMnemonic('c');
        searchRentalMenuItem.setText("Search");
        rentalMenu.add(searchRentalMenuItem);
        rentalMenu.add(jSeparator2);

        updateRentalMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK));
        updateRentalMenuItem.setMnemonic('a');
        updateRentalMenuItem.setText("Update");
        rentalMenu.add(updateRentalMenuItem);

        addRentalMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.ALT_MASK));
        addRentalMenuItem.setText("Add");
        rentalMenu.add(addRentalMenuItem);

        menuBar.add(rentalMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        WindowController.getInstance().showLogin();
    }//GEN-LAST:event_formWindowClosed

    private void addRentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRentButtonActionPerformed
        WindowController.getInstance().showRentStatusForm();
    }//GEN-LAST:event_addRentButtonActionPerformed

    private void editSelectedRentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editSelectedRentButtonActionPerformed
        // TODO: Put user and rental selected into the form
        int selectedRow = this.rentStatusTable.getSelectedRow();
        System.out.println("ROW: " + selectedRow);
        if (selectedRow >= 0) {
            RentalStatus selectedTitleValue = (RentalStatus) (
                    (RentStatusTable)this.rentStatusTable.getModel()
                    ).getRow(selectedRow);
            if (selectedTitleValue != null) {
                WindowController.getInstance().showRentStatusForm(selectedTitleValue);
            }
        }
    }//GEN-LAST:event_editSelectedRentButtonActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        refreshList();
    }//GEN-LAST:event_formWindowActivated


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addCustomerMenuItem;
    private javax.swing.JButton addRentButton;
    private javax.swing.JMenuItem addRentalMenuItem;
    private javax.swing.JMenu customerMenu;
    private javax.swing.JMenuItem deleteCustomerMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JButton editSelectedRentButton;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenuItem exportDataMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JTable rentStatusTable;
    private javax.swing.JScrollPane rentStatusTableScroll;
    private javax.swing.JMenu rentalMenu;
    private javax.swing.JMenuItem searchCustomerMenuItem;
    private javax.swing.JTextField searchRentStatusField;
    private javax.swing.JMenuItem searchRentalMenuItem;
    private javax.swing.JMenuItem updateCustomerMenuItem;
    private javax.swing.JMenuItem updateRentalMenuItem;
    private JButton searchRentStatusButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public Window copy() {
        return new MainWindow(this.user);
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

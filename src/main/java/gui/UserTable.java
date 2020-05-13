
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.User;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author thiago.amanajas
 */
public class UserTable extends AbstractTableModel{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -16864792917633446L;
	private final List<User> userStatus;

    public UserTable(List<User> userStatus) {
        super();
        this.userStatus = new ArrayList<>(userStatus);
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Customer ID";
            case 1:
                return "Customer name";
            case 2:
                return "Membership";
        }
        return "";
    }

    @Override
    public int getRowCount() {
        return userStatus.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Object value = "??";
        User status = this.userStatus.get(rowIndex);
        if (rowIndex > -1) {
            switch (columnIndex) {
                case 0:
                    value = status != null ? status.getId() : " -- ";
                    break;
                case 1:
                    value = status != null ? status.getName() : " -- ";
                    break;
                case 2:
                    value = status != null ? status.getMembership().getDescription() : " -- ";
                    break;
            }
        }

        return value;

    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
       switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
        }
       return String.class;
    }

    /* Override this if you want the values to be editable...
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //....
    }
    */

    /**
     * This will return the object at the specified row...
     * @param row
     * @return 
     */
    public User getRow(int row) {
        return this.userStatus.get(row);
    }

    
}

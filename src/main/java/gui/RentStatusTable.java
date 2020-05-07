/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.RentalStatus;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author thiago.amanajas
 */
public class RentStatusTable extends AbstractTableModel{
    private final List<RentalStatus> rentStatus;

    public RentStatusTable(List<RentalStatus> rentStatus) {
        this.rentStatus = new ArrayList<>(rentStatus);
    }

    @Override
    public int getRowCount() {
        return rentStatus.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Object value = "??";
        RentalStatus status = this.rentStatus.get(rowIndex);
        switch (columnIndex) {
            case 0:
                value = status.getId();
                break;
            case 1:
                value = status.getUser().getName();
                break;
            case 2:
                value = status.getRental().getTitle();
                break;
            case 3:
                value = status.getCreated().toString();
                break;
            case 4:
                value = status.getUpdated().toString();
                break;
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
            case 3:
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
     * This will return the user at the specified row...
     * @param row
     * @return 
     */
    public RentalStatus getUserAt(int row) {
        return this.rentStatus.get(row);
    }

    
}

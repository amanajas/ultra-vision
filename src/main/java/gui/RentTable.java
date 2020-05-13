
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Rental;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author thiago.amanajas
 */
public class RentTable extends AbstractTableModel{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -8348197219929829935L;
	private final List<Rental> rentalStatus;

    public RentTable(List<Rental> rentals) {
        super();
        this.rentalStatus = new ArrayList<>(rentals);
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Rental ID";
            case 1:
                return "Title";
            case 2:
                return "Category";
            case 3:
                return "Created";
        }
        return "";
    }

    @Override
    public int getRowCount() {
        return rentalStatus.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Object value = "??";
        Rental status = this.rentalStatus.get(rowIndex);
        if (rowIndex > -1) {
            switch (columnIndex) {
                case 0:
                    value = status != null ? status.getId() : " -- ";
                    break;
                case 1:
                    value = status != null ? status.getTitle() : " -- ";
                    break;
                case 2:
                    value = status != null ? status.getCategory().getDescription() : " -- ";
                    break;
                case 3:
                	value = status != null ? status.getCreated().toString() : " -- ";
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
     * This will return the object at the specified row...
     * @param row
     * @return 
     */
    public Rental getRow(int row) {
        return this.rentalStatus.get(row);
    }

    
}

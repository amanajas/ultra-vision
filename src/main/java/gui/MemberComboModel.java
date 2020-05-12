/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;
import entities.Membership;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thiago.amanajas
 */
public class MemberComboModel implements ComboBoxModel<String>{

    private List<Membership> list;
    private int selectedItem;
    private ListDataListener dataListener;
    
    public MemberComboModel() {
        this.list = new ArrayList<>();
        this.selectedItem = 0;
    }
    
    public void setOptionList(List<Membership> list) {
        this.list = list;
    }
    
    @Override
    public void setSelectedItem(Object anItem) {
        this.selectedItem = this.list.indexOf((Membership) anItem);
    }

    @Override
    public Object getSelectedItem() {
        if (selectedItem > -1) return this.list.get(this.selectedItem);
        return null;
    }

    @Override
    public int getSize() {
        return this.list.size();
    }

    @Override
    public String getElementAt(int index) {
        return this.list.get(index).getDescription();
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

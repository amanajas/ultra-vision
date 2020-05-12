/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.DefaultComboBoxModel;
import entities.Membership;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thiago.amanajas
 */
public class MemberComboModel extends DefaultComboBoxModel<String> {

    /**
	 * 
	 */
	private static final long serialVersionUID = -601556777576051880L;
	private List<Membership> list;
    
    public MemberComboModel() {
    	super();
        this.list = new ArrayList<>();
    }
    
    public void setOptionList(List<Membership> list) {
        this.list = list;
    }

    @Override
    public int getSize() {
        return this.list.size();
    }

    @Override
    public String getElementAt(int index) {
        return this.list.get(index).getDescription();
    }    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.keyboard.adapter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author thiago.amanajas
 */
public class OnlyNumber extends KeyAdapter {
    
    private final JTextField field;
    
    public OnlyNumber (JTextField field) {
        this.field = field;
    }
    
    @Override
    public void keyPressed(KeyEvent ke) {
        String value = field.getText();
        int l = value.length();
        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || 
                KeyEvent.VK_BACK_SPACE == ke.getKeyCode()) {
           field.setEditable(true);
        } else {
           field.setEditable(false);
        }
     }
    
}

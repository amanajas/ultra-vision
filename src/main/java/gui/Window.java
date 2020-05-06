/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author thiago.amanajas
 */
public abstract class Window extends javax.swing.JFrame {
    private final String name;
    /**
     * Creates new form NewApplication
     * @param name
     */
    public Window(String name) {
        this.name = name;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    public abstract void clear();
    
    public abstract Window copy();
    
}

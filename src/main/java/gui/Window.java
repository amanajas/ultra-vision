/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import db.Database;

/**
 *
 * @author thiago.amanajas
 */
public abstract class Window extends javax.swing.JFrame {
    private String name;
    /**
     * Creates new form NewApplication
     * @param db
     */
    public Window(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public abstract Window copy();
    
}

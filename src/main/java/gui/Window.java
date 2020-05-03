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
public class Window extends javax.swing.JFrame {
    private final Database db;
    private String name;
    /**
     * Creates new form NewApplication
     * @param db
     */
    public Window(String name, Database db) {
        this.name = name;
        this.db = db;
    }
    
    public String getName() {
        return name;
    }
    
    public Database getDb() {
        return db;
    }
    
    
}

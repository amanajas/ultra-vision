/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import gui.Window;
import java.util.HashMap;

/**
 *
 * @author thiago.amanajas
 */
public class WindowController {
    
    private final HashMap<String, Window> windows;
    
    private WindowController() {
        this.windows = new HashMap<>();
    }
    
    public static WindowController getInstance() {
        return WindowControllerHolder.INSTANCE;
    }
    
    private static class WindowControllerHolder {

        private static final WindowController INSTANCE = new WindowController();
    }
    
    public void addWindow(Window window) {
        this.windows.put(window.getName(), window);
        this.showWindow(window.getName(), true);
    }
    
    public void showWindow(String key, boolean flag) {
        this.windows.entrySet().forEach((window) -> {
            if (window.getKey().equals(key)) {
                window.getValue().setVisible(flag);
            } else {
                window.getValue().setVisible(false);
            }
        });
    }
}

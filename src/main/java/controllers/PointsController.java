/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author thiago.amanajas
 */
public class PointsController {
    
    private PointsController() {
    }
    
    public static PointsController getInstance() {
        return PointsControllerHolder.INSTANCE;
    }
    
    private static class PointsControllerHolder {

        private static final PointsController INSTANCE = new PointsController();
    }
}

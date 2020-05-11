/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Date;

/**
 *
 * @author thiago.amanajas
 */
public class NumberUtils {
    
    public static boolean isNumeric(String str) {
    	if (str == null) return false;
        try { 
          Double.parseDouble(str);  
          return true;
        } catch(NumberFormatException e){  
          return false;  
        }  
     }

    public static Date getDate() {
		return new Date();
	}
    
    public static Date getDate(Object number) {
    	Date date = new Date();
    	if (number instanceof Long) {
			date.setTime((Long) number);
		} else if (number instanceof Integer) {
			date.setTime((int) number);
		}
		return date;
	}
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package overloading;

import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class Overloading {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        Info f = new Info();
        
        f.getInfo();
        
        f.getInfo("ola");
        f.getInfo(23, "John");
    }
    
}

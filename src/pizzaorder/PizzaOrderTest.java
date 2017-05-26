/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaorder;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author wfram
 */
public class PizzaOrderTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                    PizzaOrderFrame frame = new PizzaOrderFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);
            }
	});
    }
    
}

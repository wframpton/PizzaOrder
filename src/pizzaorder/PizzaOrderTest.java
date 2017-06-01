/*
 * Pizza Order GUI Test 
 * Created by Will Frampton
 */
package pizzaorder;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author wfram - Will Frampton
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

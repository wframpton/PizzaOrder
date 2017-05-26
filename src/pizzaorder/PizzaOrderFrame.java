package pizzaorder;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;
import static javax.swing.SwingConstants.BOTTOM;


public class PizzaOrderFrame extends JFrame {
    public static final double PER_TOPPING_COST = 1.5;
    public static final double SMALL_PIZZA_COST = 6.5;
    public static final double MEDIUM_PIZZA_COST = 8.5;
    public static final double LARGE_PIZZA_COST = 10.0;
        
    public static final int DEFAULT_WIDTH = 600;
    public static final int DEFAULT_HEIGHT = 450;

    private CheckBoxPanel toppingPanel;
    private ButtonPanel pizzaTypePanel;
    private ButtonPanel pizzaSizePanel;
        
    private JLabel label;
    private JTextArea textArea;

    public PizzaOrderFrame() {

        setTitle("Pizza To Go Carryout");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout());

        toppingPanel = new CheckBoxPanel("Each Topping $1.50","Tomato", "Green Pepper", "Black Olives", "Mushrooms",
                        "Extra Cheese","Pepperoni","Sausage");
        pizzaSizePanel = new ButtonPanel("Pizza Size","Small  $6.50", "Medium $8.50",
                        "Large $10.00");
        pizzaTypePanel = new ButtonPanel("Pizza Type","Thin Crust", "Medium Crust", "Pan");

        northPanel.add(toppingPanel);
        northPanel.add(pizzaSizePanel);
        northPanel.add(pizzaTypePanel);
                
        add(northPanel, BorderLayout.NORTH);
                
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2,1));
                                
        // add the sample text label
        label = new JLabel("Your Order");
        label.setVerticalAlignment(BOTTOM);
        centerPanel.add(label, BorderLayout.PAGE_END);
                
        textArea = new JTextArea(1,1);
           
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setEditable(false);
        textArea.setFont(new Font("San Serif",Font.BOLD,12));
        centerPanel.add(scrollPane);
                
        add(centerPanel, BorderLayout.CENTER);
                
        // add button to append text into the text area

        JPanel southPanel = new JPanel();

        JButton processButton = new JButton("Process Order");
        processButton.addActionListener(new ShowAction());
        southPanel.add(processButton);
		
        add(southPanel, BorderLayout.SOUTH);

    }

    /**
    * The action listener for the Show button shows a Confirm, Input, Message
    * or Option dialog depending on the Type panel selection.
    */
    private class ShowAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            textArea.setText("");
            textArea.append("Pizza Type: ");
            textArea.append(pizzaTypePanel.getSelection());
            textArea.append("\nPizza Size: ");
            textArea.append(pizzaSizePanel.getSelection().substring(0,6));
            textArea.append("\nToppings: ");
                    
            textArea.append(toppingPanel.getSelection());
                        
            textArea.append("\n\nAmount Due: $");
                        
            double totalAmt=0.0;
                        
            if(pizzaSizePanel.getSelection().equals("Small  $6.50")){
                totalAmt+=SMALL_PIZZA_COST;
            }else if(pizzaSizePanel.getSelection().equals("Medium $8.50")){
                totalAmt+=MEDIUM_PIZZA_COST;
            }else{
                totalAmt+=LARGE_PIZZA_COST;
            }
                        
            int nbrOfToppings = toppingPanel.getNbrOfCheckBoxesSelected();
                        
            totalAmt+=(nbrOfToppings * PER_TOPPING_COST);
                        
            DecimalFormat myFormatter = new DecimalFormat("#.00");
            textArea.append(myFormatter.format(totalAmt));

        }
    }
}

package pizzaorder;

import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class CheckBoxPanel extends JPanel {

    //private JPanel group;
    private ArrayList<JCheckBox> checkBoxes;

    /**
     * Constructs a checkbox panel.
     * 
     * @param title
     *            the title shown in the border
     * @param options
     *            an array of checkbox labels
     */
    public CheckBoxPanel(String title, String... options) {
        
        setBorder(BorderFactory.createTitledBorder(BorderFactory
                .createEtchedBorder(), title));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
        checkBoxes = new ArrayList<>();
                
        // make one checkbox for each option
	
        for (String option : options) {
                
            JCheckBox cb = new JCheckBox(option);
            add(cb);
            checkBoxes.add(cb);
        }
    }


    /**
     * Gets the currently selected option.
     * 
     * @return the label of the currently selected radio button.
     */
    public String getSelection() {
            
        StringBuffer s = new StringBuffer("");
        boolean firstItem = true;
                
        for(JCheckBox checkBox: checkBoxes){
 
            if(checkBox.isSelected()){
                if (firstItem){
                    firstItem = false;
                }else{
                    s.append(", ");
                }
                s.append(checkBox.getActionCommand());
            }
        }
                
        if(firstItem){
            s.append("None Selected");
        }
                
        return s.toString();
    }  
    
    /**
     * Gets the number of checkboxes selected.
     * 
     * @return the number of checkboxes selected.
     */
    public int getNbrOfCheckBoxesSelected() {
    
        int i=0;   
            
        for(JCheckBox checkBox: checkBoxes){
            if(checkBox.isSelected()){
                i++;
            }
        }
        return i;
    }
}

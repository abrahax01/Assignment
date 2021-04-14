// Program to make a GUI with events

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

// GUI CLASS 
public class GUI extends JFrame implements ActionListener
{
    private static final long serialVersionUID = 1L;
    
    String gender1, ownBusiness1, partTimeJob1, area1, studyBusiness1; 
    String[] genders = {" ", "Male", "Female"}, yesNo = {" ", "Yes", "No"}, areas = {" ", "Urban", "Rural"};
    boolean event1 = false, event2 = false, event3 = false, event4 = false, event5 = false;
    Hashtable<String, Integer> dataDictionary;
    String[][] dataByRow;
    String answers;

    // ATTRIBUTES
    JComboBox<String> genderBox, ownBusinessBox, partTimeJobBox, areaBox, studyBusinessBox; 
    JLabel genderLabel, ownBusinessLabel, partTimeJobLabel, areaLabel, studyBusinessLabel;
    JButton CheckProbability;
    JTextArea result;

    GUI(String title, Hashtable<String, Integer> dataDictionary, String[][] dataByRow)
    { 
        super(title);
        this.dataDictionary = dataDictionary;
        this.dataByRow = dataByRow;
        
        setSize(1000,300);
        setLayout(new FlowLayout());

        // LABELS
        genderLabel = new JLabel("Gender: ");
        ownBusinessLabel = new JLabel("Parent own a business?: ");
        partTimeJobLabel = new JLabel("Has part time job?: ");
        areaLabel = new JLabel("Area: ");
        studyBusinessLabel = new JLabel("Study business?: ");

        // BOXES 
        genderBox = new JComboBox<String>(genders);
        ownBusinessBox = new JComboBox<String>(yesNo);
        partTimeJobBox = new JComboBox<String>(yesNo);
        areaBox = new JComboBox<String>(areas);
        studyBusinessBox = new JComboBox<String>(yesNo);

        genderBox.setToolTipText("Please enter Gender here");
        ownBusinessBox.setToolTipText("Please enter 'YES' or 'No' if parents own a business");
        partTimeJobBox.setToolTipText("Please enter 'YES' or 'No' if student has a part time job");
        areaBox.setToolTipText("Please enter 'Urban' or 'Rural' if student lives in urban area or rural area");
        studyBusinessBox.setToolTipText("Please enter 'YES' or 'No' if student studies business");

        add(genderLabel);
        add(genderBox);

        add(ownBusinessLabel);
        add(ownBusinessBox);

        add(partTimeJobLabel);
        add(partTimeJobBox);

        add(areaLabel);
        add(areaBox);

        add(studyBusinessLabel);
        add(studyBusinessBox);

        genderBox.addActionListener(this);
        ownBusinessBox.addActionListener(this);
        partTimeJobBox.addActionListener(this);
        areaBox.addActionListener(this);
        studyBusinessBox.addActionListener(this);

        // BUTTONS
        CheckProbability = new JButton("Check Probability");

        CheckProbability.setToolTipText("Checks the probability of student to become an entrepreneur or not");

        CheckProbability.setForeground(Color.BLUE);

        add(CheckProbability);

        CheckProbability.addActionListener(this);

        // RESULT TXT FIELD
        result = new JTextArea("Results");
        
        // SHOW THE BUTTONS, TEXT FIELDS
        setVisible(true);

    }

    // USER RESULTS TO A PERFORMED ACTION
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == genderBox)
        {
            event1 = false;
            gender1 = (String) genderBox.getSelectedItem();
            JOptionPane.showMessageDialog(this, "You selected: " + gender1);
            if("Male".equals(gender1) || "Female".equals(gender1))
            {
                event1 = true;
            } 
            
        }

        if(e.getSource() == ownBusinessBox)
        {
            event2 = false;
            ownBusiness1 = (String) ownBusinessBox.getSelectedItem();
            JOptionPane.showMessageDialog(this, "You selected: " + ownBusiness1);
            if("Yes".equals(ownBusiness1) || "No".equals(ownBusiness1))
            {
                event2 = true;
            } 
            
        } 

        if(e.getSource() == partTimeJobBox)
        {
            event3 = false; 
            partTimeJob1 = (String) partTimeJobBox.getSelectedItem();
            JOptionPane.showMessageDialog(this, "You selected: " + partTimeJob1);
            if("Yes".equals(partTimeJob1) || "No".equals(partTimeJob1))
            {
                event3 = true;
            } 
            
        } 

        if(e.getSource() == areaBox)
        {
            event4 = false;
            area1 = (String) areaBox.getSelectedItem();
            JOptionPane.showMessageDialog(this, "You selected: " + area1);
            if("Urban".equals(area1) || "Rural".equals(area1))
            {
                event4 = true;
            } 
            
        } 

        if(e.getSource() == studyBusinessBox)
        {
            event5 = false;
            studyBusiness1 = (String) studyBusinessBox.getSelectedItem();
            JOptionPane.showMessageDialog(this, "You selected: " + studyBusiness1);
            if("Yes".equals(studyBusiness1) || "No".equals(studyBusiness1))
            {
                event5 = true;
            } 
            
        } 

        // BUTTON EVENTS
        if (e.getSource() == CheckProbability)
        {
            if (event1 == true && event2 == true && event3 == true && event4 == true && event5 == true)
            {
                JOptionPane.showMessageDialog(this, "Checking probability for this student to become an entrepreneur: " + gender1 + " " + ownBusiness1 + " " + partTimeJob1 + " " + area1 + " " + studyBusiness1);

                // MachineLearning answers = new MachineLearning();
                MachineLearning probabilities = new MachineLearning(gender1, ownBusiness1, partTimeJob1, area1, studyBusiness1, dataDictionary, dataByRow);
                answers = probabilities.toString();

                add(result);
                result.setText("Results: " + answers);
                
            }
            else
            {
                if (event1 == false)
                {
                    JOptionPane.showMessageDialog(this, "Please enter 'Male' or 'Female' for 'gender'"); 
                }
                if (event2 == false)
                {
                    JOptionPane.showMessageDialog(this, "Please enter 'Yes' or 'No' for 'Parents own business'");  
                }
                if (event3 == false)
                {
                    JOptionPane.showMessageDialog(this, "Please enter 'Yes' or 'No' for 'Part time job'");  
                } 
                if (event4 == false)
                {
                    JOptionPane.showMessageDialog(this, "Please enter 'Urban' or 'Rural' for 'Area'");  
                } 
                if (event5 == false)
                {
                    JOptionPane.showMessageDialog(this, "Please enter 'Yes' or 'No' for 'Study business'");  
                } 
            } // END OF ELSE STATEMENT

        } // END OF IF STATEMENT

    } // END OF ACTION PERFORMED
}

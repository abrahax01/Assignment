// Program to make a GUI with events, stores entered text from GUI into an array and then displays it 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// GUI CLASS 
public class GUI extends JFrame implements ActionListener
{
    private static final long serialVersionUID = 1L;
    
    // ATTRIBUTES
    JButton CheckProbability;
    JTextField gender, ownBusiness, partTimeJob, area, studyBusiness;
    JTextArea result;
    String gender1, ownBusiness1, partTimeJob1, area1, studyBusiness1; 
    boolean event1 = false, event2 = false, event3 = false, event4 = false, event5 = false;
    Hashtable<String, Integer> dataDictionary;
    String[][] dataByRow;
    String answers;

    GUI(String title, Hashtable<String, Integer> dataDictionary, String[][] dataByRow)
    { 
        super(title);
        this.dataDictionary = dataDictionary;
        this.dataByRow = dataByRow;
        
        setSize(800,300);
        setLayout(new FlowLayout());

        // TEXT FIELDS
        gender = new JTextField("Gender");
        ownBusiness = new JTextField("Parents own a business?");
        partTimeJob = new JTextField("Part time job?");
        area = new JTextField("Area of residence");
        studyBusiness = new JTextField("Study business?");

        gender.setToolTipText("Please type gender of student here");
        ownBusiness.setToolTipText("Please type 'YES' or 'No' if parents own a business");
        partTimeJob.setToolTipText("Please type type 'YES' or 'No' if student has a part time job");
        area.setToolTipText("Please type type 'Urban' or 'Rural' if student lives in urban area or rural area");
        studyBusiness.setToolTipText("Please type type 'YES' or 'No' if student studies business");

        add(gender);
        add(ownBusiness);
        add(partTimeJob);
        add(area);
        add(studyBusiness);

        gender.addActionListener(this);
        ownBusiness.addActionListener(this);
        partTimeJob.addActionListener(this);
        area.addActionListener(this);
        studyBusiness.addActionListener(this);

        // BUTTONS
        CheckProbability = new JButton("Check Probability");

        CheckProbability.setToolTipText("Checks the probability of student to become an entrepreneur or not");

        CheckProbability.setForeground(Color.BLUE);

        add(CheckProbability);

        CheckProbability.addActionListener(this);

        // RESULT TXT FIELD
        result = new JTextArea("Results");
        add(result);

        // SHOW THE BUTTONS, TEXT FIELDS
        setVisible(true);

    }

    // USER RESULTS TO A PERFORMED ACTION
    public void actionPerformed(ActionEvent e)
    {
        // TEXT EVENTS
        if (e.getSource() == gender )
        {
            event1 = false;
            gender1 = gender.getText();
            JOptionPane.showMessageDialog(this, "You entered: " + gender1);
            System.out.println("You Entered: " + gender1);
            if("Male".equals(gender1) || "Female".equals(gender1))
            {
                event1 = true;
            }
        }

        if (e.getSource() == ownBusiness)
        {
            event2 = false;
            ownBusiness1 = ownBusiness.getText();
            JOptionPane.showMessageDialog(this, "You entered: " + ownBusiness1);
            System.out.println("You Entered: " + ownBusiness1);
            if("Yes".equals(ownBusiness1) || "No".equals(ownBusiness1))
            {
                event2 = true;
            }

        }

        if (e.getSource() == partTimeJob)
        {
            event3 = false;
            partTimeJob1 = partTimeJob.getText();
            JOptionPane.showMessageDialog(this, "You entered: " + partTimeJob1);
            System.out.println("You Entered: " + partTimeJob1);
            if("Yes".equals(partTimeJob1) || "No".equals(partTimeJob1))
            {
                event3 = true;
            }
        }

        if (e.getSource() == area)
        {
            event4 = false;
            area1 = area.getText();
            JOptionPane.showMessageDialog(this, "You entered: " + area1);
            System.out.println("You Entered: " + area1);
            if("Urban".equals(area1) || "Rural".equals(area1))
            {
                event4 = true;
            }
        }    
        
        if (e.getSource() == studyBusiness)
        {
            event5 = false;
            studyBusiness1 = studyBusiness.getText();
            JOptionPane.showMessageDialog(this, "You entered: " + studyBusiness1);
            System.out.println("You Entered: " + studyBusiness1);
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


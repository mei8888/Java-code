
import javax.swing.*;
import java.awt.event.*;

public class TempConvertor extends JFrame{
	
	   private JPanel panel;             // To reference a panel
	   private JLabel messageLabel;      // To reference a label
	   private JTextField temperatureTextField;  
	   private JRadioButton CToF; // convert celsius to Farenheit
	   private JRadioButton FToC; // convert Farenheit to celsius
	   private ButtonGroup radioButtonsGroup ; // to group botton 
	   private final int WINDOW_WIDTH = 500;  // Window width
	   private final int WINDOW_HEIGHT = 200; // Window height
	   

	public TempConvertor() {
		
		   // Set the window title.
	      setTitle("Temperature Converter");

	      // Set the size of the window.
	      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

	      // Specify what happens when the close button is clicked.
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	      // Build the panel and add it to the frame.
	      buildPanel();

	      // Add the panel to the frame's content pane.
	      add(panel);

	      // Display the window.
	      setVisible(true);
	}
	
	private void buildPanel()
	{
		// Create the label, text field and two buttons to a pannel
		messageLabel = new JLabel("Enter the degree of Celsius or Fahrenhait :");
		temperatureTextField= new JTextField(10); 
		CToF = new JRadioButton("Convert from Celsius To Farenheit");
		FToC = new JRadioButton("Convert from Farenheit To Celsius");
		
		// group  Radio Buttons
		radioButtonsGroup = new ButtonGroup();
      
      //add radioButtons to the Group
		radioButtonsGroup.add(CToF);
		radioButtonsGroup.add(FToC);
		
		// add action Listener to the Radio Buttons 
		CToF.addActionListener(new RadioButtonListener());
		FToC.addActionListener(new RadioButtonListener());		
		
		// create a panel to add component to it
		panel = new JPanel();
		panel.add(messageLabel);
		panel.add(temperatureTextField);
		panel.add(CToF);
		panel.add(FToC);
	
	}
	
	/** 
	 * Private inner class that handle the event when the user clicks one
	 *  of the radio buttons to convert the temperature.
	 */
	private class RadioButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			String input;          // hold the user input 
			String fromTo= "";
			String convertTo = ""; // hold the units we are converting to 
			double result = 0.0; // hold the convertion 
		
			
			
			input = temperatureTextField.getText(); // get the user input

			
			//determine which radio buttons the user chooses. 
			if (e.getSource()== CToF)
			{
			
				// convert celsius to Farenheit
				result = (Double.parseDouble(input)* (1.8)+32); 
				fromTo = " Celsius ";
				convertTo= " Fanrenheit.";
            
				//display conversation
				JOptionPane.showMessageDialog(null,input +" degree"+ fromTo + " is "+result + "  degree "+ convertTo );
							
			}
			
			else if (e.getSource()== FToC)
			{
				// convert  Fatenheit to Celsius
				result = ((Double.parseDouble(input) - 32) * 5) / 9; 
				fromTo = " Fanrenheit ";
				convertTo= " Celsius. ";
			
			  //display conversation
			  JOptionPane.showMessageDialog(null,input +" degree"+ fromTo + " is "+result + "  degree "+ convertTo );
			
		   }	 
			

		}
		
	}


}

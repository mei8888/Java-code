
import javax.swing.*; //Needed for swing class
import java.awt.event.*; //Needed for ActionListener class

public class AnonymousTempConvertor extends JFrame {
			
			private JPanel panel;             // To reference a panel
		   private JLabel messageLabel;      // To reference a label
		   private JTextField temperatureTextField; //  to hold the user input
		   private JRadioButton CToF; // convert celsius to Farenheit
		   private JRadioButton FToC; // convert Farenheit to celsius
		   private ButtonGroup radioButtonGroup ; // to group button 
		   private final int WINDOW_WIDTH = 500;  // Window width
		   private final int WINDOW_HEIGHT = 200; // Window height
		   
	public AnonymousTempConvertor() {
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
		radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(CToF);
		radioButtonGroup.add(FToC);
		
		
		// add action Listener to the Radio Buttons 
		CToF.addActionListener(
				new ActionListener(){
					 public void actionPerformed(ActionEvent e) {
							// convert celsius to Farenheit
							String input;          // hold the user input 
							String fromTo= "";
							String convertTo = ""; // hold the units we are converting to 
			            double result = 0.0;
					
							
							// get the degree entered 
							input = temperatureTextField.getText();
							
							result = (Double.parseDouble(input)* (1.8)+32);  
							fromTo = " Celsius ";
							convertTo= " Fanrenheit.";
						
							
							//display conversation
							JOptionPane.showMessageDialog(null,input +" degree"+ fromTo + " is "+result + "  degree "+ convertTo );
								
					 }} );
							
		FToC.addActionListener(
				new ActionListener(){
					
			 public void actionPerformed(ActionEvent e) {
					// convert celsius to Farenheit
				 
				 String input;       // hold the user input 
					String fromTo= "";
					String convertTo = ""; // hold the units we are converting to 
					double result = 0.0; // hold the convertion 
					// get the degree entered 
					input = temperatureTextField.getText();	 
					result = ((Double.parseDouble(input) - 32) * 5) / 9; // deducted 32,  multiply by 5 , and divide by 9 
					fromTo = " Fanrenheit ";
					convertTo= " Celsius. ";
					//display conversation
					JOptionPane.showMessageDialog(null,input +" degree"+ fromTo + " is "+result + "  degree "+ convertTo );
										
			 }});
					
		
		// create a panel to add component to it
		panel = new JPanel();
		panel.add(messageLabel);
		panel.add(temperatureTextField);
		panel.add(CToF);
		panel.add(FToC);
	}
	
}
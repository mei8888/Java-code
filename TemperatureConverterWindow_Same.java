import javax.swing.*;
import java.awt.event.*;

public class TemperatureConverterWindow_Same extends JFrame implements ActionListener
{
   private JPanel panel;
   private JLabel messageLabel;
   private JTextField tempTextField;
   private JRadioButton CToF;
   private JRadioButton FToC;
   private ButtonGroup radioButtonGroup;   
   private final int WINDOW_WIDTH = 500;
   private final int WINDOW_HEIGHT = 200;
   
   public TemperatureConverterWindow_Same()
   {
   
      setTitle("Temperature Converter");
    
      setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
      buildPanel();
      
      add(panel);
      
      setVisible(true);
   }
    
     /**
      The buildPanel method adds a label, text field, and
      and a button to a panel.
     */
     private void buildPanel()
     {
      
      messageLabel = new JLabel("Enter the degree of Celsius or Fahrenhait :");
      tempTextField= new JTextField(10); 
		CToF = new JRadioButton("Convert from Celsius To Farenheit");
		FToC = new JRadioButton("Convert from Farenheit To Celsius");
   
      radioButtonGroup = new ButtonGroup();
      radioButtonGroup.add(CToF);   
      radioButtonGroup.add(FToC);
      
      CToF.addActionListener(this); //new radioButtonListener
      FToC.addActionListener(this);
      
      panel = new JPanel();
      
      panel.add(messageLabel);
      panel.add(tempTextField);
      panel.add(CToF);
      panel.add(FToC);
     }
   
    public void actionPerformed(ActionEvent e)
		{
			String input;          // hold the user input 
			String fromTo= "";
			String convertTo = ""; 
			double result = 0.0; // hold the convertion 			
			
			input = tempTextField.getText(); // get the user input

       if (e.getSource()== CToF)
			{
			
				result = (Double.parseDouble(input)* (1.8)+32); 
				fromTo = " Celsius ";
				convertTo= " Fanrenheit.";
            				
				JOptionPane.showMessageDialog(null,input +" degree"+ fromTo + " is "+result + "  degree "+ convertTo );						
			}
			
		else if (e.getSource()== FToC)
			{
								
            result = ((Double.parseDouble(input) - 32) * 5) / 9;  
				fromTo = " Fanrenheit ";
				convertTo= " Celsius. ";
			
			  JOptionPane.showMessageDialog(null,input +" degree"+ fromTo + " is "+result + "  degree "+ convertTo );			
		   }	     
    }
   
}
package Assignment1;


	
	import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

		public class UserConsole {
		   private JFrame mainFrame;
		   private JLabel headerLabel;
		   private JLabel statusLabel;
		   private JPanel controlPanel;
		   private JLabel msglabel;
		   public static final String DATE_FORMAT_NOW = " HH:mm:ss dd-MM-yyyy";
		   public  UserConsole uc;
		   ElevatorStart es;
		
		   public UserConsole(){
		      prepareGUI();
		      showGridBagLayoutDemo();
		   }
		
		      
		   private void prepareGUI(){
		      mainFrame = new JFrame("User Interface");
		      mainFrame.setSize(1000,1000);
		      mainFrame.setLayout(new GridLayout(3, 3));
		
		      headerLabel = new JLabel("",JLabel.CENTER );
		      statusLabel = new JLabel("",JLabel.CENTER);        
		
		      statusLabel.setSize(350,100);
		      mainFrame.addWindowListener(new WindowAdapter() {
		         public void windowClosing(WindowEvent windowEvent){
			        System.exit(0);
		         }        
		      });    
		      controlPanel = new JPanel();
		      controlPanel.setLayout(new FlowLayout());
		      		
		      mainFrame.add(headerLabel);
		      mainFrame.add(controlPanel);
		      mainFrame.add(statusLabel);
		      mainFrame.setVisible(true);  
		   }
		
		   private void showGridBagLayoutDemo(){
		      headerLabel.setText("User Interface");
		   
		      
		      JPanel panel = new JPanel();
		     // panel.setBackground();
		      panel.setSize(1500,1500);
		      GridBagLayout layout = new GridBagLayout();
		
		      panel.setLayout(layout);        
		      GridBagConstraints gbc = new GridBagConstraints();
		
		      gbc.fill = GridBagConstraints.HORIZONTAL;
		      gbc.gridx = 0;
		      gbc.gridy = 0;		      
		      panel.add(new JLabel("Enter number of elevators:"),gbc);
		      gbc.gridx = 10;
		      gbc.gridy = 0;
		      final JTextField jTextField1=new  JTextField(10);
		      panel.add(jTextField1,gbc);
		      
		      
		      
		      gbc.fill = GridBagConstraints.HORIZONTAL;
		      gbc.gridx = 0;
		      gbc.gridy = 15;
		      panel.add(new JLabel("Enter number of flooors:"),gbc); 
		      gbc.gridx = 10;
		      gbc.gridy = 15;
		      final JTextField jTextField2=new  JTextField(10);
		      panel.add(jTextField2,gbc);
		      
		      
		
		    
		      
		      gbc.fill = GridBagConstraints.HORIZONTAL;
		      gbc.ipady = 0;   
		      gbc.gridx = 0;
		      gbc.gridy = 30;
		      panel.add(new JLabel("Parking Zone Floors:"),gbc);
		      gbc.gridx = 10;
		      gbc.gridy = 30;
		      JTextField jTextField3=new  JTextField(10);
		      panel.add(jTextField3,gbc);
		      
		      
		      
		      Calendar cal = Calendar.getInstance();
		      SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		      String dt=sdf.format(cal.getTime());
		       
		      
		      
		      gbc.fill = GridBagConstraints.HORIZONTAL;
		      gbc.ipady = 0;   
		      gbc.gridx = 0;
		      gbc.gridy = 40;
		     // panel.add(new JLabel("Clock Time:"),gbc);
		      JLabel ClockTime=new JLabel("ClockTime:", JLabel.RIGHT);
		      ClockTime.setText(sdf.format(cal.getTime()));
		      panel.add(new JLabel("Clock Time:"),gbc);
		      gbc.gridx = 10;
		      gbc.gridy = 40; 
		      JTextField values=new JTextField(12);
		      values.setText(dt);
		      panel.add(values,gbc);
		      
		      
		      gbc.fill = GridBagConstraints.HORIZONTAL;
		      gbc.gridx = 0;
		      gbc.gridy = 50;
		      panel.add(new JLabel("No of Persons:"),gbc);
		      gbc.gridx = 10;
		      gbc.gridy = 50; 
		      final JTextField jTextField5=new  JTextField(10);
		      panel.add(jTextField5,gbc);
		      
		      
		      JButton Rbutton = new JButton("Results");
		      Rbutton.setActionCommand("Results");
		      //Rbutton.addActionListener(this.);
		      
		      panel.add(Rbutton);
		      controlPanel.add(panel);
		      Rbutton.addActionListener(new ActionListener()
		      {
				
				
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String command = e.getActionCommand(); 
					if (jTextField1.getText().isEmpty() || jTextField2.getText().isEmpty()){
						
				        JOptionPane.showMessageDialog(null, "One of the required field is empty!", "Error", JOptionPane.ERROR_MESSAGE);
					}	 
					else {
		                action();
		                
		             }
		             	  					
				}

				private void action() {
					// TODO Auto-generated method stub
					
					Controller.MAX_ELEVATORS= Integer.parseInt(jTextField1.getText());
					Controller.MAX_FLOORS=Integer.parseInt(jTextField2.getText());
					Controller.MAX_PERSONS=Integer.parseInt(jTextField5.getText());	
					
					
					mainFrame.dispose();
					
					
				}
				
			});
		      mainFrame.setVisible(true);    
		   }
		
		}
	



package Assignment1;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;


public class ApplicationWindow {
	 JFrame frame ;
	    //frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
	   // frame.setSize(5000, 5000);
	    JPanel panel ;
	    public ApplicationWindow()
	    {
	    frame = new JFrame();
    frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
	//frame.getContentPane().setLayout(new BorderLayout(0, 0));
	
   // frame.setSize(5000, 5000);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     panel = new JPanel();
    JScrollPane scrollPane = new JScrollPane();
    frame.getContentPane().add(scrollPane,BorderLayout.CENTER);
	showPane();
	    }//	panel.setLayout(layout);
  public void showPane()
  {
    List floors = new ArrayList();
	  int flNo=5;
	 for(int j=1;j<=Controller.MAX_FLOORS;j--)
	 {
		  JPanel panel1 = new JPanel();
		  
		  GroupLayout layout1 = new GroupLayout(panel1);
		//  panel1.setBorder(BorderFactory.createLineBorder(Color.black));
		  List elevators = new ArrayList();
		  JButton buttonU = new JButton("F"+(flNo)+"-UP");
		    JButton buttonD = new JButton("F"+(flNo)+"-DOWN");
		    flNo=flNo-1;
		    buttonU.addActionListener(action);
		    buttonD.addActionListener(action);
		    GroupLayout.SequentialGroup leftToRightUD = layout1.createSequentialGroup();
		    GroupLayout.SequentialGroup topToBottomUD = layout1.createSequentialGroup();
		    
		    leftToRightUD.addComponent(buttonU);
		    leftToRightUD.addComponent(buttonD);
		    
		    GroupLayout.ParallelGroup rowTop = layout1.createParallelGroup();
		    rowTop.addComponent(buttonU);
		    rowTop.addComponent(buttonD);
		    
		    topToBottomUD.addGroup(rowTop);
		    layout1.setHorizontalGroup(leftToRightUD);
		    layout1.setVerticalGroup(topToBottomUD);
		 //   panel1.setSize(0, 0);
		 
		 
  for(int i=1;i<=Controller.MAX_ELEVATORS;i++)
	{
	  Container cntr = new Container();
	  GroupLayout layout = new GroupLayout(cntr);
	  
	  cntr.setLayout(layout);
	  GroupLayout.SequentialGroup leftToRight = layout.createSequentialGroup();
	    GroupLayout.SequentialGroup topToBottom = layout.createSequentialGroup();
	    
	    
	    List elevatorButtons = new ArrayList();
		 
		    JButton button1 = new JButton("01");
		    JButton button2 = new JButton("02");
		    JButton button3 = new JButton("03");
		    JButton button4 = new JButton("04");
		    JButton button5 = new JButton("05");
		    button1.setName("F"+j+"-E"+i+"-01");
		    button1.addActionListener(action);
		    
		    button2.setName("F"+j+"-E"+i+"-02");
		    button2.addActionListener(action);
		    
		    button3.setName("F"+j+"-E"+i+"-03");
		    button3.addActionListener(action);
		    
		    button4.setName("F"+j+"-E"+i+"-04");
		    button4.addActionListener(action);
		   
		    button5.setName("F"+j+"-E"+i+"-05");
		    button5.addActionListener(action);
		  
		    elevatorButtons.add(button1);
		    elevatorButtons.add(button2);
		    elevatorButtons.add(button3);
		    elevatorButtons.add(button4);
		    elevatorButtons.add(button5);
		    if(j!=5)
		    {
		    	Controller.hideButtons(0,i,elevatorButtons);
		    }
		    /*JButton button6 = new JButton("06");*/
		    /*JButton button7 = new JButton("07");
		    JButton button8 = new JButton("08");
		    JButton button9 = new JButton("09");
		    JButton button10 = new JButton("10");
		    JButton button11= new JButton("11");
		    JButton button12 = new JButton("12");*/
		
	//	GroupLayout.SequentialGroup leftToRighto = layout.createSequentialGroup();
	   
	    
	    GroupLayout.SequentialGroup leftToright1 = layout.createSequentialGroup();
	    GroupLayout.ParallelGroup paraLeftToRight = layout.createParallelGroup();
	    paraLeftToRight.addComponent(button1);
	    paraLeftToRight.addComponent(button4);
	   /* paraLeftToRight.addComponent(button7);
	    paraLeftToRight.addComponent(button10);*/
	  
	    GroupLayout.SequentialGroup leftToright2 = layout.createSequentialGroup();
	    GroupLayout.ParallelGroup paraLeftToRight1 = layout.createParallelGroup();
	    paraLeftToRight1.addComponent(button2);
	    paraLeftToRight1.addComponent(button5);
	   /* paraLeftToRight1.addComponent(button8);
	    paraLeftToRight1.addComponent(button11);*/
	   
	    
	    GroupLayout.SequentialGroup leftToright3 = layout.createSequentialGroup();
	    GroupLayout.ParallelGroup paraLeftToRight3 = layout.createParallelGroup();
	    paraLeftToRight3.addComponent(button3);
	    /*paraLeftToRight3.addComponent(button6);*/
	    /*paraLeftToRight3.addComponent(button9);
	    paraLeftToRight3.addComponent(button12);
	  */
	  /*  GroupLayout.SequentialGroup leftToright4 = layout.createSequentialGroup();
	    GroupLayout.ParallelGroup paraLeftToRight4 = layout.createParallelGroup();
	    paraLeftToRight4.addComponent(button7);
	    paraLeftToRight4.addComponent(button10);
	  
	    GroupLayout.SequentialGroup leftToright5 = layout.createSequentialGroup();
	    GroupLayout.ParallelGroup paraLeftToRight5 = layout.createParallelGroup();
	    paraLeftToRight5.addComponent(button8);
	    paraLeftToRight5.addComponent(button11);
	    
	    GroupLayout.SequentialGroup leftToright6 = layout.createSequentialGroup();
	    GroupLayout.ParallelGroup paraLeftToRight6 = layout.createParallelGroup();
	    paraLeftToRight6.addComponent(button9);
	    paraLeftToRight6.addComponent(button12);
	  */  
	 
	    leftToright1.addGroup(paraLeftToRight);
	    leftToright2.addGroup(paraLeftToRight1);
	    leftToright3.addGroup(paraLeftToRight3);
	    /*leftToright4.addGroup(paraLeftToRight4);
	    leftToright5.addGroup(paraLeftToRight5);
	    leftToright6.addGroup(paraLeftToRight6);
	    */

	 //   leftToRighto.addGroup(leftToRighto);
	    leftToRight.addGroup(leftToright1);
	    leftToRight.addGroup(leftToright2);
	    leftToRight.addGroup(leftToright3);
	 /*   leftToRight.addGroup(leftToright4);
	    leftToRight.addGroup(leftToright5);
	    leftToRight.addGroup(leftToright6);
	 */   
	    //leftToRight.addGroup(leftToRighto);
	    

	   // GroupLayout.SequentialGroup topToBottom0 = layout.createSequentialGroup();
	  
	   
	    GroupLayout.ParallelGroup rowTop1 = layout.createParallelGroup();
	    rowTop1.addComponent(button1);
	    rowTop1.addComponent(button2);
	    rowTop1.addComponent(button3);
	/*    rowTop1.addComponent(button4);
	    rowTop1.addComponent(button5);
	    rowTop1.addComponent(button6);*/
	    topToBottom.addGroup(rowTop1);
	    
	    GroupLayout.ParallelGroup rowTop3 = layout.createParallelGroup();
	    rowTop3.addComponent(button4);
	    rowTop3.addComponent(button5);
	    /*rowTop3.addComponent(button6);*/
	    topToBottom.addGroup(rowTop3);
	   /* GroupLayout.ParallelGroup rowTop4 = layout.createParallelGroup();
	    rowTop4.addComponent(button7);
	    rowTop4.addComponent(button8);
	    rowTop4.addComponent(button9);
	    topToBottom.addGroup(rowTop4);
	   
	    GroupLayout.ParallelGroup rowTop2 = layout.createParallelGroup();
	    rowTop2.addComponent(button7);
	    rowTop2.addComponent(button8);
	    rowTop2.addComponent(button9);
	    rowTop2.addComponent(button10);
	    rowTop2.addComponent(button11);
	    rowTop2.addComponent(button12);
	    topToBottom.addGroup(rowTop2);*/
	  
	    
	    //topToBottom.addGroup(topToBottom0);
		layout.setHorizontalGroup(leftToRight);
	    layout.setVerticalGroup(topToBottom);
	    elevators.add(elevatorButtons);
	    panel1.add(cntr);
	}
  floors.add(elevators);
  panel.add(panel1);
	 }
  Controller.uiButtonsActionsList=floors;
  frame.add(panel);
  frame.pack();
    frame.setVisible(true);
  }

  ActionListener  action = new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand(); 
		String name = ((JButton)(e.getSource())).getName();
		
		if(command.contains("F"))
		{
			Character floor = command.split("-")[0].toCharArray()[1];
			String direction = command.split("-")[1];
			System.out.println("Floor Number:"+floor);
			System.out.println("Direction "+ direction);
			
			Person person =new Person(Controller.log,Integer.parseInt(floor.toString())-1,direction);
			Controller.persons.add(person);
			Thread th = new Thread(person);
			th.start();
		}else
		{
			Character floor = name.split("-")[0].toCharArray()[1];
			Character elevator= name.split("-")[1].toCharArray()[1];
			System.out.println("Other Buttons Clicked::"+name);
			for(Object obj: Controller.persons)
			{
				Person person = (Person)obj;
				if(person.getCurrentFloor()== Integer.parseInt(floor.toString()) && person.getCurrentElevatorNum()==
					Integer.parseInt(elevator.toString()))
				{
					person.setDestination(Integer.parseInt(command)-1);
					synchronized(person){
						person.notify();
					}
				}
			}
			
		}
	}
};

	
}

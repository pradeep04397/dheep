package Assignment1;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;


public class Controller {
	
private static Vector elevators;
public static int MAX_FLOORS=5;
public static int MAX_ELEVATORS=5;
public static int MAX_PERSONS=5;
public static List uiButtonsActionsList;
public static List persons = new ArrayList();
public static Logger log;

public static void hideButtons(int currentFloor, int elevatorNumber,List elevatorButtons) {
	for(Object obj: elevatorButtons)
	{
		JButton btn = (JButton)obj;
		if(btn.getName().equals("F"+currentFloor+"-E"+elevatorNumber+"01"))
		{
			btn.setEnabled(false);
		}else if(btn.getName().equals("F"+currentFloor+"-E"+elevatorNumber+"02"))
		{
			btn.setEnabled(false);
		}else if(btn.getName().equals("F"+currentFloor+"-E"+elevatorNumber+"03"))
		{
			btn.setEnabled(false);
		}else if(btn.getName().equals("F"+currentFloor+"-E"+elevatorNumber+"04"))
		{
			btn.setEnabled(false);
		}else if(btn.getName().equals("F"+currentFloor+"-E"+elevatorNumber+"05"))
		{
			btn.setEnabled(false);
		}
	}
}

public  static Vector getElevators() {
	return elevators;
}

public static void setElevators(Vector elev) {
	elevators = elev;
}


//scan algorithm multithreading
public  synchronized static  Elevator requestElevator(Person pr) {
	boolean noDirection = false;
	List elevatorsSubList = new ArrayList();
	Elevator nearElevator=null;
	for(Object obj : getElevators())
	{
		Elevator elv= (Elevator)obj;
		if(!elv.NO_DIRECTION && elv.personsInsideElevator.size()>0)
		{
			//if(pr.getCurrentFloor()<pr.getDestination() && pr.getCurrentFloor()!=elv.getCurrentFloor())
			if(pr.getDirection().equals("UP"))
			{
				if(elv.MOVING_UP)
				{
					elevatorsSubList.add(elv);
				}
			}else if(pr.getDirection().equals("DOWN"))
			//else if(pr.getCurrentFloor()>pr.getDestination() && pr.getCurrentFloor()!=elv.getCurrentFloor())
				{
				if(elv.MOVING_DOWN)
				{
					elevatorsSubList.add(elv);
				}
			}
		}else{
			elv.setCurrentFloor(pr.getCurrentFloor());
			nearElevator=elv;
			noDirection=true;
			break;
		}
	}
	
	if(!noDirection)
	{
		
		for(Object obj : elevatorsSubList)
		{
			Elevator elv = (Elevator)obj;
			if(null!=nearElevator)
			{
				int val1 = Math.abs(pr.getCurrentFloor()-nearElevator.getCurrentFloor());
				int val2 = Math.abs(pr.getCurrentFloor()-elv.getCurrentFloor());
				if(val1>val2)
				{
					nearElevator=elv;
				}
			}else
			{
				nearElevator=elv;
			}
		}
	}	
	return nearElevator;
}

public static void elevatorButtonsDisplay(Elevator elevator, Person person) {
	List  elevs =(List)uiButtonsActionsList.get(elevator.getCurrentFloor());
	List buttons =(List)elevs.get(elevator.getElevatorNum());
	hideButtons(elevator.getCurrentFloor(),elevator.getElevatorNum(), buttons);
	List  perElevs =(List)uiButtonsActionsList.get(person.getCurrentFloor());
	List perButtons =(List)elevs.get(elevator.getElevatorNum());
	enableButtons(person.getCurrentFloor(),elevator.getElevatorNum(),buttons);
	
	
}

private static void enableButtons(int perCurrentFloor, int elevatorNumber,List buttons) { 
	
	for(Object obj: buttons)
	{
		JButton btn = (JButton)obj;
		if(btn.getName().equals("F"+perCurrentFloor+"-E"+elevatorNumber+"01"))
		{
			btn.setEnabled(true);
		}else if(btn.getName().equals("F"+perCurrentFloor+"-E"+elevatorNumber+"02"))
		{
			btn.setEnabled(true);
		}else if(btn.getName().equals("F"+perCurrentFloor+"-E"+elevatorNumber+"03"))
		{
			btn.setEnabled(true);
		}else if(btn.getName().equals("F"+perCurrentFloor+"-E"+elevatorNumber+"04"))
		{
			btn.setEnabled(true);
		}else if(btn.getName().equals("F"+perCurrentFloor+"-E"+elevatorNumber+"05"))
		{
			btn.setEnabled(true);
		}
	}
	
}	

//printing();

}

package Assignment1;


import java.util.Vector;


public class Person implements Runnable{
private int currentFloor;
private Logger log=null;
public volatile boolean keeprunning;
private int activity;
public static final int WAITING=0;
private int personID;
public Thread person;
public Elevator elevator;
private int destination;
private int currentElevatorNum;

public int getCurrentElevatorNum() {
	return currentElevatorNum;
}
public void setCurrentElevatorNum(int currentElevatorNum) {
	this.currentElevatorNum = currentElevatorNum;
}


private String direction;


public String getDirection() {
	return direction;
}
public void setDirection(String direction) {
	this.direction = direction;
}
public int getPersonID() {
	return personID;
}
public void setPersonID(int personID) {
	this.personID = personID;
}

	public int getDestination() {
	return destination;
}
public void setDestination(int destination) {
	this.destination = destination;
}
	public int getCurrentFloor() {
	return currentFloor;
    }
    public void setCurrentFloor(int currentFloor) {
	this.currentFloor = currentFloor;
    }
    public synchronized void elevatorArrived(Elevator elevator) {        
        this.elevator = elevator;
     }
    
    public Person(Logger log,int currentFloor,String direction)
    {
    	this.log = log;
    	this.setCurrentFloor(currentFloor);
    	this.setDirection(direction);
    	
    }
    
	@SuppressWarnings("unused")
	public void run() {
		keeprunning=true;
  	    activity=WAITING;
		
	 /*   while(keeprunning){
*/	       log.write("PERSON-"  +this.getPersonID() + " Initialized ");
		   System.out.println("PERSON-"  +this.getPersonID() + " Initialized ");
		   switch(activity){
		   
		   case WAITING:
			
			try {
				
				 //setCurrentFloor(((int) (1 + ((Math.random() * 10000) % (Controller.MAX_FLOORS )))));
				// setDestination();
				Elevator elv = Controller.requestElevator(this);
				this.setCurrentElevatorNum(elv.getElevatorNum());
				
				try {
					if(null!=elv)
					{
					enterElevator(elv);
					}else
					{
						
						log.write("Person-- "  +this.getPersonID()+ "is waiting for an elevator");
						System.out.println("Person-- "  +this.getPersonID()+ "is waiting for an elevator");
                               synchronized(this)
                               {
                            	   this.wait(1000);
                               }
					}
					 
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			}
          
/*		   }*/ 
	   
	}
	
	private synchronized void enterElevator(Elevator elevator) throws InterruptedException  {
		
		/*log.write("Person-" +this.getPersonID()+" **is at Floor-" +getCurrentFloor());
		System.out.println("Person-" +this.getPersonID()+" **is at Floor-" +getCurrentFloor() );
	         //we don't get here unless we entered the elevator
*/	        Controller.elevatorButtonsDisplay(elevator,this); 
			//this.wait();
			elevator.setDestination(this.getDestination(),this);
			if(elevator.isThisElevatorWait())
	        {
	       	 elevator.setThisElevatorWait(false);
	       	 synchronized (elevator) {
	       		 //notifying the elevator on the continous wait did in intial time
	       		 elevator.notify();
	       		/* log.write("Person--"   +this.getPersonID()+  "received Elevator-" +elevator.getElevatorNum());
	       		 System.out.println("Person--"  +this.getPersonID()+  " received Elevator-"  +elevator.getElevatorNum());*/
				}
	        }
			
			//Person waits inside the lift till it arrives to his destination 
			this.wait();
			
			//Person goes to his destination for other activity after reaching destination floor
			this.wait(2000);
			log.write("Person--"  +this.getPersonID()+  "Reached Floor-"+this.getDestination());
			System.out.println("Person--" +this.getPersonID()+  "Reached Floor-"+this.getDestination());
	         
	}
	
	
	/*private  synchronized  void setDestination() throws InterruptedException {
		
		while(true)
		{
		//int dest = (int) (1 + ((Math.random() * 10000) % (Controller.MAX_FLOORS )));
			if(dest!=this.getCurrentFloor())
			{
				this.setDestination(dest);
				break;
			}
		}
		log.write("person-- "  + this.getPersonID()+  "whose current floor is " +this.getCurrentFloor()+  " set destination to" + this.getDestination());
		System.out.println("person-- "  + this.getPersonID()+  "whose current floor is " +this.getCurrentFloor()+ " set destination to" + this.getDestination());
		
	}*/
	
}

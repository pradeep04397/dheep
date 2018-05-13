package Assignment1;


import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Elevator implements Runnable{

	
	public int currentFloor=0;
	private int elevatorNum;
	private boolean keepRunning;
	private int activity;
	 private boolean motionDirection;
	 public Vector personsInsideElevator =  new Vector();
	 private Logger log;
	 private boolean isThisElevatorWait=false;
		
		public Thread elevator;
	    public static   boolean MOVING_UP = false;
		   public static boolean NO_DIRECTION = true;
		   public static boolean MOVING_DOWN = false;
		   public boolean isDestinationSet;
		   public static Boolean MOVING = false;
	   
	  
	 
	 public boolean isThisElevatorWait() {
		return isThisElevatorWait;
	}

	public void setThisElevatorWait(boolean isThisElevatorWait) {
		this.isThisElevatorWait = isThisElevatorWait;
	}


	
	 //defining some common variable to set destination for elevators
	 public Elevator(int elevatorNumber,Logger log){
		 this.log = log;
	      this.setElevatorNum(elevatorNumber);
	      this.setCurrentFloor(1);
	      this.NO_DIRECTION=false;
	      this.MOVING_DOWN=false;
	      this.MOVING_UP=true;
	     
	   }

	public int getElevatorNum() {
		return elevatorNum;
	}

	public void setElevatorNum(int elevatorNum) {
		this.elevatorNum = elevatorNum;
	}
	
	 public void start() {
	      
	      keepRunning = true;
	        elevator = new Thread(this);
	         //activeElevator.setDaemon(true);
	         elevator.setPriority(Thread.NORM_PRIORITY - 1);
	         elevator.start();
	          
	         log.write("Elevator---" +this.getElevatorNum()+ " has started---");
	         System.out.println("Elevator---" +this.getElevatorNum()+ " has started---");
	      
	   } 

	public int getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}
	public void run() {
		while(true)travel();
		
			
	}
		
	private synchronized void travel() {

	
		if(this.NO_DIRECTION)
		{
			this.NO_DIRECTION=true;
            this.MOVING_UP=false;
            this.MOVING_DOWN=false;
			//motionState = MOVING;
			continuousWait();
		}
		else if(this.MOVING_UP){
            motionDirection = MOVING_UP;           
            if(this.personsInsideElevator.size()>0)
            {
            moveUp();
            log.write("elevator--" +this.getElevatorNum()+ " which is at "+this.getCurrentFloor()+"--is set the direction to move up");
            System.out.println("elevator" +this.getElevatorNum()+ " which is at "+this.getCurrentFloor()+"--is set the direction to move up");
            }else
            {
            	continuousWait();
            }
		}
		else if(this.MOVING_DOWN){
			motionDirection=MOVING_DOWN;
			moveDown();
			log.write("elevator--" +this.getElevatorNum() + "which is at "+this.getCurrentFloor()+"--is set the direction to move down");
			System.out.println("elevator-" +this.getElevatorNum() + "which is at "+this.getCurrentFloor()+"--is set the direction to move down");
		}
		
	}

	private synchronized void setDirection() {
		if(personsInsideElevator.size()>0)
		{
			for(Object obj: personsInsideElevator)
			{
				Person person=(Person)obj;
				
				if(person.getDestination()<this.getCurrentFloor())
				{
					this.NO_DIRECTION=false;
					this.MOVING_UP=false;
					this.MOVING_DOWN=true;
					this.MOVING=true;
				}else
				{
					this.NO_DIRECTION=false;
					this.MOVING_UP=true;
					this.MOVING_DOWN=false;
					this.MOVING=true;
				}
			}
			
		}else
		{
			this.NO_DIRECTION=true;
			this.MOVING_UP=false;
			this.MOVING_DOWN=false;
			this.MOVING=false;
		}
	}

	private synchronized void moveDown() {
		// TODO Auto-generated method stub
		while(true)
		{
			if(currentFloor!=0)
			{
			currentFloor=currentFloor-1;
			}
			else
			{
				this.NO_DIRECTION=false;
				this.MOVING_UP=true;
				this.MOVING_DOWN=false;
				this.MOVING=true;
				break;
			}
			
			try {
				//waitPersonsInLift();
				waitEl();
				dropPersonsFromLift();
				if(this.personsInsideElevator.size()==0)
				{
					continuousWait();
					break;
				}
				log.write("Elevator--"  +this.getElevatorNum()+ "is moved down to" + currentFloor);
				System.out.println("Elevator--"  +this.getElevatorNum()+ "is moved down to" + currentFloor);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	
	private synchronized void moveUp() {
		
		while(true)
		{
			if(currentFloor !=Controller.MAX_FLOORS)
			{
			currentFloor=currentFloor+1;
			}
			else
			{
				this.NO_DIRECTION=false;
				this.MOVING_UP=false;
				this.MOVING_DOWN=true;
				this.MOVING=true;
				break;
			}
			try {
				//waitPersonsInLift();
				waitEl();
				dropPersonsFromLift();
				if(this.personsInsideElevator.size()==0)
				{
					continuousWait();
					break;
				}
				log.write("Elevator "  +this.getElevatorNum()+ "is moved to" + currentFloor);
				System.out.println("Elevator "  +this.getElevatorNum()+ "is moved to" + currentFloor);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	
	//setElevatorFloor();
	
	
	private synchronized void dropPersonsFromLift() throws InterruptedException
	{
		int personsLeft[] = new int[personsInsideElevator.size()];
		int size = personsInsideElevator.size();
		for(int i=0;i<size;i++)
		{
			 Person person = ((Person)personsInsideElevator.get(i));
			if(person.getDestination()==this.getCurrentFloor())
			{
				person.setCurrentFloor(this.getCurrentFloor());
				personsLeft[i]=i; }
			else {
			  personsLeft[i]=-1;
		  }
	   }
		for(int j=0;j<personsLeft.length;j++)
		{
			if(personsLeft[j]!=-1)
			{
				Person person = ((Person)personsInsideElevator.get(j));
				personsInsideElevator.remove(person);
				synchronized(person)
				{
					person.notify();
					//notifing the user once reached destination
				}
			}
		}
		
	}
	public synchronized void setDestination(int Floor,Person person) throws InterruptedException {
		
		personsInsideElevator.add(person);
		log.write("Person-"+person.getPersonID()+"-enters into Elevator-"+this.getElevatorNum());
		System.out.println("Person-"+person.getPersonID()+"-enters into Elevator-"+this.getElevatorNum());
		this.setDirection();
				
	}
	
	public synchronized void continuousWait() 
	{
		log.write("Elevator-" + this.getElevatorNum()+ " is waiting at floor-"+this.getCurrentFloor());
		System.out.println("Elevator-" + this.getElevatorNum()+ " is waiting at floor-"+this.getCurrentFloor());
		System.out.println("=============================================");
		try
		{
			this.setThisElevatorWait(true);
			synchronized (this) {
				this.wait();
				//Thread.sleep(3000);
			}
		
		System.out.println("");
		}
		catch(Exception ex)
		{
			ex.toString();
		}
	}
	
	public synchronized void waitEl() throws InterruptedException
	{
		try
		{
			System.out.println("Normal Wait Called elevator" + this.getElevatorNum());
			System.out.println("=============================================");
		    Thread.sleep(3000);
		}
		catch(Exception ex)
		{
			ex.toString();
		}
	}
	
	
	
}

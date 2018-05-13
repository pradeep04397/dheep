package Assignment1;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ElevatorStart {

	public static final int MaxElevators=5;
	public static final int Maxpersons=10;
	private Vector elevators;
	Logger log = null;
	
	public ElevatorStart() throws InterruptedException{
		log= new Logger("log");
		Controller.log=log;
		startElevators(log);
		//initializePersons(log);

	}
	
	public static void main(String args[]) throws InterruptedException
	{
		UserConsole ec = new UserConsole();
		ApplicationWindow window = new ApplicationWindow();
		try {
			ElevatorStart EC= new ElevatorStart();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		//SheildMain.main(null);
	}
	
	/*private void initializePersons(Logger log) throws InterruptedException {
		for(int i=0;i<Controller.MAX_PERSONS;i++)
		{
			Person p = new Person(log);
		p.setPersonID(i);
		Thread person= new Thread(p);
    	person.start();
    	person.sleep(1000);
		}
	}*/
	
	 // private ExecutorService executor = Executors.newFixedThreadPool(50);
	private void startElevators(Logger log) {
		elevators = new Vector();
		for(int i = 0; i < Controller.MAX_ELEVATORS; i++){
			Elevator e =new Elevator(i,log);
			elevators.add(e);
			 e.start();
	      }
		Controller.setElevators(elevators);
	}
}

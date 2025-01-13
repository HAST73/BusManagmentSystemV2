import java.util.*;

public class BusManagementSystemModel implements IModelController {

	private ArrayList<Passenger> passengers = new ArrayList<>();
	private ArrayList<Ticket> tickets = new ArrayList<>();
	private static BusManagementSystemModel instance;
	private ArrayList<Delay> delays = new ArrayList<>();
	private ArrayList<Dispatcher> dispatchers = new ArrayList<>();
	private ArrayList<BusDriver> busDrivers = new ArrayList<>();
	private ArrayList<User> users = new ArrayList<>();
	private ArrayList<Impediment> impediments = new ArrayList<>();
	private GPSDevice gpsDeviceControl;
	private ArrayList<Payment> payments = new ArrayList<>();
	private ArrayList<NotificationManager> notificationManager;

	public BusManagementSystemModel() {
	}

	@Override
	public ArrayList<Ticket> getTickets(){
		throw new UnsupportedOperationException();
	}

	@Override
	public ArrayList<Delay> getDelays(){
		throw new UnsupportedOperationException();
	}

	@Override
	public ArrayList<Dispatcher> getDispatchers(){
		throw new UnsupportedOperationException();
	}

	@Override
	public ArrayList<BusDriver> getBusDrivers(){
		throw new UnsupportedOperationException();
	}

	@Override
	public ArrayList<User> getUsers(){
		throw new UnsupportedOperationException();
	}

	@Override
	public ArrayList<Passenger> getPassengers(){
		throw new UnsupportedOperationException();
	}

	@Override
	public ArrayList<Impediment> getImpediments(){
		throw new UnsupportedOperationException();
	}

	@Override
	public ArrayList<Payment> getPayments(){
		throw new UnsupportedOperationException();
	}

	@Override
	public GPSDevice getGpsDeviceControl(){
		throw new UnsupportedOperationException();
	}

	@Override
	public NotificationManager getNotificationManager(){
		throw new UnsupportedOperationException();
	}


}
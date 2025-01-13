import java.util.ArrayList;

public interface IModelController {

	ArrayList<Ticket> getTickets();

	ArrayList<Delay> getDelays();

	ArrayList<Dispatcher> getDispatchers();

	ArrayList<BusDriver> getBusDrivers();

	ArrayList<User> getUsers();

	ArrayList<Passenger> getPassengers();

	ArrayList<Impediment> getImpediments();

	GPSDevice getGpsDeviceControl();

	ArrayList<Payment> getPayments();

	NotificationManager getNotificationManager();

}
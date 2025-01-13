import java.util.ArrayList;

public class BusDriver extends User {

	private int driverID;
	private ArrayList<Impediment> impedimentControl;
	private GPSDevice gpsDeviceHolder;

	public int getDriverID() {
		return this.driverID;
	}

	/**
	 * 
	 * @param driverID
	 */
	public void setDriverID(int driverID) {
		this.driverID = driverID;
	}

	/**
	 * 
	 * @param impedimentControl
	 */
	public void setImpedimentControl(Impediment impedimentControl) {
		// TODO - implement BusDriver.setImpedimentControl
		throw new UnsupportedOperationException();
	}

	public ArrayList<Impediment> getImpedimentControl() {
		// TODO - implement BusDriver.getImpedimentControl
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param impedimentControl
	 */
	public void setImpedimentControl(ArrayList<Impediment> impedimentControl) {
		// TODO - implement BusDriver.setImpedimentControl
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param driverID
	 * @param name
	 * @param surname
	 * @param email
	 * @param password
	 * @param iC
	 */
	public BusDriver(int driverID, String name, String surname, String email, String password, ArrayList<Impediment> iC) {
		// TODO - implement BusDriver.BusDriver
		super(name, surname, email, password);
		this.driverID = driverID;
		this.impedimentControl = iC;
	}

}
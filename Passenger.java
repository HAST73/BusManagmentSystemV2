public abstract class Passenger extends User implements Subscriber {

	private int passengerID;

	public int getPassengerID() {
		return this.passengerID;
	}

	/**
	 * 
	 * @param passengerID
	 */
	public void setPassengerID(int passengerID) {
		this.passengerID = passengerID;
	}

	/**
	 * 
	 * @param passengerID
	 * @param name
	 * @param surname
	 * @param email
	 * @param password
	 */
	public Passenger(int passengerID, String name, String surname, String email, String password) {
		// TODO - implement Passenger.Passenger
		super(name, surname, email, password);
		this.passengerID = passengerID;
	}

}
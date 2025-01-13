import java.util.*;

public class Dispatcher extends User {

	private int dispatcherID;
	private ArrayList<Delay> delay;

	public int getDispatcherID() {
		return this.dispatcherID;
	}

	/**
	 * 
	 * @param dispatcherID
	 */
	public void setDispatcherID(int dispatcherID) {
		this.dispatcherID = dispatcherID;
	}

	/**
	 * 
	 * @param dispatcherID
	 * @param name
	 * @param surname
	 * @param email
	 * @param password
	 * @param delay
	 */
	public Dispatcher(int dispatcherID, String name, String surname, String email, String password, ArrayList<Delay> delay) {
		super(name,surname,email,password);
		this.dispatcherID = dispatcherID;
		this.delay = delay;
	}

	public ArrayList<Delay> getDelay() {
		return this.delay;
	}

	/**
	 * 
	 * @param delay
	 */
	public void setDelay(ArrayList<Delay> delay) {
		this.delay = delay;
	}

}
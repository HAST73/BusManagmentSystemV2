import java.util.*;

public class Delay {

	private float gpsDelay;
	private float systemDelay;
	private String delayStatus;
	private ArrayList<Route> useRoute;
	private ArrayList<Impediment> useImpediment;
	private GPSDevice gpsDevice;

	public float getGpsDelay() {
		return this.gpsDelay;
	}

	/**
	 * 
	 * @param gpsDelay
	 */
	public void setGpsDelay(float gpsDelay) {
		this.gpsDelay = gpsDelay;
	}

	public float getSystemDelay() {
		return this.systemDelay;
	}

	/**
	 * 
	 * @param systemDelay
	 */
	public void setSystemDelay(float systemDelay) {
		this.systemDelay = systemDelay;
	}

	public String getDelayStatus() {
		return this.delayStatus;
	}

	/**
	 * 
	 * @param delayStatus
	 */
	public void setDelayStatus(String delayStatus) {
		this.delayStatus = delayStatus;
	}

	public ArrayList<Route> getUseRoute() {
		return this.useRoute;
	}

	/**
	 * 
	 * @param useRoute
	 */
	public void setUseRoute(ArrayList<Route> useRoute) {
		this.useRoute = useRoute;
	}

	/**
	 * 
	 * @param gD
	 * @param sD
	 * @param dS
	 * @param uR
	 * @param uI
	 */
	public Delay(float gD, float sD, String dS, Route uR, Impediment uI) {
		// TODO - implement Delay.Delay
		throw new UnsupportedOperationException();
	}

}
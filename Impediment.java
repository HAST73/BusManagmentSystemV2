public class Impediment {

	private int impedimentID;
	private String description;
	private Route route;
	private ImpedimentType impedimentType;
	private Date date;

	public int getImpedimentID() {
		return this.impedimentID;
	}

	/**
	 * 
	 * @param impedimentID
	 */
	public void setImpedimentID(int impedimentID) {
		this.impedimentID = impedimentID;
	}

	public String getDescription() {
		return this.description;
	}

	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public Route getRoute() {
		return this.route;
	}

	/**
	 * 
	 * @param route
	 */
	public void setRoute(Route route) {
		this.route = route;
	}

	public ImpedimentType getImpedimentType() {
		return this.impedimentType;
	}

	/**
	 * 
	 * @param impedimentType
	 */
	public void setImpedimentType(ImpedimentType impedimentType) {
		this.impedimentType = impedimentType;
	}

	/**
	 * 
	 * @param iID
	 * @param desc
	 * @param route
	 * @param iT
	 */
	public Impediment(int iID, String desc, Route route, ImpedimentType iT) {
		// TODO - implement Impediment.Impediment
		throw new UnsupportedOperationException();
	}

	public Date getDate() {
		return this.date;
	}

	/**
	 * 
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

}
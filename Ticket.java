public class Ticket {

	private int ticketID;
	private float price;
	private Passenger passenger;
	private TicketType ticketType;
	private Date concreteDate;
	private Route concreteRoute;
	private int quantity;
	private Payment payment;
	private int passengerID;

	public Passenger getPassenger() {
		return this.passenger;
	}

	/**
	 * 
	 * @param passengerID
	 */
	public void setPassenger(int passengerID) {
		this.passengerID = passengerID;
	}

	public TicketType getTicketType() {
		return this.ticketType;
	}

	/**
	 * 
	 * @param ticketType
	 */
	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}

	public Route getConcreteRoute() {
		return this.concreteRoute;
	}

	/**
	 * 
	 * @param concreteRoute
	 */
	public void setConcreteRoute(Route concreteRoute) {
		this.concreteRoute = concreteRoute;
	}

	public Date getConcreteDate() {
		return this.concreteDate;
	}

	/**
	 * 
	 * @param concreteDate
	 */
	public void setConcreteDate(Date concreteDate) {
		this.concreteDate = concreteDate;
	}

	public int getTicketID() {
		return this.ticketID;
	}

	public float getPrice() {
		return this.price;
	}

	/**
	 * 
	 * @param tID
	 * @param price
	 * @param pass
	 * @param tType
	 * @param cDate
	 * @param cRoute
	 * @param quantity
	 */
	public Ticket(int tID, float price, Passenger pass, TicketType tType, Date cDate, Route cRoute, int quantity) {
		this.ticketID = tID;
		this.price = price;
		this.passenger = pass;
		this.ticketType = tType;
		this.concreteDate = cDate;
		this.concreteRoute = cRoute;
		this.quantity = quantity;
	}

	public Ticket(float price, TicketType tType, Date cDate, Route cRoute, int quantity) {
		this.price = price;
		this.ticketType = tType;
		this.concreteDate = cDate;
		this.concreteRoute = cRoute;
		this.quantity = quantity;
	}

	public int getQuantity() {
		return this.quantity;
	}

	/**
	 * 
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * 
	 * @param price
	 */
	public void setPrice(float price) {
		this.price = price;
	}

}
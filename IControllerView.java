public interface IControllerView {

	TicketType getTicketChoice(Ticket ticket);

	Route getRouteChoice(Ticket ticket);

	Date getDateChoice(Ticket ticket);

	int getQuantity(Ticket ticket);

	Payment getPaymentMethod();

	Ticket getSelectedTicket();

	Passenger getPassengerData();

	int getChoice();

	String getInputEmail();

	String getInputPassword();

	int getOptionsChoice();

	String getImpedimentRoute();

	String getDelayNotificationDetails();

	String getBlikCode();

	String getCardNumber();

	String getCVV();

	String getExpiryDate();

	String getRole();

	Impediment getImpedimentDetails();

	/**
	 * 
	 * @param prompt
	 */
	boolean confirmAction(String prompt);

	void resetView();

	void initializeView();

}
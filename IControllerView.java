public interface IControllerView {
	TicketType getTicketChoice(Ticket var1);

	Route getRouteChoice(Ticket var1);

	Date getDateChoice(Ticket var1);

	int getQuantity(Ticket var1);

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

	void getCardNumber();

	String getCVV();

	String getExpiryDate();

	String getRole();

	Impediment getImpedimentDetails();

	boolean confirmAction(String var1);

	void resetView();

	void initializeView();
}
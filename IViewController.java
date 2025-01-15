public interface IViewController {
	void displayMenuOptions();

	void displayTicketType();

	void displayRoute();

	void displayQuantity();

	void displaySelectedTicket(TicketType var1, Route var2, Date var3, int var4);

	void displayBlikMessage();

	void displayCardMessage();

	void displayPaymentSuccess(String var1);

	void displayAddImpedimentOption();

	void displayCompareDelaysOption();

	void displaySendNotificationToPassengers(String var1);

	void updateView(String var1, Object var2);

	void displayPaymentMethods();

	void displayLogin(String var1, String var2);

	void displayTicketsForRoute(String var1);

	void displayTicketsForDate(String var1);

	void displayTicketPurchaseQuantity(int var1);

	void displayAvailableTicketsWithDiscounts(TicketType var1);

	void displayRoleChoice();

	void displayError(String var1);

	void displaySuccess(String var1);
}
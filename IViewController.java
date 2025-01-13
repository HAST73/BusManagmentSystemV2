import java.util.ArrayList;

public interface IViewController {

	void displayMenuOptions();

	void displayTicketType();

	void displayRoute();

	void displayQuantity();

	void displaySelectedTicket(TicketType ticketType, Route route, Date date, int quantity);

	void displayBlikMessage();

	void displayCardMessage();

	/**
	 *
	 * @param paymentType
	 */
	void displayPaymentSuccess(String paymentType);

	void displayAddImpedimentOption();

	void displayCompareDelaysOption();

	/**
	 *
	 * @param delayStatus
	 */
	void displaySendNotificationToPassengers(String delayStatus);

	/**
	 *
	 * @param updateType
	 * @param data
	 */
	void updateView(String updateType, Object data);

	void displayPaymentMethods();

	/**
	 *
	 * @param email
	 * @param password
	 */
	void displayLogin(String email, String password);

	/**
	 *
	 * @param route
	 */
	void displayTicketsForRoute(String route);

	/**
	 *
	 * @param date
	 */
	void displayTicketsForDate(String date);

	/**
	 *
	 * @param quantity
	 */
	void displayTicketPurchaseQuantity(int quantity);

	/**
	 *
	 * @param ticketType
	 */
	void displayAvailableTicketsWithDiscounts(TicketType ticketType);

	void displayRoleChoice();

	/**
	 *
	 * @param s
	 */
	void displayError(String s);

	/**
	 *
	 * @param s
	 */
	void displaySuccess(String s);

}
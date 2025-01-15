public interface IPaymentStrategy {

	boolean processPayment();

	/**
	 * 
	 * @param priceTicket
	 */
	boolean processPayment(Ticket priceTicket);

	/**
	 * 
	 * @param blikCode
	 */
	boolean isValidBlikCode(String blikCode);

	boolean isValidCardDetails();

	boolean isValidCardNumber(String cardNumber);

	boolean isValidCVV(String cvv);

	boolean isValidExpiryDate(String expiryDate);

}
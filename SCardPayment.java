public abstract class SCardPayment implements IPaymentStrategy {

	/**
	 * 
	 * @param priceTicket
	 */
	public boolean processPayment(Ticket priceTicket) {
		// TODO - implement SCardPayment.processPayment
		throw new UnsupportedOperationException();
	}

	public boolean isValidCardDetails() {
		// TODO - implement SCardPayment.isValidCardDetails
		throw new UnsupportedOperationException();
	}

	public boolean isValidCardNumber() {
		// TODO - implement SCardPayment.isValidCardNumber
		throw new UnsupportedOperationException();
	}

	public boolean isValidCVV() {
		// TODO - implement SCardPayment.isValidCVV
		throw new UnsupportedOperationException();
	}

	public boolean isValidExpiryDate() {
		// TODO - implement SCardPayment.isValidExpiryDate
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param cardNumber
	 * @param cvv
	 * @param expiryDate
	 */
	public SCardPayment(String cardNumber, String cvv, String expiryDate) {
		// TODO - implement SCardPayment.SCardPayment
		throw new UnsupportedOperationException();
	}

}
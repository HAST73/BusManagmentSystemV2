public class SBlikPayment implements IPaymentStrategy {

	@Override
	public boolean processPayment() {
		return false;
	}

	/**
	 * 
	 * @param priceTicket
	 */
	@Override
	public boolean processPayment(Ticket priceTicket) {
		// TODO - implement SBlikPayment.processPayment
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param blikCode
	 */
	@Override
	public boolean isValidBlikCode(String blikCode) {
		// Sprawdź, czy format jest poprawny
		if (blikCode.matches("\\d{3} \\d{3}")) {
			System.out.println("Kod BLIK jest poprawny");
			return true;
		} else {
			System.out.println("Niepoprawny format! Kod BLIK powinien mieć format XXX XXX.");
			return false;
		}
	}

	@Override
	public boolean isValidCardDetails() {
		return false;
	}

	@Override
	public boolean isValidCardNumber(String cardNumber) {
		return false;
	}

	@Override
	public boolean isValidCVV(String cvv) {
		return false;
	}

	@Override
	public boolean isValidExpiryDate(String expiryDate) {
		return false;
	}

	public SBlikPayment() {
	}

}
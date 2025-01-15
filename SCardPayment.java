public class SCardPayment implements IPaymentStrategy {


	@Override
	public boolean isValidCardNumber(String cardNumber) {
		if (cardNumber.matches("\\d{16}")) {
			System.out.println("Numer karty jest poprawny");
			return true;
		} else {
			System.out.println("Numer karty powinien zawierać dokładnie 16 cyfr!");
			return false;
		}
	}

	@Override
	public boolean isValidCVV(String cvv) {
		if (cvv.matches("\\d{3}")) {
			System.out.println("Kod cvv jest poprawny");
			return true;
		} else {
			System.out.println("Numer CVV powinien zawierać dokładnie 3 cyfry!");
			return false;
		}
	}

	@Override
	public boolean isValidExpiryDate(String expiryDate) {
		if (expiryDate.matches("(0[1-9]|1[0-2])/\\d{2}")) {
			System.out.println("Data jest poprwana");
			return true;
		} else {
			System.out.println("Niepoprawny format daty! Wprowadź w formacie MM/YY (np. 12/25).");
			return false;
		}
	}



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
		// TODO - implement SCardPayment.processPayment
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isValidBlikCode(String blikCode) {
		return false;
	}

	@Override
	public boolean isValidCardDetails() {
		// TODO - implement SCardPayment.isValidCardDetails
		throw new UnsupportedOperationException();
	}


	public SCardPayment() {

	}

}
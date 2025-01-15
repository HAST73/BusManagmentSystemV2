public class CardPayment {

	private String cardNumber;
	private String cvv;
	private String expiryDate;

	public String getCardNumber() {
		return this.cardNumber;
	}

	/**
	 * 
	 * @param cardNumber
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCvv() {
		return this.cvv;
	}

	/**
	 * 
	 * @param cvv
	 */
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getExpiryDate() {
		return this.expiryDate;
	}

	/**
	 * 
	 * @param expiryDate
	 */
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * 
	 * @param cardNumber
	 * @param cvv
	 * @param exDate
	 */
	public CardPayment(String cardNumber, String cvv, String exDate) {
		// TODO - implement CardPayment.CardPayment
		throw new UnsupportedOperationException();
	}

	public CardPayment() {
	}

}
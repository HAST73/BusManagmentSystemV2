import java.util.*;

public class Payment {

	private int paymentID;
	private BlikPayment blikPayment;
	private CardPayment cardPayment;

	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}

	public int getPaymentID() {
		return this.paymentID;
	}

	public BlikPayment getBlikPayment() {
		return this.blikPayment;
	}

	/**
	 * 
	 * @param blikPayment
	 */
	public void setBlikPayment(BlikPayment blikPayment) {
		this.blikPayment = blikPayment;
	}

	public CardPayment getCardPayment() {
		// TODO - implement Payment.getCardPayment
		return this.cardPayment;
	}

	/**
	 * 
	 * @param cardPayment
	 */
	public void setCardPayment(CardPayment cardPayment) {
		this.cardPayment = cardPayment;
	}

	public Payment() {
	}

}
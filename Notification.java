public class Notification {

	private int notificationID;
	private String content;
	private Impediment relatedImpediment;
	private User recipient;
	private Impediment attribute;
	private User attribute2;

	public int getNotificationID() {
		return this.notificationID;
	}

	/**
	 * 
	 * @param notificationID
	 */
	public void setNotificationID(int notificationID) {
		this.notificationID = notificationID;
	}

	public String getContent() {
		return this.content;
	}

	/**
	 * 
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	public Impediment getRelatedImpediment() {
		return this.relatedImpediment;
	}

	/**
	 * 
	 * @param relatedImpediment
	 */
	public void setRelatedImpediment(Impediment relatedImpediment) {
		this.relatedImpediment = relatedImpediment;
	}

	public User getRecipient() {
		return this.recipient;
	}

	/**
	 * 
	 * @param recipient
	 */
	public void setRecipient(User recipient) {
		this.recipient = recipient;
	}

}
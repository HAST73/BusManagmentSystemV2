import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Date {

	private String date;
	private String time;

	public Date(String date, String time) {
		this.date = date;
		this.time = time;
	}
	public Date() {
	}

	public String getDate() {
		return this.date;
	}

	public String getTime() {
		return this.time;
	}

	/**
	 * 
	 * @param date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * 
	 * @param time
	 */
	public void setTime(String time) {
		this.time = time;
	}

	public void setCurrentDateTime() {
		// Pobierz aktualną datę i godzinę
		LocalDateTime now = LocalDateTime.now();

		// Ustaw formatery
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

		// Przypisz sformatowaną datę i godzinę do pól
		this.date = now.format(dateFormatter);
		this.time = now.format(timeFormatter);
	}

}
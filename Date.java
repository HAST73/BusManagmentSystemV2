
import java.time.LocalDate;
import java.time.LocalTime;

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
		LocalDate inputDate = LocalDate.now();
		LocalTime inputTime = LocalTime.now();
		this.setDate(String.valueOf(inputDate));
		this.setTime(String.valueOf(inputTime));
	}

}
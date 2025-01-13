public interface DelayCalculator {

	/**
	 * 
	 * @param impedimentID
	 */
	float calculateDelay(int impedimentID);

	/**
	 * 
	 * @param impedimentID
	 * @param location
	 */
	float calculateDelayWithGPS(int impedimentID, String location);

}
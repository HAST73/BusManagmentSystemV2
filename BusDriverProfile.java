import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BusDriverProfile {

	private ArrayList<Impediment> impedimentsBusDriverProfile = new ArrayList<>();
	private BusManagementSystemController busManagementBusDriver;

	/**
	 * 
	 * @param impediment
	 */
	public void addImpediment(Impediment impediment) { // ja bym tutaj dal arrayliste chyba jako argument
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("opoznienie.txt", true))) {
			// Zapisujemy datę i opis w jednym wierszu
			writer.write(impediment.getDate().getDate() + " " + impediment.getDescription());
			writer.newLine();  // Przechodzimy do nowej linii
		} catch (IOException e) {
			System.out.println("Błąd podczas zapisywania do pliku: " + e.getMessage());
		}
	}

	public String updateGPSLocation() {
		// TODO - implement BusDriverProfile.updateGPSLocation
		throw new UnsupportedOperationException();
	}

}
import java.util.ArrayList;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class TicketDAO {

	private static TicketDAO instance;
	private ArrayList<Ticket> activeTickets = new ArrayList<>();
	private static int maxActiveTickets = 30;

	private TicketDAO(ArrayList<Ticket> activeTickets) {
		this.activeTickets = activeTickets;
	}

	public TicketDAO() {

	}

	public static TicketDAO getInstance(ArrayList<Ticket> activeTickets) {
		if (instance == null) {
			instance = new TicketDAO(activeTickets);
		}
		return instance;
	}


	public void addTicketToSystem(String data, List<Integer> numbers) {
		// Formatowanie ciągu do zapisu w pliku
		String numbersStr = String.join(",", numbers.stream().map(String::valueOf).toArray(String[]::new));
		String line = data + " " + numbersStr + System.lineSeparator();

		// Dopisywanie do pliku
		try {
			Files.write(Paths.get("tickets.txt"), line.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	// Metoda sprawdzająca, czy data istnieje w pliku i zwracająca tablicę liczb
	public List<Integer> checkDateInSystem(String date) throws IOException {
		// Sprawdzanie, czy plik istnieje
		Path filePath = Paths.get("tickets.txt");
		if (!Files.exists(filePath)) {
			return null;
		}

		// Lista do przechowywania wszystkich wierszy poza usuniętym
		List<String> remainingLines = new ArrayList<>();
		List<Integer> numbers = null;

		// Odczyt pliku linia po linii
		List<String> lines = Files.readAllLines(filePath);
		for (String line : lines) {
			String[] parts = line.split(" ", 2);
			if (parts[0].equals(date)) {
				// Parsowanie liczb do listy Integer
				String[] numberStrings = parts[1].split(",");
				numbers = new ArrayList<>();
				for (String numStr : numberStrings) {
					numbers.add(Integer.parseInt(numStr));
				}
			} else {
				remainingLines.add(line);
			}
		}

		// Nadpisanie pliku pozostałymi wierszami
		Files.write(filePath, remainingLines, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE);

		// Zwracamy znalezione liczby lub null, jeśli data nie istnieje
		return numbers;
	}

	/**
	 * @param ticketID
	 */
	public void cleanTicketByID(int ticketID) {
		this.activeTickets.remove(ticketID);
	}

	/**
	 * @param quantity
	 */
	public boolean checkAvailability(int quantity) {
		int availableTickets = activeTickets.size();

		if (availableTickets + quantity > maxActiveTickets) {
			System.out.println("nie da rady");
			return false;
		}
		return true;
	}
}
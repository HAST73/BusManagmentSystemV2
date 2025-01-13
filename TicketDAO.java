import java.util.ArrayList;

public class TicketDAO {

	private static TicketDAO instance;
	private ArrayList<Ticket> activeTickets = new ArrayList<>();
	private static int maxActiveTickets = 30;

	private TicketDAO(ArrayList<Ticket> activeTickets) {
		this.activeTickets = activeTickets;
	}

	public static TicketDAO getInstance(ArrayList<Ticket> activeTickets) {
		if (instance == null) {
			instance = new TicketDAO(activeTickets);
		}
		return instance;
	}

	/**
	 * @param ticket
	 */
	public void addTicketToSystem(Ticket ticket) {
		this.activeTickets.add(ticket);
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
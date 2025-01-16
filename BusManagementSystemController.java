import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Sterowanie przebiegiem zakupu biletu.
 */
public class BusManagementSystemController implements IControllerView {

	private TicketDAO ticketDAO;
	private IPaymentStrategy paymentStrategy;
	private ArrayList<PassengerProfile> passengerProfile;
	private ArrayList<DispatcherProfile> dispatcherProfiles;
	private ArrayList<BusDriverProfile> busDriverProfiles;
	private ArrayList<RouteImpedimentResolver> routeIssueResolver;
	Scanner scanner;
	BusDriverProfile busDriverProfile;
	Impediment impediment;
	Date dateDelay;

	public BusManagementSystemModel busManagementSystemModel = new BusManagementSystemModel();
	private BusManagementSystemView busManagementSystemView = new BusManagementSystemView();
	Ticket ticket;
	int choiceRoute;
	BlikPayment blikPayment;
	CardPayment cardPayment;
	Payment payment;
	Date date;
	int choice;
	String role = "";

	/**
	 *
	 * @param tDAO
	 * @param model
	 * @param view
	 * @param pS
	 * @param psP
	 * @param dsP
	 * @param bDP
	 * @param rIR
	 */

	public BusManagementSystemController(TicketDAO tDAO, IModelController model, IViewController view, IPaymentStrategy pS, PassengerProfile psP, DispatcherProfile dsP, BusDriverProfile bDP, RouteImpedimentResolver rIR) {

	}

	public BusManagementSystemController() {
		int choiseBD;
		boolean checkBD = false;
		scanner = new Scanner(System.in);
		reportRouteImpediment();
		while (!checkBD) {
			busManagementSystemView.displaySendNotificationToPassengers();
			choiseBD = scanner.nextInt();
			switch (choiseBD) {
				case 1:
					purchaseTicket();
					calculatePrice();
					processPayment();
					break;
				case 2:
					getDelayNotificationDetails();
					break;
				default:
					System.out.println("Podano nieprawidlowa wartosc");
					break;
			}
		}
	}


	public void reportRouteImpediment(){
		impediment = new Impediment();
		dateDelay = new Date();
		boolean check = false;
		scanner = new Scanner(System.in);
		while (!check) {
			busManagementSystemView.displayRoleChoice();
			choice = scanner.nextInt();
			switch (choice) {
				case 1:
					role = "Pasazer";
					check = true;
					break;
				case 2:
					role = "Kierowca";
					busDriverProfile = new BusDriverProfile();
					check = true;
					break;
				case 3:
					role = "Dyspozytor";
					check = true;
					break;
				default:
					System.out.println("Podano nieprawidlowa wartosc");
					break;
			}
		}

		boolean checkBusDriver = false;
		if(role == "Kierowca"){
			while (!checkBusDriver) {
				System.out.println("Czy chcesz zasygnalizowac utrudnienie?");
				System.out.println("1.Tak");
				System.out.println("2.Nie");
				choice = scanner.nextInt();
				switch (choice) {
					case 1:
						getImpedimentDetails();
						busDriverProfile.addImpediment(impediment);
						break;
					case 2:
						checkBusDriver = true;
						break;
					default:
						System.out.println("Podano nieprawidlowa wartosc");
						break;
				}
			}
		}

	}

	public void setCurrentDateTime() {
		LocalDate inputDate = LocalDate.now();
		LocalTime inputTime = LocalTime.now();
		date.setDate(String.valueOf(inputDate));
		date.setTime(String.valueOf(inputTime));
	}

	public boolean check(){
		return ticket.getConcreteRoute() != null
				&& ticket.getTicketType() != null
				&& ticket.getQuantity() > 0;
	}

	public void purchaseTicket(){
		date = new Date();
		blikPayment = new BlikPayment();
		cardPayment = new CardPayment();
		payment = new Payment();
		setCurrentDateTime();

		ticket = new Ticket(0,0f,null,null,date, null, 0);

		Route route = new Route("brak miejsca odjazdu", "brak miejsca przyjazdu",0);
		ticket.setConcreteRoute(route);

		scanner = new Scanner(System.in);

		while(!check()) {
			while (ticket.getConcreteRoute() == null || ticket.getTicketType() == null || ticket.getQuantity() == 0) {
				busManagementSystemView.displayMenuOptions();

				choice = scanner.nextInt();
				switch (choice) {
					case 1:
						TicketType ticketType = getTicketChoice(ticket);
						break;
					case 2:
						route = getRouteChoice(ticket);
						break;
					case 3:
						date = getDateChoice(ticket);
						break;
					case 4:
						int quantity = getQuantity(ticket);
						break;
					case 5:
						busManagementSystemView.displaySelectedTicket(ticket.getTicketType(), ticket.getConcreteRoute(), ticket.getConcreteDate(), ticket.getQuantity());
						break;
					default:
						System.out.println("Podano nieprawidlowa wartosc");
				}

			}
			//check = confirmAction(ticket.getConcreteDate().getDate());
		}
	}

	public void calculatePrice(){
		//ustaw cene do zaplaty za bilety
		ticket.setPrice(calculatePrice(ticket));
		System.out.println("Cena biletu: " + ticket.getPrice() + " zl");
	}

	public void processPayment(){
		boolean pay = false;
		//platnosci
		while (!pay) {
			busManagementSystemView.displayPaymentMethods();

			choice = scanner.nextInt();
			switch (choice) {
				case 1:
					busManagementSystemView.displaySelectedTicket(ticket.getTicketType(), ticket.getConcreteRoute(), ticket.getConcreteDate(), ticket.getQuantity());
					break;
				case 2:
					getCardNumber();
					payment.setCardPayment(cardPayment);
					System.out.println();
					pay = true;
					break;
				case 3:
					blikPayment.setBlikNumber(getBlikCode());
					payment.setBlikPayment(blikPayment);
					System.out.println();
					pay = true;
					break;
				default:
					System.out.println("Podano nieprawidlowa wartosc");
			}
		}
		System.out.println();
		System.out.println("Transakcja przebiegla pomyslnie. Dziekujemy za korzystanie z naszych linii autobusowych");
		System.out.println();
	}

	@Override
	public TicketType getTicketChoice(Ticket ticket){
		int k = 1;

		while(k!=0){
			busManagementSystemView.displayTicketType();
			int choiceTicketType = scanner.nextInt();
			switch (choiceTicketType){
				case 1:
					ticket.setTicketType(TicketType.NORMAL);
					k = 0;
					break;
				case 2:
					ticket.setTicketType(TicketType.DISCOUNTED);
					k = 0;
					break;
				case 3:
					k = 0;
					break;
				default:
					System.out.println("Podano nieprawidlowa wartosc");
			}

		}
		return ticket.getTicketType();
	}

	@Override
	public Route getRouteChoice(Ticket ticket){
		int k = 1;
		Route route = new Route(null,null,0);

		while(k!=0){
			busManagementSystemView.displayRoute();
			choiceRoute = scanner.nextInt();
			switch (choiceRoute){
				case 1:
					route.setStartPoint("Pasaz Grunwaldzki");
					route.setEndPoint("ZOO");
					route.setLenght(1200);
					k = 0;
					break;
				case 2:
					route.setStartPoint("Pasaz Grunwaldzki");
					route.setEndPoint("Olimpia Port");
					route.setLenght(1380);
					k = 0;
					break;
				case 3:
					route.setStartPoint("Pasaz Grunwaldzki");
					route.setEndPoint("Tarczynski Arena");
					route.setLenght(5000);
					k = 0;
					break;
				case 4:
					route.setStartPoint("Pasaz Grunwaldzki");
					route.setEndPoint("Grabiszynska");
					route.setLenght(2800);
					k = 0;
					break;
				case 5:
					route.setStartPoint("Pasaz Grunwaldzki");
					route.setEndPoint("Kosciuszki");
					route.setLenght(1900);
					k = 0;
					break;
				case 6:
					route.setStartPoint("ZOO");
					route.setEndPoint("Pasaz Grunwaldzki");
					route.setLenght(1200);
					k = 0;
					break;
				case 7:
					route.setStartPoint("Oplimpia Port");
					route.setEndPoint("Pasaz Grunwaldzki");
					route.setLenght(1380);
					k = 0;
					break;
				case 8:
					route.setStartPoint("Tarczynski Arena");
					route.setEndPoint("Pasaz Grunwaldzki");
					route.setLenght(5000);
					k = 0;
					break;
				case 9:
					route.setStartPoint("Grabiszynska");
					route.setEndPoint("Pasaz Grunwaldzki");
					route.setLenght(2800);
					k = 0;
					break;
				case 10:
					route.setStartPoint("Kosciuszki");
					route.setEndPoint("Pasaz Grunwaldzki");
					route.setLenght(1900);
					k = 0;
					break;
				case 11:
					k = 0;
					break;
				default:
					System.out.println("Podano nieprawidlowa wartosc");
			}
			ticket.setConcreteRoute(route);
		}
		return ticket.getConcreteRoute();
	}

	@Override
	public Date getDateChoice(Ticket ticket) {
		Date date = new Date();
		scanner = new Scanner(System.in);
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

		LocalDateTime currentDateTime = LocalDateTime.of(2025, 1, 13, 19, 0);

		LocalDate inputDate = null;
		LocalTime inputTime = null;

		while (true) {
			try {
				System.out.println("Wprowadź datę w formacie dd.MM.yyyy:");
				String dateInput = scanner.nextLine();
				inputDate = LocalDate.parse(dateInput, dateFormatter);
				ticket.getConcreteDate().setDate(String.valueOf(inputDate));

				System.out.println("Wprowadź godzinę w formacie HH:mm:");
				String timeInput = scanner.nextLine();
				inputTime = LocalTime.parse(timeInput, timeFormatter);
				ticket.getConcreteDate().setTime(String.valueOf(inputTime));

				LocalDateTime inputDateTime = LocalDateTime.of(inputDate, inputTime);

				// Sprawdzenie, czy data i godzina są z przyszłości
				if (inputDateTime.isBefore(currentDateTime)) {
					System.out.println("Wprowadzona data i godzina są z przeszłości. Spróbuj ponownie.");
				} else {
					System.out.println("Poprawnie wprowadzona data i godzina: " + inputDateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")));
					break;
				}

			} catch (DateTimeParseException e) {
				System.out.println("Nieprawidłowy format daty lub godziny. Spróbuj ponownie.");
			}
		}
		return date;
	}

	@Override
	public int getQuantity(Ticket ticket){
		busManagementSystemView.displayQuantity();
		int choiceQuantity = scanner.nextInt();
		if(choiceQuantity < 30) {
			ticket.setQuantity(choiceQuantity);
			return choiceQuantity;
		}
		else {
			return 10;
		}
	}

	@Override
	public void getImpedimentDetails(){
		scanner = new Scanner(System.in);
		// Pobieramy datę od użytkownika
		System.out.print("Podaj datę (format: YYYY-MM-DD): ");
		String dateD = scanner.nextLine();
		dateDelay.setDate(dateD);
		impediment.setDate(dateDelay);

		// Pobieramy opis opóźnienia od użytkownika
		System.out.print("Podaj opis opóźnienia: ");
		String description = scanner.nextLine();
		impediment.setDescription(description);
	}

	@Override
	public Payment getPaymentMethod(){
		throw new UnsupportedOperationException();
	}

	@Override
	public Ticket getSelectedTicket(){
		throw new UnsupportedOperationException();
	}

	@Override
	public Passenger getPassengerData(){
		throw new UnsupportedOperationException();
	}

	@Override
	public int getChoice(){
		throw new UnsupportedOperationException();
	}

	@Override
	public String getInputEmail(){
		throw new UnsupportedOperationException();
	}

	@Override
	public String getInputPassword(){
		throw new UnsupportedOperationException();
	}

	@Override
	public int getOptionsChoice(){
		throw new UnsupportedOperationException();
	}

	@Override
	public String getImpedimentRoute(){
		throw new UnsupportedOperationException();
	}

	@Override
	public void getDelayNotificationDetails(){
		try {
			// Odczytujemy zawartość pliku
			List<String> lines = new ArrayList<>();
			BufferedReader reader = new BufferedReader(new FileReader("opoznienie.txt"));
			String line;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
			reader.close();

			// Wyświetlamy zawartość pliku
			System.out.println("Utrudnienia na drodze: ");
			for (int i = 0; i < lines.size(); i++) {
				System.out.println((i + 1) + ". " + lines.get(i));
			}
		} catch (IOException e) {
			System.out.println("Błąd podczas odczytywania pliku: " + e.getMessage());
		}
	}

	@Override
	public String getBlikCode(){
		paymentStrategy = new SBlikPayment();

		scanner = new Scanner(System.in);
		String blikCode;
		busManagementSystemView.displayBlikMessage();
		while (true) {
			System.out.print("Wpisz kod BLIK w formacie XXX XXX: ");
			blikCode = scanner.nextLine();
			if(paymentStrategy.isValidBlikCode(blikCode)){
				break;
			}
		}
		return blikCode;
	}

	@Override
	public void getCardNumber(){
		paymentStrategy = new SCardPayment();

		scanner = new Scanner(System.in);
		String cardNumber;
		String cvv;
		String expiryDate;
		busManagementSystemView.displayCardMessage();

		while (true) {
			System.out.print("Podaj numer karty (16 cyfr): ");
			cardNumber = scanner.nextLine();
			if(paymentStrategy.isValidCardNumber(cardNumber)){
				break;
			}
			cardPayment.setCardNumber(cardNumber);
		}

		while (true){
			System.out.print("Podaj numer CVV (3 cyfry): ");
			cvv = scanner.nextLine();
			if(paymentStrategy.isValidCVV(cvv)){
				break;
			}
			cardPayment.setCvv(cvv);
		}

		while (true) {
			System.out.print("Podaj datę ważności karty (MM/YY): ");
			expiryDate = scanner.nextLine();
			if(paymentStrategy.isValidExpiryDate(expiryDate)){
				break;
			}
			cardPayment.setExpiryDate(expiryDate);
		}
	}

	@Override
	public String getCVV(){
		throw new UnsupportedOperationException();
	}

	@Override
	public String getExpiryDate(){
		throw new UnsupportedOperationException();
	}

	@Override
	public String getRole(){
		return "siema";
	}


	@Override
	public boolean confirmAction(String data){
		//ile biletow jest na kupno
		List<Integer> numbers;
		int num;
		ticketDAO = new TicketDAO();
		choiceRoute-=1;

		try {
			numbers = ticketDAO.checkDateInSystem(data);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		if(numbers == null){
			numbers  = Arrays.asList(30, 30, 30, 30, 30, 30, 30, 30, 30, 30);
		}
		num = numbers.get(choiceRoute);

		if(num - ticket.getQuantity() >= 0){
			numbers.set(choiceRoute,numbers.get(choiceRoute) - ticket.getQuantity());
			ticketDAO.addTicketToSystem(data,numbers);
			System.out.println("Udana rezerwacja, przejdź do platnosci");
			return true;
		}
		else{
			ticketDAO.addTicketToSystem(data,numbers);
			System.out.println("Nie udana rezerwacja, brak wolnych miejsc. Wybierz inna trase, lub termin");
			return false;
		}
	}

	@Override
	public void resetView(){
		throw new UnsupportedOperationException();
	}

	@Override
	public void initializeView(){
		throw new UnsupportedOperationException();
	}


	public float calculatePrice(Ticket ticket) {
		float totalCost = ticket.getConcreteRoute().getRouteLength()/1000f * 12f;
		if(ticket.getTicketType() == TicketType.DISCOUNTED){
			totalCost = totalCost * 0.5f;
		}
		totalCost = totalCost * ticket.getQuantity();

		ticket.setPrice(totalCost);
		return totalCost;
	}

}
import java.util.ArrayList;

public class BusManagementSystemView implements IViewController {

	private View view;

	public BusManagementSystemView(){
	}

	@Override
	public void displayMenuOptions() {
		System.out.println("=================== MENU ===================");
		System.out.println("1.Wybierz rodzaj biletu, ktory chcesz kupic");
		System.out.println("2.Wybierz trase, ktora chcesz przebyc");
		System.out.println("3.Wybierz date odjazdu");
		System.out.println("4.Wybierz ilosc biletow ktore chcesz kupic");
		System.out.println("5.Wyswietl swoj bilet");
		System.out.println("Aby przejsc do kupna biletu uzupelnij wszystkie dane potrzebne do stworzenia twojego biletu");
	}

	@Override
	public void displaySelectedTicket(TicketType ticketType, Route route, Date date, int quantity){
		System.out.println("Ilosc biletow: " + quantity);
		System.out.println("Trasa: od " + route.getStartPoint() + " do " + route.getEndPoint());
		System.out.println("Typ biletu: " + ticketType);
		System.out.println("Wybrano bilet na dzien : " + date.getDate() + " oraz na godzine : " + date.getTime());
	}

	@Override
	public void displayTicketType(){
		System.out.println("================== Ticket Type ==================");
		System.out.println("1.Normalny");
		System.out.println("2.Ulgowy");
	}

	@Override
	public void displayRoute(){
		System.out.println("================== Route ==================");
		System.out.println("1.Pasaz Grunwaldzki -> Zoo");
		System.out.println("2.Pasaz Grunwaldzki - > Olimpia Port");
		System.out.println("3.Pasaz Grunwaldzki - > Tarczynski Arena");
		System.out.println("4.Pasaz Grunwaldzki - > Grabiszynska");
		System.out.println("5.Pasaz Grunwaldzki - > Kosciuszki");
		System.out.println("6.Zoo - > Pasaz Grunwaldzki");
		System.out.println("7.Olimpia Port - > Pasaz Grunwaldzki");
		System.out.println("8.Tarczynski Arena - > Pasaz Grunwaldzki");
		System.out.println("9.Grabiszynska - > Pasaz Grunwaldzki");
		System.out.println("10.Kosciuszki - > Pasaz Grunwaldzki");
	}

	@Override
	public void displayQuantity(){
		System.out.println("================== Quantity ==================");
		System.out.println("Podaj ilosc biletow jaka chcesz kupic: ");
	}

	@Override
	public void displayPaymentMethods() {
		System.out.println("=================== KASA ===================");
		System.out.println("1.Wyświetl swój bilet");
		System.out.println("2.Wybierz platnosc Karta");
		System.out.println("3.Wybierz platnosc BLIK");
	}

	@Override
	public void displaySuccess(String s) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void displayBlikMessage(){
		System.out.println("=================== BLIK ===================");
		System.out.println("Podaj numer BLIK do zrealizowania platnosci:");
	}

	@Override
	public void displayCardMessage(){
		System.out.println("=================== Karta ===================");
		System.out.println("Podaj numer karty do zrealizowania platnosci:");
	}

	@Override
	public void displayRoleChoice() {
		System.out.println("================= Wybor Roli =================");
		System.out.println("1.Pasazer");
		System.out.println("2.Kierowca");
		System.out.println("3.Dyspozytor");
	}


	@Override
	public void displayPaymentSuccess(String paymentType){
		throw new UnsupportedOperationException();
	}



	@Override
	public void displayAddImpedimentOption(){
		throw new UnsupportedOperationException();
	}

	@Override
	public void displayCompareDelaysOption(){
		throw new UnsupportedOperationException();
	}

	@Override
	public void displaySendNotificationToPassengers(){
		System.out.println("================= Menu =================");
		System.out.println("1.Kupno biletu");
		System.out.println("2.Pokazanie utrudnien");
	}


	@Override
	public void displayError(String s) {
		throw new UnsupportedOperationException();
	}


	@Override
	public void displayAvailableTicketsWithDiscounts(TicketType ticketType) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void displayTicketsForDate(String date) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void displayTicketsForRoute(String route) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void displayLogin(String email, String password) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void updateView(String updateType, Object data) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void displayTicketPurchaseQuantity(int quantity) {
		throw new UnsupportedOperationException();
	}


	public void render() {
		// TODO - implement BusManagementSystemView.render
		throw new UnsupportedOperationException();
	}

	public void handleUserAction() {
		// TODO - implement BusManagementSystemView.handleUserAction
		throw new UnsupportedOperationException();
	}

	public void displayPassengerTickets() {
		// TODO - implement BusManagementSystemView.displayPassengerTickets
		throw new UnsupportedOperationException();
	}

	public void displayNotification() {
		// TODO - implement BusManagementSystemView.displayNotification
		throw new UnsupportedOperationException();
	}

	public void displayBusDriverReport() {
		// TODO - implement BusManagementSystemView.displayBusDriverReport
		throw new UnsupportedOperationException();
	}

	public void initializeComponents() {
		// TODO - implement BusManagementSystemView.initializeComponents
		throw new UnsupportedOperationException();
	}

}
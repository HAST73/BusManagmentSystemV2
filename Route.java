import java.util.*;

public class Route {

	private int ID_route;
	private String startPoint;
	private String endPoint;
	private int totalSeats;
	private int reservedSeats;
	private ArrayList<Route> alternativeRoutes;
	private int routeLength;

	/**
	 * 
	 * @param startPoint
	 */
	public void setStartPoint(String startPoint) {
		this.startPoint = startPoint;
	}

	public String getStartPoint() {
		return this.startPoint;
	}

	/**
	 * 
	 * @param endPoint
	 */
	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	public String getEndPoint() {
		return this.endPoint;
	}

	public ArrayList<Route> getAlternativeRoutes() {
		return this.alternativeRoutes;
	}

	/**
	 * 
	 * @param alternativeRoutes
	 */
	public void setAlternativeRoutes(ArrayList<Route> alternativeRoutes) {
		this.alternativeRoutes = alternativeRoutes;
	}

	public int getRouteLength(){
		return this.routeLength;
	}

	public void setLenght(int lenght) {
		this.routeLength = lenght;
	}

	/**
	 * 
	 * @param sP
	 * @param eP
	 */
	public Route(String sP, String eP, int routeLength) {
		this.startPoint = sP;
		this.endPoint = eP;
		this.routeLength = routeLength;
	}

	/**
	 * 
	 * @param sP
	 * @param eP
	 * @param tS
	 * @param rS
	 * @param aR
	 */
	public Route(String sP, String eP, int routeLength, int tS, int rS, ArrayList<Route> aR) {
		this.startPoint = sP;
		this.endPoint = eP;
		this.routeLength = routeLength;
		this.totalSeats = tS;
		this.reservedSeats = rS;
		this.alternativeRoutes = aR;
	}

}
package org.example;
import java.util.ArrayList;
public class FlightCollection {
	public static ArrayList<Flight> flights= new ArrayList<>();

	public static ArrayList<Flight> getFlights() {
		return flights;
	}

	public static void addFlights(ArrayList<Flight> flights) {
		FlightCollection.flights.addAll(flights);
	}
	public static void addFlight(Flight flight) {
//		if (!isValidCity(flight.getDepartFrom()) || !isValidCity(flight.getDepartTo())) {
//			throw new IllegalArgumentException("Invalid city names. Please use valid city names.");
//		}
//
//		if (getFlightInfo(flight.getFlightID()) != null) {
//			throw new IllegalArgumentException("Flight with this ID already exists in the system.");
//		}
//
//		if (getFlightInfoByCode(flight.getCode()) != null) {
//			throw new IllegalArgumentException("Flight with this code already exists in the system.");
//		}

		flights.add(flight);
	}

	public static Flight getFlightInfo(String city1, String city2) {
		//display the flights where there is a direct flight from city 1 to city2
		for (Flight flight : flights) {
			if (flight.getDepartFrom().equalsIgnoreCase(city1) && flight.getDepartTo().equalsIgnoreCase(city2)) {
				return flight;
			}
		}
		return null;
	}

	public static Flight getFlightInfo(String city) {
		//SELECT a flight where depart_to = city
		for (Flight flight : flights) {
			if (flight.getDepartTo().equalsIgnoreCase(city)) {
				return flight;
			}
		}
		return null;

	}
	public static Flight getFlightInfo(int flight_id) {
		//SELECT a flight with a particular flight id
		for (Flight flight : flights) {
			if (flight.getFlightID() == flight_id) {
				return flight;
			}
		}
		return null;
	}
}

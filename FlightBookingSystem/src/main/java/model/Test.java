package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import businessLogic.CityBL;
import businessLogic.PassengerBL;
import businessLogic.PlaneBL;
import businessLogic.SeatBL;
import businessLogic.PassengerBookingBL;
import businessLogic.TripBL;

public class Test {

	
	public static void main(String[] args) {
		PassengerBL passengerBL = new PassengerBL();
		passengerBL.register("Naveen", "Kumar", "NaveenKumar", "naveen@gmail.com", "123456", "12345678909", "L67TR34Y");
		passengerBL.register("Sandeep", "Kumar", "SandeepAmarnath", "sandeep@gmail.com", "123456", "12345678909",
				"L67TX34Y");
		
		Passenger passenger = (Passenger) passengerBL.login("NaveenKumar", "123456");
		
		PlaneBL planeBL = new PlaneBL();
		planeBL.create("British Airways", 80);
		planeBL.create("Lufthansa", 100);
		planeBL.create("Air Canada", 150);
		
		Plane plane = planeBL.readById(1);
		
		SeatBL seatBL = new SeatBL();
		seatBL.create(SeatNumber.A1, SeatType.BusinessClass, 1250.99);
		seatBL.create(SeatNumber.E1, SeatType.EconomyClass, 1000.99);
		
		Seat seat = seatBL.readBySeatNumber(SeatNumber.A1);
		Seat seat2 = seatBL.readBySeatNumber(SeatNumber.E1);
		
		CityBL cityBL = new CityBL();
		cityBL.create("Bangalore", "BLR");
		cityBL.create("Hyderabad", "HYD");
		
		TripBL tripBL  = new TripBL();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		tripBL.create(plane, LocalDateTime.parse("2007-12-03 10:15:30",formatter), LocalDateTime.parse("2007-12-04 10:15:30",formatter), cityBL.readById(1), cityBL.readById(2));
		
		
		PassengerBookingBL passengerBookingBL = new PassengerBookingBL();
		
		
	}
}


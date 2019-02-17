package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import businessLogic.BookingBL;
import businessLogic.CityBL;
import businessLogic.PassengerBL;
import businessLogic.PlaneBL;
import businessLogic.SeatBL;
import businessLogic.PassengerBookingBL;
import businessLogic.TripBL;
import dao.jpa.CityJpaDao;
import dao.jpa.PassengerJpaDao;
import dao.jpa.PlaneJpaDao;

public class ModelTestAPP {

	public static void main(String[] args) {
//
//		// Testing PassengerBL
//
		PassengerBL passengerBL = new PassengerBL();
		passengerBL.register("Naveen", "Kumar", "NaveenKumar", "naveen@gmail.com", "123456", "12345678909", "L67TR34Y");
		passengerBL.register("Sandeep", "Kumar", "SandeepAmarnath", "sandeep@gmail.com", "123456", "12345678909",
				"L67TX34Y");
		
		
		
		

//		System.err.println("Passengers' List:\n " + passengerBL.readAll());
////		System.err.println("Passenger with userId 2\n" + passengerBL.readById(2));
////		System.err.println("Passenger readByUsername --> Passing username - SandeepAmarnath\n"
////				+ passengerBL.readByUserName("SandeepAmarnath"));
////		System.err.println("Passengers with last name Kumar\n" + passengerBL.readByLastName("Kumar"));
////		System.err.println(
////				"Passengers login test-->Testing NaveenKumar, 123456\n" + passengerBL.login("NaveenKumar", "123456"));
////		System.err.println("Passenger readbyPassport -->Testing Naveen's Passport L67TR34Y\n"
////				+ passengerBL.readByPassport("L67TR34Y"));
//		Passenger passenger = (Passenger) passengerBL.login("NaveenKumar", "123456");
//		System.err.println("Testing Login:\n"+passenger);
//		passenger.setPassword("12345678");
//		System.err.println("Update password:\n" + passengerBL.update(passenger));
//		System.err.println("Testing Login:\n"+passenger);
////
////		System.err.println("PASSENGER BUSINESS LOGIC TESTED SUCCESSFULLY");
////
////		// Testing PlaneBL
////
		PlaneBL planeBL = new PlaneBL();
		planeBL.create("British Airways", 80);
		planeBL.create("Lufthansa", 100);
		planeBL.create("Air Canada", 150);
////
////		System.err.println("Planes' List:\n" + planeBL.readAll());
////		System.err.println("Plane readByPlaneName:\n" + planeBL.readByNameLike("Br"));
////		
		Plane plane = planeBL.readById(1);
////		System.err.println("Plane readByid:\n" + plane);
////
//////		TODO: PlaneBL update is not working. Fix it later
////		System.err.println("Plane update British Airways to Jet Airways:\n" + planeBL.update(plane));
////
////		System.err.println("PLANE BUSINESS LOGIC TESTED. UPDATE IS NOT WORKING");
////		
////		
////		// Testing SeatBL
////		
		SeatBL seatBL = new SeatBL();
		seatBL.create(SeatNumber.A1, SeatType.BusinessClass, 1250.99);
		seatBL.create(SeatNumber.E1, SeatType.EconomyClass, 1000.99);
//		
		Seat seat = seatBL.readBySeatNumber(SeatNumber.A1);
		Seat seat2 = seatBL.readBySeatNumber(SeatNumber.E1);
//		System.err.println("Seat readbySeatNumber:\n"+seat);
//		System.err.println("Seats readAll:\n"+seatBL.readAll());
//		System.err.println("Seat readById:\n"+seatBL.readById(1));
////		
////		System.err.println("SeatBL Tested. Working fine");
////		
////		
////		
//		// Testing PassengerBookingBL
//		
		PassengerBookingBL passengerBookingBL = new PassengerBookingBL();
//		
		Passenger passenger = (Passenger) passengerBL.login("NaveenKumar", "123456");
//		
//		
//		
//		ticketBL.create(passenger, 1500.32, seat);
//		
		CityBL cityBL = new CityBL();
		cityBL.create("Bangalore", "BLR");
		cityBL.create("Hyderabad", "HYD");
//		
//		
//		
		TripBL tripBL  = new TripBL();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		tripBL.create(plane, LocalDateTime.parse("2007-12-03 10:15:30",formatter), LocalDateTime.parse("2007-12-04 10:15:30",formatter), cityBL.readById(1), cityBL.readById(2));
		
		
//		
//		
		BookingBL bookingBL = new BookingBL();
		
		bookingBL.create(tripBL.readById(1), passengerBL.readById(1));
	
		
		Trip trip2 = tripBL.readByPlaneAndDepartDate(plane, LocalDateTime.parse("2007-12-03 10:15:30",formatter));
//		
		tripBL.create(plane, LocalDateTime.parse("2010-04-03 15:45:20",formatter), LocalDateTime.parse("2010-04-05 05:45:40",formatter), cityBL.readById(2), cityBL.readById(1));
//		
//		
//		
		PassengerBookingBL passengerBookingBL = new PassengerBookingBL();
		System.err.println("Available seats trip 2 before"+trip2.getAvailableSeats());
		passengerBookingBL.create(trip2, passenger, 1500, seat);
		System.err.println("Available seats trip 2 later"+trip2.getAvailableSeats());
		passengerBookingBL.create(trip2, passenger, 2000, seat2);
//		
//		
		tripBL.create(plane, LocalDateTime.parse("2011-04-03 15:45:20",formatter), LocalDateTime.parse("2011-04-04 15:45:20",formatter), cityBL.readById(2), cityBL.readById(1));
		
		Trip trip3 = tripBL.readByPlaneAndDepartDate(plane, LocalDateTime.parse("2011-04-03 15:45:20",formatter));
//		
//		
//		System.err.println("THE SEATS AVAILABLE AFTER CREATING TRIP3 are :\n"+trip3.getAvailableSeats());
//
		passengerBookingBL.create(trip3, passenger, 2400, seat);
//
//		System.err.println("Available seats trip 3 later"+trip3.getAvailableSeats());
		passengerBookingBL.create(trip3, passenger, 1500, seat2);
//		
//		
//		BookingBL bookingBL = new BookingBL();
//		
		List<PassengerBooking> passengerBookings = passengerBookingBL.readAll();
		bookingBL.create(trip2, passenger, passengerBookings);
		
//		System.err.println(tickets);
		
		
		
	}

}

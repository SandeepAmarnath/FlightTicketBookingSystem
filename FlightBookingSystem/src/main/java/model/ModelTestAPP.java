package model;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ModelTestAPP {
	
	
	public static void main(String[] args) {
		
		
		Passenger vijay = new Passenger("Vijay","4322","s@g.com","123456","L8yh");
		Admin sandeep = new Admin("Sandeep","6789","vijay@g.com","123456");
		
		City bangaloreCity = new City().setCityCode("BLR").setCityName("Bangalore");
		City torontoCity = new City().setCityCode("BLR").setCityName("Toronto");
		Plane britishAirways = new Plane().setCapity(50).setFightName("British Airways");
		
		Seat a1 = new Seat().setSeatNumber(SeatNumber.A1).setSeatPrice(32.3).setSeatType(SeatType.BusinessClass);
		List<Seat> seats= new ArrayList<>();
		
		seats.add(a1);
		
		
		Trip trip = new Trip().
				setArrivalCity(bangaloreCity).setDepartCity(torontoCity).
				setArrivalDateTime(LocalDateTime.now()).setDepartDateTime(LocalDateTime.now()).setPlane(britishAirways).setSeats(seats);

		
//		Seat a1 = new Seat().setAvaliability(true).setPlane(britishAirways).setSeatNumber(SeatNumber.A1).setSeatType(SeatType.BusinessClass);
//		Seat a2 = new Seat().setAvaliability(true).setPlane(britishAirways).setSeatNumber(SeatNumber.A2).setSeatType(SeatType.EconomyClass);
		
		//Booking
		Booking bookingOne = new Booking().setPassenger(vijay).setTrip(trip).setPassenger(vijay).setNetPrice(59.9);
		
		
		
		//Ticket
		Ticket ticketOne = new Ticket().setPrice(34.5).setSeat(a1).setBooking(bookingOne);
//		Ticket ticketTwo = new Ticket().setPrice(34.5).setSeat(a2).setSeatClass("BC").setBooking(bookingOne);
		
		
		
		
		//EMFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("InheritanceDatabase");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(trip);
		em.persist(vijay);
		em.persist(bangaloreCity);
		em.persist(britishAirways);
		
		em.persist(a1);
		em.persist(torontoCity);
	
		em.persist(ticketOne);
		em.persist(bookingOne);
		
		em.getTransaction().commit();
		em.close();
		
	}

}

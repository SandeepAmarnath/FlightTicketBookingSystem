package businessLogic;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.TransactionRequiredException;

import dao.interfaces.IPassengerBookingDao;
import dao.jpa.JpaDaoFactory;
import model.Booking;
import model.Passenger;
import model.Seat;
import model.SeatNumber;
import model.PassengerBooking;
import model.Trip;

public class PassengerBookingBL {

	private IPassengerBookingDao passengerBookingDao;

	public PassengerBookingBL() {
		
		this.passengerBookingDao = JpaDaoFactory.getTicketDao();

	}
	
	public boolean create(Trip trip, Passenger passenger, double price, Seat seat) {
		
		if (passenger == null || price<seat.getSeatPrice() || seat == null) {
			return false;
		}
		
		if (!checkSeatAvaialability(seat.getSeatNumber(), trip)) {
			System.err.println("Sorry brother...This seat is been taken. You are too late");
			return false;
		}
		
		PassengerBooking passengerBooking = new PassengerBooking().setPassenger(passenger).setPrice(price).setSeat(seat);
		
		try {
			return passengerBookingDao.create(passengerBooking);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (EntityExistsException e) {
			e.printStackTrace();
		} catch (TransactionRequiredException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public PassengerBooking readById(int id) {
		
		try {
			return passengerBookingDao.readById(id);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<PassengerBooking> readAll(){
		
		try {
			return passengerBookingDao.readAll();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public List<PassengerBooking> readByBooking(Booking booking){
		
		if (booking == null) {
			return null;
		}
		
		try {
			return passengerBookingDao.readByBooking(booking);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<PassengerBooking> readByPassenger(Passenger passenger){
		if (passenger == null) {
			return null;
		}
		
		try {
			return passengerBookingDao.readByPassenger(passenger);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	
	}
	
	private boolean checkSeatAvaialability(SeatNumber seatNumber,Trip trip) {
		
		 return trip.checkAvailability(seatNumber);
	}

	public boolean update(PassengerBooking passengerBooking) {
		if (passengerBooking==null) {
			return false;
		}
		
		try {
			return passengerBookingDao.update(passengerBooking);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} 
		return false;
		
	}
}

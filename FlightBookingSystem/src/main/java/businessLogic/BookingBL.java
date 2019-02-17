package businessLogic;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.TransactionRequiredException;

import dao.interfaces.IBookingDao;
import dao.jpa.JpaDaoFactory;
import model.Booking;
import model.Passenger;
import model.PassengerBooking;
import model.Trip;

public class BookingBL {

	private IBookingDao bookingDao;
	private PassengerBookingBL passengerBookingBL;

	public BookingBL() {

		this.bookingDao = JpaDaoFactory.getBookingDao();
		this.passengerBookingBL = new PassengerBookingBL();

	}

	public boolean create(Trip trip, Passenger passenger, List<PassengerBooking> passengerBookings) {

		if (trip == null || passenger == null) {
			return false;
		}

		Booking booking = new Booking().setTrip(trip).setPassenger(passenger).setTickets(passengerBookings);

		try {
			bookingDao.create(booking);
			Booking mybooking = readByTripAndPassenger(trip, passenger);
			System.err.println("SAndeep the booking is "+mybooking);
			for (PassengerBooking passengerBooking : passengerBookings) {
				passengerBooking.setBooking(mybooking);
				passengerBookingBL.update(passengerBooking);
				
			}
			return true;
			
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (EntityExistsException e) {
			e.printStackTrace();
		} catch (TransactionRequiredException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(Booking booking) {

		if (booking == null) {
			return false;
		}
		try {
			return bookingDao.update(booking);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (EntityExistsException e) {
			e.printStackTrace();
		} catch (TransactionRequiredException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Booking> readByPassenger(String passengerName) {

		if (passengerName == null || passengerName.isEmpty()) {
			return null;
		}
		try {
			return bookingDao.readByPassenger(passengerName);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Booking> readAll() {

		try {
			return bookingDao.readAll();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Booking readById(int id) {

		try {
			return bookingDao.readById(id);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public Booking readByTripAndPassenger(Trip trip,Passenger passenger) {
		
		try {
			return bookingDao.readByTripAndPassenger(trip,passenger);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}
}

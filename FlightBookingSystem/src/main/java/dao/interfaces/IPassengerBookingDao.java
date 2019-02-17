package dao.interfaces;

import java.util.List;

import dao.interfaces.generics.ICreatable;
import dao.interfaces.generics.IReadable;
import dao.interfaces.generics.IUpdatable;
import model.Booking;
import model.Passenger;
import model.PassengerBooking;

public interface IPassengerBookingDao extends ICreatable<PassengerBooking>,IReadable<PassengerBooking>,IUpdatable<PassengerBooking>{
	
	
	List<PassengerBooking> readByBooking(Booking booking);
	List<PassengerBooking> readByPassenger(Passenger passenger);
	

}

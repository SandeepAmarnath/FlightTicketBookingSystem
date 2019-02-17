package dao.interfaces;

import java.util.List;

import dao.interfaces.generics.ICreatable;
import dao.interfaces.generics.IReadable;
import dao.interfaces.generics.IUpdatable;
import model.Booking;
import model.Passenger;
import model.Trip;

public interface IBookingDao extends ICreatable<Booking>, IUpdatable<Booking>,IReadable<Booking>{

	
	List<Booking> readByPassenger(String passengerName);

	Booking readByTripAndPassenger(Trip trip, Passenger passenger);
	
	
}

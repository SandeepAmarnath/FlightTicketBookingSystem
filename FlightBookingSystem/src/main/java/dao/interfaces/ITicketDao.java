package dao.interfaces;

import java.util.List;

import dao.interfaces.generics.ICreatable;
import dao.interfaces.generics.IReadable;
import model.Booking;
import model.Ticket;

public interface ITicketDao extends ICreatable<Ticket>,IReadable<Ticket>{
	
	
	List<Ticket> readByPassenger(String passenger);
	List<Ticket> readByBooking(Booking booking);
	

}

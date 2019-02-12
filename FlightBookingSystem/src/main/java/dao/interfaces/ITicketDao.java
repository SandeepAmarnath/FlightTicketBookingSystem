package dao.interfaces;

import java.util.List;

import dao.interfaces.generics.ICreatable;
import dao.interfaces.generics.IReadable;
import model.Ticket;

public interface ITicketDao extends ICreatable<Ticket>,IReadable<Ticket>{
	
	
	List<Ticket> readByPassport(String passport);
	List<Ticket> readByPassenger(String passenger);
	

}

package dao.interfaces;

import dao.interfaces.generics.ICreatable;
import dao.interfaces.generics.IReadable;
import model.Seat;
import model.SeatNumber;

public interface ISeatDao extends ICreatable<Seat>,IReadable<Seat>{
	
	
	Seat readBySeatNumber(SeatNumber seatNumber);

}

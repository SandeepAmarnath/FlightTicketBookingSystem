package businessLogic;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.TransactionRequiredException;

import dao.interfaces.ISeatDao;
import dao.jpa.JpaDaoFactory;
import model.Seat;
import model.SeatNumber;
import model.SeatType;

public class SeatBL {

	private ISeatDao seatDao;

	public SeatBL() {

		this.seatDao = JpaDaoFactory.getSeatDao();
	}

	public boolean create(SeatNumber seatNumber, SeatType seatType, double seatPrice) {
		Seat seat = new Seat().setSeatType(seatType).setSeatAvailabile(true).setSeatNumber(seatNumber)
				.setSeatPrice(seatPrice);

		try {
			return seatDao.create(seat);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (EntityExistsException e) {
			e.printStackTrace();
		} catch (TransactionRequiredException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Seat readById(int id) {
		
		try {
			return seatDao.readById(id);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Seat> readAll(){
		
		try {
			return seatDao.readAll();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Seat readBySeatNumber(SeatNumber seatNumber) {
		
		if (seatNumber == null) {
			return null;
		}
		
		try {
			return seatDao.readBySeatNumber(seatNumber);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}
}

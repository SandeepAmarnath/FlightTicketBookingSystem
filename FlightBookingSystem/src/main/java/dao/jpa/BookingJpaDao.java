package dao.jpa;

import java.util.List;

import dao.interfaces.IBookingDao;
import model.Booking;

public class BookingJpaDao implements IBookingDao{

	@Override
	public boolean create(Booking t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Booking t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Booking> readByPassenger(String passengerName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Booking> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Booking readById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}

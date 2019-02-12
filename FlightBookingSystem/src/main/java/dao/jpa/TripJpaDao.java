package dao.jpa;

import java.time.LocalDate;
import java.util.List;

import dao.interfaces.ITripDao;
import model.Trip;

public class TripJpaDao implements ITripDao {

	@Override
	public boolean create(Trip t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Trip> readByPlane(String planeName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Trip> readBySourceCity(String cityName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Trip> readByDestination(String cityName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Trip> readByStartDate(LocalDate startDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Trip> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Trip readById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}

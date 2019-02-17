package businessLogic;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.TransactionRequiredException;
import dao.interfaces.ITripDao;
import dao.jpa.JpaDaoFactory;
import model.City;
import model.Plane;
import model.Seat;
import model.Trip;

public class TripBL {

	private ITripDao tripDao;
	private List<Seat> seats;

	public TripBL() {
		
		this.tripDao = JpaDaoFactory.getTripDao();
		this.seats = new ArrayList<>();
	}

	public boolean create(Plane plane, LocalDateTime departDateTime, LocalDateTime arrivalDateTime, City departCity,
			City arrivalCity) {

		//TODO: Add this later. Cannot test if added now:-)
//		if (plane == null || departDateTime.isBefore(LocalDateTime.now())
//				|| arrivalDateTime.isBefore(LocalDateTime.now())) {
//			return false;
//		}
		Trip trip = new Trip().setPlane(plane).setDepartCity(departCity).setArrivalCity(arrivalCity)
				.setDepartDateTime(departDateTime).setArrivalDateTime(arrivalDateTime).setSeats(seats);

		try {
			System.err.println("Created Successfully");
			return tripDao.create(trip);
			
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (EntityExistsException e) {
			e.printStackTrace();
		} catch (TransactionRequiredException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Trip> readByPlane(Plane plane) {

		if (plane == null) {
			return null;
		}

		try {
			return tripDao.readByPlane(plane);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Trip> readBySourceCity(String cityName) {

		if (cityName == null || cityName.isEmpty()) {
			return null;
		}

		try {
			return tripDao.readBySourceCity(cityName);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Trip> readByStartDate(LocalDateTime startDate) {

		if (startDate.isBefore(LocalDateTime.now()) || startDate == null) {
			return null;
		}

		try {
			return tripDao.readByStartDate(startDate);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Trip> readAll() {

		try {
			return tripDao.readAll();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Trip readById(int id) {

		try {
			return tripDao.readById(id);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Trip readByPlaneAndDepartDate(Plane plane, LocalDateTime departTime) {
		
		if (plane==null) {
			return null;
		}
		
		try {
			return tripDao.readByPlaneAndDepartDate(plane, departTime);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}
}

package dao.jpa;

import dao.interfaces.IAdminDao;
import dao.interfaces.IBookingDao;
import dao.interfaces.ICityDao;
import dao.interfaces.IPassengerDao;
import dao.interfaces.IPlaneDao;
import dao.interfaces.ISeatDao;
import dao.interfaces.IPassengerBookingDao;
import dao.interfaces.ITripDao;

public class JpaDaoFactory {

	private JpaDaoFactory() {

	}
	
	public static final IPassengerDao getPassengerDao() {
		return new PassengerJpaDao();
	}

	public static final IAdminDao getAdminDao() {
		return new AdminJpaDao();
	}

	public static final IBookingDao getBookingDao() {
		return new BookingJpaDao();
	}

	public static final IPlaneDao getPlaneDao() {
		return new PlaneJpaDao();
	}

	public static final ISeatDao getSeatDao() {
		return new SeatJpaDao();
	}

	public static final IPassengerBookingDao getTicketDao() {
		return new PassengerBookingJpaDao();
	}

	public static final ITripDao getTripDao() {
		return new TripJpaDao();
	}
	
	public static final ICityDao getCityDao() {
		return new CityJpaDao();
	}

}

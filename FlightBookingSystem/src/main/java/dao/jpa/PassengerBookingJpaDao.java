package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import dao.interfaces.IPassengerBookingDao;
import model.Booking;
import model.Passenger;
import model.PassengerBooking;

public class PassengerBookingJpaDao implements IPassengerBookingDao {

	@Override
	public boolean create(PassengerBooking passengerBooking) {
		
		EntityManager em = EMFactory.getEntityManager();
		em.getTransaction().begin();
		em.persist(passengerBooking);
		em.getTransaction().commit();
		em.close();
		return true;
	}

	@Override
	public List<PassengerBooking> readByBooking(Booking booking) {
		
		EntityManager em = EMFactory.getEntityManager();
		List<PassengerBooking> passengerBookings = em.createNamedQuery("PassengerBooking.readByBooking",PassengerBooking.class).setParameter("booking", booking).getResultList();
		return passengerBookings;
	}

	@Override
	public List<PassengerBooking> readByPassenger(Passenger passenger) {
		
		EntityManager em = EMFactory.getEntityManager();
		List<PassengerBooking> passengerBookings = em.createNamedQuery("PassengerBooking.readByPassenger",PassengerBooking.class).setParameter("passengerName", passenger.getUsername()).getResultList();
		return passengerBookings;
	}

	@Override
	public List<PassengerBooking> readAll() {
		EntityManager em = EMFactory.getEntityManager();
		List<PassengerBooking> passengerBookings = em.createNamedQuery("PassengerBooking.All",PassengerBooking.class).getResultList();
		return passengerBookings;
	}

	@Override
	public PassengerBooking readById(int id) {
		EntityManager em = EMFactory.getEntityManager();
		return em.find(PassengerBooking.class, id);
	}

	@Override
	public boolean update(PassengerBooking passengerBooking) {
		EntityManager em = EMFactory.getEntityManager();
		em.getTransaction().begin();
		em.merge(passengerBooking);
		em.getTransaction().commit();
		em.close();
		return true;
	}

}

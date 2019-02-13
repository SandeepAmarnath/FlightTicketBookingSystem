package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import dao.interfaces.IBookingDao;
import model.Booking;

public class BookingJpaDao implements IBookingDao{

	@Override
	public boolean create(Booking booking) {
		
		EntityManager em = EMFactory.getEntityManager();
		em.getTransaction().begin();
		em.persist(booking);
		em.getTransaction().commit();
		em.close();
		return true;
	}

	@Override
	public boolean update(Booking booking) {
		
		EntityManager em = EMFactory.getEntityManager();
		em.getTransaction().begin();
		em.merge(booking);
		em.getTransaction().commit();
		em.close();
		return true;
	}

	@Override
	public List<Booking> readByPassenger(String passengerName) {
		EntityManager em = EMFactory.getEntityManager();
		List<Booking> bookings = em.createNamedQuery("Booking.readByPassenger",Booking.class).
													setParameter("passengerName", passengerName).getResultList();
		return bookings;
	}

	@Override
	public List<Booking> readAll() {
		
		EntityManager em = EMFactory.getEntityManager();
		List<Booking> bookings = em.createNamedQuery("Booking.All",Booking.class).getResultList();
		return bookings;
	}

	@Override
	public Booking readById(int id) {
		EntityManager em = EMFactory.getEntityManager();
		return em.find(Booking.class, id);
	}

}

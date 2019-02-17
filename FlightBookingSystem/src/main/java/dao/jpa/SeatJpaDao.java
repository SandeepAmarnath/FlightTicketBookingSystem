package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import dao.interfaces.ISeatDao;
import model.Seat;
import model.SeatNumber;

public class SeatJpaDao implements ISeatDao{

	@Override
	public boolean create(Seat seat) {

		EntityManager em = EMFactory.getEntityManager();
		em.getTransaction().begin();
		em.persist(seat);
		em.getTransaction().commit();
		em.close();
		return true;
	}

	@Override
	public List<Seat> readAll() {

		EntityManager em = EMFactory.getEntityManager();
		List<Seat> seats = em.createNamedQuery("Seat.All", Seat.class).getResultList();
		return seats;
	}

	@Override
	public Seat readById(int id) {
		EntityManager em = EMFactory.getEntityManager();
		return em.find(Seat.class, id);
	}

	@Override
	public Seat readBySeatNumber(SeatNumber seatNumber) {
		
		EntityManager em = EMFactory.getEntityManager();
		Seat seat = em.createNamedQuery("Seat.readByNumber", Seat.class).setParameter("seatNumber", seatNumber).getSingleResult();
		return seat;
	}

}

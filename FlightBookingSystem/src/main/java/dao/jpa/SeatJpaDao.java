package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import dao.interfaces.ISeatDao;
import model.Seat;

public class SeatJpaDao implements ISeatDao{

	@Override
	public boolean create(Seat seat) {

		EntityManager em = EMFactory.getEntityManager();
		em.getTransaction().begin();
		em.persist(seat);
		em.getTransaction().commit();
		em.close();
		return true;}

	@Override
	public List<Seat> readAll() {

		EntityManager em = EMFactory.getEntityManager();
		List<Seat> seats = em.createNamedQuery("Seat.All", Seat.class).getResultList();
		return seats;
	}

	@Override
	public Seat readById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}

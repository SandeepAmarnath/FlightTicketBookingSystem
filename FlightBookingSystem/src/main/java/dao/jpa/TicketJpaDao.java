package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import dao.interfaces.ITicketDao;
import model.Booking;
import model.Ticket;

public class TicketJpaDao implements ITicketDao {

	@Override
	public boolean create(Ticket ticket) {
		
		EntityManager em = EMFactory.getEntityManager();
		em.getTransaction().begin();
		em.persist(ticket);
		em.getTransaction().commit();
		em.close();
		return true;
	}

	@Override
	public List<Ticket> readByBooking(Booking booking) {
		
		EntityManager em = EMFactory.getEntityManager();
		List<Ticket> tickets = em.createNamedQuery("Ticket.readByBooking",Ticket.class).setParameter("booking", booking).getResultList();
		return tickets;
	}

	@Override
	public List<Ticket> readByPassenger(String passenger) {
		EntityManager em = EMFactory.getEntityManager();
		List<Ticket> tickets = em.createNamedQuery("Ticket.readByPassenger",Ticket.class).setParameter("passengerName", passenger).getResultList();
		return tickets;
	}

	@Override
	public List<Ticket> readAll() {
		EntityManager em = EMFactory.getEntityManager();
		List<Ticket> tickets = em.createNamedQuery("Ticket.All",Ticket.class).getResultList();
		return tickets;
	}

	@Override
	public Ticket readById(int id) {
		EntityManager em = EMFactory.getEntityManager();
		return em.find(Ticket.class, id);
	}

}

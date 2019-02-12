package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import dao.interfaces.ITicketDao;
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
	public List<Ticket> readByPassport(String passport) {
		
		return null;
	}

	@Override
	public List<Ticket> readByPassenger(String passenger) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ticket readById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}

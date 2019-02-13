package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import dao.interfaces.IPassengerDao;
import model.Passenger;
import model.User;

public class PassengerJpaDao implements IPassengerDao{

	
	
	private boolean create(Passenger passenger) {

		EntityManager em = EMFactory.getEntityManager();
		em.getTransaction().begin();
		em.persist(passenger);
		em.getTransaction().commit();
		em.close();
		return true;
	}

	@Override
	public boolean update(Passenger passenger) {
		
		EntityManager em = EMFactory.getEntityManager();
		em.getTransaction().begin();
		em.merge(passenger);
		em.getTransaction().commit();
		em.close();
		return true;
	}
	
	
	@Override
	public User login(String username, String password) {
		EntityManager em = EMFactory.getEntityManager();
		Passenger passenger = em.createNamedQuery("passenger.readByUsernamePassword", Passenger.class).
								 setParameter("username", username).setParameter("password", password).getSingleResult();
																									
		return passenger;
	}

	@Override
	public boolean register(Passenger passenger) {
		
		if (create(passenger)) {
			return true;
		}
		return false;
	}


	@Override
	public List<Passenger> readAll() {
		EntityManager em = EMFactory.getEntityManager();
		List<Passenger> passengers = em.createNamedQuery("Passenger.All",Passenger.class).getResultList();
		return passengers;
	}

	@Override
	public Passenger readById(int id) {
		EntityManager em = EMFactory.getEntityManager();
		return em.find(Passenger.class, id);
	}

	@Override
	public List<Passenger> readbyName(String passengerLastName) {
		EntityManager em = EMFactory.getEntityManager();
		List<Passenger> passengers = em.createNamedQuery("Passenger.readByLastName",Passenger.class).
										setParameter("passengerLastName", passengerLastName).getResultList();
		return passengers;
	}

	@Override
	public Passenger readByPassport(String passport) {
		EntityManager em = EMFactory.getEntityManager();
		Passenger passenger = em.createNamedQuery("Passenger.readByPassport",Passenger.class).setParameter("passport", passport).getSingleResult();
		return passenger;
	}

	@Override
	public boolean changePassword(String username, String oldPassword, String newPassword) {
		// TODO Implement this later
		return false;
	}

	@Override
	public Passenger readByUserName(String username) {
		EntityManager em = EMFactory.getEntityManager();
		Passenger passenger = (Passenger) em.createNamedQuery("User.readByName", User.class).setParameter("username", username).getSingleResult();
		return passenger;
	}

}

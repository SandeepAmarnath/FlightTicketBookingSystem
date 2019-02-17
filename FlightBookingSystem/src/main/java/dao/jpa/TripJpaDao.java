package dao.jpa;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityManager;
import dao.interfaces.ITripDao;
import model.Plane;
import model.Trip;

public class TripJpaDao implements ITripDao {

	@Override
	public boolean create(Trip trip) {

		EntityManager em = EMFactory.getEntityManager();
		em.getTransaction().begin();
		em.persist(trip);
		em.getTransaction().commit();
		em.close();
		return true;
	}

	@Override
	public List<Trip> readByPlane(Plane plane) {
		EntityManager em = EMFactory.getEntityManager();
		List<Trip> trips = em.createNamedQuery("Trip.readByPlaneName", Trip.class).setParameter("plane", plane)
				.getResultList();
		return trips;
	}

	@Override
	public List<Trip> readBySourceCity(String cityName) {
		EntityManager em = EMFactory.getEntityManager();
		List<Trip> trips = em.createNamedQuery("Trip.readBySource", Trip.class).setParameter("cityName", cityName)
				.getResultList();
		return trips;
	}

	@Override
	public List<Trip> readByStartDate(LocalDateTime startDate) {
		EntityManager em = EMFactory.getEntityManager();
		List<Trip> trips = em.createNamedQuery("Trip.readByStartDate", Trip.class).setParameter("startDate", startDate)
				.getResultList();
		return trips;
	}

	@Override
	public List<Trip> readAll() {
		EntityManager em = EMFactory.getEntityManager();
		List<Trip> trips = em.createNamedQuery("Trip.All", Trip.class).getResultList();
		return trips;
	}

	@Override
	public Trip readById(int id) {
		EntityManager em = EMFactory.getEntityManager();
		return em.find(Trip.class, id);
	}

	@Override
	public Trip readByPlaneAndDepartDate(Plane plane, LocalDateTime departTime) {
		EntityManager em = EMFactory.getEntityManager();
		return em.createNamedQuery("Trip.readByPlaneAndDepartDate", Trip.class).setParameter("plane", plane)
				.setParameter("departTime", departTime).getSingleResult();
	}

	
}

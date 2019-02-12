package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import dao.interfaces.ICityDao;
import model.City;

public class CityJpaDao implements ICityDao {

	@Override
	public boolean create(City city) {
				
		EntityManager em = EMFactory.getEntityManager();
		em.getTransaction().begin();
		em.persist(city);
		em.getTransaction().commit();
		em.close();
		return true;
	}

	@Override
	public List<City> readAll() {
		
		EntityManager em = EMFactory.getEntityManager();
		List<City> allCities = em.createNamedQuery("City.All",City.class).getResultList();
		return allCities;
	}

	@Override
	public City readById(int id) {
		EntityManager em = EMFactory.getEntityManager();
		return em.find(City.class, id);
	}

}

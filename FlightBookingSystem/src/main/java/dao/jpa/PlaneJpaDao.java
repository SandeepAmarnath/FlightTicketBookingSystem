package dao.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import dao.interfaces.IPlaneDao;
import model.Plane;

public class PlaneJpaDao implements IPlaneDao {

	@Override
	public boolean create(Plane plane) {

		EntityManager em = EMFactory.getEntityManager();
		em.getTransaction().begin();
		em.persist(plane);
		em.getTransaction().commit();
		em.close();
		return true;

	}

	@Override
	public boolean update(Plane plane) {

		EntityManager em = EMFactory.getEntityManager();
		em.getTransaction().begin();
		em.merge(plane);
		em.getTransaction().commit();
		em.close();
		return true;
	}

	@Override
	public List<Plane> readAll() {

		EntityManager em = EMFactory.getEntityManager();
		List<Plane> allPlanes = em.createNamedQuery("Plane.All", Plane.class).getResultList();
		return allPlanes;
	}

	@Override
	public Plane readById(int id) {
		EntityManager em = EMFactory.getEntityManager();
		return em.find(Plane.class, id);
	}

	@Override
	public List<Plane> readByNameLike(String planeNameLike) {
		EntityManager em = EMFactory.getEntityManager();
		return em.createNamedQuery("Plane.readByNameLike", Plane.class).setParameter("planeNameLike", "%"+planeNameLike+"%").getResultList();
	}

}

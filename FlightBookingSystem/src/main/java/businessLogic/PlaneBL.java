package businessLogic;

import java.util.List;

import dao.interfaces.IPlaneDao;
import dao.jpa.JpaDaoFactory;
import model.Plane;

public class PlaneBL {

	private IPlaneDao planeDao;
	
	
 
	public PlaneBL() {
		this.planeDao = JpaDaoFactory.getPlaneDao();
	}


	
	public boolean create(String planeName,int capity) {
		
		if (planeName.isEmpty() || planeName == null || capity<6) {
			return false;
		}
		Plane plane = new Plane().setPlaneName(planeName).setCapity(capity);
		try {
			return planeDao.create(plane);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public Plane readById(int id) {
		
		try {
			return planeDao.readById(id);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	
	public List<Plane> readByNameLike(String planeNameLike) {
		
		if (planeNameLike.isEmpty() || planeNameLike == null) {
			
			return null;
			
		}
		try {
			return planeDao.readByNameLike(planeNameLike);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	public List<Plane> readAll(){
		
		try {
			return planeDao.readAll();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean update(Plane plane) {
		
		if (plane == null) {
			return false;
		}
		
		try {
			return planeDao.update(plane);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}

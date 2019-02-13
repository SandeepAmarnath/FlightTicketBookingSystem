package businessLogic;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.TransactionRequiredException;

import dao.interfaces.ICityDao;
import dao.jpa.JpaDaoFactory;
import model.City;

public class CityBL {
	
	private ICityDao cDao;
	
	
	public CityBL() {
		this.cDao = JpaDaoFactory.getCityDao();
	}

	public boolean create(String cityName, String cityCode) {
		if (cityCode == null || cityName == null || cityCode.isEmpty() || cityName.isEmpty()) {
			return false;
		}
		City city  = new City().setCityName(cityName).setCityCode(cityCode);
		
		try {
			return this.cDao.create(city);
		} catch (EntityExistsException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (TransactionRequiredException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public List<City> readAll(){
		
		try {
			return this.cDao.readAll();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public City readById(int id) {
		try {
			return this.cDao.readById(id);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return null;
		}
	}
}

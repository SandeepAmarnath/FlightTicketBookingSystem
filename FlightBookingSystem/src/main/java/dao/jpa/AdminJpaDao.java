package dao.jpa;

import java.util.List;

import dao.interfaces.IAdminDao;
import model.Admin;
import model.User;

public class AdminJpaDao implements IAdminDao {

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User register(String username, String password, String phone, String address, String passport) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(Admin t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Admin t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Admin> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin readById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin readByName(String adminName) {
		// TODO Auto-generated method stub
		return null;
	}

}

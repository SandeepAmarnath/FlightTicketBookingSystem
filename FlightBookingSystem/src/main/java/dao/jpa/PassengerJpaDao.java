package dao.jpa;

import java.util.List;

import dao.interfaces.IPassengerDao;
import model.Passenger;
import model.User;

public class PassengerJpaDao implements IPassengerDao{

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
	public boolean create(Passenger t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Passenger t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Passenger> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Passenger readById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Passenger readbyName(String passengerName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Passenger readByPassport(String passport) {
		// TODO Auto-generated method stub
		return null;
	}

}

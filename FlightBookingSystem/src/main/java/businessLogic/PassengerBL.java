package businessLogic;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TransactionRequiredException;

import dao.interfaces.IPassengerDao;
import dao.jpa.JpaDaoFactory;
import model.Passenger;
import model.User;

public class PassengerBL {

	private IPassengerDao passengerDao;

	public PassengerBL() {
		this.passengerDao = JpaDaoFactory.getPassengerDao();
	}

	//TODO: Basic registration
	public boolean register() {
		// TODO: Write here
		return false;
	}
	
	public String register(String firstName, String lastName, String username, String email, String password,
			String phone, String passport) {

		if (firstName == null || firstName.isEmpty() || lastName == null || lastName.isEmpty() || username == null
				|| username.isEmpty())
			return "FirstName or UserName or LastName cannot be blank. Please fill it";

		if (passengerNameTaken(username)) {
			System.err.println("Username " + username + " is not unique. Please try another Username");
			return "Username is not unique. Please try another Username";
		}
		
		Passenger passenger = new Passenger(firstName, lastName, username, phone, email, password, passport);

		try {
			if (passengerDao.register(passenger)) {
				System.err.println("Registered " + username + " Successfully");
				return "Registered " + username + " Successfully";
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();

		}
		return null;
	}

	private boolean passengerNameTaken(String username) {

		if (username == null || username.isEmpty()) {
			return true;
		}
		if (readByUserName(username) != null) {
			return true;
		}
		return false;
	}

	public User readByUserName(String username) {

		if (username == null || username.isEmpty()) {
			return null;
		}

		try {
			return this.passengerDao.readByUserName(username);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return null;
		} catch (NoResultException e) {
			return null;
		}

	}

	public List<Passenger> readAll() {

		try {
			return passengerDao.readAll();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Passenger readById(int id) {

		try {
			return passengerDao.readById(id);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Passenger> readByLastName(String lastName) {

		try {
			return passengerDao.readbyName(lastName);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Passenger readByPassport(String passport) {

		try {
			return passengerDao.readByPassport(passport);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public User login(String username, String password) {

		try {

			return passengerDao.login(username, password);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean update(Passenger passenger) {

		try {
			return passengerDao.update(passenger);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (TransactionRequiredException e) {
			e.printStackTrace();
		}
		return false;
	}
}

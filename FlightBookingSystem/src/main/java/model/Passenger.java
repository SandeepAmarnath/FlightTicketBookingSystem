package model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(name = "Passenger.All", query = "SELECT c FROM Passenger c"), })
public class Passenger extends User {

	private String passport;

	public Passenger(String username, String phone, String email, String password, String passport) {
		super(username, phone, email, password);
		this.passport = passport;
	}

	public Passenger() {

	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	@Override
	public String toString() {
		return "Passenger [passport=" + passport + "]";
	}

}

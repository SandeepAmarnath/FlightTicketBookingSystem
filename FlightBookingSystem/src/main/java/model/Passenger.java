package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({ @NamedQuery(name = "Passenger.All", query = "SELECT c FROM Passenger c"),
			    @NamedQuery(name = "Passenger.readByLastName", query = "SELECT p FROM Passenger p WHERE p.lastName = :passengerLastName"), 
				@NamedQuery(name = "Passenger.readByPassport", query = "SELECT p FROM Passenger p WHERE p.passport = :passport"),
				@NamedQuery(name = "passenger.readByUsernamePassword", query = "SELECT p FROM Passenger p WHERE p.username = :username "
																									+ "AND p.password = :password")
			 })
public class Passenger extends User {

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "passport",unique=true)
	private String passport;

	@OneToMany(mappedBy = "passenger")
	private List<PassengerBooking> passengerBookings;

	@OneToMany(mappedBy = "passenger")
	private List<Booking> bookings;

	public Passenger(String firstName, String lastName, String username, String phone, String email, String password,
			String passport) {
		super(username, phone, email, password);
		this.passport = passport;
		this.firstName = firstName;
		this.lastName = lastName;

	}

	public Passenger() {

	}

	public String getFirstName() {
		return firstName;
	}

	public Passenger setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public Passenger setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public List<PassengerBooking> getTickets() {
		return passengerBookings;
	}

	public Passenger setTickets(List<PassengerBooking> passengerBookings) {
		this.passengerBookings = new ArrayList<>();
		return this;
	}

	public boolean addTicket(PassengerBooking passengerBooking) {

		if (passengerBooking == null)
			return false;
		if (!this.passengerBookings.contains(passengerBooking)) {
			passengerBooking.setPassenger(this);
			return this.passengerBookings.add(passengerBooking);
		}
		return false;

	}

	public boolean removeTicket(PassengerBooking passengerBooking) {

		if (this.passengerBookings == null)
			return false;
		if (this.passengerBookings.contains(passengerBooking)) {
			return this.passengerBookings.remove(passengerBooking);
		}
		return false;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public Passenger setBookings(List<Booking> bookings) {
		this.bookings = new ArrayList<>();
		return this;
	}

	public boolean addBooking(Booking booking) {
		if (booking == null)
			return false;
		if (!this.bookings.contains(booking)) {
			booking.setPassenger(this);
			return this.bookings.add(booking);
		}
		return false;
	}

	public boolean removeBooking(Booking booking) {
		if (this.bookings == null)
			return false;

		if (this.bookings.contains(booking)) {
			return this.bookings.remove(booking);
		}
		return false;
	}

	

	@Override
	public String toString() {
		return "Passenger [firstName=" + firstName + ", lastName=" + lastName + ", passport=" + passport + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookings == null) ? 0 : bookings.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((passport == null) ? 0 : passport.hashCode());
		result = prime * result + ((passengerBookings == null) ? 0 : passengerBookings.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passenger other = (Passenger) obj;
		if (bookings == null) {
			if (other.bookings != null)
				return false;
		} else if (!bookings.equals(other.bookings))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (passport == null) {
			if (other.passport != null)
				return false;
		} else if (!passport.equals(other.passport))
			return false;
		if (passengerBookings == null) {
			if (other.passengerBookings != null)
				return false;
		} else if (!passengerBookings.equals(other.passengerBookings))
			return false;
		return true;
	}

	
	
}

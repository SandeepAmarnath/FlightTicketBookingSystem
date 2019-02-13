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
	private List<Ticket> tickets;

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

	public List<Ticket> getTickets() {
		return tickets;
	}

	public Passenger setTickets(List<Ticket> tickets) {
		this.tickets = new ArrayList<>();
		return this;
	}

	public boolean addTicket(Ticket ticket) {

		if (ticket == null)
			return false;
		if (!this.tickets.contains(ticket)) {
			ticket.setPassenger(this);
			return this.tickets.add(ticket);
		}
		return false;

	}

	public boolean removeTicket(Ticket ticket) {

		if (this.tickets == null)
			return false;
		if (this.tickets.contains(ticket)) {
			return this.tickets.remove(ticket);
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

}

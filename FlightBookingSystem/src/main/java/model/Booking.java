package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Booking implements IStorable {

	@Id
	@Column(name = "bookingId")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_generator")
	@SequenceGenerator(name = "booking_generator", sequenceName = "booking_seq", allocationSize = 50)
	private int bookingId;

	@OneToMany(mappedBy = "booking")
	private List<Ticket> tickets;

	@ManyToOne
	@JoinColumn(name = "tripId", referencedColumnName = "tripId")
	private Trip trip;

	@ManyToOne
	private Passenger passenger;

	@Column(name = "booking_price")
	private double netPrice;

	public Booking() {

	}

	public List<Ticket> getTicket() {
		return tickets;
	}

	public Booking setTicket(Ticket ticket) {
		if (this.tickets == null)
			this.tickets = new ArrayList<>();
		this.tickets.add(ticket);
		return this;
	}

	public boolean addTicket(Ticket ticket) {
		if (this.tickets == null)
			this.tickets = new ArrayList<>();
		if (!this.tickets.contains(ticket)) {
			ticket.setBooking(this);
			return this.tickets.add(ticket);
		}
		return false;
	}

	public boolean removeTicket(Ticket ticket) {
		if (this.tickets.contains(ticket)) {
			return this.tickets.remove(ticket);
		}
		return false;
	}

	public int getBookingId() {
		return bookingId;
	}

	public Trip getTrip() {
		return trip;
	}

	public Booking setTrip(Trip trip) {
		this.trip = trip;
		return this;
	}

	public User getPassenger() {
		return passenger;
	}

	public Booking setPassenger(Passenger passenger) {
		this.passenger = passenger;
		return this;
	}

	public double getNetPrice() {
		return netPrice;
	}

	public Booking setNetPrice(double netPrice) {
		this.netPrice = netPrice;
		return this;
	}

}

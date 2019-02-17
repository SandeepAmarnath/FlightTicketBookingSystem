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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
@Entity
@NamedQueries({ @NamedQuery(name = "Booking.All", query = "SELECT b FROM Booking b"),
				@NamedQuery(name = "Booking.readByPassenger", query = "SELECT b FROM Booking b WHERE b.passenger = :passengerName"),
				@NamedQuery(name = "Booking.readByTripAndPassenger", query = "SELECT b FROM Booking b WHERE b.passenger = :passenger AND b.trip = :trip")
			 })
public class Booking implements IStorable {

	@Id
	@Column(name = "bookingId")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_generator")
	@SequenceGenerator(name = "booking_generator", sequenceName = "booking_seq", allocationSize = 50)
	private int bookingId;

	@OneToMany(mappedBy = "booking")
	private List<PassengerBooking> passengerBookings;

	@ManyToOne
	@JoinColumn(name = "tripId", referencedColumnName = "tripId")
	private Trip trip;

	@ManyToOne
	@JoinColumn(name = "passengerId",referencedColumnName="userId")
	private Passenger passenger;

	@Column(name = "booking_price")
	private double netPrice;

	public Booking() {

	}

	public List<PassengerBooking> getTicket() {
		return passengerBookings;
	}

	public Booking setTicket(PassengerBooking passengerBooking) {
		if (this.passengerBookings == null)
			this.passengerBookings = new ArrayList<>();
		this.passengerBookings.add(passengerBooking);
		return this;
	}

	public boolean addTicket(PassengerBooking passengerBooking) {
		if (this.passengerBookings == null)
			this.passengerBookings = new ArrayList<>();
		if (!this.passengerBookings.contains(passengerBooking)) {
			passengerBooking.setBooking(this);
			return this.passengerBookings.add(passengerBooking);
		}
		return false;
	}

	public boolean removeTicket(PassengerBooking passengerBooking) {
		if (this.passengerBookings.contains(passengerBooking)) {
			return this.passengerBookings.remove(passengerBooking);
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

	public List<PassengerBooking> getTickets() {
		return passengerBookings;
	}

	public Booking setTickets(List<PassengerBooking> passengerBookings) {
		this.passengerBookings = passengerBookings;
		return this;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", passengerBookings=" + passengerBookings + ", trip=" + trip + ", passenger="
				+ passenger + ", netPrice=" + netPrice + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookingId;
		long temp;
		temp = Double.doubleToLongBits(netPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((passenger == null) ? 0 : passenger.hashCode());
		result = prime * result + ((passengerBookings == null) ? 0 : passengerBookings.hashCode());
		result = prime * result + ((trip == null) ? 0 : trip.hashCode());
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
		Booking other = (Booking) obj;
		if (bookingId != other.bookingId)
			return false;
		if (Double.doubleToLongBits(netPrice) != Double.doubleToLongBits(other.netPrice))
			return false;
		if (passenger == null) {
			if (other.passenger != null)
				return false;
		} else if (!passenger.equals(other.passenger))
			return false;
		if (passengerBookings == null) {
			if (other.passengerBookings != null)
				return false;
		} else if (!passengerBookings.equals(other.passengerBookings))
			return false;
		if (trip == null) {
			if (other.trip != null)
				return false;
		} else if (!trip.equals(other.trip))
			return false;
		return true;
	}

	
}

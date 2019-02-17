package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQueries({ @NamedQuery(name = "PassengerBooking.All", query = "SELECT t FROM PassengerBooking t"), 
	@NamedQuery(name = "PassengerBooking.readByBooking", query = "SELECT t FROM PassengerBooking t WHERE t.booking = :booking"),
	@NamedQuery(name = "PassengerBooking.readByPassenger", query = "SELECT t FROM PassengerBooking t WHERE t.passenger = :passenger")
 			 })
public class PassengerBooking implements IStorable {

	@Id
	@Column(name = "ticketId")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_generator")
	@SequenceGenerator(name = "ticket_generator", sequenceName = "ticket_seq", allocationSize = 50)
	private int ticketId;

	@ManyToOne
	@JoinColumn(name = "bookingId", referencedColumnName = "bookingId")
	private Booking booking;
	
	@ManyToOne
	@JoinColumn(name="passengerId",referencedColumnName = "userId")
	private Passenger passenger;
	
	@OneToOne
	private Seat seat;

	@Column
	private double price;

	public PassengerBooking() {

	}

	public int getTicketId() {
		return ticketId;
	}

	public Booking getBooking() {
		return booking;
	}

	public PassengerBooking setBooking(Booking booking) {
		this.booking = booking;
		return this;
	}

	public Seat getSeat() {
		return seat;
	}

	public PassengerBooking setSeat(Seat seat) {
		this.seat = seat;
		return this;
	}

	public double getPrice() {
		return price;
	}
	
	public Passenger getPassenger() {
		return passenger;
	}

	public PassengerBooking setPassenger(Passenger passenger) {
		this.passenger = passenger;
		return this;
	}

	public PassengerBooking setPrice(double price) {
		this.price = price;
		return this;
	}

	@Override
	public String toString() {
		return "PassengerBooking [ticketId=" + ticketId + ", booking=" + booking + ", passenger=" + passenger + ", seat=" + seat
				+ ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((booking == null) ? 0 : booking.hashCode());
		result = prime * result + ((passenger == null) ? 0 : passenger.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((seat == null) ? 0 : seat.hashCode());
		result = prime * result + ticketId;
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
		PassengerBooking other = (PassengerBooking) obj;
		if (booking == null) {
			if (other.booking != null)
				return false;
		} else if (!booking.equals(other.booking))
			return false;
		if (passenger == null) {
			if (other.passenger != null)
				return false;
		} else if (!passenger.equals(other.passenger))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (seat == null) {
			if (other.seat != null)
				return false;
		} else if (!seat.equals(other.seat))
			return false;
		if (ticketId != other.ticketId)
			return false;
		return true;
	}

	
}

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
@NamedQueries({ @NamedQuery(name = "Ticket.All", query = "SELECT t FROM Ticket t"), 
	@NamedQuery(name = "Ticket.readByBooking", query = "SELECT t FROM Ticket t WHERE t.booking = :booking"),
	@NamedQuery(name = "Ticket.readByPassenger", query = "SELECT t FROM Ticket t WHERE t.passenger = :passenger")
 			 })
public class Ticket implements IStorable {

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

	public Ticket() {

	}

	public int getTicketId() {
		return ticketId;
	}

	public Booking getBooking() {
		return booking;
	}

	public Ticket setBooking(Booking booking) {
		this.booking = booking;
		return this;
	}

	public Seat getSeat() {
		return seat;
	}

	public Ticket setSeat(Seat seat) {
		this.seat = seat;
		return this;
	}

	public double getPrice() {
		return price;
	}
	
	public Passenger getPassenger() {
		return passenger;
	}

	public Ticket setPassenger(Passenger passenger) {
		this.passenger = passenger;
		return this;
	}

	public Ticket setPrice(double price) {
		this.price = price;
		return this;
	}

}

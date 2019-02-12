package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

@Entity
public class Seat implements IStorable {

	@Id
	@Column(name = "seatId")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seat_generator")
	@SequenceGenerator(name = "seat_generator", sequenceName = "seat_generator", allocationSize = 50)
	private int seatId;

	@Enumerated(EnumType.STRING)
	@Column
	private SeatNumber seatNumber;

	@Enumerated(EnumType.STRING)
	@Column
	private SeatType seatType;

	@Column
	private double seatPrice;

	@Transient
	private boolean seatAvailabile; // No need to show the availability in database.

	@ManyToMany
//	@JoinTable(name = "Trip_Seat",
//    joinColumns = @JoinColumn(name = "seatId"),
//    inverseJoinColumns = @JoinColumn(name = "tripId"))
	private List<Trip> trips = new ArrayList<>();

	public SeatNumber getSeatNumber() {
		return seatNumber;
	}

	public Seat setSeatNumber(SeatNumber seatNumber) {
		this.seatNumber = seatNumber;
		return this;
	}

	public SeatType getSeatType() {
		return seatType;
	}

	public Seat setSeatType(SeatType seatType) {
		this.seatType = seatType;
		return this;
	}

	public double getSeatPrice() {
		return seatPrice;
	}

	public Seat setSeatPrice(double seatPrice) {
		this.seatPrice = seatPrice;
		return this;
	}

	public int getSeatId() {
		return seatId;
	}

	public List<Trip> getTrips() {
		return trips;
	}

	public Seat setTrips(List<Trip> trips) {
		this.trips = trips;
		return this;
	}

	public boolean isSeatAvailabile() {
		return seatAvailabile;
	}

	public Seat setSeatAvailabile(boolean seatAvailabile) {
		this.seatAvailabile = seatAvailabile;
		return this;
	}

}

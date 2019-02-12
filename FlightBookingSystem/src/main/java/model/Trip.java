package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import model.City;

@Entity
public class Trip implements IStorable {

	@Id
	@Column(name = "tripId")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trip_generator")
	@SequenceGenerator(name = "trip_generator", sequenceName = "trip_seq", allocationSize = 50)
	private int tripId;

	@ManyToOne
	@JoinColumn(name = "planeId", referencedColumnName = "planeId")
	private Plane plane;

	@OneToOne
	private City departCity;

	@OneToOne
	private City arrivalCity;

	@Column
	private LocalDateTime departDateTime;

	@Column
	private LocalDateTime arrivalDateTime;

	@OneToMany(mappedBy = "trip")
	private List<Booking> bookings = new ArrayList<>();

	@ManyToMany // (mappedBy="trips")
	private List<Seat> seats;

	public Trip() {
		super();
	}

	public int getTripId() {
		return tripId;
	}

	public Trip setTripId(int tripId) {
		this.tripId = tripId;
		return this;
	}

	public City getDepartCity() {
		return departCity;
	}

	public Trip setDepartCity(City departCity) {
		this.departCity = departCity;
		return this;
	}

	public City getArrivalCity() {
		return arrivalCity;
	}

	public Trip setArrivalCity(City arrivalCity) {
		this.arrivalCity = arrivalCity;
		return this;
	}

	public LocalDateTime getDepartDateTime() {
		return departDateTime;
	}

	public Trip setDepartDateTime(LocalDateTime departDateTime) {
		this.departDateTime = departDateTime;
		return this;
	}

	public LocalDateTime getArrivalDateTime() {
		return arrivalDateTime;
	}

	public Trip setArrivalDateTime(LocalDateTime arrivalDateTime) {
		this.arrivalDateTime = arrivalDateTime;
		return this;
	}

	public Plane getPlane() {
		return plane;
	}

	public Trip setPlane(Plane plane) {
		this.plane = plane;
		return this;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public Trip setBookings(List<Booking> bookings) {
		this.bookings = new ArrayList<>();
		return this;
	}

	public boolean addBooking(Booking booking) {
		if (this.bookings == null)
			this.bookings = new ArrayList<>();
		if (!this.bookings.contains(booking)) {
			booking.setTrip(this);
			return this.bookings.add(booking);
		}

		return false;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public Trip setSeats(List<Seat> seats) {
		if (this.seats == null)
			this.seats = new ArrayList<>();
		this.seats = seats;
		return this;
	}

	public boolean removeBooking(Booking booking) {
		if (this.bookings.contains(booking))
			return this.bookings.remove(booking);
		return false;
	}

}

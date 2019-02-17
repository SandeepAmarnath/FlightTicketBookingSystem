package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import model.City;

@Entity
@NamedQueries({ @NamedQuery(name = "Trip.All", query = "SELECT t FROM Trip t"), 
				@NamedQuery(name = "Trip.readByPlaneName" , query = "SELECT t FROM Trip t WHERE t.plane = :plane"),
				@NamedQuery(name = "Trip.readBySource" , query = "SELECT t FROM Trip t WHERE t.arrivalCity = :cityName"),
				@NamedQuery(name = "Trip.readByStartDate" , query = "SELECT t FROM Trip t WHERE t.departDateTime Like :startDate"),
				@NamedQuery(name = "Trip.readByPlaneAndDepartDate" , query = "SELECT t FROM Trip t WHERE t.departDateTime = :departTime AND t.plane=:plane")
		     })
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

	@Transient
	private List<SeatNumber> seatsAvailable;
	
	public Trip() {
		
		this.seatsAvailable = new LinkedList<>(Arrays.asList(SeatNumber.values()));
		
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

	public List<SeatNumber> getAvailableSeats(){
		
		return seatsAvailable;
	}
	
	public boolean checkAvailability(SeatNumber seatNumber) {
		
		if (this.seatsAvailable.contains(seatNumber)) {
			this.seatsAvailable.remove(seatNumber);
			return true;
		}
		System.err.println("Seat is already taken");
		return false;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrivalCity == null) ? 0 : arrivalCity.hashCode());
		result = prime * result + ((arrivalDateTime == null) ? 0 : arrivalDateTime.hashCode());
		result = prime * result + ((bookings == null) ? 0 : bookings.hashCode());
		result = prime * result + ((departCity == null) ? 0 : departCity.hashCode());
		result = prime * result + ((departDateTime == null) ? 0 : departDateTime.hashCode());
		result = prime * result + ((plane == null) ? 0 : plane.hashCode());
		result = prime * result + ((seats == null) ? 0 : seats.hashCode());
		result = prime * result + ((seatsAvailable == null) ? 0 : seatsAvailable.hashCode());
		result = prime * result + tripId;
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
		Trip other = (Trip) obj;
		if (arrivalCity == null) {
			if (other.arrivalCity != null)
				return false;
		} else if (!arrivalCity.equals(other.arrivalCity))
			return false;
		if (arrivalDateTime == null) {
			if (other.arrivalDateTime != null)
				return false;
		} else if (!arrivalDateTime.equals(other.arrivalDateTime))
			return false;
		if (bookings == null) {
			if (other.bookings != null)
				return false;
		} else if (!bookings.equals(other.bookings))
			return false;
		if (departCity == null) {
			if (other.departCity != null)
				return false;
		} else if (!departCity.equals(other.departCity))
			return false;
		if (departDateTime == null) {
			if (other.departDateTime != null)
				return false;
		} else if (!departDateTime.equals(other.departDateTime))
			return false;
		if (plane == null) {
			if (other.plane != null)
				return false;
		} else if (!plane.equals(other.plane))
			return false;
		if (seats == null) {
			if (other.seats != null)
				return false;
		} else if (!seats.equals(other.seats))
			return false;
		if (seatsAvailable == null) {
			if (other.seatsAvailable != null)
				return false;
		} else if (!seatsAvailable.equals(other.seatsAvailable))
			return false;
		if (tripId != other.tripId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Trip [tripId=" + tripId + ", plane=" + plane + ", departCity=" + departCity + ", arrivalCity="
				+ arrivalCity + ", departDateTime=" + departDateTime + ", arrivalDateTime=" + arrivalDateTime + "]";
	}

	
	
}

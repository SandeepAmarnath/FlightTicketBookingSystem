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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

@Entity
@NamedQueries({ @NamedQuery(name = "Seat.All", query = "SELECT s FROM Seat s"), 
				@NamedQuery(name = "Seat.readByNumber", query = "SELECT s FROM Seat s WHERE s.seatNumber = :seatNumber")
			  })
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

	@Override
	public String toString() {
		return "Seat [seatId=" + seatId + ", seatNumber=" + seatNumber + ", seatType=" + seatType + ", seatPrice="
				+ seatPrice + ", seatAvailabile=" + seatAvailabile + ", trips=" + trips + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (seatAvailabile ? 1231 : 1237);
		result = prime * result + seatId;
		result = prime * result + ((seatNumber == null) ? 0 : seatNumber.hashCode());
		long temp;
		temp = Double.doubleToLongBits(seatPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((seatType == null) ? 0 : seatType.hashCode());
		result = prime * result + ((trips == null) ? 0 : trips.hashCode());
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
		Seat other = (Seat) obj;
		if (seatAvailabile != other.seatAvailabile)
			return false;
		if (seatId != other.seatId)
			return false;
		if (seatNumber != other.seatNumber)
			return false;
		if (Double.doubleToLongBits(seatPrice) != Double.doubleToLongBits(other.seatPrice))
			return false;
		if (seatType != other.seatType)
			return false;
		if (trips == null) {
			if (other.trips != null)
				return false;
		} else if (!trips.equals(other.trips))
			return false;
		return true;
	}

	
}

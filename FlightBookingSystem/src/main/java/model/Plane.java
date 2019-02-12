package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import model.Trip;

@Entity
@NamedQueries({ @NamedQuery(name = "Plane.All", query = "SELECT p FROM Plane p"), 
				@NamedQuery(name = "Plane.readByName", query = "SELECT p FROM Plane p WHERE p.planeName = :planeName")
			 })
public class Plane implements IStorable{

	@Id
	@Column(name = "planeId")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "plane_generator")
	@SequenceGenerator(name="plane_generator", sequenceName = "plane_seq", allocationSize=50)
	private int planeId;
	
	@Column(name = "plane_company")
	private String planeName;
	
	@Column(name = "seating_capacity")
	private int capity;

	@OneToMany(mappedBy="plane")
	private List<Trip> trips;

	
	public Plane() {
		super();
	}

	public int getFlightId() {
		return planeId;
	}

	public Plane setFlightId(int flightId) {
		this.planeId = flightId;
		return this;
	}

	public String getFightName() {
		return planeName;
	}

	public Plane setFightName(String fightName) {
		this.planeName = fightName;
		return this;
	}

	public int getCapity() {
		return capity;
	}

	public Plane setCapity(int capity) {
		this.capity = capity;
		return this;
	}

	public List<Trip> getTrips() {
		return trips;
	}

	public Plane setTrips(List<Trip> trips) {
		this.trips = new ArrayList<>();
		return this;
	}
	
	public boolean addTrip(Trip trip) {
		
		if(this.trips==null)
			this.trips = new ArrayList<>();
		if(!this.trips.contains(trip)) {
			trip.setPlane(this);
			return this.trips.add(trip);
		}
		return false; 
	}
	
	public boolean removeTrip(Trip trip) {
		if(this.trips.contains(trip))
			return this.trips.remove(trip);
		return false;
	}

	
}

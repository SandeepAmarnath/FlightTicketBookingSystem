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
				@NamedQuery(name = "Plane.readByNameLike", query = "SELECT p FROM Plane p WHERE p.planeName LIKE :planeNameLike")
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

	public Plane setPlaneId(int planeId) {
		this.planeId = planeId;
		return this;
	}

	public String getFightName() {
		return planeName;
	}

	public Plane setPlaneName(String planeName) {
		this.planeName = planeName;
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

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + capity;
		result = prime * result + planeId;
		result = prime * result + ((planeName == null) ? 0 : planeName.hashCode());
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
		Plane other = (Plane) obj;
		if (capity != other.capity)
			return false;
		if (planeId != other.planeId)
			return false;
		if (planeName == null) {
			if (other.planeName != null)
				return false;
		} else if (!planeName.equals(other.planeName))
			return false;
		if (trips == null) {
			if (other.trips != null)
				return false;
		} else if (!trips.equals(other.trips))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Plane [planeId=" + planeId + ", planeName=" + planeName + ", capity=" + capity + "]";
	}

	
	

	
}

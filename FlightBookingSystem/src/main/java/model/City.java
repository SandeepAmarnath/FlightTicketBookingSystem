package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQueries({ @NamedQuery(name = "City.All", query = "SELECT c FROM City c"), })
public class City implements IStorable {

	@Id
	@Column(name = "cityId")
	@SequenceGenerator(name = "seq_city_id", sequenceName = "seq_city_id", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "seq_city_id")
	private int cityId;

	@Column(name = "city_code")
	private String cityCode;

	@Column(name = "city_name")
	private String cityName;

	public City() {
		super();
	}

	public String getCityCode() {
		return cityCode;
	}

	public City setCityCode(String cityCode) {
		this.cityCode = cityCode;
		return this;
	}

	public int getCityId() {
		return cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public City setCityName(String cityName) {
		this.cityName = cityName;
		return this;
	}

	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", cityCode=" + cityCode + ", cityName=" + cityName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cityCode == null) ? 0 : cityCode.hashCode());
		result = prime * result + cityId;
		result = prime * result + ((cityName == null) ? 0 : cityName.hashCode());
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
		City other = (City) obj;
		if (cityCode == null) {
			if (other.cityCode != null)
				return false;
		} else if (!cityCode.equals(other.cityCode))
			return false;
		if (cityId != other.cityId)
			return false;
		if (cityName == null) {
			if (other.cityName != null)
				return false;
		} else if (!cityName.equals(other.cityName))
			return false;
		return true;
	}

	
}

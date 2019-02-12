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

}

package anil.it.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Country {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cid;
	
	private String countryName;

	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Country(Integer cid, String countryName) {
		super();
		this.cid = cid;
		this.countryName = countryName;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@Override
	public String toString() {
		return "Country [cid=" + cid + ", countryName=" + countryName + "]";
	}
	
	

}

package th.co.The1API.model;

import java.io.Serializable;

public class LocationModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8198502217390825952L;

	private Object street;
	private String city;
	private String state;
	private String country;
	private String postcode;
	private Object coordinates;
	private Object timezone;
	
	public Object getStreet() {
		return street;
	}
	public void setStreet(Object street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public Object getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(Object coordinates) {
		this.coordinates = coordinates;
	}
	public Object getTimezone() {
		return timezone;
	}
	public void setTimezone(Object timezone) {
		this.timezone = timezone;
	}
	
	
}

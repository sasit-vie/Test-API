package th.co.The1API.model;

import java.io.Serializable;

public class UserInfoModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8203782975047243591L;
	
	private String gender;
	private NameModel name;
	private LocationModel location;
	private String email;
	private String phone;
	private String cell;
	private Object picture;
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public NameModel getName() {
		return name;
	}
	public void setName(NameModel name) {
		this.name = name;
	}
	public LocationModel getLocation() {
		return location;
	}
	public void setLocation(LocationModel location) {
		this.location = location;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCell() {
		return cell;
	}
	public void setCell(String cell) {
		this.cell = cell;
	}
	public Object getPicture() {
		return picture;
	}
	public void setPicture(Object picture) {
		this.picture = picture;
	}

	
}

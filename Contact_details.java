package com;

public class Contact_details 
{
	protected String first_name;
	protected String last_name;
	protected String address;
	protected String city;
	protected String state;
	protected String zip;
	protected String mobile;
	protected String email;

	public void setFirstName(String name) {
		this.first_name = name;
	}

	public String getFirstName() {
		return first_name;
	}

	public void setLast(String name) {
		this.last_name = name;
	}

	public String getLast() {
		return last_name;
	}

	public void setAddress(String addr) {
		this.address = addr;
	}

	public String getAddress() {
		return address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStateName() {
		return state;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getZip() {
		return zip;
	}

	public void setPhone(String ph) {
		this.mobile = ph;
	}

	public String getPhone() {
		return mobile;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public String toString() {
		return "Name-" + first_name + " " + last_name + "\n Address :" + address + " " + city + " " + state + " " + zip+ "\n Phone Number " + mobile + "\n Email id :  " + email;
	}


}

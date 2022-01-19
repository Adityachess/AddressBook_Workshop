package com.application.AddressBookApp.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;
import lombok.ToString;

@ToString
public class PersonDTO {

	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "Person first name is Invalid")
	private String firstName;

	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "Person last name is Invalid")
	private String lastName;

	@Pattern(regexp = "male|female", message = "Gender needs to be male or female")
	private String gender;

	@Pattern(regexp = "^[6-9]{1}[0-9]{9,}$", message = "Phone Number is invalid")
	@NotNull(message = "Phone Number can not be null")
	private String mobileNo;

	@Pattern(regexp = "^[a-zA-Z0-9_+/#$%?~.-]+@[a-zA-Z0-9.-]+$", message = "Email is invalid")
	@NotNull(message = "Email should not empty")
	private String emailAddress;

	@NotNull(message = "City name should not empty")
	private String city;

	@NotNull(message = "State name should not empty")
	private String state;

	@NotNull(message = "Country name should not empty")
	private String country;

	@NotNull(message = "Address should not empty")
	private String address;

	@NotNull(message = "Profile Picture should not empty")
	private String profilePic;

	/**
	 * creating getters and setters
	 */
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

}

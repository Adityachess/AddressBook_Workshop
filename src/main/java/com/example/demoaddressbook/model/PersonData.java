package com.example.demoaddressbook.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demoaddressbook.dto.PersonDTO;

import lombok.Data;

@Data
@Entity
@Table(name="person_details")
public class PersonData {
	@Id

	private int personId;
	private String fName;
	private String lName;
	private String gender;
	private String phoneNum;
	private String email;
	private String address;
	private String city;
	private String state;
	private String country;
	private String profilePic;

	public PersonData() {
	}

	public PersonData(PersonDTO personDTO) {
	//	this.updatePersonData(personDTO);
	}

	public void updatePersonData(PersonDTO personDTO) {
		this.fName = personDTO.fName;
		this.lName = personDTO.lName;
		this.gender = personDTO.gender;
		this.profilePic = personDTO.profilePic;
		this.phoneNum = personDTO.phoneNum;
		this.email = personDTO.email;
		this.address = personDTO.address;
		this.city = personDTO.city;
		this.state = personDTO.state;
		this.country = personDTO.country;

	}

}
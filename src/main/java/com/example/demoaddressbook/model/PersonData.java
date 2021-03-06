package com.example.demoaddressbook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.example.demoaddressbook.dto.PersonDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
/**
 * 
 * @author 91855
 * using lombok to auto generate getters and setters and constructor
 *
 */
@Data
@Entity
@AllArgsConstructor
@Table(name="person_details")
public class PersonData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "person_id")

	private int pId;
	
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

	@ManyToOne
	@JoinColumn(name = "add_id", referencedColumnName = "book_id")
	private AddressBookData addressBook;
	
	public PersonData() {
	}

	public PersonData(PersonDTO personDTO) {
		this.updatePersonData(personDTO);
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
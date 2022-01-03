package com.example.demoaddressbook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
/**
 * 
 * @author 91855
 * using lombok to auto generate getters and setters also the constructor
 *
 */
@Data
@AllArgsConstructor

public class PersonDTO {
	
	public String fName;
	public String lName;
	public String gender;
	public String profilePic;
	public String phoneNum;
	public String email;
	public String address;
	public String city;
	public String state;
	public String country;
	
	
	

}
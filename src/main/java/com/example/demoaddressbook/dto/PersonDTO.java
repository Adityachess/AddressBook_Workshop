package com.example.demoaddressbook.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 
 * @author 91855 using lombok to auto generate getters and setters also the
 *         constructor
 *
 */
@Data
@AllArgsConstructor

public class PersonDTO {

	/**
	 * Using regex pattern for validation
	 */
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\$]{2,}$", message = "Firstname is Invalid")
	@NotEmpty(message = "FirstName cannot be null")
	public String fName;

	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\$]{2,}$", message = "Lastname is Invalid")
	@NotEmpty(message = "LastName cannot be null")
	public String lName;

	@Pattern(regexp = "male|female", message = "Gender needs to either male or female")
	@NotEmpty(message = "Gender cannot be null")
	public String gender;

	@NotEmpty(message = "profpic cannot be null")
	public String profilePic;

	@Pattern(regexp = "^[1-9]{2}\\s{1}[0-9]{10}$", message = "phone Number is invalid")
	@NotBlank(message = "phone Number can not be null")
	public String phoneNum;

	@Pattern(regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "email is invalid")
	@NotBlank(message = "email can not be null")
	public String email;

	@NotBlank(message = "Address can not be null")
	public String address;

	@NotEmpty(message = "city cannot be null")
	public String city;

	@NotEmpty(message = "state cannot be null")
	public String state;

	@NotEmpty(message = "country cannot be null")
	public String country;

}
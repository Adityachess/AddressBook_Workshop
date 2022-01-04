package com.example.demoaddressbook.dto;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString

public class AddressBookDTO {

	public int bookId;
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\$]{2,}$",message = "Invalid AddressBook name")
	public String addressBookName;
}

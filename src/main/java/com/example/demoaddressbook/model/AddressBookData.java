package com.example.demoaddressbook.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.example.demoaddressbook.dto.AddressBookDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@ToString
@NoArgsConstructor
public class AddressBookData {

	@Id
	// @GeneratedValue
	@Column(name = "book_id")
	private int bookId;

	private String addressBookName;

	/**
	 * public AddressBookData(int bookId, String addressBookName) { this.bookId =
	 * bookId; this.addressBookName = addressBookName; }
	 */

	public AddressBookData(AddressBookDTO addressBookDTO) {
		this.bookId = addressBookDTO.bookId;
		this.addressBookName=addressBookDTO.addressBookName;
	}

	public void updateAddressBookData(AddressBookDTO addressBookDTO) {
		// this.addressBookName = addressBookDTO.addressBookName;
	}

}
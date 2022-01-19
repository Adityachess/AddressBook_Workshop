package com.application.AddressBookApp.service;

import java.util.List;
import com.application.AddressBookApp.dto.AddressBookDTO;
import com.application.AddressBookApp.model.AddressBook;
import com.application.AddressBookApp.model.User;

public interface IAddressBookService {

	List<AddressBook> getAllAddressBook(String token);

	AddressBook getAddressBookByID(Long addressBookID, String token);

	AddressBook createAddressBook(AddressBookDTO addressBookDTO, String token);

	AddressBook updateAddressBookByID(Long addressBookID, AddressBookDTO addressBookDTO, String token);

	void deleteAddressBookByID(Long addressBookID, String token);

	User createUser(User user);

	String generateToken(User user);
}

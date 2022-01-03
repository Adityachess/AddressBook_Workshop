package com.example.demoaddressbook.service;

import java.util.List;

import com.example.demoaddressbook.dto.AddressBookDTO;
import com.example.demoaddressbook.model.AddressBookData;

public interface IAddressBookService {

	List<AddressBookData> getAddressBookData();

	AddressBookData getAddressBookDataById(int addressBookId);

	AddressBookData createAddressBookData(AddressBookDTO addressBookDTO);

	AddressBookData updateAddressBookData(int addressBookId, AddressBookDTO addressBookDTO);

	void deleteAddressBookData(int addressBookId);
}
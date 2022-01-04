package com.example.demoaddressbook.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoaddressbook.dto.AddressBookDTO;
import com.example.demoaddressbook.dto.PersonDTO;
import com.example.demoaddressbook.exception.PersonException;
import com.example.demoaddressbook.model.AddressBookData;
import com.example.demoaddressbook.model.PersonData;
import com.example.demoaddressbook.repository.IAddressBookRepository;

@Service
public class AddressBookService implements IAddressBookService {
	
	@Autowired
	private IAddressBookRepository addressBookRepository;

	/**
	 * @param get method
	 * @return All persons Data
	 */
	@Override
	public List<AddressBookData> getAddressBookData() {
		return addressBookRepository.findAll();
	}

	/**
	 * @param addressBookId
	 * @return particular address if not present user friendly message
	 */
	@Override
	public AddressBookData getAddressBookDataById(int addressBookId) {
		return addressBookRepository.findById(addressBookId).orElseThrow(
				() -> new PersonException("Address book with this id " + addressBookId + " Is not created !"));
	}

	/**
	 * @param addressBokk Dto
	 * @return addressbook data
	 */
	@Override
	public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
		AddressBookData addressBookData = null;
		addressBookData = new AddressBookData(addressBookDTO);
		return addressBookRepository.save(addressBookData);
	}


	/**
	 * @param AddressBookID , AddressB0ok DTO
	 * @return addressbookdata
	 */
	@Override
	public AddressBookData updateAddressBookData(int addressBookId, AddressBookDTO addressBookDTO) {
		AddressBookData addressBookData = this.getAddressBookDataById(addressBookId);
		addressBookData.updateAddressBookData(addressBookDTO);
		return addressBookRepository.save(addressBookData);
	}


	/**
	 * @param addressBookId
	 * @return  String that id is deleted
	 */
	@Override
	public void deleteAddressBookData(int addressBookId) {
		AddressBookData addressBookData = this.getAddressBookDataById(addressBookId);
		addressBookRepository.delete(addressBookData);
	}
}
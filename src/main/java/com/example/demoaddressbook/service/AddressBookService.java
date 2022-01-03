package com.example.demoaddressbook.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoaddressbook.dto.AddressBookDTO;
import com.example.demoaddressbook.dto.PersonDTO;
import com.example.demoaddressbook.model.AddressBookData;
import com.example.demoaddressbook.model.PersonData;
import com.example.demoaddressbook.repository.IAddressBookRepository;

@Service
public class AddressBookService implements IAddressBookService {
	
	@Autowired
	private IAddressBookRepository addressBookRepository;

	@Override
	public List<AddressBookData> getAddressBookData() {
		return addressBookRepository.findAll();
	}

	@Override
	public AddressBookData getAddressBookDataById(int addressBookId) {
		return addressBookRepository.findById(addressBookId).get();
	}

	@Override
	public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
		AddressBookData addressBookData = null;
		addressBookData = new AddressBookData(addressBookDTO);
		return addressBookRepository.save(addressBookData);
	}


	@Override
	public AddressBookData updateAddressBookData(int addressBookId, AddressBookDTO addressBookDTO) {
		AddressBookData addressBookData = this.getAddressBookDataById(addressBookId);
		addressBookData.updateAddressBookData(addressBookDTO);
		return addressBookRepository.save(addressBookData);
	}


	@Override
	public void deleteAddressBookData(int addressBookId) {
		AddressBookData addressBookData = this.getAddressBookDataById(addressBookId);
		addressBookRepository.delete(addressBookData);
	}
}
package com.application.AddressBookApp.service;

import java.util.List;
import java.util.Optional;
import com.application.AddressBookApp.dto.PersonDTO;
import com.application.AddressBookApp.exceptions.AddressBookCustomException;
import com.application.AddressBookApp.exceptions.PersonException;
import com.application.AddressBookApp.model.*;
import com.application.AddressBookApp.repository.AddressBookRepository;
import com.application.AddressBookApp.repository.PersonRepository;
import com.application.AddressBookApp.utility.JwtTokenUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements IPersonService {

	@Autowired
	PersonRepository personRepository;

	@Autowired
	AddressBookRepository addressBookRepository;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	/**
	 * @return : person details
	 */
	@Override
	public List<Person> getPersonData(String token) {
		if (jwtTokenUtil.isValidToken(token)) {
			return personRepository.findAll();
		} else
			throw new AddressBookCustomException("Not Valid Token");
	}

	/**
	 * @param : personID
	 * @return : Person details of particular ID
	 */

	@Override
	public Person getPersonDataById(Long personID, String token) {
		if (jwtTokenUtil.isValidToken(token)) {
			return personRepository.findById(personID)
					.orElseThrow(() -> new AddressBookCustomException("Address Book ID Not Found"));
		} else
			throw new AddressBookCustomException("Not Valid Token");
	}

	/**
	 * @param : personDTO ,addressBookID
	 * @return : Person Data added
	 */
	@Override
	public Person createPersonData(Long addressBookID, PersonDTO personDTO) {
		Person personData = new Person(personDTO);
		Optional<AddressBook> addressBook = addressBookRepository.findById(addressBookID);
		if (addressBook.isPresent()) {
			personData.setAddressBook(addressBook.get());
		} else {
			throw new AddressBookCustomException("Address Book Not Found");
		}
		return personRepository.save(personData);
	}

	/**
	 * @param : personDTO ,addressBookID
	 * @return : Person Data updated
	 */
	@Override
	public Person updatePersonData(Long addressBookID, Long personID, PersonDTO personDTO, String token) {
		Person personData = this.getPersonDataById(personID, token);
		personData.updatePerson(personDTO);
		Optional<AddressBook> addressBook = addressBookRepository.findById(addressBookID);
		if (addressBook.isPresent()) {
			personData.setAddressBook(addressBook.get());
		} else {
			throw new AddressBookCustomException("Address Book Not Found");
		}
		return personRepository.save(personData);
	}

	/**
	 * @param : personID
	 * @param : String message
	 */

	@Override
	public void deletePersonData(Long personID, String token) {
		Person person = this.getPersonDataById(personID, token);
		personRepository.delete(person);
	}
}

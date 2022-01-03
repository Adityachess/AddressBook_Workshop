package com.example.demoaddressbook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoaddressbook.dto.PersonDTO;
import com.example.demoaddressbook.model.AddressBookData;
import com.example.demoaddressbook.model.PersonData;
import com.example.demoaddressbook.repository.IAddressBookRepository;
import com.example.demoaddressbook.repository.IPersonRepository;

@Service
public class PersonService implements IPersonService {
	
	@Autowired
	private IPersonRepository personRepository;

	@Autowired
	private IAddressBookRepository addressbookrepository;

	/**
	 * Using the get method to get all person details
	 */
	@Override
	public List<PersonData> getPersonData() {
		return personRepository.findAll();
	}

	/**
	 * using get method to get the person details by id
	 * @param   person Id
	 * @return  Contact details of the person
	 */
	@Override
	public PersonData getPersonDataById(int addressBookId, int pId) {
		return personRepository.findById(pId).get();
	}

	/**
	 * using post method to create the person details
	 * @param personDTO 
	 * @return  person details
	 */
	@Override
	public PersonData createPersonData(int addressBookId, PersonDTO personDTO) {
		PersonData contactData = null;
		contactData = new PersonData(personDTO);
		Optional<AddressBookData> addressbook = addressbookrepository.findById(addressBookId);
		if (addressbook.isPresent()) {
			contactData.setAddressBook(addressbook.get());
		}
		return personRepository.save(contactData);
	}
	/**
	 * Using put method to update the person details
	 * @param personDTO 
	 * @return  details of the person
	 */
	@Override
	public PersonData updatePersonData(int addressBookId, int pId, PersonDTO personDTO) {
		PersonData personData = this.getPersonDataById(addressBookId, pId);
		personData.updatePersonData(personDTO);
		Optional<AddressBookData> addressbook = addressbookrepository.findById(addressBookId);
		if (addressbook.isPresent()) {
			personData.setAddressBook(addressbook.get());
		}
		return personRepository.save(personData);
	}

	/**
	 * using delete method to remove the person contact
	 * @param   person id
	 * @return  deleted person id with string message
	 */
	@Override
	public void deletePersonData(int addressBookId, int pId) {
		PersonData personData = this.getPersonDataById(addressBookId, pId);
		personRepository.delete(personData);
	}
	
}
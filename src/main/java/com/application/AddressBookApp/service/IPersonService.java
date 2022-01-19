package com.application.AddressBookApp.service;

import java.util.List;
import com.application.AddressBookApp.dto.PersonDTO;
import com.application.AddressBookApp.model.*;

public interface IPersonService {

	List<Person> getPersonData(String token);

	Person createPersonData(Long addressBookID, PersonDTO personDTO);

	Person updatePersonData(Long addressBookID, Long personID, PersonDTO personDTO, String token);

	Person getPersonDataById(Long personID, String token);

	/**
	 * method to delete person
	 * 
	 * @param : personID
	 * @param : personID
	 */
	void deletePersonData(Long personID, String token);
}

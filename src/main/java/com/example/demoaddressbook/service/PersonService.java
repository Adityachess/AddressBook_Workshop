package com.example.demoaddressbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoaddressbook.dto.PersonDTO;
import com.example.demoaddressbook.model.PersonData;
import com.example.demoaddressbook.repository.IPersonRepository;

@Service
public class PersonService implements IPersonService {
	
	@Autowired
	private IPersonRepository personRepository;

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
	public PersonData getPersonDataById(int pId) {
		return personRepository.findById(pId).get();
	}

	/**
	 * using post method to create the person details
	 * @param personDTO 
	 * @return  person details
	 */
	@Override
	public PersonData createPersonData(PersonDTO personDTO) {
		PersonData personData = new PersonData(personDTO);
		return personRepository.save(personData);
	}

	/**
	 * Using put method to update the person details
	 * @param personDTO 
	 * @return  details of the person
	 */
	@Override
	public PersonData updatePersonData(int pId, PersonDTO personDTO) {
        PersonData personData  = this.getPersonDataById(pId);
        personData .updatePersonData(personDTO);
        return personRepository.save(personData);
	}

	/**
	 * using delete method to remove the person contact
	 * @param   person id
	 * @return  deleted person id with string message
	 */
	@Override
	public void deletePersonData(int id) {
		PersonData personData  = this.getPersonDataById(id);
		personRepository.delete(personData );
	}
	
}
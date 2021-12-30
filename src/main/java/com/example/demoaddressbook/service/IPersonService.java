package com.example.demoaddressbook.service;

import java.util.List;

import com.example.demoaddressbook.dto.PersonDTO;
import com.example.demoaddressbook.model.PersonData;

public interface IPersonService {

	List<PersonData> getPersonData();

	PersonData getPersonDataById(int id);

	PersonData createPersonData(PersonDTO personDTO);

	PersonData updatePersonData(int id, PersonDTO personDTO);

	void deletePersonData(int id);
}
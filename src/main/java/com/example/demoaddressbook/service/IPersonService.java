package com.example.demoaddressbook.service;

import java.util.List;

import com.example.demoaddressbook.dto.PersonDTO;
import com.example.demoaddressbook.model.PersonData;

public interface IPersonService {

	List<PersonData> getPersonData();

	PersonData createPersonData(int addressBookId, PersonDTO personDTO);

	PersonData getPersonDataById(int addressBookId, int pId);

	PersonData updatePersonData(int addressBookId, int pId, PersonDTO personDTO);

	void deletePersonData(int addressBookId, int pId);
}
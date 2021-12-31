package com.example.demoaddressbook.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoaddressbook.dto.PersonDTO;
import com.example.demoaddressbook.dto.ResponseDTO;
import com.example.demoaddressbook.model.PersonData;
import com.example.demoaddressbook.service.IPersonService;

@RestController
@RequestMapping("/persondb")
public class PersonController {

	@Autowired
	private IPersonService personService;

	@RequestMapping(value = { "/get" })
	public ResponseEntity<ResponseDTO> getPersonData() {
		List<PersonData> personList = null;
		personList = personService.getPersonData();
		ResponseDTO respDTO = new ResponseDTO("Get Call Successful", personList);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * using get method to fetch all person details in person_db
	 * @param : person id
	 * @return : person details for that particular id
	 */
	@GetMapping("/get/{pId}")
	public ResponseEntity<ResponseDTO> getPersonData(@PathVariable("pId") int pId) {
		PersonData personData = null;
		personData = personService.getPersonDataById(pId);
		ResponseDTO respDTO = new ResponseDTO("Get Call for Id Successful", personData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * Using post method to add person details in person_db
	 * @param : adding the details of the person
	 * @return : data posting for that person
	 */

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> createPersonData(@RequestBody PersonDTO presonDTO) {
		PersonData personData = null;
		personData = personService.createPersonData(presonDTO);
		ResponseDTO respDTO = new ResponseDTO("Created person data Successfully", personData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}


	/**
	 * using put method to update person details in person_db
	 * @param : person data to be updated
	 * @return : updated data of that person
	 */
	@PutMapping("/update/{pId}")
	public ResponseEntity<ResponseDTO> updatePersonData(@PathVariable("pId") int pId, @RequestBody PersonDTO personDTO) {
		PersonData personData = null;
		personData = personService.updatePersonData(pId, personDTO);
		ResponseDTO respDTO = new ResponseDTO("Updated AddressBook data Successfully", personData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}


	/**
	 * using delete method to remove the person details in person_db
	 * @param : person id to be deleted
	 * @return : string if the id is deleted successfully
	 */
	@DeleteMapping("/remove/{pId}")
	public ResponseEntity<ResponseDTO> deleteContactData(@PathVariable("pId") int pId) {
		personService.deletePersonData(pId);
		ResponseDTO response = new ResponseDTO("Delete call success for id ", "deleted id:" + pId);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

	}
}

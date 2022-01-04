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
import org.springframework.web.bind.annotation.RequestParam;
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

	/**
	 * @param url
	 * @return
	 */
	@RequestMapping("/getAll")
	public ResponseEntity<ResponseDTO> getAllAddressBookData() {
		List<PersonData> addressBookList = null;
		addressBookList = personService.getPersonData();
		ResponseDTO respDTO = new ResponseDTO("Get call success", addressBookList);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	
	/**
	 * using get method to fetch all person details in person_db
	 * @param : person id
	 * @return : person details for that particular id
	 */
	@GetMapping("/get")
	public ResponseEntity<ResponseDTO> getAddressBookData(@Valid @RequestParam int addressBookId, @RequestParam int pId) {
		PersonData personDetails = null;
		personDetails = personService.getPersonDataById(addressBookId, pId);
		ResponseDTO respDTO = new ResponseDTO("Get call success for id:" + pId, personDetails);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * Using post method to add person details in person_db
	 * @param : adding the details of the person
	 * @return : data posting for that person
	 */

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> createAddressBookData( @RequestParam int addressBookId, @Valid
			@RequestBody PersonDTO personDTO) {
		PersonData personDetails = null;
		personDetails = personService.createPersonData(addressBookId, personDTO);
		ResponseDTO respDTO = new ResponseDTO("created address book data successfully", personDetails);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}


	/**
	 * using put method to update person details in person_db
	 * @param : person data to be updated
	 * @return : updated data of that person
	 */
	@PutMapping("/update")
	public ResponseEntity<ResponseDTO> updateAddressBookData( @RequestParam int addressBookId, @Valid
			@RequestParam int pId, @RequestBody PersonDTO personDTO) {
		PersonData personDetails = null;
		personDetails = personService.updatePersonData(addressBookId, pId, personDTO);
		ResponseDTO respDTO = new ResponseDTO("updated address book data successfully", personDetails);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}


	/**
	 * using delete method to remove the person details in person_db
	 * @param : person id to be deleted
	 * @return : string if the id is deleted successfully
	 */
	@DeleteMapping("/remove")
	public ResponseEntity<ResponseDTO> deleteAddressBookData(@RequestParam int addressBookId,
			@RequestParam int pId) {
		personService.deletePersonData(addressBookId, pId);
		ResponseDTO respDTO = new ResponseDTO("Deleted AddressBook data Successfully", "deleted id is :" + pId);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
}

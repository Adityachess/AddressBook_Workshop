package com.application.AddressBookApp.controller;

import java.util.List;
import javax.validation.Valid;
import com.application.AddressBookApp.dto.PersonDTO;
import com.application.AddressBookApp.dto.ResponseDTO;
import com.application.AddressBookApp.model.Person;
import com.application.AddressBookApp.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class Personcontroller {
	@Autowired
	IPersonService iPersonService;

	/**
	 * @param : token
	 * @return : ResponseEntity of Person
	 */
	@GetMapping("/get")
	public ResponseEntity<ResponseDTO> getContactDetails(@RequestHeader String token) {
		List<Person> personData = iPersonService.getPersonData(token);
		ResponseDTO responseDTO = new ResponseDTO("Get Call Success : ", personData, HttpStatus.FOUND);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.FOUND);
	}

	/**
	 * @param personID
	 * @return Person Details of that id
	 */
	@GetMapping("/getbyid")
	public ResponseEntity<ResponseDTO> getContactByID(@RequestParam Long personID, @RequestHeader String token) {
		Person personData = iPersonService.getPersonDataById(personID, token);
		ResponseDTO responseDTO = new ResponseDTO("Get Call Success : ", personData, HttpStatus.FOUND);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.FOUND);

	}

	/**
	 * @param personDTO
	 * @return : Added person details
	 */
	@PostMapping("/create/{addressBookID}")
	public ResponseEntity<ResponseDTO> addingContact(@PathVariable("addressBookID") Long addressBookID,
			@Valid @RequestBody PersonDTO personDTO, @RequestHeader String token) {
		Person personData = iPersonService.createPersonData(addressBookID, personDTO);
		ResponseDTO responseDTO = new ResponseDTO("Create Call Success : ", personData, HttpStatus.OK);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	/**
	 * @param personDTO , personID token 
	 * @return : Updated Person details
	 */
	@PutMapping("/update/{personID}")
	public ResponseEntity<ResponseDTO> updateContact(@RequestParam Long addressBookID,
			@Valid @RequestBody PersonDTO contactDTO, @PathVariable("personID") Long personID,
			@RequestHeader String token) {
		Person personData = iPersonService.updatePersonData(addressBookID, personID, contactDTO, token);
		ResponseDTO responseDTO = new ResponseDTO("Update Call Success : ", personData, HttpStatus.OK);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	/**
	 * @param personID , token
	 * @return :message showing delete ID
	 */
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseDTO> deleteContactByID(@RequestParam Long personID, @RequestHeader String token) {
		iPersonService.deletePersonData(personID, token);
		ResponseDTO responseDTO = new ResponseDTO("Deleted Successfull : ", personID, HttpStatus.OK);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
}

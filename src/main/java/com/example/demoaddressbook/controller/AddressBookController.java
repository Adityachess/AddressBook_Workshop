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

import com.example.demoaddressbook.dto.AddressBookDTO;
import com.example.demoaddressbook.dto.ResponseDTO;
import com.example.demoaddressbook.model.AddressBookData;
import com.example.demoaddressbook.service.IAddressBookService;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

	@Autowired
	private IAddressBookService addressBookService;
	
	/**
	 * @param url
	 * @return PersonData for all person
	 */
	@RequestMapping("/getAll")
	public ResponseEntity<ResponseDTO> getAllAddressBookData() {
		List<AddressBookData> addressBookList = null;
		addressBookList = addressBookService.getAddressBookData();
		ResponseDTO respDTO = new ResponseDTO("Get call success", addressBookList);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param addressBookId
	 * @return personData for particular id
	 */
	
	@GetMapping("/get")
	public ResponseEntity<ResponseDTO> getAddressBookData(@RequestParam int addressBookId) {
		AddressBookData personDetails = null;
		personDetails= addressBookService.getAddressBookDataById(addressBookId);
		ResponseDTO respDTO = new ResponseDTO("Get call success for id:" + addressBookId, personDetails);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param AddressBookDTO
	 * @return personData And HTTP status
	 */
	
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> createAddressBookData(@Valid @RequestBody AddressBookDTO addressBookDTO) {
		AddressBookData createBook = null;
		createBook = addressBookService.createAddressBookData(addressBookDTO);
		ResponseDTO respDTO = new ResponseDTO("created address book successfully", createBook);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	/**
	 * 
	 * @param addressbookId ,addressBookDto
	 * @return Updated PersonData And HTTP status
	 */
	
	@PutMapping("update")
	public ResponseEntity<ResponseDTO> updateAddressBookData(@Valid @RequestParam int addressBookId,@RequestBody AddressBookDTO addressBookDTO) {
		AddressBookData createBook = null;
		createBook = addressBookService.updateAddressBookData(addressBookId,addressBookDTO);
		ResponseDTO respDTO = new ResponseDTO("created address book successfully", createBook);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	/**
	 * 
	 * @param addressBookId
	 * @return String if id is removed
	 */
	
	@DeleteMapping("/remove")
	public ResponseEntity<ResponseDTO> deleteAddressBookData(@RequestParam int addressBookId) {
		addressBookService.deleteAddressBookData(addressBookId);
		ResponseDTO respDTO = new ResponseDTO("Deleted AddressBook data Successfully", "deleted addressbookId is :" + addressBookId);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

}
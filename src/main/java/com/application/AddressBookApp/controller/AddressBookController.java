
package com.application.AddressBookApp.controller;

import java.util.List;
import javax.validation.Valid;
import com.application.AddressBookApp.dto.AddressBookDTO;
import com.application.AddressBookApp.dto.ResponseDTO;
import com.application.AddressBookApp.model.AddressBook;
import com.application.AddressBookApp.model.User;
import com.application.AddressBookApp.service.IAddressBookService;

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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

	@Autowired
	IAddressBookService addressBookService;

	/**
	 * @param : username password
	 * @return : user generated
	 */

	@PostMapping("/userregister")
	public ResponseEntity<ResponseDTO> generateUser(@RequestBody User user) {
		User userDetailUser = addressBookService.createUser(user);
		ResponseDTO responseDTO = new ResponseDTO("Create Call Success ", userDetailUser, HttpStatus.CREATED);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);
	}

	/**
	 * @param username password
	 * @return token
	 */

	@GetMapping("/token")
	public ResponseEntity<ResponseDTO> loginUser(@RequestBody User user) {
		String userDetailUser = addressBookService.generateToken(user);
		ResponseDTO responseDTO = new ResponseDTO("Create Call Success ", userDetailUser, HttpStatus.OK);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);

	}

	@GetMapping("/getall")
	public ResponseEntity<ResponseDTO> getAddressBookDetailsDetails(@RequestHeader String token) {
		List<AddressBook> addressBooks = addressBookService.getAllAddressBook(token);
		ResponseDTO responseDTO = new ResponseDTO("Get Call Success ", addressBooks, HttpStatus.ACCEPTED);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.ACCEPTED);
	}

	/**
	 * @param addressBookID
	 * @return : AddressBook details
	 */
	@GetMapping("/getbyid/{addressBookID}")
	public ResponseEntity<ResponseDTO> getAddressBookDetailsByID(@PathVariable("addressBookID") Long addressBookID,
			@RequestHeader String token) {
		AddressBook addressBook = addressBookService.getAddressBookByID(addressBookID, token);
		ResponseDTO responseDTO = new ResponseDTO("Get Call Success ", addressBook, HttpStatus.FOUND);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.FOUND);
	}

	/**
	 * @param addressBookDTO
	 * @return : Created AddressBook
	 */
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> createAddressBook(@Valid @RequestBody AddressBookDTO addressBookDTO,
			@RequestHeader String token) {
		AddressBook addressBook = addressBookService.createAddressBook(addressBookDTO, token);
		ResponseDTO responseDTO = new ResponseDTO("Create Call Success ", addressBook, HttpStatus.CREATED);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);
	}

	/**
	 * @param addressbookID, addressBookDTO
	 * @return : updated addressbookDTO
	 */
	@PutMapping("/update/{addressBookID}")
	public ResponseEntity<ResponseDTO> updateAddressBook(@Valid @RequestBody AddressBookDTO addressBookDTO,
			@PathVariable("addressBookID") Long addressBookID, @RequestHeader String token) {
		AddressBook addressBook = addressBookService.updateAddressBookByID(addressBookID, addressBookDTO, token);
		ResponseDTO responseDTO = new ResponseDTO("Update Call Sucess ", addressBook, HttpStatus.CONTINUE);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CONTINUE);
	}

	/**
	 * @param addressBookID
	 * @return : String after deleting the id
	 */
	@DeleteMapping("/deletebyid/{addressBookID}")
	public ResponseEntity<ResponseDTO> deleteAddressBookID(@PathVariable("addressBookID") Long addressBookID,
			@RequestHeader String token) {
		addressBookService.deleteAddressBookByID(addressBookID, token);
		ResponseDTO responseDTO = new ResponseDTO("Delete Call Sucess ", addressBookID, HttpStatus.NOT_EXTENDED);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.NOT_FOUND);
	}

}
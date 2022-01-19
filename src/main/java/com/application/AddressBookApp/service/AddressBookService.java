package com.application.AddressBookApp.service;

import java.util.List;
import java.util.Optional;

import com.application.AddressBookApp.dto.AddressBookDTO;
import com.application.AddressBookApp.exceptions.AddressBookCustomException;
import com.application.AddressBookApp.model.AddressBook;
import com.application.AddressBookApp.model.User;
import com.application.AddressBookApp.repository.AddressBookRepository;
import com.application.AddressBookApp.repository.UserRepository;
import com.application.AddressBookApp.utility.JwtTokenUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressBookService implements IAddressBookService{

    
    @Autowired
    AddressBookRepository addressBookRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

   
    @Override
    public List<AddressBook> getAllAddressBook(String token) {
        if (jwtTokenUtil.isValidToken(token)){
            return addressBookRepository.findAll();
        }
        else throw new AddressBookCustomException("Not Valid Token");
    }

    
    @Override
    public AddressBook getAddressBookByID(Long addressBookID,String token) {
        if (jwtTokenUtil.isValidToken(token)){
            return addressBookRepository.findById(addressBookID).orElseThrow(()-> new AddressBookCustomException("Address Book ID Not Found"));
        }
        else throw new AddressBookCustomException("Not Valid Token");
    }

  
    @Override
    public AddressBook createAddressBook(AddressBookDTO addressBookDTO,String token) {
        if (jwtTokenUtil.isValidToken(token)){
            AddressBook addressBook = new AddressBook(addressBookDTO);
        return addressBookRepository.save(addressBook);
        }
        else throw new AddressBookCustomException("Not Valid Token");
    }

   
    @Override
    public AddressBook updateAddressBookByID(Long addressBookID, AddressBookDTO addressBookDTO,String token) {
       if (jwtTokenUtil.isValidToken(token)){
        AddressBook addressBook = this.getAddressBookByID(addressBookID,token);
        addressBook.updateAddressBook(addressBookDTO);
        return addressBookRepository.save(addressBook);
       }
       else throw new AddressBookCustomException("Not Valid Token");
    }

  
    @Override
    public void deleteAddressBookByID(Long addressBookID,String token) {
        if (jwtTokenUtil.isValidToken(token)){
            AddressBook addressBook = this.getAddressBookByID(addressBookID,token);
            addressBookRepository.delete(addressBook);
        }
        else throw new AddressBookCustomException("Not Valid Token");
    }

    @Override
    public User createUser(User user){
        return userRepository.save(user);
    }

    @Override
    public String generateToken(User user) {
        Optional<User> userOptional = userRepository.findById(userRepository.getUserDetails(user.getUserName() ,user.getPassword()).getId());
        if(userOptional.isPresent()){

            return jwtTokenUtil.generateToken(user.getUserName());
        }
        else{
            throw new AddressBookCustomException("User Not Found");
        }   
    } 
}

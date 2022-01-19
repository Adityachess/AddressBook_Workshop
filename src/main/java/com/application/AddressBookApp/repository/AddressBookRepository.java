package com.application.AddressBookApp.repository;

import com.application.AddressBookApp.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AddressBookRepository extends JpaRepository<AddressBook,Long>{
    
}

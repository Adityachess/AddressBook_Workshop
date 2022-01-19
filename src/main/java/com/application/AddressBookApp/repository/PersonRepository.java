package com.application.AddressBookApp.repository;

import com.application.AddressBookApp.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long>{  
}

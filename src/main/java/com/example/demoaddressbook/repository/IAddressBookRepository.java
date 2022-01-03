package com.example.demoaddressbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoaddressbook.model.AddressBookData;

public interface IAddressBookRepository extends JpaRepository<AddressBookData, Integer> {

}

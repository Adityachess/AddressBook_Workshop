package com.example.demoaddressbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoaddressbook.model.PersonData;

public interface IPersonRepository extends JpaRepository<PersonData , Integer> {

}
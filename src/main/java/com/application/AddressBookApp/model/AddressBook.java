package com.application.AddressBookApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.application.AddressBookApp.dto.AddressBookDTO;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@Entity
@Table(name = "address_book_list")
public class AddressBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_Book_ID")
    private Long addressBookID;

    private String addressBookName;


   
    public AddressBook(AddressBookDTO addressBookDTO){
        this.updateAddressBook(addressBookDTO);
    }

       public void updateAddressBook(AddressBookDTO addressBookDTO){
        this.addressBookName = addressBookDTO.getAddressBookName();
    }
}
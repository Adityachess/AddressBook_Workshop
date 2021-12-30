package com.example.demoaddressbook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonDTO {
	
    public String fName;
    public String lName;
    public String gender;
    public String phoneNo;
    public String emailId;
    public String postalAddress;
   

}

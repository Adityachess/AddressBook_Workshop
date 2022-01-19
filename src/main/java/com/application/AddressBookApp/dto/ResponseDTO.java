package com.application.AddressBookApp.dto;

import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class ResponseDTO {
	public String message;
	public Object data;
	public HttpStatus httpStatus;

	/**
	 * @param message
	 * @param data
	 * @param httpStatus
	 * generating parametarized constructor
	 */
	public ResponseDTO(String message, Object data, HttpStatus httpStatus) {
		super();
		this.message = message;
		this.data = data;
		this.httpStatus = httpStatus;
	}

	public ResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}

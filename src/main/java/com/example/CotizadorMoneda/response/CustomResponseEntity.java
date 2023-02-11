package com.example.CotizadorMoneda.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CustomResponseEntity {

	public static ResponseEntity<?> getResponseError(String msg, HttpStatus status) {
		return new ResponseEntity<>(msg, status);
	}

}

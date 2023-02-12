package com.example.CotizadorMoneda.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.CotizadorMoneda.response.CustomResponseEntity;
import com.example.CotizadorMoneda.response.VariacionResponse;
import com.example.CotizadorMoneda.service.TasaVariacionService;

@RestController
public class TasaVariacionController {

	@Autowired
	TasaVariacionService tasaVariacionService;

	private final String EMPTY_PARAM = "Alguno de los parametros esta vacio";
	private final String INVALID_PARAM = "Alguno de los parametros es invalido";
	
	@GetMapping("/variacion")
	public ResponseEntity<?> tasaVariacion(@RequestParam("id") Optional<Long> monedaId) {
		if (!monedaId.isPresent()) {
			return CustomResponseEntity.getResponseError(EMPTY_PARAM, HttpStatus.BAD_REQUEST);
		}
		try {
			VariacionResponse variacion = tasaVariacionService.getTasaDeVariacionByMonedaid(monedaId.get());
			return ResponseEntity.ok(variacion);
		} catch (Exception e) {
			return CustomResponseEntity.getResponseError(INVALID_PARAM, HttpStatus.BAD_REQUEST);
		}
	}

}

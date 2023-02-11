package com.example.CotizadorMoneda.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.CotizadorMoneda.model.Moneda;
import com.example.CotizadorMoneda.response.CustomResponseEntity;
import com.example.CotizadorMoneda.response.VariacionResponse;
import com.example.CotizadorMoneda.service.MonedaService;
import com.example.CotizadorMoneda.service.TasaVariacionService;

@RestController
public class TasaVariacionController {

	@Autowired
	MonedaService monedaService;
	@Autowired
	TasaVariacionService tasaVariacionService;

	private final String EMPTY_PARAM = "Alguno de los parametros esta vacio";
	private final String INVALID_PARAM = "Alguno de los parametros es invalido";

	@GetMapping("/tasaDeVariacion")
	public ResponseEntity<?> tasaVariacion(@RequestParam("from") Optional<Long> monedaFromId,
			@RequestParam("to") Optional<Long> monedaToId) {
		if (!(monedaFromId.isPresent() && monedaToId.isPresent())) {
			return CustomResponseEntity.getResponseError(EMPTY_PARAM, HttpStatus.BAD_REQUEST);
		}
		try {
			Moneda monedaFrom = monedaService.findMoneda(monedaFromId.get());
			Moneda monedaTo = monedaService.findMoneda(monedaToId.get());
			VariacionResponse variacion = tasaVariacionService.compararTasasVariacion(monedaFrom, monedaTo);
			return ResponseEntity.ok(variacion);
		} catch (Exception e) {
			return CustomResponseEntity.getResponseError(INVALID_PARAM, HttpStatus.BAD_REQUEST);
		}
	}

}

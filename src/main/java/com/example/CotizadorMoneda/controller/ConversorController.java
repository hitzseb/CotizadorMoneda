package com.example.CotizadorMoneda.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.CotizadorMoneda.response.CustomResponseEntity;
import com.example.CotizadorMoneda.model.Operacion;
import com.example.CotizadorMoneda.response.ConversionResponse;
import com.example.CotizadorMoneda.service.ConversorService;

@RestController
public class ConversorController {

	@Autowired
	ConversorService conversorService;

	private final String EMPTY_PARAM = "Alguno de los parametros esta vacio";
	private final String INVALID_PARAM = "Alguno de los parametros es invalido";

	@GetMapping("/compra")
	public ResponseEntity<?> compraMoneda(@RequestParam("monto") Optional<Double> monto,
			@RequestParam("from") Optional<Long> monedaFromId, @RequestParam("to") Optional<Long> monedaToId) {
		if (!(monto.isPresent() && monedaFromId.isPresent() && monedaToId.isPresent())) {
			return CustomResponseEntity.getResponseError(EMPTY_PARAM, HttpStatus.BAD_REQUEST);
		}
		try {
			ConversionResponse compraResponse = conversorService.convertirMoneda(Operacion.COMPRA, monto.get(),
					monedaFromId.get(), monedaToId.get());
			return ResponseEntity.ok(compraResponse);
		} catch (Exception e) {
			return CustomResponseEntity.getResponseError(INVALID_PARAM, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/venta")
	public ResponseEntity<?> vendeMoneda(@RequestParam("monto") Optional<Double> monto,
			@RequestParam("from") Optional<Long> monedaFromId, @RequestParam("to") Optional<Long> monedaToId) {
		if (!(monto.isPresent() && monedaFromId.isPresent() && monedaToId.isPresent())) {
			return CustomResponseEntity.getResponseError(EMPTY_PARAM, HttpStatus.BAD_REQUEST);
		}
		try {
			ConversionResponse conversionResponse = conversorService.convertirMoneda(Operacion.VENTA, monto.get(),
					monedaFromId.get(), monedaToId.get());
			return ResponseEntity.ok(conversionResponse);
		} catch (Exception e) {
			return CustomResponseEntity.getResponseError(INVALID_PARAM, HttpStatus.BAD_REQUEST);
		}
	}

}

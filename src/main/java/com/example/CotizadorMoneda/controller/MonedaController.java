package com.example.CotizadorMoneda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.CotizadorMoneda.model.Moneda;
import com.example.CotizadorMoneda.service.MonedaService;

@RestController
public class MonedaController {

	@Autowired
	MonedaService monedaService;
	
	@GetMapping("/moneda")
	public ResponseEntity<?> getMonedaById(@RequestParam Long id) {
		Moneda moneda = monedaService.findMonedaById(id);
		return ResponseEntity.ok(moneda);
	}
	
	@GetMapping("/monedas")
	public ResponseEntity<?> getMonedas() {
		List<Moneda> monedas = monedaService.findMonedas();
		return ResponseEntity.ok(monedas);
	}
}

package com.example.CotizadorMoneda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.CotizadorMoneda.model.Valor;
import com.example.CotizadorMoneda.service.ValorService;

@RestController
public class ValorController {
	
	@Autowired
	ValorService valorService;
	
	@GetMapping("valores")
	public ResponseEntity<?> getValoresByMoneda(@RequestParam Long id) {
		List<Valor> valores = valorService.findValoresByMonedaId(id);
		return ResponseEntity.ok(valores);
	}

}

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
	
	@GetMapping("valor")
	public ResponseEntity<?> getValor(@RequestParam("moneda") Long monedaId, @RequestParam("mercado") Long mercadoId) {
		Valor valor = valorService.findValorByMonedaAndMercado(monedaId, mercadoId);
		return ResponseEntity.ok(valor);
	}
	
	@GetMapping("valores")
	public ResponseEntity<?> getValores(@RequestParam("moneda") Long monedaId, @RequestParam("mercado") Long mercadoId) {
		List<Valor> valores = valorService.findValoresByMonedaAndMercado(monedaId, mercadoId);
		return ResponseEntity.ok(valores);
	}

}

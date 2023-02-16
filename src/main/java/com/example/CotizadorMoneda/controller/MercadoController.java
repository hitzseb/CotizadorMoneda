package com.example.CotizadorMoneda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.CotizadorMoneda.model.Mercado;
import com.example.CotizadorMoneda.service.MercadoService;

@RestController
public class MercadoController {
	
	@Autowired
	MercadoService mercadoService;
	
	@GetMapping("/mercado")
	public Mercado getMercadoById(@RequestParam("id") Long mercadoId) {
		return mercadoService.findMercadoById(mercadoId);
	}

}

package com.example.CotizadorMoneda.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Mercado {

	private Long id;
	private Long moneda;
	private String nombre;

}

package com.example.CotizadorMoneda.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Moneda {

	private Long id;
	private String nombre;
	private String simbolo;

}

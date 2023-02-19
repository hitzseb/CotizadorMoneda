package com.example.CotizadorMoneda.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Valor {

	private Long id;
	private Long moneda;
	private Long mercado;
	private boolean activo;
	private double compra;
	private double venta;
	private Date fecha;

}

package com.example.CotizadorMoneda.model;

public class Moneda {
	private Long id;
	private String nombre;
	private String simbolo;
	private double compra;
	private double venta;
	private double variacion;

	public Moneda() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Moneda(Long id, String nombre, String simbolo, double compra, double venta, double variacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.simbolo = simbolo;
		this.compra = compra;
		this.venta = venta;
		this.variacion = variacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public double getCompra() {
		return compra;
	}

	public void setCompra(double compra) {
		this.compra = compra;
	}

	public double getVenta() {
		return venta;
	}

	public void setVenta(double venta) {
		this.venta = venta;
	}

	public double getTasaDeVariacion() {
		return variacion;
	}

	public void setTasaDeVariacion(double variacion) {
		this.variacion = variacion;
	}

}

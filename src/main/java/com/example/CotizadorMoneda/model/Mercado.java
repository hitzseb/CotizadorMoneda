package com.example.CotizadorMoneda.model;

public class Mercado {

	private Long id;
	private Long moneda;
	private String nombre;

	public Mercado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mercado(Long id, Long moneda, String nombre) {
		super();
		this.id = id;
		this.moneda = moneda;
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMoneda() {
		return moneda;
	}

	public void setMoneda(Long moneda) {
		this.moneda = moneda;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}

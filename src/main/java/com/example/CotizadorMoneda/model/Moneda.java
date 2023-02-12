package com.example.CotizadorMoneda.model;

public class Moneda {

	private Long id;
	private String nombre;
	private String simbolo;

	public Moneda() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Moneda(Long id, String nombre, String simbolo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.simbolo = simbolo;
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

}

package com.example.CotizadorMoneda.model;

import java.sql.Date;

public class Valor {
	
	private Long id;
	private Long moneda;
	private boolean activo;
	private double compra;
	private double venta;
	private Date fecha;
	
	public Valor(Long id, Long moneda, boolean activo, double compra, double venta, Date fecha) {
		super();
		this.id = id;
		this.moneda = moneda;
		this.activo = activo;
		this.compra = compra;
		this.venta = venta;
		this.fecha = fecha;
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
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}

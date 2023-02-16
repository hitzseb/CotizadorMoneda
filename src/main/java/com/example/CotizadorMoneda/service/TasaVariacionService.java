package com.example.CotizadorMoneda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CotizadorMoneda.model.Mercado;
import com.example.CotizadorMoneda.model.Moneda;
import com.example.CotizadorMoneda.model.Valor;
import com.example.CotizadorMoneda.response.VariacionResponse;

@Service
public class TasaVariacionService {
	
	@Autowired
	MonedaService monedaService;
	@Autowired
	MercadoService mercadoService;
	@Autowired
	ValorService valorService;
	
	public VariacionResponse getTasaDeVariacion(Long monedaId, Long mercadoId) {
		Moneda moneda = monedaService.findMonedaById(monedaId);
		Mercado mercado = mercadoService.findMercadoById(mercadoId);
		VariacionResponse variacion = new VariacionResponse(moneda.getNombre(), mercado.getNombre(), printTasa(moneda, mercado));
		return variacion;
	}
	
	public String printTasa(Moneda moneda, Mercado mercado) {
		double variacion = 0;
		if (moneda.getId() != mercado.getMoneda()) {
			variacion = calcularVariacion(moneda, mercado);
		}
		if(variacion >= 0) {
			return "+" + variacion + "%";
		} else {
			return variacion + "%";
		}
	}
	
	public double calcularVariacion(Moneda moneda, Mercado mercado) {
		List<Valor> valores = valorService.findValoresByMonedaAndMercado(moneda.getId(), mercado.getId());
		double tasa =0;
		if (valores.size() == 1) {
			return 0;
		}
		if (valores.size() > 2) {
			for (int i = 0; i < valores.size()-1; i++) {
			tasa += calcularTasa(valores.get(i), valores.get(i+1));
			} 
			return tasa / valores.size();
		} else {
			tasa = calcularTasa(valores.get(0), valores.get(1));
			return tasa;
		}
	}
	
	public double calcularTasa(Valor viejoValor, Valor nuevoValor) {
		double valor2 = nuevoValor.getVenta();
		double valor1 = viejoValor.getVenta();
		return ((valor2 - valor1) / valor1 * 100);
	}

}

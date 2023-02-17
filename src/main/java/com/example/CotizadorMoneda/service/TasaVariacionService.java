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
	
//	Devuelve la tasa de variacion histórica de una moneda en un mercado en forma de String:
//	Por ejemplo => "+0.1%"
	
	public VariacionResponse getTasaDeVariacionHistorica(Long monedaId, Long mercadoId) {
		Moneda moneda = monedaService.findMonedaById(monedaId);
		Mercado mercado = mercadoService.findMercadoById(mercadoId);
		VariacionResponse variacion = new VariacionResponse(moneda.getNombre(), mercado.getNombre(), printTasa(moneda, mercado));
		return variacion;
	}
	
//	Agrega a la tasa de variacion el signo de % y el signo + si corresponde
	
	public String printTasa(Moneda moneda, Mercado mercado) {
		double variacion = 0;
		if (moneda.getId() != mercado.getMoneda()) {
			variacion = tasaDeVariacionHistorica(moneda, mercado);
		}
		if(variacion > 0) {
			return "+" + variacion + "%";
		} else {
			return variacion + "%";
		}
	}
	
//	Calcula al tasa de variacion historica de una moneda en un mercado
//	Devuelve el resultado en forma de double basándose en todos los registros de valores para esa moneda en ese mercado
//	Si no encuentra al menos dos registros de valores devuelve 0

	
	public double tasaDeVariacionHistorica(Moneda moneda, Mercado mercado) {
		List<Valor> valores = valorService.findValoresByMonedaAndMercado(moneda.getId(), mercado.getId());
		double tasa =0;
		if (valores.size() == 1) {
			return 0;
		}
		if (valores.size() > 2) {
			for (int i = 0; i < valores.size()-1; i++) {
			tasa += calcularTasaDeVariacion(valores.get(i), valores.get(i+1));
			} 
			return tasa / (valores.size() - 1);
		} else {
			tasa = calcularTasaDeVariacion(valores.get(0), valores.get(1));
			return tasa;
		}
	}
	
//	Tasa de variacion de M = valor de M en t2 - valor de M en t1 / valor de M en t1 * 100
	
	public double calcularTasaDeVariacion(Valor viejoValor, Valor nuevoValor) {
		double valor2 = nuevoValor.getVenta();
		double valor1 = viejoValor.getVenta();
		return ((valor2 - valor1) / valor1 * 100);
	}

}

package com.example.CotizadorMoneda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CotizadorMoneda.model.Moneda;
import com.example.CotizadorMoneda.model.Valor;
import com.example.CotizadorMoneda.response.VariacionResponse;

@Service
public class TasaVariacionService {
	
	@Autowired
	MonedaService monedaService;
	@Autowired
	ValorService valorService;
	
	public VariacionResponse getTasaDeVariacionByMonedaid(Long monedaId) {
		Moneda moneda = monedaService.findMonedaById(monedaId);
		VariacionResponse variacion = new VariacionResponse(moneda.getNombre(), printTasa(moneda));
		return variacion;
	}
	
	public String printTasa(Moneda moneda) {
		double variacion = 0;
		if (moneda.getId() == 1) {
			variacion = - calcularVariacion(monedaService.findMonedaById(Long.valueOf(2)));
		}else {
			variacion = calcularVariacion(moneda);
		}
		if(variacion >= 0) {
			return "+" + variacion + "%";
		} else {
			return variacion + "%";
		}
	}
	
	public double calcularVariacion(Moneda moneda) {
		List<Valor> valores = valorService.findValoresByMonedaId(moneda.getId());
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

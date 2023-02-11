package com.example.CotizadorMoneda.service;

import org.springframework.stereotype.Service;

import com.example.CotizadorMoneda.dto.MonedaVariacionDto;
import com.example.CotizadorMoneda.model.Moneda;
import com.example.CotizadorMoneda.response.VariacionResponse;

@Service
public class TasaVariacionService {

	public VariacionResponse compararTasasVariacion(Moneda monedaFrom, Moneda monedaTo) {
		MonedaVariacionDto monedaVariacionDto = new MonedaVariacionDto(monedaTo.getNombre(),
				calcularTasa(monedaTo, monedaFrom));
		VariacionResponse variacionResponse = new VariacionResponse(monedaFrom.getNombre(), monedaVariacionDto);
		return variacionResponse;
	}

	public String calcularTasa(Moneda monedaFrom, Moneda monedaTo) {
		String tasaVariacion;
		double diferencia = monedaFrom.getTasaDeVariacion() - monedaTo.getTasaDeVariacion();
		if (diferencia >= 0) {
			tasaVariacion = "+" + diferencia + "%";
		} else {
			tasaVariacion = diferencia + "%";
		}
		return tasaVariacion;
	}

}

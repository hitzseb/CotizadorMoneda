package com.example.CotizadorMoneda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CotizadorMoneda.dto.MonedaConversionDto;
import com.example.CotizadorMoneda.model.Moneda;
import com.example.CotizadorMoneda.model.Operacion;
import com.example.CotizadorMoneda.response.ConversionResponse;

@Service
public class ConversorService {
	
	@Autowired
	MonedaService monedaService;
	@Autowired
	ValorService valorService;

	public ConversionResponse convertirMoneda(Operacion operacion, double monto, Long monedaFromId, Long monedaToId) {

		Moneda monedaFrom = monedaService.findMonedaById(monedaFromId);
		String nombreFrom = monedaFrom.getNombre();
		String simboloFrom = monedaFrom.getSimbolo();
		double valorFrom = 0;
		if (operacion == Operacion.COMPRA) {
			valorFrom = valorService.findValorByMonedaId(monedaFromId).getCompra();
		} else if (operacion == Operacion.VENTA) {
			valorFrom = valorService.findValorByMonedaId(monedaFromId).getVenta();
		}
		double conversionFrom = monto * valorFrom;

		MonedaConversionDto monedaFromDto = new MonedaConversionDto(nombreFrom, "ARS$" + valorFrom,
				simboloFrom + monto);

		Moneda monedaTo = monedaService.findMonedaById(monedaToId);
		String nombreTo = monedaTo.getNombre();
		String simboloTo = monedaTo.getSimbolo();
		double valorTo = 0;
		if (operacion == Operacion.COMPRA) {
			valorTo = valorService.findValorByMonedaId(monedaToId).getCompra();
		} else if (operacion == Operacion.VENTA) {
			valorTo = valorService.findValorByMonedaId(monedaToId).getVenta();
		}
		double conversionTo = conversionFrom / valorTo;

		MonedaConversionDto monedaToDto = new MonedaConversionDto(nombreTo, "ARS$" + valorTo, simboloTo + conversionTo);

		ConversionResponse compraResponse = new ConversionResponse(monedaFromDto, monedaToDto);
		return compraResponse;
	}

}

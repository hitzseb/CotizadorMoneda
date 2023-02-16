package com.example.CotizadorMoneda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CotizadorMoneda.dto.MonedaConversionDto;
import com.example.CotizadorMoneda.model.Mercado;
import com.example.CotizadorMoneda.model.Moneda;
import com.example.CotizadorMoneda.model.Operacion;
import com.example.CotizadorMoneda.response.ConversionResponse;

@Service
public class ConversorService {

	@Autowired
	MonedaService monedaService;
	@Autowired
	MercadoService mercadoService;
	@Autowired
	ValorService valorService;

	public ConversionResponse convertirMoneda(Operacion operacion, Long mercadoId, Long monedaFromId, Long monedaToId,
			double monto) {

		Mercado mercado = mercadoService.findMercadoById(mercadoId);
		Moneda monedaMercado = monedaService.findMonedaById(mercado.getMoneda());
		String simboloMercado = monedaMercado.getSimbolo();
		
		Moneda monedaFrom = monedaService.findMonedaById(monedaFromId);
		String nombreFrom = monedaFrom.getNombre();
		String simboloFrom = monedaFrom.getSimbolo();
		
		double valorFrom=0;
		
		if (mercado.getMoneda() == monedaFromId) {
			valorFrom = 1;
		}
		
		if (mercado.getMoneda() != monedaFromId && operacion == Operacion.COMPRA) {
			valorFrom = valorService.findValorByMonedaAndMercado(monedaFromId, mercadoId).getCompra();
		}
		if (mercado.getMoneda() != monedaFromId && operacion == Operacion.VENTA) {
			valorFrom = valorService.findValorByMonedaAndMercado(monedaFromId, mercadoId).getVenta();
		}
		
		double conversionFrom = monto * valorFrom;

		MonedaConversionDto monedaFromDto = new MonedaConversionDto(nombreFrom, simboloMercado + valorFrom,
				simboloFrom + monto);

		Moneda monedaTo = monedaService.findMonedaById(monedaToId);
		String nombreTo = monedaTo.getNombre();
		String simboloTo = monedaTo.getSimbolo();
		double valorTo = 0;
		
		if (mercado.getMoneda() == monedaToId) {
			valorTo = 1;
		}
		
		if (mercado.getMoneda() != monedaToId && operacion == Operacion.COMPRA) {
			valorTo = valorService.findValorByMonedaAndMercado(monedaToId, mercadoId).getCompra();
		}
		if (mercado.getMoneda() != monedaToId && operacion == Operacion.VENTA) {
			valorTo = valorService.findValorByMonedaAndMercado(monedaToId, mercadoId).getVenta();
		}

		double conversionTo = conversionFrom / valorTo;

		MonedaConversionDto monedaToDto = new MonedaConversionDto(nombreTo, simboloMercado + valorTo, simboloTo + conversionTo);

		ConversionResponse compraResponse = new ConversionResponse(monedaFromDto, monedaToDto);
		return compraResponse;
	}

}

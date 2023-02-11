package com.example.CotizadorMoneda.service;

import org.springframework.stereotype.Service;

import com.example.CotizadorMoneda.dto.MonedaConversionDto;
import com.example.CotizadorMoneda.model.Moneda;
import com.example.CotizadorMoneda.response.ConversionResponse;

@Service
public class ConversorService {

	public ConversionResponse compraMoneda(double monto, Moneda monedaFrom, Moneda monedaTo) {

		String nombreFrom = monedaFrom.getNombre();
		String simboloFrom = monedaFrom.getSimbolo();
		double ventaFrom = monedaFrom.getVenta();
		double conversionFrom = monto * ventaFrom;

		MonedaConversionDto monedaFromDto = new MonedaConversionDto(nombreFrom, "ARS$" + ventaFrom,
				simboloFrom + monto);

		String nombreTo = monedaTo.getNombre();
		String simboloTo = monedaTo.getSimbolo();
		double ventaTo = monedaTo.getVenta();
		double conversionTo = conversionFrom / ventaTo;

		MonedaConversionDto monedaToDto = new MonedaConversionDto(nombreTo, "ARS$" + ventaTo, simboloTo + conversionTo);

		ConversionResponse compraResponse = new ConversionResponse(monedaFromDto, monedaToDto);
		return compraResponse;
	}

	public ConversionResponse vendeMoneda(double monto, Moneda monedaFrom, Moneda monedaTo) {

		String nombreFrom = monedaFrom.getNombre();
		String simboloFrom = monedaFrom.getSimbolo();
		double compraFrom = monedaFrom.getCompra();
		double conversionFrom = monto * compraFrom;

		MonedaConversionDto monedaFromDto = new MonedaConversionDto(nombreFrom, "ARS$" + compraFrom,
				simboloFrom + monto);

		String nombreTo = monedaTo.getNombre();
		String simboloTo = monedaTo.getSimbolo();
		double compraTo = monedaTo.getCompra();
		double conversionTo = conversionFrom / compraTo;

		MonedaConversionDto monedaToDto = new MonedaConversionDto(nombreTo, "ARS$" + compraTo,
				simboloTo + conversionTo);

		ConversionResponse ventaResponse = new ConversionResponse(monedaFromDto, monedaToDto);
		return ventaResponse;
	}

}

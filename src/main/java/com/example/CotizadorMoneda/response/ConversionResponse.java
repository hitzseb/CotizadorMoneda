package com.example.CotizadorMoneda.response;

import com.example.CotizadorMoneda.dto.MonedaConversionDto;

public record ConversionResponse(MonedaConversionDto monedaFrom, MonedaConversionDto monedaTo) {
}

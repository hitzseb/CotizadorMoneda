package com.example.CotizadorMoneda.response;

import com.example.CotizadorMoneda.dto.MonedaVariacionDto;

public record VariacionResponse(String monedaFrom, MonedaVariacionDto monedaTo) {
}

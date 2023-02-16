package com.example.CotizadorMoneda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.CotizadorMoneda.mapper.ValorMapper;
import com.example.CotizadorMoneda.model.Valor;

@Service
public class ValorService {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings("deprecation")
	public Valor findValorByMonedaAndMercado(Long monedaId, Long mercadoId) {
		String SQL_QUERY = "SELECT * FROM VALORES WHERE MONEDA=? AND MERCADO=? AND ACTIVO=TRUE;";
		return jdbcTemplate.queryForObject(SQL_QUERY, new Object[] { monedaId, mercadoId }, new ValorMapper());
	}

	@SuppressWarnings("deprecation")
	public List<Valor> findValoresByMonedaAndMercado(Long monedaId, Long mercadoId) {
		String SQL_QUERY = "SELECT * FROM VALORES WHERE MONEDA=? AND MERCADO=? ORDER BY FECHA;";
		return jdbcTemplate.query(SQL_QUERY, new Object[] { monedaId, mercadoId }, new ValorMapper());
	}

}

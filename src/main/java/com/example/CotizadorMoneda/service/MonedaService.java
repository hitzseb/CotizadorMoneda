package com.example.CotizadorMoneda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.CotizadorMoneda.mapper.MonedaMapper;
import com.example.CotizadorMoneda.model.Moneda;

@Service
public class MonedaService {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@SuppressWarnings("deprecation")
	public Moneda findMoneda(Long id) {
		String SQL_QUERY = "SELECT * FROM MONEDAS" + " WHERE ID=?;";
		return jdbcTemplate.queryForObject(SQL_QUERY, new Object[] { id }, new MonedaMapper());
	}

}

package com.example.CotizadorMoneda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.CotizadorMoneda.mapper.MercadoMapper;
import com.example.CotizadorMoneda.model.Mercado;

@Service
public class MercadoService {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings("deprecation")
	public Mercado findMercadoById(Long mercadoId) {
		String SQL_QUERY = "SELECT * FROM MERCADOS WHERE ID=?;";
		return jdbcTemplate.queryForObject(SQL_QUERY, new Object[] { mercadoId }, new MercadoMapper());
	}

	public List<Mercado> findMercados() {
		String SQL_QUERY = "SELECT * FROM MERCADOS;";
		return jdbcTemplate.query(SQL_QUERY, new MercadoMapper());
	}

}

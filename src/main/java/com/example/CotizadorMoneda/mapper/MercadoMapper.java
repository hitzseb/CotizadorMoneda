package com.example.CotizadorMoneda.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.CotizadorMoneda.model.Mercado;

public class MercadoMapper implements RowMapper<Mercado> {

	@Override
	public Mercado mapRow(ResultSet rs, int rowNum) throws SQLException {
		Mercado mercado = new Mercado(rs.getLong(1), rs.getLong(2), rs.getString(3));
		return mercado;
	}

}

package com.example.CotizadorMoneda.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.CotizadorMoneda.model.Moneda;

public class MonedaMapper implements RowMapper<Moneda> {

	@Override
	public Moneda mapRow(ResultSet rs, int rowNum) throws SQLException {
		Moneda moneda = new Moneda(rs.getLong(1), rs.getString(2), rs.getString(3));
		return moneda;
	}

}

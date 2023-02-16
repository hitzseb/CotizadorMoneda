package com.example.CotizadorMoneda.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.CotizadorMoneda.model.Valor;

public class ValorMapper implements RowMapper<Valor> {

	@Override
	public Valor mapRow(ResultSet rs, int rowNum) throws SQLException {
		Valor valor = new Valor(rs.getLong(1), rs.getLong(2), rs.getLong(3), rs.getBoolean(4), rs.getDouble(5),
				rs.getDouble(6), rs.getDate(7));
		return valor;
	}

}

package com.perscholas.Classified.Spring.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.perscholas.Classified.Spring.model.Add;
import com.perscholas.Classified.Spring.repository.AddRepository;

	@Repository("mariaDbBookRepository")
	public class MariadbAddRepository implements AddRepository {

		@Autowired
		private NamedParameterJdbcTemplate mariaDbJdbcTemplate;

		@Override 
		public List<Add> showAdds() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Integer addAdd(Add add) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Boolean removeAdd(Integer Id) {
			// TODO Auto-generated method stub
			return null;
		}
		
		
}

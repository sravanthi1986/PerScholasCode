package com.perscholas.hibernate_validation_repository.repository.impl;

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

import com.perscholas.hibernate_validation_repository.models.Add;
import com.perscholas.hibernate_validation_repository.repository.AddRepository;

@Repository("mariaDbAddRepository")
public class MariaDbAddRepository implements AddRepository {

	@Autowired
	private NamedParameterJdbcTemplate mariaDbJdbcTemplate;
	
	@Override
	public List<Add> showAdds() {
		String selectAdds = "SELECT * FROM adds";
		List<Add> result = mariaDbJdbcTemplate.query(selectAdds, 
				new AddMapper());
		return result;
	}

	@Override
	public Integer addAdd(Add add) {
		Integer id = -1;
		/* The class MapSqlParameterSource behaves much like a Map and holds 
		 * key-value pairs. The keys can be included in a query string to 
		 * accept values associated with the keys such as illustrated in the 
		 * "createCourseSql" string below. */
		MapSqlParameterSource params = new MapSqlParameterSource();
		
		params.addValue("item", add.getItem());
		params.addValue("price", add.getPrice());
		params.addValue("status", add.getStatus());
		String createAddSql = "insert into adds (item, price,status) values "
				+ "(:item, :price,:status)";
		
		/* The KeyHolder instance will receive the primary key generated by 
		 * the database.*/
		KeyHolder keyHolder = new GeneratedKeyHolder();
		Integer createResult = mariaDbJdbcTemplate.update(createAddSql, 
				params, keyHolder);
		/* The JdbcTemplate "update" method returns the number of rows 
		 * affected. If the number is 0, then it indicates the insert 
		 * attempt failed. */
		if (createResult > 0) {
			/* The Database returns a BigInteger that needs to be cast to an 
			 * int or Integer. */
			id = keyHolder.getKey().intValue();
		}
		return id;
	}

	@Override
	public Boolean removeAdd(Integer addId) {
		Integer result;
		String deleteSql = "delete from adds where add_id = :id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", addId);
		result = mariaDbJdbcTemplate.update(deleteSql, params);
		if (result > 0) {
			return true;
		}
		return false;
	}
	
	@Override
	public Boolean updateStatusOne(Integer addStatus) {
		Integer result;
		String deleteSql = "UPDATE adds SET status = 0 WHERE add_id = :id";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", addStatus);
		result = mariaDbJdbcTemplate.update(deleteSql, params);
		if (result > 0) {
			return true;
		}
		return false;
	}
	
	@Override
	public Boolean updateStatusTwo(Integer addStatus) {
		Integer result;
		String deleteSql = "UPDATE adds SET status = 1 WHERE add_id = :id";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", addStatus);
		result = mariaDbJdbcTemplate.update(deleteSql, params);
		if (result > 0) {
			return true;
		}
		return false;
	}
	

	private final class AddMapper implements RowMapper<Add> {

		@Override
		public Add mapRow(ResultSet rs, int rowNum) throws SQLException {
			Add add = new Add();
			add.setAddId(rs.getInt(1));
			add.setItem(rs.getString(2));
			add.setPrice(rs.getDouble(3));
			add.setStatus(rs.getInt(4));
			return add;
		}
	}
	
}

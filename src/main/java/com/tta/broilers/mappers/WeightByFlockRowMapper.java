package com.tta.broilers.mappers;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.tta.broilers.entities.rest.WeightByFlock; 

/**
 * @author EMNA
 *
 *         
 */
public class WeightByFlockRowMapper implements RowMapper<WeightByFlock> {

	@Override
	public WeightByFlock mapRow(ResultSet rs, int arg1) throws SQLException {

		WeightByFlock weightByFlock = new WeightByFlock();
	
		weightByFlock.setAgeFlock(rs.getInt("age_flock"));
		weightByFlock.setWeight(rs.getDouble("measure"));
		weightByFlock.setHouseID(rs.getString("house_id"));
		weightByFlock.setFlockID(rs.getString("flock_id"));
		weightByFlock.setCenterID(rs.getString("center_id"));
		
		
		
		return weightByFlock;
	}


}

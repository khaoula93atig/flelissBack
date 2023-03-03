package com.tta.broilers.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.broilers.entities.rest.visitTasksVerification;

public class VisitTasksVerificationRowMapper  implements RowMapper<visitTasksVerification> {

	@Override
	public visitTasksVerification mapRow(ResultSet rs, int arg1) throws SQLException {
		visitTasksVerification visit = new visitTasksVerification();
		visit.setVisitId(rs.getString("visit_id"));
		visit.setFlockID(rs.getString("flock_id"));
		visit.setAge(rs.getInt("age_flock"));
		visit.setMeasure(rs.getDouble("measure"));
		
		return visit;
	}

}

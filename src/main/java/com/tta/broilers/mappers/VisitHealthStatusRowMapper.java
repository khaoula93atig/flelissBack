package com.tta.broilers.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.broilers.entities.VisitHealthStatus;

/**
 * @author Emna
 *
 *         31 aout 2020
 */
public class VisitHealthStatusRowMapper implements RowMapper<VisitHealthStatus> {

	@Override
	public VisitHealthStatus mapRow(ResultSet rs, int arg1) throws SQLException {

		VisitHealthStatus visitHealthStatus = new VisitHealthStatus();
		//visitHealthStatus.setHealthStatusId(rs.getInt("health_status_id"));
		//visitHealthStatus.setMeasure(rs.getBoolean("measure"));
		visitHealthStatus.setVisitId(rs.getString("visit_id"));
		visitHealthStatus.setCreationDate(rs.getDate("creation_date"));
		visitHealthStatus.setVisitHealthStatusID(rs.getString("visit_health_status_id"));
		visitHealthStatus.setProstration(rs.getBoolean("prostration"));
		visitHealthStatus.setAnorexia(rs.getBoolean("anorexia"));
		visitHealthStatus.setRuffledFeather(rs.getBoolean("ruffled_feather"));
		visitHealthStatus.setDehydratation(rs.getBoolean("dehydratation"));
		visitHealthStatus.setGeneralObservation(rs.getString("general_observation"));
		visitHealthStatus.setCoughing(rs.getBoolean("coughing"));
		visitHealthStatus.setNasalExsudate(rs.getBoolean("nasal_exsudate"));
		visitHealthStatus.setSneezing(rs.getBoolean("sneezing"));	
		visitHealthStatus.setTrachealRales(rs.getBoolean("tracheal_rales"));
		visitHealthStatus.setOcularDischarge(rs.getBoolean("ocular_discharge"));
		visitHealthStatus.setConjonctivitis(rs.getBoolean("conjonctivitis"));
		visitHealthStatus.setOedema(rs.getBoolean("oedema"));	
		visitHealthStatus.setRespiratoryObservation(rs.getString("respiratory_observation"));
		visitHealthStatus.setDiarrhoea(rs.getBoolean("diarrhoea"));
		visitHealthStatus.setWhitish(rs.getBoolean("whitish"));
		visitHealthStatus.setWatery(rs.getBoolean("watery"));
		visitHealthStatus.setMucoid(rs.getBoolean("mucoid"));
		visitHealthStatus.setGreenish(rs.getBoolean("greenish"));
		visitHealthStatus.setDigestiveObservation(rs.getString("digestive_observation"));
		visitHealthStatus.setLocomotionObservation(rs.getString("locomotion_observation"));
		visitHealthStatus.setNervous(rs.getString("nervous"));
		visitHealthStatus.setDermatitis(rs.getString("dermatitis"));
		visitHealthStatus.setOtherObservation(rs.getString("other_observation"));
		
		 
		
	
		return visitHealthStatus;
	}

}

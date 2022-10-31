package com.tta.broilers.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.broilers.entities.VisitNecropsyObservation; 

/**
 * @author RLamouchi @email r.lamouchi@ttatunisia.com
 *
 *         31 aout 2020
 */
public class VisitNecropsyObservationRowMapper implements RowMapper<VisitNecropsyObservation> {

	@Override
	public VisitNecropsyObservation mapRow(ResultSet rs, int arg1) throws SQLException {

		VisitNecropsyObservation visitNecropsyObservation = new VisitNecropsyObservation();

		visitNecropsyObservation.setVisitId(rs.getString("visit_id"));
		visitNecropsyObservation.setCreationDate(rs.getDate("creation_date"));
		visitNecropsyObservation.setVisitNecropsyObservationId(rs.getString("visit_necropsy_observation_id"));
		visitNecropsyObservation.setExternalExamination(rs.getString("external_examination"));
		visitNecropsyObservation.setBones(rs.getString("bones"));
		visitNecropsyObservation.setLegFeet(rs.getString("leg_feet"));
		visitNecropsyObservation.setTrachea(rs.getString("trachea"));
		visitNecropsyObservation.setCrop(rs.getString("crop"));
		visitNecropsyObservation.setThymus(rs.getString("thymus"));
		visitNecropsyObservation.setLiver(rs.getString("liver"));
		visitNecropsyObservation.setSpleen(rs.getString("spleen"));
		visitNecropsyObservation.setKidney(rs.getString("kidney"));
		visitNecropsyObservation.setHeart(rs.getString("heart"));
		visitNecropsyObservation.setLung(rs.getString("lung"));
		visitNecropsyObservation.setGastroIntestinalTract(rs.getString("gastro_intestinal_tract"));
		visitNecropsyObservation.setBursaFabricius(rs.getString("bursa_fabricius"));
		visitNecropsyObservation.setBrain(rs.getString("brain"));


		return visitNecropsyObservation;
	}

}

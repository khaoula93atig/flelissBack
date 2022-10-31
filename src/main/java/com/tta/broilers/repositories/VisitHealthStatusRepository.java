package com.tta.broilers.repositories;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.tta.broilers.dao.VisitHealthStatusInterface;
import com.tta.broilers.entities.VisitHealthStatus;
import com.tta.broilers.mappers.VisitHealthStatusRowMapper;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
@Repository
public class VisitHealthStatusRepository implements VisitHealthStatusInterface {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<VisitHealthStatus> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from  visit_health_status", new VisitHealthStatusRowMapper());

	}

	@Override
	public BasicResponse save(VisitHealthStatus visitHealthStatus) {
		System.out.println("save visitHealthStatus" + visitHealthStatus);
		try {
			System.out.println("save visit");
			visitHealthStatus.setCreationDate(new Date());
			visitHealthStatus.setVisitHealthStatusID(UUID.randomUUID().toString().replace("-", ""));
			jdbcTemplate.update(

					"INSERT INTO visit_health_status(\r\n"
					+ "            visit_health_status_id,visit_id, prostration, anorexia, ruffled_feather, dehydratation, \r\n"
					+ "            general_observation, coughing, nasal_exsudate, sneezing, tracheal_rales, \r\n"
					+ "            ocular_discharge, conjonctivitis, oedema, respiratory_observation, \r\n"
					+ "            diarrhoea, whitish, watery, mucoid, greenish, digestive_observation, \r\n"
					+ "            locomotion_observation, nervous, dermatitis, other_observation, \r\n"
					+ "            creation_date)\r\n"
					+ "    VALUES (?,?, ?, ?, ?, ?, \r\n"
					+ "            ?, ?, ?, ?, ?, \r\n"
					+ "            ?, ?, ?, ?, \r\n"
					+ "            ?, ?, ?, ?, ?, ?, \r\n"
					+ "            ?, ?, ?, ?, \r\n"
					+ "            ?);\r\n"
					+ "",
					 visitHealthStatus.getVisitHealthStatusID(), visitHealthStatus.getVisitId(),
					visitHealthStatus.isProstration(), visitHealthStatus.isAnorexia(),visitHealthStatus.isRuffledFeather(),
					visitHealthStatus.isDehydratation(),visitHealthStatus.getGeneralObservation(),visitHealthStatus.isCoughing(),
					visitHealthStatus.isNasalExsudate(),visitHealthStatus.isSneezing(),visitHealthStatus.isTrachealRales(),
					visitHealthStatus.isOcularDischarge(),visitHealthStatus.isConjonctivitis(),visitHealthStatus.isOedema(),
					visitHealthStatus.getRespiratoryObservation(),visitHealthStatus.isDiarrhoea(),visitHealthStatus.isWhitish(),
					visitHealthStatus.isWatery(),visitHealthStatus.isMucoid(),visitHealthStatus.isGreenish(),  visitHealthStatus.getDigestiveObservation()
					,visitHealthStatus.getLocomotionObservation(),visitHealthStatus.getNervous(),visitHealthStatus.getDermatitis(),
					visitHealthStatus.getOtherObservation(),visitHealthStatus.getCreationDate());
			return new BasicResponse("visitHealthStatus created: " + visitHealthStatus.toString(), HttpStatus.OK);
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public BasicResponse update(VisitHealthStatus visitHealthStatus) {
		try {
			return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public List<VisitHealthStatus> getByVisitId(String visitId) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from  visit_health_status where visit_id=?", new Object[] { visitId },
				new VisitHealthStatusRowMapper());

	}

	@Override
	public List<VisitHealthStatus> getById(String visitId, int healthStatusId) {
		return jdbcTemplate.query(
				"select * from visitTasks vt , visit v ,task t,flock f, \"user\"  u, house h, farm fa  where  v.flock_id=f.flock_id and v.username= u.username and f.house_id=h.house_id and h.farm_id=fa.farm_id and vt.visit_id=v.visit_id and vt.task_id=t.task_id and vt.visit_id=? and t.task_id=?",
				new Object[] { visitId, healthStatusId }, new VisitHealthStatusRowMapper());
	}

}

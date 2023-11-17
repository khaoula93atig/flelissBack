package com.tta.broilers.repositories;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.tta.broilers.entities.Visit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tta.broilers.dao.VisitNecropsyObservationInterface;
import com.tta.broilers.entities.VisitNecropsyObservation;
import com.tta.broilers.mappers.VisitNecropsyObservationRowMapper;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
@Repository
public class VisitNecropsyObservationRepository implements VisitNecropsyObservationInterface {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<VisitNecropsyObservation> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from  visit_necropsy_observation ",
				new VisitNecropsyObservationRowMapper());

	}

	@Override
	public VisitNecropsyObservation save(VisitNecropsyObservation visitNecropsyObservation) {

		try {
			System.out.println("save visit");
			visitNecropsyObservation.setCreationDate(new Date());
			visitNecropsyObservation.setVisitNecropsyObservationId(UUID.randomUUID().toString().replace("-", ""));
			jdbcTemplate.update(

					"INSERT INTO visit_necropsy_observation(\r\n"
					+ "            visit_id, external_examination, bones, leg_feet, trachea, crop, \r\n"
					+ "            thymus, liver, spleen, kidney, heart, lung, gastro_intestinal_tract, \r\n"
					+ "            bursa_fabricius, brain, creation_date, visit_necropsy_observation_id)\r\n"
					+ "    VALUES (?, ?, ?, ?, ?, ?, \r\n"
					+ "            ?, ?, ?, ?, ?, ?, ?, \r\n"
					+ "            ?, ?, ?, ?);\r\n"
					+ "",visitNecropsyObservation.getVisitId(),visitNecropsyObservation.getExternalExamination(),visitNecropsyObservation.getBones(),
					visitNecropsyObservation.getLegFeet(),visitNecropsyObservation.getTrachea(),visitNecropsyObservation.getCrop(),
					visitNecropsyObservation.getThymus(),visitNecropsyObservation.getLiver(),visitNecropsyObservation.getSpleen(),
					visitNecropsyObservation.getKidney(),visitNecropsyObservation.getHeart(),visitNecropsyObservation.getLung(),
					visitNecropsyObservation.getGastroIntestinalTract(),visitNecropsyObservation.getBursaFabricius(),visitNecropsyObservation.getBrain(),
					visitNecropsyObservation.getCreationDate(),visitNecropsyObservation.getVisitNecropsyObservationId()
					
					);
			List<VisitNecropsyObservation> results = getByVisitId(visitNecropsyObservation.getVisitId());
			if (!results.isEmpty()) {
				return results.get(0);
			} else
				return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
			/*return new BasicResponse("visitNecropsyObservation created: " + visitNecropsyObservation.toString(),
					HttpStatus.OK);
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}*/
	}

	@Override
	public BasicResponse update(VisitNecropsyObservation visitNecropsyObservation) {
		/*try {
			List<VisitNecropsyObservation> toUpdate = getById(visitNecropsyObservation.getVisitId(),
					visitNecropsyObservation.getVisitNecropsyObservationId());
			if (!toUpdate.isEmpty()) {
				jdbcTemplate.update(
						"UPDATE visittasks  SET  measure=?, percentage=?  standard=?, deviation=?,action_plan=? WHERE visit_id=? and task_id=?;");
				return new BasicResponse("Visit Tasks updated: " + visitNecropsyObservation.toString(), HttpStatus.OK);
			} else {
				return new BasicResponse("Element introuvable!", HttpStatus.BAD_REQUEST);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
		*/
		return null;
	}

	@Override
	public List<VisitNecropsyObservation> getByVisitId(String visitId) {
		return jdbcTemplate.query("select * from  visit_necropsy_observation where visit_id=?",
				new Object[] { visitId }, new VisitNecropsyObservationRowMapper());
	}

	@Override
	public List<VisitNecropsyObservation> getById(String visitId, int necropsyId) {
		return jdbcTemplate.query(
				"select * from visitTasks vt , visit v ,task t,flock f, \"user\"  u, house h, farm fa  where  v.flock_id=f.flock_id and v.username= u.username and f.house_id=h.house_id and h.farm_id=fa.farm_id and vt.visit_id=v.visit_id and vt.task_id=t.task_id and vt.visit_id=? and t.task_id=?",
				new Object[] { visitId, necropsyId }, new VisitNecropsyObservationRowMapper());
	}

}

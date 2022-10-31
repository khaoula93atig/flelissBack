package com.tta.broilers.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tta.broilers.dao.VisitAuditsInterface;
import com.tta.broilers.entities.VisitAudits;
import com.tta.broilers.mappers.VisitAuditsRowMapper;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
@Repository
public class VisitAuditsRepository implements VisitAuditsInterface {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<VisitAudits> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(
				"select * from  visit_audits",
				new VisitAuditsRowMapper());

	}

	@Override
	public BasicResponse save(VisitAudits visitAudits) {
		System.out.println("save visitHealthStatus"+visitAudits);
		try {
			System.out.println("save visit");
			visitAudits.setCreationDate(new Date());
			
			jdbcTemplate.update(

					"INSERT INTO visit_audits(breeding_management_id, visit_id, measure, creation_date) VALUES (?, ?, ?, ?);",
					visitAudits.getBreedingMnagementId(),visitAudits.getVisitId(),visitAudits.getMeasure(),visitAudits.getCreationDate());
			return new BasicResponse("visit_audits created: " + visitAudits.toString(), HttpStatus.OK);
			} catch (org.springframework.dao.DuplicateKeyException ex) {
				ex.printStackTrace();
				return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

			} catch (Exception ex) {
				ex.printStackTrace();
				return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

			}
	}


	@Override
	public BasicResponse update(VisitAudits visitAudits) {
		try {
			List<VisitAudits> toUpdate = getById(visitAudits.getVisitId(),visitAudits.getBreedingMnagementId());
			if (!toUpdate.isEmpty()) {
				jdbcTemplate.update(
						"UPDATE visit_audits  SET  measure=? WHERE visit_id=? and breeding_management_id=?;");
				return new BasicResponse("visit_audits updated: " + visitAudits.toString(), HttpStatus.OK);
			} else {
				return new BasicResponse("Element introuvable!", HttpStatus.BAD_REQUEST);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}


	@Override
	public List<VisitAudits> getByVisitId(String visitId) {
		// TODO Auto-generated method stub
				return jdbcTemplate.query(
						"select * from  visit_audits where visit_id=?",
						new Object[] { visitId },new VisitAuditsRowMapper());

	}

	@Override
	public List<VisitAudits> getById(String visitId, int breedingManagementId) {
		return jdbcTemplate.query("select * from visit_audits VA , visit v ,breeding_management Bm,flock f, \"user\"  u, house h, farm fa  where  v.flock_id=f.flock_id and v.username= u.username and f.house_id=h.house_id and h.farm_id=fa.farm_id and VA.visit_id=v.visit_id and VA.breeding_management_id=Bm.breeding_management_id and VA.visit_id=? and Bm.breeding_management_id=?",
				new Object[] { visitId, breedingManagementId }, new VisitAuditsRowMapper());
	}











}

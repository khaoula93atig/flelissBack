package com.tta.broilers.repositories;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.tta.broilers.entities.rest.MortalityHistorique;
import com.tta.broilers.mappers.MortalityHistoriqueRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tta.broilers.dao.VisitInterface;
import com.tta.broilers.entities.Flock;
import com.tta.broilers.entities.Visit;
import com.tta.broilers.entities.rest.visitTasksVerification;
import com.tta.broilers.mappers.VisitRowMapper;
import com.tta.broilers.mappers.VisitTasksVerificationRowMapper;
import com.tta.broilers.responses.BasicResponse;
import com.tta.broilers.utils.Utils;

/**
 * @author rym lamouchi
 *
 */
@Repository
public class VisitRepository implements VisitInterface {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private FlockRepository flockRepository;

	@Override
	public List<Visit> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(
				"select * from  visit v, flock f, house h, farm fa, breed b  where  v.type_visit='daily_visit' and  v.flock_id=f.flock_id and f.breed=b.breed_id  and f.house_id=h.house_id and h.farm_id=fa.farm_id",
				new VisitRowMapper());
	}

	@Override
	public Visit save(Visit visit) {
		try {
			System.out.println("visit******** " + visit.toString());
			
			List<Flock> flocks=flockRepository.getById(visit.getFlockID());
			Flock flock=flocks.get(0);
			System.out.println(flock);
			/*if(flock.getRestFlockNumber()==0 && (flock.getFlockNumber()>visit.getMortality())) {
				System.out.println("flock"+flock.toString());
				System.out.println("test1");
				visit.setVisitId(UUID.randomUUID().toString().replace("-", ""));
				visit.setCreationDate(new Date());
				visit.setVisitDate(Utils.SMPDF3.parse(visit.getVisitdateString()));
				System.out.println("date viste "+visit.getVisitDate());
				jdbcTemplate.update(
						"INSERT INTO visit( visit_id, visit_date, frequency,  flock_id, house_id, username, age_flock,type_visit, creation_date,center_id,farm_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);",
						visit.getVisitId(), visit.getVisitDate(), visit.getFrequency(), visit.getFlockID(),
						visit.getHouseID(), visit.getUsername(), visit.getAgeFlock(),visit.getTypeVisit(), visit.getCreationDate(),visit.getCenterID(),visit.getFarmId());

				int d=(int) (flock.getFlockNumber()-visit.getMortality());
				flockRepository.updateRestNumberFlock(flock.getFlockID(),d);
				List<Visit> results = getById(visit.getVisitId());
				if (!results.isEmpty()) {
					results.get(0).setStatusSave("success");
					return results.get(0);
				} else
					return null;
			}else*/ if(flock.getRestFlockNumber()>0 && flock.getFlockNumber()>=flock.getRestFlockNumber() && flock.getRestFlockNumber()>visit.getMortality()) {
				System.out.println("mor"+visit.getMortality());
				System.out.println(flock.getRestFlockNumber()>visit.getMortality());
				System.out.println("test2");
				visit.setVisitId(UUID.randomUUID().toString().replace("-", ""));
				visit.setCreationDate(new Date());
				visit.setVisitDate(Utils.SMPDF3.parse(visit.getVisitdateString()));
				System.out.println("date viste "+visit.getVisitDate());
				jdbcTemplate.update(
						"INSERT INTO visit( visit_id, visit_date, frequency,  flock_id, house_id, username, age_flock,type_visit, creation_date,center_id,farm_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);",
						visit.getVisitId(), visit.getVisitDate(), visit.getFrequency(), visit.getFlockID(),
						visit.getHouseID(), visit.getUsername(), visit.getAgeFlock(),visit.getTypeVisit(), visit.getCreationDate(),visit.getCenterID(),visit.getFarmId());
				System.out.println("mor1"+visit.getMortality());
				int d1=(int)(flock.getRestFlockNumber()-visit.getMortality());
				System.out.println(d1);
				flockRepository.updateRestNumberFlock(flock.getFlockID(), d1);
				System.out.println(visit);
				List<Visit> results = this.getById(visit.getVisitId());
				System.out.println(results);
				if (!results.isEmpty()) {
					results.get(0).setStatusSave("success");
					return results.get(0);
				} else
					return null;
				
			}
			else
					return null;
			//System.out.println("visit******** " + visit.toString());
			
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Visit saveVistveterinarian(Visit visit) {
		try {
			System.out.println("visit" + visit.toString()  );
			visit.setVisitId(UUID.randomUUID().toString().replace("-", ""));
			visit.setCreationDate(new Date());
			visit.setVisitDate(Utils.SMPDF3.parse(visit.getVisitdateString()));
			jdbcTemplate.update(
					"INSERT INTO visit( visit_id, visit_date, frequency,  flock_id, house_id, username, age_flock, creation_date, morbidity, mortality, dwg, eep, total_water_consumption, total_feed_consumption, fcr,type_visit,center_id,farm_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);",
				
					visit.getVisitId(), visit.getVisitDate(), visit.getFrequency(), visit.getFlockID(),
					visit.getHouseID(), visit.getUsername(), visit.getAgeFlock(), visit.getCreationDate(),
					visit.getMorbidity(), visit.getMortality(), visit.getDwg(), visit.getEep(),
					visit.getTotal_water_consumption(), visit.getTotal_feed_consumption(), visit.getFcr(),visit.getTypeVisit(),visit.getCenterID(),visit.getFarmId());

			List<Visit> results = getById(visit.getVisitId());
			if (!results.isEmpty()) {
				return results.get(0);
			} else
				return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public BasicResponse update(Visit visit) {
		try {
			List<Visit> toUpdate = getById(visit.getVisitId());
			if (!toUpdate.isEmpty()) {
				jdbcTemplate.update(
						"UPDATE visit  SET  visit_date=?, frequency=?,  flock_id=? ,age_flock=?  WHERE visit_id=?;",
						visit.getVisitDate(), visit.getFrequency(), visit.getFlockID(), visit.getAgeFlock(),
						visit.getVisitId());
				return new BasicResponse("Visit updated: " + visit.toString(), HttpStatus.OK);
			} else {
				return new BasicResponse("Element introuvable!", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public List<Visit> getById(String id) {
		return jdbcTemplate.query(
				"select * from  visit v, flock f, \"user\"  u, house h, farm fa, breed b  where   v.flock_id=f.flock_id and f.breed=b.breed_id and v.username=u.username and f.house_id=h.house_id and h.farm_id=fa.farm_id and v.visit_id=?",
				new Object[] { id }, new VisitRowMapper());
	}

	@Override
	public List<Visit> getByuserName(String username, String role,String farmID) {
		System.out.println("farm manager ***** "+role);
		if (role.equals("Farm_Manager")) {
			System.out.println("farm manager ");
			return jdbcTemplate.query(
					"select * from visit v , house h , center c,  flock fo , breed b , farm f\r\n"
					+ "where v.type_visit='daily_visit' and h.house_id=v.house_id and c.center_id=v.center_id and fo.flock_id=v.flock_id and b.breed_id =fo.breed  and f.farm_id=v.farm_id  and v.farm_id=?\r\n"
					+ "ORDER BY visit_date  DESC",
					new Object[] {farmID }, new VisitRowMapper());
		}else {
			System.out.println("else if  ");
		return jdbcTemplate.query(
				"\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "select * from visit v , house h , farm f, flock fo ,breed b , \"user\" u where v.type_visit='daily_visit'\r\n"
				+ " and v.house_id=h.house_id and f.farm_id=h.farm_id and v.flock_id=fo.flock_id and fo.breed=b.breed_id \r\n"
				+ " and v.username=? and  v.username=u.username ORDER BY visit_date  DESC ",
				new Object[] { username }, new VisitRowMapper());
		}
	}

	@Override
	public List<Visit> getByuserNameveterinarian(String username, String role, String farmID) {
		System.out.println("farm manager ***** "+role);
		if (role.equals("Farm_Manager")) {
			System.out.println("farm manager ");
			return jdbcTemplate.query(
					"select * from  visit v, flock f, \"user\"  u, house h, farm fa, breed b , company c\r\n"
					+ "where   v.flock_id=f.flock_id and fa.company_id=c.company_id and f.breed=b.breed_id and\r\n"
					+ " v.username=u.username and f.house_id=h.house_id and \r\n"
					+ "  h.farm_id=fa.farm_id and   fa.farm_id=? and type_visit='veter_visit'\r\n"
					+ "  ORDER BY visit_date  DESC",
					new Object[] { farmID }, new VisitRowMapper());
		}else {
			System.out.println("else if  ");
		return jdbcTemplate.query(
				"select * from  visit v, flock f, \"user\"  u, house h, farm fa, breed b  where  "
				+ " v.flock_id=f.flock_id and f.breed=b.breed_id and v.username=u.username and f.house_id=h.house_id and h.farm_id=fa.farm_id and v.username=? "
				+ " and v.type_visit='veter_visit' ORDER BY visit_date  DESC",
				new Object[] { username }, new VisitRowMapper());
		}
	}

	@Override
	public List<visitTasksVerification> getVistTasksVerfication(String flockId, int age, int task) {
		return jdbcTemplate.query(
				"SELECT visit.visit_id, age_flock, flock_id , visittasks.measure\r\n"
				+ "	FROM public.visit join visittasks on visittasks.visit_id = visit.visit_id\r\n"
				+ "	WHERE flock_id=? and age_flock=? and visittasks.task_id=? ;",
				new Object[] { flockId , age , task }, new VisitTasksVerificationRowMapper());
	}

	@Override
	public List<MortalityHistorique> getHistoriqueMortalityByFlock(String flockId) {
		String req = "select measure , visit.age_flock , visit.visit_date\n" +
				"from visittasks join visit on visit.visit_id= visittasks.visit_id\n" +
				"where task_id=8 and visit.flock_id=?\n" +
				"ORDER by visit.age_flock ASC;";
		return jdbcTemplate.query(req, new Object[]{flockId}, new MortalityHistoriqueRowMapper());
	}


}
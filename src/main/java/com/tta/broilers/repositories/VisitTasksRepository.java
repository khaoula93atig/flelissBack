package com.tta.broilers.repositories;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tta.broilers.dao.AirQualityGuidelinesInterface;
import com.tta.broilers.dao.BroodingVentilationInterface;
import com.tta.broilers.dao.DailyWeightInterface;
import com.tta.broilers.dao.FeedConsumptionInterface;
import com.tta.broilers.dao.HumidityGuideInterface;
import com.tta.broilers.dao.TemperatureGuideInterface;
import com.tta.broilers.dao.VisitTasksInterface;
import com.tta.broilers.entities.AirQualityGuidelines;
import com.tta.broilers.entities.BroodingVentilation;
import com.tta.broilers.entities.DailyWeight;
import com.tta.broilers.entities.FeedConsumption;
import com.tta.broilers.entities.HumidityGuide;
import com.tta.broilers.entities.TemperatureGuide;
import com.tta.broilers.entities.VisitTasks;
import com.tta.broilers.entities.rest.WeightVariation;
import com.tta.broilers.mappers.VisitTasksRowMapper;
import com.tta.broilers.responses.BasicResponse;
import com.tta.broilers.utils.Utils;

/**
 * @author rym lamouchi
 *
 */
@Repository
public class VisitTasksRepository implements VisitTasksInterface {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private HumidityGuideInterface humidityGuideInterface;
	@Autowired
	private TemperatureGuideInterface temperatureGuideInterface;
	@Autowired
	private BroodingVentilationInterface broodingVentilationInterface;
	@Autowired
	private AirQualityGuidelinesInterface airQualityGuidelinesInterface;
	@Autowired
	private DailyWeightInterface dailyWeightInterface;
	@Autowired
	private FeedConsumptionInterface feedConsumptionInterface;

	@Override
	public List<VisitTasks> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(
				"select * from visitTasks vt , visit v ,task t,flock f, \"user\"  u, house h, farm fa  where  v.flock_id=f.flock_id and v.username= u.username  and f.house_id=h.house_id and h.farm_id=fa.farm_id and vt.visit_id=v.visit_id and vt.task_id=t.task_id ",
				new VisitTasksRowMapper());

	}

	@Override
	public BasicResponse save(VisitTasks visitTasks) {
		try {
			System.out.println("visitTasks "+visitTasks.toString());

			visitTasks.setCreationDate(new Date());
			int nbrOfWeeks = Utils.GetWeekNbr(visitTasks.getAgeFlock());
			String element = "Ammonia";
			int ageDays = visitTasks.getAgeFlock();
			double measure = visitTasks.getMeasure();
			double percentage = visitTasks.getPercentage();
			visitTasks.setStandard(searchStandard(visitTasks.getTaskId(), nbrOfWeeks, element, ageDays,visitTasks.getBreedId(), measure));
			visitTasks.setDeviation(
					searchDeviation(visitTasks.getTaskId(), nbrOfWeeks, element, ageDays, measure, percentage,visitTasks.getBreedId()));

	jdbcTemplate.update(
					"INSERT INTO visittasks(visit_id, measure, percentage, creation_date, standard, deviation, action_plan,task_id) VALUES (?, ?, ?, ?, ?, ?,?, ?);",
				visitTasks.getVisitId(), visitTasks.getMeasure(), visitTasks.getPercentage(),
					visitTasks.getCreationDate(), visitTasks.getStandard(), visitTasks.getDeviation(),
					visitTasks.getActionPlan(), visitTasks.getTaskId());
			return new BasicResponse("visitTasks created: " + visitTasks.toString(), HttpStatus.OK);
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	private String searchDeviation(int taskId, int nbrOfWeeks, String element, int ageDays, double measure,
			double percentage,int breed) {

		System.out.println("searchDeviation taskId "+taskId+"breed "+breed);

		String deviation = "";
		switch (taskId) {

		case 1: {
			TemperatureGuide temperatureGuide = temperatureGuideInterface.getByWeek(nbrOfWeeks);
			if (measure < temperatureGuide.getUpper_30_weeks()) {
				deviation = "Low";
			} else if (measure > temperatureGuide.getLower_30_weeks()) {
				deviation = "High";
			} else {
				deviation = "Normal";
			}
		}
			break;
		case 2: {
			HumidityGuide humidityGuide = humidityGuideInterface.getByWeek(nbrOfWeeks);
			if (measure < humidityGuide.getMin_relative_humidity()) {
				deviation = "Low";
			} else if (measure > humidityGuide.getMax_relative_humidity()) {
				deviation = "High";
			} else {
				deviation = "Normal";
			}
		}
			break;

		case 3: {
			BroodingVentilation broodingVentilation = broodingVentilationInterface.getByWeek(nbrOfWeeks);
			if (broodingVentilation.getMeters_per_second() == -1) {
				if (measure < broodingVentilation.getMin_meters_per_second()) {
					deviation = "Low";
				} else if (measure > broodingVentilation.getMax_meters_per_second()) {
					deviation = "High";
				} else {
					deviation = "Normal";
				}
			} else {
				if (measure > broodingVentilation.getMeters_per_second()) {
					deviation = "High";
				} else if (measure < broodingVentilation.getMeters_per_second()) {
					deviation = "Low";
				} else {
					deviation = "Normal";
				}

			}

		}
			break;
		case 4: {
			AirQualityGuidelines airQualityGuidelines = airQualityGuidelinesInterface.getByElement(element);
			if (measure >= airQualityGuidelines.getMax_percentage()) {
				deviation = "High";
			} else {
				deviation = "Normal";
			}
		}
			break;
		case 6: {
			FeedConsumption feedConsumption = feedConsumptionInterface.getByAgeDays(ageDays);
			if (percentage > feedConsumption.getDaily_feed_consumption()) {
				deviation = "High";
			} else if (measure < feedConsumption.getDaily_feed_consumption()) {
				deviation = "Low";
			} else if (percentage == feedConsumption.getDaily_feed_consumption()) {
				deviation = "Normal";
			}
		}
			break;
			case 8: {
				if(ageDays==7) {
					if (percentage > 2) {
						deviation = "High";
					} else if (measure <= 1) {
						deviation = "Good";
					} else if (percentage <= 2 && percentage > 1) {
						deviation = "Acceptable";
					}
				}else if(ageDays == 14 || ageDays == 21 || ageDays == 28 || ageDays == 35){
					System.out.println("//// test deviation mortality " + ageDays + '/' + percentage);
					if (percentage >= 1) {
						deviation = "High";
						System.out.println("//// high " );
					} else if (percentage <= 0.5) {
						System.out.println("//// good " );
						deviation = "Good";
					} else if (percentage <= 0.6 && percentage > 0.5) {
						System.out.println("//// acceptable " );
						deviation = "Acceptable";
					}
				}
			}
			break;

		case 11: {
			DailyWeight dailyWeight = dailyWeightInterface.getByAgeDays(ageDays,breed);
			if (measure < dailyWeight.getWeight()) {
				deviation = "Low";
			} else if (measure > dailyWeight.getWeight()) {
				deviation = "High";
			} else {
				deviation = "Normal";
			}
			System.out.println("deviation "+ deviation+"measure "+measure);

		}
			break;
			
		case 12: {
			if(measure>=5 && measure<=7){
				deviation = "Execellent";
	          }
	          else if(measure>=8 && measure<=10){
	        	  deviation = "Average";
	          }
	          else if(measure>=11 && measure<=16){
	        	  deviation = "Poor";
	          }
			System.out.println("deviation "+ deviation+"measure "+measure);

		}
			break;

		default:
			;

		}
		return deviation;
	}

	public String searchStandard(int taskId, int nbrOfWeeks, String element, int ageDays,int breed ,double measure) {

		System.out.println("nbrOfWeeks " + nbrOfWeeks);
		String standard = "";

		switch (taskId) {

		case 1: {
			TemperatureGuide temperatureGuide = temperatureGuideInterface.getByWeek(nbrOfWeeks);

			standard = "[" + temperatureGuide.getUpper_30_weeks() + " - " + temperatureGuide.getLower_30_weeks() + "]";

		}
			break;
		case 2: {
			HumidityGuide humidityGuide = humidityGuideInterface.getByWeek(nbrOfWeeks);

			standard = "[" + humidityGuide.getMin_relative_humidity() + " - " + humidityGuide.getMax_relative_humidity()
					+ "]";
		}
			break;

		case 3: {
			BroodingVentilation broodingVentilation = broodingVentilationInterface.getByWeek(nbrOfWeeks);

			if (broodingVentilation.getMeters_per_second() == -1) {
				standard = "[" + broodingVentilation.getMin_meters_per_second() + " - "
						+ broodingVentilation.getMax_meters_per_second() + "]";
			} else {
				standard = String.valueOf(broodingVentilation.getMeters_per_second());
			}

		}
			break;
		case 4: {
			AirQualityGuidelines airQualityGuidelines = airQualityGuidelinesInterface.getByElement(element);

			standard = String.valueOf(airQualityGuidelines.getMax_percentage());
		}
			break;
		case 6: {
			FeedConsumption feedConsumption = feedConsumptionInterface.getByAgeDays(ageDays);

			standard = String.valueOf(feedConsumption.getDaily_feed_consumption());
		}
			break;
			case 8: {
				if(ageDays==7) {
					standard= "[0,1]";
				}else if(ageDays == 14 || ageDays == 21 || ageDays == 28 || ageDays == 35){
					standard ="[0, 0.5]";
				}
			}
			break;

		case 11: {
			
			DailyWeight dailyWeight = dailyWeightInterface.getByAgeDays(ageDays,breed);
			standard = String.valueOf(dailyWeight.getWeight());
			System.out.println("standard weight////////////////////  "+standard);
		}
		
			break;
			
         case 12: {
			
        	 if(measure>=5 && measure<=7){
                 standard="[5-7]";      
               }
               else if(measure>=8 && measure<=10){
                 standard="[8-10]";
                
               }
               else if(measure>=11 && measure<=16){
                 standard="[11-16]";
               }
			System.out.println("standard homo////////////////////  "+standard);
		}
		
			break;

		default:
			;

		}
		return standard;

	}

	@Override
	public BasicResponse update(VisitTasks visitTasks) {
		try {
			List<VisitTasks> toUpdate = getById(visitTasks.getVisitId(), visitTasks.getTaskId());
			if (!toUpdate.isEmpty()) {
				jdbcTemplate.update(
						"UPDATE visittasks  SET  measure=?, percentage=?  standard=?, deviation=?,action_plan=? WHERE visit_id=? and task_id=?;",
						visitTasks.getMeasure(), visitTasks.getPercentage(), visitTasks.getStandard(),
						visitTasks.getDeviation(), visitTasks.getActionPlan(), visitTasks.getVisitId(),
						visitTasks.getTaskId());
				return new BasicResponse("Visit Tasks updated: " + visitTasks.toString(), HttpStatus.OK);
			} else {
				return new BasicResponse("Element introuvable!", HttpStatus.BAD_REQUEST);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public List<VisitTasks> getByVisitId(String visitId) {

		return jdbcTemplate.query(
				"select * from visitTasks vt , visit v ,flock f, \"user\"  u, house h, farm fa , task t  where  v.flock_id=f.flock_id and v.username= u.username and f.house_id=h.house_id and h.farm_id=fa.farm_id and vt.visit_id=v.visit_id and t.task_id=vt.task_id and vt.visit_id=?",
				new Object[] { visitId }, new VisitTasksRowMapper());
	}

	@Override
	public List<VisitTasks> getById(String visitId, int taskId) {
		return jdbcTemplate.query(
				"select * from visitTasks vt , visit v ,task t,flock f, \"user\"  u, house h, farm fa  where  v.flock_id=f.flock_id and v.username= u.username and f.house_id=h.house_id and h.farm_id=fa.farm_id and vt.visit_id=v.visit_id and vt.task_id=t.task_id and vt.visit_id=? and t.task_id=?",
				new Object[] { visitId, taskId }, new VisitTasksRowMapper());
	}

	@Override
	public double getTotalMeasures(String visitDate, int taskId, String flockId) throws ParseException {
		System.out.println("visitDate" + visitDate );
		Date dateVisit = Utils.SMPDF.parse(visitDate);
		java.sql.Date sqlDate = new java.sql.Date(dateVisit.getTime());
		System.out.println("dateVisit" + dateVisit );
		return jdbcTemplate.queryForObject(
				"SELECT SUM(measure) FROM visittasks vt , visit v  where  vt.visit_id=v.visit_id and visit_date <=? and task_id=? and flock_id=?",
				new Object[] { sqlDate, taskId, flockId }, Double.class);

	}

	@Override
	public WeightVariation WeightVariationByFlock(String flockId) {
		System.out.println("Hello");
		double weightVariationFCRMeasures = 0;
		double weightVariationDWGMeasures = 0;
		double lastWeightMeasure;
		int endingDay = 0;
		int PrevDay = 0;
		List<VisitTasks> result = jdbcTemplate.query(
				"SELECT * FROM visittasks vt , visit v , flock f, house h, farm fa , task t, \"user\" u \r\n"
				+ "where  vt.visit_id=v.visit_id  and v.flock_id=f.flock_id and h.house_id=f.house_id and v.username= u.username \r\n"
				+ "and fa.farm_id=h.farm_id  and vt.task_id=t.task_id and vt.task_id=11 and v.flock_id=?\r\n"
				+ "ORDER BY visit_date ASC",
				new Object[] { flockId }, new VisitTasksRowMapper());
		// result.size()>1 pour la première visite fcr= 0
		System.out.println("reslt"+result);
		if (!result.isEmpty() && result.size() > 1) {

			// ending weight(first visit) – beginning weight (last visit)
			weightVariationFCRMeasures = result.get(result.size() - 1).getMeasure() - result.get(0).getMeasure();

			// ending weight(first visit) – ending-1 weight (previous visit)
			weightVariationDWGMeasures = result.get(result.size() - 1).getMeasure()
					- result.get(result.size() - 2).getMeasure();

			Calendar calendar1 = Calendar.getInstance();
			calendar1.setTime(result.get(result.size() - 1).getVisit().getVisitDate());
			endingDay = calendar1.get(Calendar.DAY_OF_MONTH);

			Calendar calendar2 = Calendar.getInstance();
			calendar2.setTime(result.get(result.size() - 2).getVisit().getVisitDate());
			PrevDay = calendar2.get(Calendar.DAY_OF_MONTH);

		}

		WeightVariation weightVariation = new WeightVariation();
		weightVariation.setWeightVariationFCR(weightVariationFCRMeasures);
		weightVariation.setWeightVariationDWG(weightVariationDWGMeasures);
		weightVariation.setAgeFlock(result.get(result.size() - 1).getVisit().getAgeFlock());
		weightVariation.setBeginningDate(result.get(0).getVisit().getVisitDate());
		weightVariation.setEndingDate(result.get(result.size() - 1).getVisit().getVisitDate());
		weightVariation.setEndingDay(endingDay);
		weightVariation.setPrevDay(PrevDay);
		lastWeightMeasure = result.get(result.size() - 1).getMeasure();
		weightVariation.setLastWeightMeasure(lastWeightMeasure);
		System.out.println("Last weight" + lastWeightMeasure);

		return weightVariation;
	}

}

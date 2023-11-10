package com.tta.broilers.controllers;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tta.broilers.dao.DashboardInterface;
import com.tta.broilers.entities.Flock;
import com.tta.broilers.entities.WeeklyWeightMeasurement;
import com.tta.broilers.entities.rest.AlertByFarm;
import com.tta.broilers.entities.rest.AlertByHouse;
import com.tta.broilers.entities.rest.FlockOutResult;
import com.tta.broilers.entities.rest.FlockWeight;
import com.tta.broilers.entities.rest.MortalityByFarm;
import com.tta.broilers.entities.rest.MortalityByFlock;
import com.tta.broilers.entities.rest.MortalityByhouseLastDays;
import com.tta.broilers.entities.rest.WeeklyWeightMesurementByFlock;
import com.tta.broilers.entities.rest.WeightByBreed;
import com.tta.broilers.mappers.MortalityByHouseLastDaysRowMapper;
/**
 * @author EMNA
 *
 */
@RestController
@RequestMapping("/dashboard")
public class DashboardController {
	@Autowired
	DashboardInterface dashboardInterface;
	
	//work khaoula
	@GetMapping("/weeklyweight/company/{company}")
	public List<WeeklyWeightMeasurement> weeklyweightByCompanyForFarm(@PathVariable("company") String companyId) {
		return dashboardInterface.weeklyweightByCompanyForFarms(companyId);
	}
	
	@GetMapping("/weeklyweight/farm/{farm}")
	public List<WeeklyWeightMeasurement> weeklyweightBycenterforFarm(@PathVariable("farm") String farmId) {
		return dashboardInterface.weeklyweightBycenterforFarm(farmId);
	}
	
	@GetMapping("/weeklyweight/center/{center}")
	public List<WeeklyWeightMeasurement> weeklyweightByhouseforcenter(@PathVariable("center") String centrerId) {
		return dashboardInterface.weeklyweightByHouseforCenter(centrerId);
	}
	
	//alert by farm
	@GetMapping("/alert/{visitDate}/{farm}")
	public List<AlertByFarm> getAlertByFarm(@PathVariable("visitDate") String visitDate,@PathVariable("farm") String farmId) throws ParseException {
		DateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = sourceFormat.parse(visitDate);
		return dashboardInterface.getAllAlertByFarm(date1, farmId);
	}
	
	@GetMapping("/alert/house/{visitDate}/{house}")
	public List<AlertByHouse> getAlertByhouse(@PathVariable("visitDate") String visitDate,@PathVariable("house") String houseId) throws ParseException {
		DateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = sourceFormat.parse(visitDate);
		return dashboardInterface.getAlertByHouse(date1, houseId);
	}
	
	//feedconsumtion by house daily
	@GetMapping("/feed/house/{visitDate}/{house}")
	public double getFeedByhouse(@PathVariable("visitDate") String visitDate,@PathVariable("house") String houseId) throws ParseException {
		DateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = sourceFormat.parse(visitDate);
		return dashboardInterface.getFeedConsumtionDialy(date1, houseId);
	}
	
	//feed consumption total by house 
	@GetMapping("/totalfeed/house/{visitDate}/{house}")
	public double getTotalFeedByhouse(@PathVariable("visitDate") String visitDate,@PathVariable("house") String houseId) throws ParseException {
		DateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = sourceFormat.parse(visitDate);
		return dashboardInterface.getFeedConsumtionTotal(date1, houseId);
	}
	
	//feed of last days by house
	@GetMapping("/feed/lastHouse/{houseId}")
	public List<MortalityByhouseLastDays> getFeedByhouseLastDays(@PathVariable("houseId") String houseId) {
		return dashboardInterface.getFeedByhouseOfLastDays(houseId);
	}
	
	//weight of last days by house
	@GetMapping("/weight/lastdays/{houseId}")
	public List<MortalityByhouseLastDays> getWeightByhouseLastDays(@PathVariable("houseId") String houseId) {
		return dashboardInterface.geWeightByhouseOfLastDays(houseId);
	}
	
	//water of last days by house
	@GetMapping("/water/lastdays/{houseId}")
	public List<MortalityByhouseLastDays> getwaterByhouseLastDays(@PathVariable("houseId") String houseId) {
		return dashboardInterface.getWaterByhouseOfLastDays(houseId);
	}
	
	//waterconsumtion by house daily
	@GetMapping("/water/house/{visitDate}/{house}")
	public double getWaterByhouse(@PathVariable("visitDate") String visitDate,@PathVariable("house") String houseId) throws ParseException {
		DateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = sourceFormat.parse(visitDate);
		return dashboardInterface.getWaterConsumtionDialy(date1, houseId);
	}
		
	//water consumption total by house 
	@GetMapping("/totalwater/house/{visitDate}/{house}")
	public double getTotalWterByhouse(@PathVariable("visitDate") String visitDate,@PathVariable("house") String houseId) throws ParseException {
		DateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = sourceFormat.parse(visitDate);
		return dashboardInterface.getWaterConsumtionTotal(date1, houseId);
	}
	
	//weight by house daily
		@GetMapping("/weight/house/{visitDate}/{house}")
		public double getWeightByhouse(@PathVariable("visitDate") String visitDate,@PathVariable("house") String houseId) throws ParseException {
			DateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = sourceFormat.parse(visitDate);
			return dashboardInterface.getWeightMesurementDialy(date1, houseId);
		}
		
	//weight by house daily
		@GetMapping("/weight/cv/house/{visitDate}/{house}")
		public double getCVByhouse(@PathVariable("visitDate") String visitDate,@PathVariable("house") String houseId) throws ParseException {
			DateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = sourceFormat.parse(visitDate);
			return dashboardInterface.getCVMesurementTotal(date1, houseId);
		}
	
		//feed comsum by farm for company
				@GetMapping("/feed/company/{companyId}/{visitDate}")
				public List<MortalityByFarm> getfeedTotalconsumByfarm(@PathVariable("companyId") String companyId, @PathVariable("visitDate") String visitDate) throws ParseException {
					DateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-dd");
					Date date1 = sourceFormat.parse(visitDate);
					return dashboardInterface.getTotalFeedConsumByFarm(companyId , date1);
				}
		//all flock by house and year
		@GetMapping("/flock/house/{houseId}/{year}")
		public List<Flock> getflockByHouseAndYear(@PathVariable("houseId") String houseId,@PathVariable("year") int year)  {
			return dashboardInterface.getFlocksByHouseAndYear(houseId, year);
			}
		//weeklyweight by flock by house and year
		@GetMapping("/flock/weight/{houseId}/{year}")
		public List<WeeklyWeightMesurementByFlock> getWeightflockByHouseAndYear(@PathVariable("houseId") String houseId,@PathVariable("year") int year)  {
			return dashboardInterface.getWeightByFlock(houseId, year);
			}
		//feed by flock by house and year
		@GetMapping("/flock/feed/{houseId}/{year}")
		public List<WeeklyWeightMesurementByFlock> getFeedFlockByHouseAndYear(@PathVariable("houseId") String houseId,@PathVariable("year") int year)  {
			return dashboardInterface.getfeedByFlock(houseId, year);
			}
			
		//water by flock by house and year
		@GetMapping("/flock/water/{houseId}/{visitDate}/{year}")
		public List<MortalityByFlock> getWaterByFlock(@PathVariable("houseId") String houseId,@PathVariable("visitDate") String visitDate,@PathVariable("year") int year) throws ParseException {
			DateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = sourceFormat.parse(visitDate);
			return dashboardInterface.getWaterByFlock(houseId, date1, year);
		}
		
	//get result of outgoing flocks on body weight in 35 day
	@GetMapping("/flock/out/{companyId}")
	public List<FlockOutResult> getFlockOutResultOfBodyWeight(@PathVariable("companyId") String companyId){
		return dashboardInterface.getFlockOutResultOfBadyWeight(companyId);
	}
	
	
	
	
	
	
	
	
	
	//work emna
	@GetMapping("/{center_id}")
	public List<FlockWeight> findWeightByFlock(@PathVariable("center_id") String center_id) {
		return dashboardInterface.findWeightByFlock(center_id);
	}
	
	@GetMapping("/breed/{center_id}")
	public ArrayList<WeightByBreed> getWeightperBreed(@PathVariable("center_id") String center_id) {
		return dashboardInterface.getWeightperBreed(center_id);
	}
	
	
}
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
import com.tta.broilers.entities.WeeklyWeightMeasurement;
import com.tta.broilers.entities.rest.AlertByFarm;
import com.tta.broilers.entities.rest.AlertByHouse;
import com.tta.broilers.entities.rest.FlockWeight;
import com.tta.broilers.entities.rest.WeightByBreed;
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
package com.tta.broilers.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tta.broilers.dao.DailyWeightInterface;
import com.tta.broilers.entities.DailyWeight;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author EMNA
 *
 */
@RestController
@RequestMapping("/dailyWeight")
public class DailyWeightController {

	@Autowired
	DailyWeightInterface dailyWeightInterface;

	@GetMapping
	public List<DailyWeight> findAll() {

		return dailyWeightInterface.findAll();
	}

	@GetMapping("/insert/file/{breed}")
	public void insertFromFile(@PathVariable("breed") int breed) {

		try {
			dailyWeightInterface.insertFromFile(breed);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@PostMapping("/save")
	public BasicResponse save(@RequestBody DailyWeight dailyWeight) {
		return dailyWeightInterface.save(dailyWeight);
	}
	@GetMapping("/weekly/{valueWeight}/{week}/{breed}")
	public String getWeeklyValue(@PathVariable("valueWeight") double valueWeight,@PathVariable("week")  int week,@PathVariable("breed")  int breed) {
		return dailyWeightInterface.getWeeklyWeight(valueWeight,week,breed);
	}
	@GetMapping("/getByAgeDays/{ageDays}/{breed}")
	public DailyWeight getByAgeDays(@PathVariable("ageDays") int ageDays,@PathVariable("breed")  int breed) {
		return dailyWeightInterface.getByAgeDays(ageDays,breed);
	}
}

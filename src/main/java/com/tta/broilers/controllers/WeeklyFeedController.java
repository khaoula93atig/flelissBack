package com.tta.broilers.controllers;

import java.util.List;

import com.tta.broilers.entities.rest.FeedWeightweekly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tta.broilers.dao.WeeklyFeedInterface;
import com.tta.broilers.entities.WeeklyFeed;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author EMNA
 *
 */
@RestController
@RequestMapping("/WeeklyFeed")
public class WeeklyFeedController {

	@Autowired
	WeeklyFeedInterface weeklyFeedInterface;

	@GetMapping
	public List<WeeklyFeed> findAll() {

		return weeklyFeedInterface.findAll();

	}

	@PostMapping("/save")
	public BasicResponse save(@RequestBody WeeklyFeed weeklyFeed) {
		return weeklyFeedInterface.save(weeklyFeed);
	}

	@GetMapping("/byflockandage/{age}/{flockId}")
	public List<Long> getWeeklyFeedByflockAndAge(@PathVariable("age") int age, @PathVariable("flockId") String flockId) {

		return weeklyFeedInterface.getbyAgeAndFlock(age, flockId);

	}

	@GetMapping("/feed/weight/{week}/{flockId}")
	public List<FeedWeightweekly> getWeeklyFeedandWeightByflockAndAge(@PathVariable("week") int week, @PathVariable("flockId") String flockId) {

		return weeklyFeedInterface.getFeedWeightWeeklyByAgeAndFlock(week, flockId);

	}
}

package com.tta.broilers.repositories;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tta.broilers.dao.DailyWeightInterface;
import com.tta.broilers.entities.DailyWeight;
import com.tta.broilers.mappers.DailyWeightRowMapper;
import com.tta.broilers.responses.BasicResponse;
import com.tta.broilers.utils.Utils;

/**
 * @author EMNA
 *
 */
@Repository
public class DailyWeightRepository implements DailyWeightInterface {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<DailyWeight> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from daily_weight", new DailyWeightRowMapper());

	}

	@Override
	public BasicResponse save(DailyWeight dailyWeight) {
		try {
			dailyWeight.setCreationDate(new Date());

			jdbcTemplate.update(
					" INSERT INTO daily_weight( "
							+ "     breed, age_days, weight, daily_gain, average_daily_gain, cumulative_feed_conversion)"
							+ "  VALUES (?, ?, ?, ?, ?, ?);",
					dailyWeight.getBreed(), dailyWeight.getAge_days(), dailyWeight.getWeight(),
					dailyWeight.getDaily_gain(), dailyWeight.getAverage_daily_gain(),
					dailyWeight.getCumulative_feed_conversion());
			return new BasicResponse("DailyWeight created: " + dailyWeight.toString(), HttpStatus.OK);
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public List<DailyWeight> getByBreed(int breed) {
		return jdbcTemplate.query("select * from daily_weight where breed=?", new Object[] { breed },
				new DailyWeightRowMapper());
	}

	@Override
	public void insertFromFile(int breed) throws Exception {

		String BASE_FOLDER = Utils.RootFolder;
		String dataFile = "dailyWeight.txt";
		BufferedReader br = null;
		String line = null;
		StringTokenizer token = null;
		DailyWeight dailyWeight;

		File data = new File(BASE_FOLDER, dataFile);

		br = new BufferedReader(new InputStreamReader(new FileInputStream(data), "iso-8859-1"));

		do {
			dailyWeight = new DailyWeight();
			line = br.readLine();
			if (line == null) {
				break;
			}
			// System.out.println(line);
			token = new StringTokenizer(line, ";");
			System.out.println("line " + line);
			if (line.trim() != "" && token.countTokens() >= 1) {
				dailyWeight.setAge_days(Integer.parseInt(token.nextToken()));
				dailyWeight.setWeight(Double.parseDouble(token.nextToken()));
				try {
					dailyWeight.setDaily_gain(Double.parseDouble(token.nextToken()));
				} catch (NumberFormatException ex) {

					ex.printStackTrace();
				}
				try {
					dailyWeight.setAverage_daily_gain(Double.parseDouble(token.nextToken()));
				} catch (NumberFormatException ex) {
					ex.printStackTrace();
				}
				try {
					dailyWeight.setCumulative_feed_conversion(Double.parseDouble(token.nextToken()));
				} catch (NumberFormatException ex) {
					ex.printStackTrace();
				}
				dailyWeight.setBreed(breed);
				try {

					save(dailyWeight);

				} catch (Exception e) {
					e.printStackTrace(System.out);
				}
			}

		} while (true);

		br.close();

	}
	
	@Override
	public DailyWeight getByWeek(int week) {
		System.out.println("search weight by weeks " + week);
		List<DailyWeight> result= jdbcTemplate.query("select * from daily_weight where week=?", new Object[] { week },
				new DailyWeightRowMapper());
		if (result.isEmpty())
			return null;
		else return result.get(0);
	}

	@Override
	public DailyWeight getByAgeDays(int ageDays,int breed) {
		System.out.println("search weight by age " + ageDays+"breed "+breed);
		List<DailyWeight> result= jdbcTemplate.query("select * from daily_weight where age_days=? and breed=?", new Object[] { ageDays,breed },
				new DailyWeightRowMapper());
		if (result.isEmpty())
			return null;
		else return result.get(0);
	}

	@Override
	public String getWeeklyWeight(double weeklyWeight, int week ,int breed) {
		// TODO Auto-generated method stub
		double standard=searchStandard(week,breed);
		String deviation;
		System.out.println("standard "+standard);
		if (weeklyWeight <standard ) {
			deviation	 = "Underweight";
		} else if (weeklyWeight > standard) {
			deviation = "Overweight";
		} else {
			deviation = "Normal";
		}
		System.out.println("deviation "+deviation);
		return deviation;
	}
	
	private double searchStandard ( int week ,int breed) {
		// TODO Auto-generated method stub
		System.out.println("week" + week );
		System.out.println("breed" + breed );
		return jdbcTemplate.queryForObject(
				"SELECT  weight FROM weekly_weight where age_days=? and breed=?",
				new Object[] { week,breed }, Double.class);
	
	}

	
	
}

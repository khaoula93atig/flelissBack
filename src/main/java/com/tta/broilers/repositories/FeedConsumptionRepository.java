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

import com.tta.broilers.dao.FeedConsumptionInterface;
import com.tta.broilers.entities.FeedConsumption;
import com.tta.broilers.mappers.FeedConsumptionMapper;
import com.tta.broilers.responses.BasicResponse;
import com.tta.broilers.utils.Utils;

/**
 * @author rym lamouchi
 *
 */
@Repository
public class FeedConsumptionRepository implements FeedConsumptionInterface {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public BasicResponse save(FeedConsumption feedConsumption) {
		try {
			System.out.println("save "+ feedConsumption.toString());
			feedConsumption.setCreationDate(new Date());
            
			jdbcTemplate.update("INSERT INTO feed_consumption("
					+ "            age_days, daily_feed_consumption, breed, cumultive_feed_consumption, "
					+ "            cumulative_feed_conversion_fcr,creation_date)" + "    VALUES (?, ?, ?, ?, ?, ?);",
					feedConsumption.getAge_days(), feedConsumption.getDaily_feed_consumption(),
					feedConsumption.getBreed(), feedConsumption.getCumultive_feed_consumption(),
					feedConsumption.getCumulative_feed_conversion_fcr(), feedConsumption.getCreationDate());

			return new BasicResponse("feed_consumption created: " + feedConsumption.toString(), HttpStatus.OK);
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public void insertFromFile(int breed) throws Exception {

		String BASE_FOLDER = Utils.RootFolder;
		String dataFile = "feedConsumption.txt";
		BufferedReader br = null;
		String line = null;
		StringTokenizer token = null;
		FeedConsumption feedConsumption;

		File data = new File(BASE_FOLDER, dataFile);

		br = new BufferedReader(new InputStreamReader(new FileInputStream(data), "iso-8859-1"));

		do {
			feedConsumption = new FeedConsumption();
			line = br.readLine();
			if (line == null) {
				break;
			}
			// System.out.println(line);
			token = new StringTokenizer(line, ";");
			System.out.println("line " + line);
			if (line.trim() != "" && token.countTokens() >= 1) {

				feedConsumption.setAge_days(Integer.parseInt(token.nextToken()));

				try {
					feedConsumption.setDaily_feed_consumption(Double.parseDouble(token.nextToken()));
				} catch (NumberFormatException ex) {
					ex.printStackTrace();
				}

				try {
					feedConsumption.setCumultive_feed_consumption(Double.parseDouble(token.nextToken()));
				} catch (NumberFormatException ex) {
					ex.printStackTrace();
				}
				try {
					feedConsumption.setCumulative_feed_conversion_fcr(Double.parseDouble(token.nextToken()));
				} catch (NumberFormatException ex) {

					ex.printStackTrace();
				}

				feedConsumption.setBreed(breed);
				feedConsumption.setCreationDate(new Date());

				try {

					save(feedConsumption);

				} catch (Exception e) {
					e.printStackTrace(System.out);
				}
			}

		} while (true);

		br.close();

	}
	
	
	@Override
	public FeedConsumption getByAgeDays(int ageDays) {
		System.out.println("search weight by age " + ageDays);
		List<FeedConsumption> result= jdbcTemplate.query("select * from feed_consumption where age_days=?", new Object[] { ageDays },
				new FeedConsumptionMapper());
		if (result.isEmpty())
			return null;
		else return result.get(0);
	}
	
}

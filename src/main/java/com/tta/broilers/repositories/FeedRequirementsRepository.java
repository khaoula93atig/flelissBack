package com.tta.broilers.repositories;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;

import java.io.InputStreamReader;
import java.util.Date;

import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tta.broilers.dao.FeedRequirementsInterface;

import com.tta.broilers.entities.FeedRequirements;

import com.tta.broilers.responses.BasicResponse;
import com.tta.broilers.utils.Utils;

/**
 * @author rym lamouchi
 *
 */
@Repository
public class FeedRequirementsRepository implements FeedRequirementsInterface {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public BasicResponse save(FeedRequirements feedRequirement) {
		try {
			feedRequirement.setCreationDate(new Date());

			jdbcTemplate.update(
					"INSERT INTO feed_requirements( "
							+ "     breed, element, unity, starter, grower, finisher1, finisher2, "
							+ "    category, min_for_starter, max_for_starter, min_for_grower, max_for_grower, "
							+ "     max_for_finisher1, min_for_finisher2, max_for_finisher2, min_for_finisher1)"
							+ "  VALUES (?, ?, ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,   ?, ?, ?, ?);",
					feedRequirement.getBreed(), feedRequirement.getElement(), feedRequirement.getUnity(),
					feedRequirement.getStarter(), feedRequirement.getGrower(), feedRequirement.getFinisher1(),
					feedRequirement.getFinisher2(), feedRequirement.getCategory(), feedRequirement.getMin_for_starter(),
					feedRequirement.getMax_for_starter(), feedRequirement.getMin_for_grower(),
					feedRequirement.getMax_for_grower(), feedRequirement.getMax_for_finisher1(),
					feedRequirement.getMin_for_finisher2(), feedRequirement.getMax_for_finisher2(),
					feedRequirement.getMin_for_finisher1());
			return new BasicResponse("DailyWeight created: " + feedRequirement.toString(), HttpStatus.OK);
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public void insertFromFile(int breed) throws Exception {

		String BASE_FOLDER = Utils.RootFolder;
		String dataFile = "nutrientRecommendations.txt";
		BufferedReader br = null;
		String line = null;
		StringTokenizer token = null;
		FeedRequirements feedRequirement;

		File data = new File(BASE_FOLDER, dataFile);

		br = new BufferedReader(new InputStreamReader(new FileInputStream(data), "iso-8859-1"));

		do {
			feedRequirement = new FeedRequirements();
			line = br.readLine();
			if (line == null) {
				break;
			}
			// System.out.println(line);
			token = new StringTokenizer(line, ";");
			System.out.println("line " + line);
			if (line.trim() != "" && token.countTokens() >= 1) {
				feedRequirement.setElement(token.nextToken());

				feedRequirement.setUnity(token.nextToken());
				try {
					feedRequirement.setStarter(Double.parseDouble(token.nextToken()));
				} catch (NumberFormatException ex) {

					ex.printStackTrace();
				}

				try {
					feedRequirement.setMin_for_starter(Double.parseDouble(token.nextToken()));
				} catch (NumberFormatException ex) {
					ex.printStackTrace();
				}

				try {
					feedRequirement.setMax_for_starter(Double.parseDouble(token.nextToken()));
				} catch (NumberFormatException ex) {
					ex.printStackTrace();
				}
				try {
					feedRequirement.setGrower(Double.parseDouble(token.nextToken()));
				} catch (NumberFormatException ex) {
					ex.printStackTrace();
				}
				try {
					feedRequirement.setMin_for_grower(Double.parseDouble(token.nextToken()));
				} catch (NumberFormatException ex) {
					ex.printStackTrace();
				}
				try {
					feedRequirement.setMax_for_grower(Double.parseDouble(token.nextToken()));
				} catch (NumberFormatException ex) {
					ex.printStackTrace();
				}
				try {
					feedRequirement.setFinisher1(Double.parseDouble(token.nextToken()));
				} catch (NumberFormatException ex) {
					ex.printStackTrace();
				}
				System.out.println(feedRequirement.getFinisher1());
				try {
					feedRequirement.setMin_for_finisher1(Double.parseDouble(token.nextToken()));
				} catch (NumberFormatException ex) {
					ex.printStackTrace();
				}
				System.out.println(feedRequirement.getMin_for_finisher1());
				try {
					feedRequirement.setMax_for_finisher1(Double.parseDouble(token.nextToken()));
				} catch (NumberFormatException ex) {
					ex.printStackTrace();
				}
				System.out.println(feedRequirement.getMax_for_finisher1());
				try {
					feedRequirement.setFinisher2(Double.parseDouble(token.nextToken()));
				} catch (NumberFormatException ex) {
					ex.printStackTrace();
				}
				try {
					feedRequirement.setMin_for_finisher2(Double.parseDouble(token.nextToken()));
				} catch (NumberFormatException ex) {
					ex.printStackTrace();
				}
				try {
					feedRequirement.setMax_for_finisher2(Double.parseDouble(token.nextToken()));
				} catch (NumberFormatException ex) {
					ex.printStackTrace();
				}
				feedRequirement.setBreed(breed);
				feedRequirement.setCreationDate(new Date());
				feedRequirement.setCategory("Nutrient Recommendations");
				try {

					save(feedRequirement);

				} catch (Exception e) {
					e.printStackTrace(System.out);
				}
			}

		} while (true);

		br.close();

	}
}

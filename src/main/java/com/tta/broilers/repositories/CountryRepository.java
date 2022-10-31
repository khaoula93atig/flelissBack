package com.tta.broilers.repositories;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tta.broilers.dao.CountryInterface;
import com.tta.broilers.entities.Country;
import com.tta.broilers.mappers.CountryRowMapper;
import com.tta.broilers.utils.Utils;

@Repository
public class CountryRepository implements CountryInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Country> findAll() {

		return jdbcTemplate.query("select * from world_countries", new CountryRowMapper());

	}

	@Override
	public void setFromFile() throws IOException {
		String BASE_FOLDER = Utils.RootFolder;
		String dataFile = "worldCountries.txt";
		BufferedReader br = null;
		String line = null;
		StringTokenizer token = null;
		Country country;

		File data = new File(BASE_FOLDER, dataFile);

		br = new BufferedReader(new InputStreamReader(new FileInputStream(data), "iso-8859-1"));

		do {
			country = new Country();
			line = br.readLine();
			if (line == null) {
				break;
			}
			// System.out.println(line);
			token = new StringTokenizer(line, ";");
			System.out.println("line " + line);
			if (line.trim() != "" && token.countTokens() >= 1) {
				country.setId(Integer.parseInt(token.nextToken()));
				country.setName(token.nextToken());
				save(country);

			}

		} while (true);

		br.close();

	}

	@Override
	public void save(Country country) {
		jdbcTemplate.update("INSERT INTO world_countries (id, name)   VALUES (?, ?);", country.getId(), country.getName());

	}

}

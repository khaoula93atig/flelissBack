package com.tta.broilers.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.tta.broilers.dao.HouseInterface;
import com.tta.broilers.entities.House;
import com.tta.broilers.mappers.HouseRowMapper;
import com.tta.broilers.responses.BasicResponse;
import com.tta.broilers.utils.Utils;

/**
 * @author rym lamouchi
 *
 */
@Repository
public class HouseRepository implements HouseInterface {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<House> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from house left join farm on house.farm_id=farm.farm_id",
				new HouseRowMapper());

	}

	@Override
	public BasicResponse save(House house) {
		try {
			System.out.println("house "+house.toString());
			String centerName= getCenterName(house.getCenterId());
			house.setHouseId(house.getCenterId() + "-" + Utils.LeftPadString(String.valueOf(countAll() + 1), 4, "0"));
			house.setCreationDate(new Date());
			house.setHouseName(centerName+"-"+house.getHouseName());
			jdbcTemplate.update(
					" INSERT INTO house( farm_id, house_id, area, ventilation, density, nbr_cycles_per_year, feeder, water_source, birds_number, creation_date, duration_of_rotation,center_id,house_name) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);",
					house.getFarmID(), house.getHouseId(), house.getArea(), house.getVentilation(), house.getDensity(),
					house.getNbrCyclesPerYear(), house.getFeeder(), house.getWaterSource(), house.getBirdsNumber(),
					house.getCreationDate(), house.getDurationOfRotation(),house.getCenterId(),house.getHouseName());
			return new BasicResponse("House created: " + house.toString(), HttpStatus.OK);
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public BasicResponse update(House house) {
		try {
			List<House> toUpdate = findById(house.getHouseId());
			if (!toUpdate.isEmpty()) {
				jdbcTemplate.update(
						"UPDATE house SET  birds_number=?, creation_date=?, area=?,ventilation=?, density=?, nbr_cycles_per_year=?, feeder=?, water_source=?,duration_of_rotation=?  WHERE house_id=?;",
						house.getBirdsNumber(), house.getCreationDate(), house.getArea(), house.getVentilation(),
						house.getDensity(), house.getNbrCyclesPerYear(), house.getFeeder(), house.getWaterSource(),
						house.getDurationOfRotation(), house.getHouseId());
				return new BasicResponse("house updated: " + house.toString(), HttpStatus.OK);
			} else {
				return new BasicResponse("Element introuvable!", HttpStatus.BAD_REQUEST);

			}
		} catch (Exception ex) {

			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public List<House> findById(String id) {
		return jdbcTemplate.query("select * from house left join farm on house.farm_id= farm.farm_id where house_id=?",
				new Object[] { id }, new HouseRowMapper());

	}

	@Override
	public List<House> findByFarmID(String farmID) {
		return jdbcTemplate.query(
				"select * from house left join farm on house.farm_id=farm.farm_id  where farm.farm_id=?",
				new Object[] { farmID }, new HouseRowMapper());

	}
	@Override
	public String getCenterName(String centerId) {
		return jdbcTemplate.queryForObject("SELECT center_name FROM center where center_id=?",new Object[] { centerId } ,String.class);

	}
	@Override
	public long countAll() {
		return jdbcTemplate.queryForObject("select count(*) from house ", Long.class);

	}
	@Override
	public List<House> getHousesByCenter(String centerId) {
		return jdbcTemplate.query(
				"select * from house left join center on house.center_id=center.center_id  left join farm on house.farm_id=farm.farm_id  where center.center_id=?",
				new Object[] { centerId }, new HouseRowMapper());

	}
}

package com.tta.broilers.repositories;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tta.broilers.dao.BroodingCheckInterface;
import com.tta.broilers.entities.BroodingCheck;
import com.tta.broilers.mappers.BroodingCheckMapper;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author EMNA 
 *
 */
@Repository
public class BroodingCheckRepository implements BroodingCheckInterface {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<BroodingCheck> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT * FROM public.\"Brooding_check\" join farm on farm.farm_id = \"Brooding_check\".farm_id;", new BroodingCheckMapper());
	}

	@Override
	public List<BroodingCheck> getByBreed(int breed) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasicResponse save(BroodingCheck broodingCheck) {
		try {
  
			System.out.println("broodingCheck "+broodingCheck.toString());
			broodingCheck.setBroodingCheckId(UUID.randomUUID().toString().replace("-", ""));
			broodingCheck.setCreationDate(new Date());
		
			jdbcTemplate.update("INSERT INTO public.\"Brooding_check\"(\r\n"
					+ "	brooding_check_id, litter_depth,"
					+ " temperature, pre_heat_least, realtive_humidity, air_speed,"
					+ " position_supp_drink, delivery_vehi_temp, delivery_vehi_humi, chick_confort,"
					+ " external_env_cond, transit_time, delivery_vehicle_air_exch, delivery_vehicle_hygiene,"
					+ " internal_chick_temp, weigh_sample_chick, place_chicks_quickly, light_intensity,"
					+ " check_chick_behavior, check_chick_water_supply, check_feed_supply, check_chick_crop_fill,"
					+ " distribution_day_old_chicks, daily_purges_piping, air_quality, creation_date,"
					+ " username, farm_id, center_id, house_id, air_temperature, ensure_feed_water,"
					+ " floor_temperature, spot_brooding, distance_access_water, check_feed, feed_on_paper,"
					+ " feeders_trays, drinkers_nipple_lines, drinkers_bell, drinkers_supp, water_temperature)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);"
					,broodingCheck.getBroodingCheckId(),broodingCheck.getLitterDepth()
					,broodingCheck.getTemperature(),broodingCheck.getPreHeatLeast(),broodingCheck.getRealtiveHumidity(),broodingCheck.getAirSpeed(),
					broodingCheck.getPositionSuppDrink(),broodingCheck.getDeliveryVehiTemp(),broodingCheck.getDeliveryVehiHumi(),broodingCheck.getChickConfort(),
					broodingCheck.getExternalEnvCond(),broodingCheck.getTransitTime(),broodingCheck.getDeliveryVehicleAirExch(),broodingCheck.getDeliveryVehicleHygiene(),
					broodingCheck.getInternalChickTemp(),broodingCheck.getWeighSampleChick(),broodingCheck.getPlaceChicksQuickly(),broodingCheck.getLightIntensity(),
					broodingCheck.getCheckChickBehavior(),broodingCheck.getCheckChickWaterSupply(),broodingCheck.getCheckFeedSupply(),broodingCheck.getCheckChickCropFill(),
					broodingCheck.getDistributionDayOldChicks(),broodingCheck.getDailyPurgesPiping(),broodingCheck.getAirQuality(),broodingCheck.getCreationDate(),
					broodingCheck.getUsername(),broodingCheck.getFarmId(),broodingCheck.getCenterID(),broodingCheck.getHousesId(),broodingCheck.getAirTemperature(),broodingCheck.getEnsureFeedWater(),
					broodingCheck.getFloorTemperature(), broodingCheck.getSpotBrooding(),broodingCheck.getDistanceAccessWater(),broodingCheck.getCheckFeed(),broodingCheck.getFeedOnPaper(),
					broodingCheck.getFeedersTrays(),broodingCheck.getDrinkersNippleLines(),broodingCheck.getDrinkersBell(),broodingCheck.getDrinkersSupp(),broodingCheck.getWaterTemperature()
							);
			return new BasicResponse("broodingCheck created: " + broodingCheck.toString(), HttpStatus.OK);
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public BroodingCheck getByWeek(int week) {
		// TODO Auto-generated method stub
		return null;
	}

}

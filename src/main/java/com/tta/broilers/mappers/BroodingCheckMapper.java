package com.tta.broilers.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.broilers.entities.BroodingCheck;
import com.tta.broilers.entities.Farm;


/**
 * @author EMNA
 *
 *         04 sep 2020
 */
public class BroodingCheckMapper implements RowMapper<BroodingCheck> {


	

	
	@Override
	public BroodingCheck mapRow(ResultSet rs, int arg1) throws SQLException {
		

		  
		BroodingCheck broodingCheck = new BroodingCheck();
		broodingCheck.setBroodingCheckId(rs.getString("brooding_check_id"));
	    broodingCheck.setLitterDepth(rs.getString("litter_depth"));  
		broodingCheck.setFarmId(rs.getString("farm_id"));
		broodingCheck.setHousesId(rs.getString("house_id"));
		broodingCheck.setCenterID(rs.getString("center_id"));
		broodingCheck.setTemperature(rs.getString("temperature"));
		broodingCheck.setRealtiveHumidity(rs.getString("realtive_humidity"));
		broodingCheck.setPreHeatLeast(rs.getString("pre_heat_least"));
		broodingCheck.setAirTemperature(rs.getString("air_temperature"));
		broodingCheck.setAirSpeed(rs.getString("air_speed"));
		broodingCheck.setPositionSuppDrink(rs.getString("position_supp_drink"));
		broodingCheck.setDeliveryVehiTemp(rs.getString("delivery_vehi_temp"));
		broodingCheck.setDeliveryVehiHumi(rs.getString("delivery_vehi_humi"));
		broodingCheck.setDeliveryVehicleAirExch(rs.getString("delivery_vehicle_air_exch"));
		broodingCheck.setChickConfort(rs.getString("chick_confort"));
		broodingCheck.setExternalEnvCond(rs.getString("external_env_cond"));
		broodingCheck.setDeliveryVehicleHygiene(rs.getString("delivery_vehicle_hygiene"));
		broodingCheck.setInternalChickTemp(rs.getString("internal_chick_temp"));
		broodingCheck.setTransitTime(rs.getString("transit_time"));
		broodingCheck.setEnsureFeedWater(rs.getString("ensure_feed_water"));
		broodingCheck.setLightIntensity(rs.getString("light_intensity"));
		broodingCheck.setCheckChickBehavior(rs.getString("check_chick_behavior"));
		broodingCheck.setCheckChickWaterSupply(rs.getString("check_chick_water_supply"));
		broodingCheck.setCheckFeedSupply(rs.getString("check_feed_supply"));
		broodingCheck.setCheckChickCropFill(rs.getString("check_chick_crop_fill"));
		broodingCheck.setDistributionDayOldChicks(rs.getString("distribution_day_old_chicks"));
		broodingCheck.setDailyPurgesPiping(rs.getString("daily_purges_piping"));
		broodingCheck.setAirQuality(rs.getString("air_quality"));
		broodingCheck.setCreationDate(rs.getDate("creation_date"));
		broodingCheck.setUsername(rs.getString("username"));
		broodingCheck.setWeighSampleChick(rs.getString("weigh_sample_chick"));
		broodingCheck.setPlaceChicksQuickly(rs.getString("place_chicks_quickly"));
		broodingCheck.setFloorTemperature(rs.getString("floor_temperature"));
		broodingCheck.setSpotBrooding(rs.getString("spot_brooding"));
		broodingCheck.setDistanceAccessWater(rs.getString("distance_access_water"));
		broodingCheck.setCheckFeed(rs.getString("check_feed"));
		broodingCheck.setFeedOnPaper(rs.getString("feed_on_paper"));
		broodingCheck.setFeedersTrays(rs.getString("feeders_trays"));
		broodingCheck.setDrinkersNippleLines(rs.getString("drinkers_nipple_lines"));
		broodingCheck.setDrinkersBell(rs.getString("drinkers_bell"));
		broodingCheck.setDrinkersSupp(rs.getString("drinkers_supp"));
		broodingCheck.setWaterTemperature(rs.getString("water_temperature"));
		
		
		Farm farm = new Farm();
		farm.setFarmId(rs.getString("farm_id"));
		farm.setFarmName(rs.getString("farm_name"));
		farm.setHousesNumber(rs.getInt("Houses_number"));
		farm.setAddress(rs.getString("address"));
		farm.setArea(rs.getString("area"));
		farm.setBreed(rs.getString("breed"));
		farm.setTypeProduction(rs.getString("type_production"));		
		farm.setFarmManageEmail(rs.getString("farm_manager_email"));
		farm.setFarmManageName(rs.getString("farm_manager_name"));
		farm.setFarmManageTel(rs.getString("farm_manager_tel"));
		farm.setCompanyID(rs.getString("company_id"));
		farm.setBridsNumberPerCenter(rs.getInt("houses_number"));
        farm.setNumberCenter(rs.getInt("number_center"));
        farm.setResult(rs.getString("result"));
		farm.setAvMortalityRate(rs.getDouble("av_mortality_rate"));
		farm.setFcr(rs.getDouble("fcr"));
		farm.setEpef(rs.getDouble("epef"));
		farm.setAvLayRate(rs.getDouble("av_lay_rate"));
		farm.setCreationDate(rs.getDate("creation_date")); 
 
		broodingCheck.setFarm(farm);
		return broodingCheck;
		

		
	}
	




}

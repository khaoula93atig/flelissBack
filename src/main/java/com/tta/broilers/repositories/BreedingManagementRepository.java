package com.tta.broilers.repositories;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tta.broilers.dao.BreedingManagementInterface;
import com.tta.broilers.entities.BreedingManagement;
import com.tta.broilers.mappers.BeedingManagementRowMapper;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
@Repository
public class BreedingManagementRepository implements BreedingManagementInterface {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<BreedingManagement> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT * FROM public.breeding_management;", new BeedingManagementRowMapper());

	}

	@Override
	public BasicResponse save(BreedingManagement breedingManagement) {
		try {
			breedingManagement.setBreedingManagementId(UUID.randomUUID().toString().replace("-", ""));
			breedingManagement.setCreationDate(new Date());
			
			jdbcTemplate.update("INSERT INTO public.breeding_management(\r\n"
					+ "	breeding_management_id, creation_date, username, farm_id, center_id,"
					+ " cleanliness_build, absence_holes_sharp_cracks, condition_doors_windows_building, sealing_ceiling_building,"
					+ " air_leaks_buildings, cleanliness_hoppers, storge_vaccines, cleanliness_feeders, sufficient_number_feeders, adjustment_height_feeders_according,"
					+ " unjustified_feed_leaks, feed_shape_size_according_age, feed_transition_achieved, recording_daily_feed_consumption,"
					+ " availability_sufficiency_feed, cleanliness_tanks_filters, cleanliness_nipples, correct_operation_watering, correct_operation_pressure_regulator,"
					+ " sufficient_number_drinkers, adjustment_height_drinkers_according, water_leaks, recording_daily_water_consumption, "
					+ "monitoring_physico_dw, monitoring_bacteriological_dw, dosing_pump_compliant, cleanliness_brooders, correct_distribution_brooders, avail_location_funct, observance_heating_program,"
					+ " state_cooling_system, correct_operation_cooling_system, fans_maintained, proper_operation_fans,"
					+ " hatch_opening_level, observance_air_flow, daily_record_min_max_temp, record_minmax_daily_humidity, breeding_humidity_confor,"
					+ " energy_saving_lamps, number_working_lamps, adequate_distri_lamps, mechanical_thermostat_alarm_funct, functional_tech_para_display_sys,"
					+ " number_birds_per_cage, isolation_sick_sick_animals, compliant_weighing_method, sampling_compliant, weighing_recording,"
					+ " compliance_vaccin_program, monitoring_vaccination_age, vaccine_dose_control, technical_performance,"
					+ " scoring, litter_quality, evolution_weight_compared_standard, visit_date)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
			+"",breedingManagement.getBreedingManagementId(),breedingManagement.getCreationDate(),breedingManagement.getUsername(),breedingManagement.getFarmId(),breedingManagement.getCenterId(),
			breedingManagement.getCleanlinessBuild(),breedingManagement.getAbsenceHolesSharpCracks(),breedingManagement.getConditionDoorsWindowsBuilding(),breedingManagement.getSealingCeilingBuilding(),
			breedingManagement.getAirLeaksBuildings(),breedingManagement.getCleanlinessHoppers(),breedingManagement.getStorageVaccines(),breedingManagement.getCleanlinessFeeders(),breedingManagement.getSufficientNumberFeeders(),breedingManagement.getAdjustmentHeightDrinkersAccording(),
			breedingManagement.getUnjustifiedFeedLeaks(),breedingManagement.getFeedShapeSizeAccordingAge(),breedingManagement.getFeedTransitionAchieved(),breedingManagement.getRecordingDailFeedConsumption(),
			breedingManagement.getAvailabilitySufficiencyFeed(),breedingManagement.getCleanlinessTanksFilters(),breedingManagement.getCleanlinessNipples(),breedingManagement.getCorrectOperationWatering(),breedingManagement.getCorrectOperationPressureRegulator(),
			breedingManagement.getSufficientNumberDrinkers(),breedingManagement.getAdjustmentHeightDrinkersAccording(),breedingManagement.getWaterLeaks(),breedingManagement.getRecordingDailyWaterConsumption(),
			breedingManagement.getMonitoringPhysicoDw(),breedingManagement.getMonitoringBacteriologicalDw(),breedingManagement.getDosingPumpCompliant(),breedingManagement.getCleanlinessBrooders(),breedingManagement.getCorrectDistributionBrooders(),breedingManagement.getAvailLocationFunct(),breedingManagement.getObservanceHeatingProgram(),
			breedingManagement.getStateCoolingSystem(),breedingManagement.getCorrectOperationCoolingSystem(),breedingManagement.getFansMaintained(),breedingManagement.getProperOperationFans(),
			breedingManagement.getHatchOpeningLevel(),breedingManagement.getObservanceAirFlow(),breedingManagement.getDailyRecordMinMaxTemp(),breedingManagement.getRecordMinmaxDailyHumidity(), breedingManagement.getBreedingHumidityConfor(),
			breedingManagement.getEnergySavingLamps(),breedingManagement.getNumberWorkingLamps(),breedingManagement.getAdequateDistriLamps(),breedingManagement.getMechanicalThermostatAlarmFunct(),breedingManagement.getFunctionalTechParaDisplaySys(),
			breedingManagement.getNumberBirdCageSquareMeter(),breedingManagement.getIsolationSickSickAnimals(),breedingManagement.getCompliantWeighingMethod(),breedingManagement.getSamplingCompliant(),breedingManagement.getWeighingRecording(),
			breedingManagement.getComplianceVaccinProgram(),breedingManagement.getMonitoringVaccinationAge(),breedingManagement.getVaccineDoseControl(),breedingManagement.getTechnicalPerformance(),
			breedingManagement.getScoring(),breedingManagement.getLitterQuality(),breedingManagement.getEvolutionWeightComparedStandard(),breedingManagement.getVisitDate()
			);
			
			return new BasicResponse("breedingManagement created: " + breedingManagement.toString(), HttpStatus.OK);
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}
	
	
	

	@Override
	public BasicResponse update(BreedingManagement breedingManagement) {
		try {
			List<BreedingManagement> toUpdate = getById(breedingManagement.getBreedingManagementId());
			if (!toUpdate.isEmpty()) {
				jdbcTemplate.update("UPDATE breeding_management SET  description=? WHERE breeding_management_id=?;",
						 breedingManagement.getBreedingManagementId());
				return new BasicResponse("HealthStatus updated: " + breedingManagement.toString(), HttpStatus.OK);
			} else {
				return new BasicResponse("Element introuvable!", HttpStatus.BAD_REQUEST);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public List<BreedingManagement> getById(String string) {

		return jdbcTemplate.query("select * from breeding_management where breeding_management_id=?",
				new Object[] { string }, new BeedingManagementRowMapper());
	}

	@Override
	public BasicResponse saveObject(BreedingManagement breedingManagement) {
		try {

			jdbcTemplate.update(" INSERT INTO breeding_management(\r\n"
					+ "            breeding_management_id, creation_date, username, farm_id, center_id, \r\n"
					+ "            house_id, cleanliness_build, absence_holes_sharp_cracks, condition_doors_windows_building, \r\n"
					+ "            sealing_ceiling_building, air_leaks_buildings, cleanliness_hoppers, \r\n"
					+ "            availability_wire_mesh_hopper, cleanliness_feeders, sufficient_number_feeders, \r\n"
					+ "            adjustment_height_feeders_according, unjustified_feed_leaks, \r\n"
					+ "            food_shape_size_according_age, feed_transition_achieved, recording_daily_feed_consumption, \r\n"
					+ "            availability_sufficiency_feed, cleanliness_tanks_filters, cleanliness_nipples, \r\n"
					+ "            correct_operation_watering, correct_operation_pressure_regulator, \r\n"
					+ "            sufficient_number_drinkers, adjustment_height_drinkers_according, \r\n"
					+ "            water_leaks, recording_daily_water_consumption, monitoring_physico_dw, \r\n"
					+ "            monitoring_bacteriological_dw, dosing_pump_compliant, cleanliness_brooders, \r\n"
					+ "            correct_distribution_brooders, avail_location_funct, observance_heating_program, \r\n"
					+ "            state_cooling_system, correct_operation_cooling_system, fans_maintained, \r\n"
					+ "            proper_operation_fans, hatch_opening_level, observance_air_flow, \r\n"
					+ "            daily_record_min_max_temp, aging_temp_confor, record_minmax_daily_humidity, \r\n"
					
					+ "            breeding_humidity_confor, energy_saving_lamps, number_working_lamps, \r\n"
					+ "            adequate_distri_lamps, compliant_pitch_height, compliance_light_program, \r\n"
					+ "            compliant_litter, mechanical_thermostat_alarm_funct, functional_tech_para_display_sys, \r\n"
					
					+ "            number_hens_per_cage, battery_layout, clean_auto_descender, functional_auto_descende, \r\n"
					+ "            clean_egg_conv_belt, functional_egg_evac_mat, functional_feed_trol_homog_distribution, \r\n"
					+ "            disposal_heavily_soiled, round_collec_eggs_completed, existing_functional_manure_scraper, \r\n"
					
					+ "            existing_manure_scraper_cable, flies_mealworms_building, clean_food_homogeneou_distribution, \r\n"
					+ "            instal__feeding_belts, trolled_compliant_test, control_behavior_distri, \r\n"
					+ "            state_hens_hens, manure_caches_clean, isolation_sick_sick_animals, \r\n"
					+ "            corpses_corridors, compliant_weighing_method, sampling_compliant, \r\n"
					+ "            weighing_recording, compliance_vaccin_program, monitoring_vaccination_age, \r\n"
					+ "            vaccine_dose_control, technical_performance, evolution_weight_weight)\r\n"
					+ "    VALUES (?, ?, ?, ?, ?,  ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
					+ "  ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,  ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,   ?, ?, ?,  ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,  ?, ?, ?);\r\n"
					/*,breedingManagement.getBreedingManagementId(),breedingManagement.getCreationDate(),breedingManagement.getUsername(),breedingManagement.getFarmId(),
					breedingManagement.getCenterId(),breedingManagement.getHouseId(),breedingManagement.getCleanlinessBuild(),breedingManagement.getAbsenceHolesSharpCracks(),
					breedingManagement.getConditionDoorsWindowsBuilding(),breedingManagement.getSealingCeilingBuilding(),breedingManagement.getAirLeaksBuildings(),
					breedingManagement.getCleanlinessHoppers(),breedingManagement.getAvailabilityWireMeshHopper(),breedingManagement.getCleanlinessFeeders(),
					breedingManagement.getCleanlinessNipples(),breedingManagement.getCorrectOperationWatering(),breedingManagement.getCorrectOperationPressureRegulator(),
					breedingManagement.getSufficientNumberDrinkers(),breedingManagement.getAdjustmentHeightDrinkersAccording(),breedingManagement.getWaterLeaks(),
					breedingManagement.getRecordingDailFeedConsumption(),breedingManagement.getMonitoringPhysicoDw(),breedingManagement.getMonitoringBacteriologicalDw(),
					breedingManagement.getDosingPumpCompliant(),breedingManagement.getCleanlinessBrooders(),breedingManagement.getCorrectDistributionBrooders(),
					breedingManagement.getAvailLocationFunct(),breedingManagement.getObservanceHeating_program(),breedingManagement.getStateCoolingSystem(),
					breedingManagement.getCorrectOperationCoolingSystem(),breedingManagement.getFansMaintained(),breedingManagement.getProperOperationFans(),
					breedingManagement.getHatchOpeningLevel(),breedingManagement.getObservanceAirFlow(),breedingManagement.getDailyRecordMinMaxTemp(),
					breedingManagement.getBreedingHumidityConfor(),breedingManagement.getEnergySavingLamps(),breedingManagement.getNumberWorkingLamps(),
					breedingManagement.getAdequateDistriLamps(),breedingManagement.getCompliantPitchHeight(),breedingManagement.getComplianceLightProgram(),
					breedingManagement.getCompliantLitter(),breedingManagement.getMechanicalThermostatAlarmFunct(),breedingManagement.getFunctionalTechParaDisplaySys(),
					breedingManagement.getDisposalHeavilySoiled(),breedingManagement.getRoundCollecEggsCompleted(),breedingManagement.getExistingFunctionalManureScraper(),
					breedingManagement.getExistingManureScraperCable(),breedingManagement.getFliesMealwormsBuilding(),breedingManagement.getCleanFoodHomogeneouDistribution(),
					breedingManagement.getInstalFeeding_belts(),breedingManagement.getTrolledCompliantTest(),breedingManagement.getControlBehaviorDistri(),
					breedingManagement.getStateHensHens(),breedingManagement.getManureCachesClean(),breedingManagement.getIsolationSickSickAnimals(),
					breedingManagement.getCorpsesCorridors(),breedingManagement.getCompliantWeighingMethod(),breedingManagement.getSamplingCompliant(),
					breedingManagement.getWeighingRecording(),breedingManagement.getComplianceLightProgram(),breedingManagement.getMonitoringVaccinationAge(),
					breedingManagement.getVaccineDoseControl(),breedingManagement.getTechnicalPerformance(),breedingManagement.getEvolutionWeightWeight()*/
					

			);
			return new BasicResponse("breedingManagement created: " + breedingManagement.toString(), HttpStatus.OK);
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	

}

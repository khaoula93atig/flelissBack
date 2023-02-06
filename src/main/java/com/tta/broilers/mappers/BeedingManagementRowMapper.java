package com.tta.broilers.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.broilers.entities.BreedingManagement;
/**
 * @author RLamouchi @email r.lamouchi@ttatunisia.com
 *
 *         31 aout 2020
 */
public class BeedingManagementRowMapper implements RowMapper<BreedingManagement> {

	@Override
	public BreedingManagement mapRow(ResultSet rs, int arg1) throws SQLException {

		BreedingManagement breedingManagement = new BreedingManagement();
	
		breedingManagement.setBreedingManagementId(rs.getString("breeding_management_id"));
		breedingManagement.setCreationDate(rs.getDate("creation_date"));
		breedingManagement.setUsername(rs.getString("username"));
		breedingManagement.setFarmId(rs.getString("farm_id"));
		breedingManagement.setCenterId(rs.getString("center_id"));
		breedingManagement.setCleanlinessBuild(rs.getString("cleanliness_build"));
		breedingManagement.setAbsenceHolesSharpCracks(rs.getString("absence_holes_sharp_cracks"));
		breedingManagement.setConditionDoorsWindowsBuilding(rs.getString("condition_doors_windows_building"));
		breedingManagement.setSealingCeilingBuilding(rs.getString("sealing_ceiling_building"));
		breedingManagement.setAirLeaksBuildings(rs.getString("air_leaks_buildings"));
		breedingManagement.setCleanlinessHoppers(rs.getString("cleanliness_hoppers"));
		breedingManagement.setStorageVaccines(rs.getString("storge_vaccines"));
		breedingManagement.setCleanlinessFeeders(rs.getString("cleanliness_feeders"));
		breedingManagement.setSufficientNumberFeeders(rs.getString("sufficient_number_feeders"));
		breedingManagement.setAdjustmentHeightDrinkersAccording(rs.getString("adjustment_height_feeders_according"));
		breedingManagement.setUnjustifiedFeedLeaks(rs.getString("unjustified_feed_leaks"));
		breedingManagement.setFeedShapeSizeAccordingAge(rs.getString("feed_shape_size_according_age"));
		breedingManagement.setFeedTransitionAchieved(rs.getString("feed_transition_achieved"));
		breedingManagement.setRecordingDailFeedConsumption(rs.getString("recording_daily_feed_consumption"));
		breedingManagement.setAvailabilitySufficiencyFeed(rs.getString("availability_sufficiency_feed"));
		breedingManagement.setCleanlinessTanksFilters(rs.getString("cleanliness_tanks_filters"));
		breedingManagement.setCleanlinessNipples(rs.getString("cleanliness_nipples"));
		breedingManagement.setCorrectOperationWatering(rs.getString("correct_operation_watering"));
		breedingManagement.setCorrectOperationPressureRegulator(rs.getString("correct_operation_pressure_regulator"));
		breedingManagement.setSufficientNumberDrinkers(rs.getString("sufficient_number_drinkers"));
		breedingManagement.setAdjustmentHeightDrinkersAccording(rs.getString("adjustment_height_drinkers_according"));
		breedingManagement.setWaterLeaks(rs.getString("water_leaks"));
		breedingManagement.setRecordingDailyWaterConsumption(rs.getString("recording_daily_water_consumption"));
		breedingManagement.setMonitoringPhysicoDw(rs.getString("monitoring_physico_dw"));
		breedingManagement.setMonitoringBacteriologicalDw(rs.getString("monitoring_bacteriological_dw"));
		breedingManagement.setDosingPumpCompliant(rs.getString("dosing_pump_compliant"));
		breedingManagement.setCleanlinessBrooders(rs.getString("cleanliness_brooders"));
		breedingManagement.setCorrectDistributionBrooders(rs.getString("correct_distribution_brooders"));
		breedingManagement.setAvailLocationFunct(rs.getString("avail_location_funct"));
		breedingManagement.setStateCoolingSystem(rs.getString("state_cooling_system"));
		breedingManagement.setCorrectOperationCoolingSystem(rs.getString("correct_operation_cooling_system"));
		breedingManagement.setFansMaintained(rs.getString("fans_maintained"));
		breedingManagement.setProperOperationFans(rs.getString("proper_operation_fans"));
		breedingManagement.setHatchOpeningLevel(rs.getString("hatch_opening_level"));
		breedingManagement.setObservanceAirFlow(rs.getString("observance_heating_program"));
		breedingManagement.setDailyRecordMinMaxTemp(rs.getString("daily_record_min_max_temp"));
		breedingManagement.setRecordMinmaxDailyHumidity(rs.getString("record_minmax_daily_humidity"));
		breedingManagement.setBreedingHumidityConfor(rs.getString("breeding_humidity_confor"));
		breedingManagement.setEnergySavingLamps(rs.getString("energy_saving_lamps"));
		breedingManagement.setNumberWorkingLamps(rs.getString("number_working_lamps"));
		breedingManagement.setAdequateDistriLamps(rs.getString("adequate_distri_lamps"));
		breedingManagement.setMechanicalThermostatAlarmFunct(rs.getString("mechanical_thermostat_alarm_funct"));
		breedingManagement.setFunctionalTechParaDisplaySys(rs.getString("functional_tech_para_display_sys"));
		breedingManagement.setIsolationSickSickAnimals(rs.getString("isolation_sick_sick_animals"));
		breedingManagement.setCompliantWeighingMethod(rs.getString("compliant_weighing_method"));
		breedingManagement.setSamplingCompliant(rs.getString("sampling_compliant"));
		breedingManagement.setWeighingRecording(rs.getString("weighing_recording"));
		breedingManagement.setComplianceVaccinProgram(rs.getString("compliance_vaccin_program"));
		breedingManagement.setMonitoringVaccinationAge(rs.getString("monitoring_vaccination_age"));
		breedingManagement.setVaccineDoseControl(rs.getString("vaccine_dose_control"));
		breedingManagement.setTechnicalPerformance(rs.getString("technical_performance"));
		breedingManagement.setScoring(rs.getFloat("scoring"));
		breedingManagement.setLitterQuality(rs.getString("litter_quality"));
		breedingManagement.setEnergySavingLamps(rs.getString("evolution_weight_compared_standard"));
		breedingManagement.setVisitDate(rs.getDate("visit_date"));
		
		return breedingManagement;
	}


}

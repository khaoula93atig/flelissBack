package com.tta.broilers.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.broilers.entities.Farm;
import com.tta.broilers.entities.Flock;
import com.tta.broilers.entities.House;
import com.tta.broilers.entities.Task;
import com.tta.broilers.entities.User;
import com.tta.broilers.entities.Visit;
import com.tta.broilers.entities.VisitTasks; 

/**
 * @author RLamouchi @email r.lamouchi@ttatunisia.com
 *
 *         31 aout 2020
 */
public class VisitTasksRowMapper implements RowMapper<VisitTasks> {

	@Override
	public VisitTasks mapRow(ResultSet rs, int arg1) throws SQLException {

		VisitTasks visitTasks = new VisitTasks();

		visitTasks.setTaskId(rs.getInt("task_id"));
		visitTasks.setVisitId(rs.getString("visit_id"));
		visitTasks.setMeasure(rs.getDouble("measure"));
		visitTasks.setPercentage(rs.getDouble("percentage"));
		visitTasks.setStandard(rs.getString("standard"));
		visitTasks.setDeviation(rs.getString("deviation"));
		visitTasks.setActionPlan(rs.getString("action_plan"));
		visitTasks.setCreationDate(rs.getDate("creation_date"));
		
		Visit visit = new Visit();

		visit.setVisitId(rs.getString("visit_id"));
		visit.setVisitDate(rs.getDate("visit_date"));
		visit.setFrequency(rs.getString("frequency"));
		visit.setFlockID(rs.getString("flock_id"));
		visit.setUsername(rs.getString("username"));
		visit.setAgeFlock(rs.getInt("age_flock"));
		visit.setCreationDate(rs.getDate("creation_date"));
		visit.setTypeVisit(rs.getString("type_visit"));

	   Flock flock = new Flock();
		
		flock.setFlockID(rs.getString("flock_id")); 
		flock.setHouseId(rs.getString("house_id"));
		flock.setBreed(rs.getInt("breed"));
		flock.setCycle(rs.getInt("cycle"));
		flock.setStartOfCycle(rs.getDate("start_of_cycle"));
		flock.setHatchDate(rs.getDate("hatch_date"));
		flock.setChikedPlaced(rs.getInt("chiked_placed"));
		flock.setPsOrigin(rs.getString("ps_origin"));
		flock.setCreationDate(rs.getDate("creation_date"));


		House house = new House();
		house.setBirdsNumber(rs.getInt("birds_number"));
		flock.setFlockName(rs.getString("flock_name"));
		house.setHouseId(rs.getString("house_id"));
		house.setFarmID(rs.getString("farm_id"));
		house.setCreationDate(rs.getDate("creation_date"));
		house.setNbrCyclesPerYear(rs.getInt("nbr_cycles_per_year"));
		house.setDensity(rs.getInt("density"));
		house.setFeeder(rs.getString("feeder"));
		house.setArea(rs.getInt("area"));
		house.setVentilation(rs.getString("ventilation"));
		house.setWaterSource(rs.getString("water_source"));
		house.setDurationOfRotation(rs.getInt("duration_of_rotation"));
		house.setCenterId(rs.getString("center_id"));
		house.setHouseName(rs.getString("house_name"));
	
	
	
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

	
		house.setFarm(farm);
		flock.setHouse(house);
		
		visit.setFlock(flock);
		
		User user = new User();

		user.setCreationDate(rs.getDate("creation_date"));
		user.setEmail(rs.getString("email"));
		user.setFarmID(rs.getString("farm_id"));
		user.setCompanyID(rs.getString("company_id"));
		user.setJob(rs.getString("job"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		user.setTelNumber(rs.getString("tel_number"));
		user.setRole(rs.getString("role"));
		user.setUsername(rs.getString("username"));
		
		visit.setUser(user);

		Task task = new Task();
	
		task.setTaskId(rs.getInt("task_id"));
		task.setDescription(rs.getString("description"));
		task.setCategory(rs.getString("category"));
		task.setMeasureUnit(rs.getString("measure_unit"));
		task.setCreationDate(rs.getDate("creation_date"));
		
		visitTasks.setTask(task);
		visitTasks.setVisit(visit);
		
		
		return visitTasks;
	}

}

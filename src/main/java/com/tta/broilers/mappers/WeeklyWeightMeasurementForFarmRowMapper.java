package com.tta.broilers.mappers;

import com.tta.broilers.entities.WeeklyWeightMeasurement;
import com.tta.broilers.entities.rest.WeeklyWeightMeasurementForFarm;
import com.tta.broilers.entities.rest.WeeklyWeightMesurementByFlock;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WeeklyWeightMeasurementForFarmRowMapper implements RowMapper<WeeklyWeightMeasurementForFarm> {


    @Override
    public WeeklyWeightMeasurementForFarm mapRow(ResultSet rs, int i) throws SQLException {
        WeeklyWeightMeasurementForFarm weight = new WeeklyWeightMeasurementForFarm();
        weight.setWeek(rs.getInt("week"));
        weight.setAverage(rs.getDouble("avg"));
        weight.setFarmId(rs.getString("farm_name"));
        return weight;
    }
}

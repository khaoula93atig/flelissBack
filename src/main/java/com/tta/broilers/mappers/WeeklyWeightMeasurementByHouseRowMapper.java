package com.tta.broilers.mappers;

import com.tta.broilers.entities.rest.WeeklyWeightMeasurementByHouse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WeeklyWeightMeasurementByHouseRowMapper implements RowMapper<WeeklyWeightMeasurementByHouse> {
    @Override
    public WeeklyWeightMeasurementByHouse mapRow(ResultSet rs, int i) throws SQLException {
        WeeklyWeightMeasurementByHouse weight = new WeeklyWeightMeasurementByHouse();
        weight.setWeek(rs.getInt("week"));
        weight.setAverage(rs.getDouble("average"));
        weight.setHouseId(rs.getString("house_name"));
        return weight;
    }
}

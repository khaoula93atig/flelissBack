package com.tta.broilers.mappers;
import org.springframework.jdbc.core.RowMapper;

import com.tta.broilers.entities.rest.FeedWeightweekly;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FeedWeightWeeklyRowMapper implements RowMapper<FeedWeightweekly>{
    @Override
    public FeedWeightweekly mapRow(ResultSet resultSet, int i) throws SQLException {
        FeedWeightweekly feedWeightweekly = new FeedWeightweekly();
        feedWeightweekly.setAverage(resultSet.getDouble("average"));
        feedWeightweekly.setTotalStarterFeed(resultSet.getDouble("total_starter_feed"));
        feedWeightweekly.setTotalGrowerFeed(resultSet.getDouble("total_grower_feed"));
        feedWeightweekly.setTotalFinisherFeed(resultSet.getDouble("total_finisher_feed"));
        return feedWeightweekly;
    }
}

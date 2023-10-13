package com.tta.broilers.mappers;

import com.tta.broilers.entities.rest.MortalityHistorique;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MortalityHistoriqueRowMapper implements RowMapper<MortalityHistorique> {
    @Override
    public MortalityHistorique mapRow(ResultSet rs, int i) throws SQLException {
        MortalityHistorique mortalityHistorique= new MortalityHistorique();
        mortalityHistorique.setMeasure(rs.getLong("measure"));
        mortalityHistorique.setAgeFlock(rs.getInt("age_flock"));
        mortalityHistorique.setVisitDate(rs.getDate("visit_date"));
        return mortalityHistorique;
    }
}

package com.tta.broilers.mappers;

import com.tta.broilers.entities.FileInfoVisit;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FileInfoVisitRowMapper implements RowMapper<FileInfoVisit> {

    @Override
    public FileInfoVisit mapRow(ResultSet resultSet, int i) throws SQLException {
        FileInfoVisit fileInfoVisit = new FileInfoVisit();
        fileInfoVisit.setName(resultSet.getString("name"));
        fileInfoVisit.setUrl(resultSet.getString("url"));
        fileInfoVisit.setVisitId(resultSet.getString(("visit_id")));
        fileInfoVisit.setVisitNecropsyNbservationId((resultSet.getString("visit_necropsy_nbservation_id")));
        return fileInfoVisit;
    }
}

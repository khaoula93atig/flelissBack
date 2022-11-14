package com.tta.broilers.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.broilers.entities.ChickReception;
import com.tta.broilers.entities.Farm;



public class ChickReceptionMapper implements RowMapper<ChickReception> {

	@Override
	public ChickReception mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ChickReception chickReception = new ChickReception();
		chickReception.setChicReceptionId(rs.getString("chick_reception_id"));
		chickReception.setFarmId(rs.getString("farm_id"));
		chickReception.setCenterId(rs.getString("center_id"));
		chickReception.setHousesId(rs.getString("house_id"));
		chickReception.setFlockId(rs.getString("flock_id"));
		chickReception.setBreed(rs.getString("breed"));
		chickReception.setHatchDate(rs.getDate("hatch_date"));
		chickReception.setChickPlaced(rs.getString("chick_placed"));
		chickReception.setPsOrigin(rs.getString("ps_origin"));
		chickReception.setPsAge(rs.getInt("ps_age"));
		chickReception.setVisitDate(rs.getDate("visit_date"));
		chickReception.setNavelNotclosedStrungButton(rs.getInt("navel_notclosed_strung_button"));
		chickReception.setNavelCleanWellHealed(rs.getInt("navel_clean_well_healed"));
		chickReception.setNavelClosedSlightAbrasiveness(rs.getInt("navel_closed_slight_abrasiveness"));
		chickReception.setLegsCleanWaxy(rs.getInt("legs_clean_waxy"));
		chickReception.setLegsDrynessPale(rs.getInt("legs_dryness_pale"));
		chickReception.setLegsDeshydratedVienProtruding(rs.getInt("legs_deshydrated_vien_protruding"));
		chickReception.setHocksCleanNoblemishes(rs.getInt("hocks_clean_noblemishes"));
		chickReception.setHocksSlightBlushing(rs.getInt("hocks_slight_blushing"));
		chickReception.setHocksRedcolorHeavyblushing(rs.getInt("hocks_redcolor_heavyblushing"));
		chickReception.setDefectsCleanNodefects(rs.getInt("defects_clean_nodefects"));
		chickReception.setDefectsMinorDefects(rs.getInt("defects_minor_defects"));
		chickReception.setDefectsEyeLegsSpraddled(rs.getInt("defects_eye_legs_spraddled"));
		chickReception.setTotalScore(rs.getInt("total_score"));
		chickReception.setCreationDate(rs.getDate("creation_date"));
		
		return chickReception;
	}

}

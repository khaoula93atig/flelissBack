package com.tta.broilers.repositories;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tta.broilers.dao.ChickReceptionInterface;
import com.tta.broilers.entities.ChickReception;
import com.tta.broilers.mappers.ChickReceptionMapper;
import com.tta.broilers.mappers.FarmRowMapper;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author EMNA
 *
 */
@Repository
public class ChickReceptionRepository implements ChickReceptionInterface {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<ChickReception> findAll() {
		
		return jdbcTemplate.query("SELECT * FROM public.chick_reception;",
				new ChickReceptionMapper());
	}

	@Override
	public List<ChickReception> getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasicResponse save(ChickReception chickReception) {
		try {
			chickReception.setChicReceptionId(UUID.randomUUID().toString().replace("-", ""));
			chickReception.setCreationDate(new Date());
			jdbcTemplate.update("INSERT INTO public.chick_reception(\r\n"
					+ "	farm_id, center_id, house_id, flock_id, breed, hatch_date, chick_placed, ps_origin, ps_age, visit_date,"
					+ " navel_notclosed_strung_button, navel_clean_well_healed, navel_closed_slight_abrasiveness,"
					+ " legs_clean_waxy, legs_dryness_pale, legs_deshydrated_vien_protruding,"
					+ " hocks_clean_noblemishes, hocks_slight_blushing, hocks_redcolor_heavyblushing,"
					+ " defects_clean_nodefects, defects_minor_defects, defects_eye_legs_spraddled, total_score,"
					+ " creation_date, chick_reception_id)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);",
					chickReception.getFarmId(),chickReception .getCenterId(),
					chickReception.getHousesId(),chickReception.getFlockId(),chickReception.getBreed(),
					chickReception.getHatchDate(),chickReception.getChickPlaced(),chickReception.getPsOrigin(),
					chickReception.getPsAge(),chickReception.getVisitDate(), chickReception.getNavelNotclosedStrungButton(),chickReception.getNavelCleanWellHealed(),chickReception.getNavelClosedSlightAbrasiveness(),
					chickReception.getLegsCleanWaxy(),chickReception.getLegsDrynessPale(), chickReception.getLegsDeshydratedVienProtruding(),
					chickReception.getHocksCleanNoblemishes(),chickReception.getHocksSlightBlushing(),chickReception.getHocksRedcolorHeavyblushing(),
					chickReception.getDefectsCleanNodefects(),chickReception.getDefectsMinorDefects(),chickReception.getDefectsEyeLegsSpraddled(),
					chickReception.getTotalScore(),chickReception.getCreationDate(),chickReception.getChicReceptionId());
			return new BasicResponse("chickReception created: " + chickReception.toString(), HttpStatus.OK);
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public BasicResponse update(ChickReception farm) {
		// TODO Auto-generated method stub
		return null;
	}


}

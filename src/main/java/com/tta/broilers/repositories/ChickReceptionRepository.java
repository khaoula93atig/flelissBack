package com.tta.broilers.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tta.broilers.dao.ChickReceptionInterface;
import com.tta.broilers.entities.ChickReception;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChickReception> getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasicResponse save(ChickReception chickReception) {
		try {
			System.out.println("chickReception +"+chickReception.toString());
			System.out.println("getThickFatBellies +"+chickReception.getThickFatBellies());
			//String farmName= getFarmName(farm.getFarmId());
	
			
			chickReception.setCreationDate(new Date());
			jdbcTemplate.update("INSERT INTO chick_reception(\r\n"
					+ "            visit_date ,chick_reception_id, farm_id, center_id, house_id, flock_id, breed, \r\n"
					+ "            hatch_date, chick_placed, ps_origin, ps_age, eyes_clear_bright, \r\n"
					+ "            body_dry_wet, body_temp, cross_beaks, feet_prop_formed, legs_clean_red_hocks, \r\n"
					+ "            developed_legs_skin, thick_fat_bellies, large_amount_growth, \r\n"
					+ "            signs_gasping_heavy, stringy_navels, black_buttons, navels_properly_healed, \r\n"
					+ "            fairly_even_wing_feather, non_stressful)\r\n"
					+ "    VALUES (?,?, ?, ?, ?, ?, ?, \r\n"
					+ "            ?, ?, ?, ?, ?, \r\n"
					+ "            ?, ?, ?, ?, ?, \r\n"
					+ "            ?, ?, ?, ?, \r\n"
					+ "            ?, ?, ?, \r\n"
					+ "            ?, ?);\r\n"
					+ "",chickReception.getVisitDate(),chickReception.getChicReceptionId(),chickReception.getFarmId(),chickReception .getCenterId(),
					chickReception.getHousesId(),chickReception.getFlockId(),chickReception.getBreed(),
					chickReception.getHatchDate(),chickReception.getChickPlaced(),chickReception.getPsOrigin(),
					chickReception.getPsAge(),chickReception.getEyesClearBright(),chickReception.getBodyDryWet(),chickReception.getBodyTemp(),
							chickReception.getCrossBeaks(),chickReception.getFeetPropFormed(),chickReception.getLegsCleanRedHocks(),
									chickReception.getSignsGaspingHeavy(),chickReception.getStringyNavels(),chickReception.getBlackButtons(),
									chickReception.getNavelsProperlyHealed(),chickReception.getDevelopedLegsSkin(),chickReception.getThickFatBellies(),
									chickReception.getLargeAmountGrowth(),chickReception.getFairlyEvenWingFeather(),chickReception.getNonstressful());
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

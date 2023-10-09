package com.tta.broilers.dao;

import java.util.List;

import com.tta.broilers.entities.ChickReception;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author Emna Laamiri
 *
 */
public interface ChickReceptionInterface {

	public List<ChickReception> findAll();

	public List<ChickReception> getById(String id);

	public BasicResponse save(ChickReception farm);

	public BasicResponse update(ChickReception farm);
	
	public List<ChickReception> getByFarm(String farm);

	

}

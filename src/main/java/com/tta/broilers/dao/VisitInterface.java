package com.tta.broilers.dao;
import java.util.List;
import com.tta.broilers.entities.Visit;
import com.tta.broilers.entities.rest.MortalityHistorique;
import com.tta.broilers.entities.rest.visitTasksVerification;
import com.tta.broilers.responses.BasicResponse;
/**
 * @author rym lamouchi
 *
 */
public interface VisitInterface  {
	
	List<Visit> findAll();
	List<Visit> getById(String id);
	List<Visit> getByuserName(String username , String role,String farmID);
	List<Visit> getByuserNameveterinarian(String username , String role,String farmID);
	
	Visit save(Visit visit);
	Visit saveVistveterinarian(Visit visit);
	BasicResponse update(Visit visit);
	List<visitTasksVerification> getVistTasksVerfication(String flockId, int age , int task);

	List<MortalityHistorique> getHistoriqueMortalityByFlock(String flockId);
}
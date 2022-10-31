package com.tta.broilers.dao;


import java.text.ParseException;
import java.util.List;
import com.tta.broilers.entities.VisitTasks;
import com.tta.broilers.entities.rest.WeightVariation;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
public interface VisitTasksInterface {

	List<VisitTasks> findAll();

	List<VisitTasks> getByVisitId(String visitId);
	List<VisitTasks> getById(String visitId, int taskId);
	WeightVariation  WeightVariationByFlock(String flockId);
	double getTotalMeasures(String visitDate, int taskId, String flockId)throws ParseException;
	BasicResponse save(VisitTasks visitTasks);

	BasicResponse update(VisitTasks visitTasks);

}

package com.tta.broilers.controllers;
import java.io.File;
import java.util.List;

import com.tta.broilers.entities.rest.MortalityHistorique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tta.broilers.dao.VisitInterface;
import com.tta.broilers.entities.Visit;
import com.tta.broilers.entities.rest.visitTasksVerification;
import com.tta.broilers.responses.BasicResponse;
/**
 * @author rym lamouchi
 *
 */
@RestController
@RequestMapping("/visit")
public class VisitController {
	@Autowired
	VisitInterface vistInterface;
	@GetMapping
	public List<Visit> findAll() {
		return vistInterface.findAll();
	}
	@GetMapping("/{id}")
	public List<Visit> findByID(@PathVariable("id") String id) {
		return vistInterface.getById(id);
	}
	@PostMapping("/save")
	public Visit save(@RequestBody Visit visit) {
		return vistInterface.save(visit);
	}
	@PostMapping("/save/veterinarian")
	public Visit saveVistveterinarian(@RequestBody Visit visit) {
		return vistInterface.saveVistveterinarian(visit);
	}
	@PutMapping("/update")
	public BasicResponse update(@RequestBody Visit visit) {
		return vistInterface.update(visit);
	}
	@GetMapping("/username/{username}/{role}/{farmID}")
	public List<Visit> getByuserName(@PathVariable("username") String username,@PathVariable("role") String role,@PathVariable("farmID") String farmID) {
		return vistInterface.getByuserName(username,role,farmID);
	}
	@GetMapping("/veterinarian/username/{username}/{role}/{farmID}")
	public List<Visit> getByuserNameveterinarian(@PathVariable("username") String username,@PathVariable("role") String role,@PathVariable("farmID") String farmID) {
		return vistInterface.getByuserNameveterinarian(username,role,farmID);
	}
	//import file analyse
	@PostMapping("/upload") 
	  public ResponseEntity<?> handleFileUpload( @RequestParam("file") MultipartFile file ) {

	    String fileName = file.getOriginalFilename();
	    try {
	      file.transferTo( new File("C:\\Documents\\analyse\\" + fileName));
	    } catch (Exception e) {
	      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    } 
	    return ResponseEntity.ok("File uploaded successfully.");
	  }
	
	@GetMapping("/vistTaskVerif/{flockId}/{age}/{task}")
	public List<visitTasksVerification> getVisitTaskVerif(@PathVariable("flockId") String flockId,@PathVariable("age") int age,@PathVariable("task") int task) {
		return vistInterface.getVistTasksVerfication(flockId, age, task);
	}

	@GetMapping("/historiqueMortalityByFlock/{flockId}")
	public List<MortalityHistorique> getHistoriqueMortalityByFlock(@PathVariable("flockId") String flockId) {
		return vistInterface.getHistoriqueMortalityByFlock(flockId);
	}


	// totale measure of until visit or date
	@GetMapping("Dailyvisit/TotalTaskMeasure/{flockId}/{taskId}/{ageFlock}")
	public Double totalTaskMeasureDate(@PathVariable("flockId") String flockId ,@PathVariable("taskId") int taskId ,@PathVariable("ageFlock") int ageFlock) {
		return vistInterface.totalMeasureTaskDate(flockId,ageFlock,taskId);
	}

}
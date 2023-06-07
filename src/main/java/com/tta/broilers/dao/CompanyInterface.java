package com.tta.broilers.dao;

import java.io.IOException;
import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.tta.broilers.entities.Company;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
public interface CompanyInterface  {
	
	public List<Company> findAll();
	public List<Company> getById(String id);
	public BasicResponse save(MultipartFile fichier,Company company);
	public BasicResponse update(Company company);
	public long countAll();
	ResponseEntity<InputStreamResource> getImage(String image)	throws IOException ;

}

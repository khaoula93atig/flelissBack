package com.tta.broilers.controllers;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.Produces;

import com.tta.broilers.entities.FileInfoVisit;
import com.tta.broilers.repositories.FileInfoVisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.tta.broilers.entities.Company;
import com.tta.broilers.repositories.CompanyRepository;
import com.tta.broilers.repositories.FarmRepository;
import com.tta.broilers.responses.BasicResponse;
import com.tta.broilers.utils.Utils;

@Controller
@RequestMapping("/upload")
public class UploaderController {
	@Autowired
	FarmRepository farmRepository;

	@Autowired
	CompanyRepository companyRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private FileInfoVisitRepository fileInfoVisitRepository;

	String path_traitement = Utils.BroilersAgreementsDIR+"agreements";
	String path_analyses = Utils.BroilersAgreementsDIR+"analyses";
	final File f = new File(getClass().getProtectionDomain().getCodeSource().getLocation().getPath());

	@RequestMapping(value = "/company/agreement/{companyID}", method = RequestMethod.POST)
	@ResponseBody
	public BasicResponse uploadFile(@PathVariable("companyID") String companyID,
			@RequestParam("agreement") MultipartFile agreement) {

		try {

			byte[] bytes = agreement.getBytes();
			// Creating the directory to store file
			String rootPath = path_traitement;
			File dir = new File(rootPath);
			if (!dir.exists())
				dir.mkdirs();
			// Create the file on server
			File serverFile = new File(dir.getAbsolutePath() + "\\" + companyID + ".pdf");
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();
			return new BasicResponse("Agreement uploaded", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);
		}

	}

	// return agreement by farmId
	@RequestMapping(value = "/company/agreement/{companyID}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<InputStreamResource> getAgreement(@PathVariable("companyID") String companyID)
			throws IOException {

		// System.out.println(username);
		List<Company> company = companyRepository.getById(companyID);
		InputStream is = null;
		if (!company.isEmpty()) {
			try {
				is = new FileInputStream(new File(path_traitement, companyID + ".pdf"));
				System.out.println("path " + path_traitement);

				// asume that it was a PDF file
				HttpHeaders responseHeaders = new HttpHeaders();
				InputStreamResource inputStreamResource = new InputStreamResource(is);
				// responseHeaders.setContentLength(contentLengthOfStream);
				responseHeaders.setContentType(MediaType.valueOf("application/pdf"));
				// just in case you need to support browsers

				responseHeaders.put("Content-Disposition",
						Collections.singletonList(  companyID + ".pdf"));
				return new ResponseEntity<InputStreamResource>(inputStreamResource, responseHeaders, HttpStatus.OK);
			} catch (Exception ex) {
				ex.printStackTrace();
				return null;
			}
		}
		// BufferedInputStream bf = new BufferedInputStream(is);
		// is.close();
		// byte[] bytes = StreamUtils.copyToByteArray(bf);
		// return
		// ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).body(bytes);
		return null;

	}
	
	
	@RequestMapping(value = "/pdf/company/agreement/{companyID}", method = RequestMethod.GET)
	@Produces("application/pdf")
	public javax.ws.rs.core.Response getPdf(@PathVariable("companyID") String companyID) throws Exception
	{
	    File file = new File(path_traitement, companyID + ".pdf");
	    FileInputStream fileInputStream = new FileInputStream(file);
	    javax.ws.rs.core.Response.ResponseBuilder responseBuilder = javax.ws.rs.core.Response.ok((Object) fileInputStream);
	    responseBuilder.type("application/pdf");
	    responseBuilder.header("Content-Disposition", "filename=test.pdf");
	    return responseBuilder.build();
	}
	

	@RequestMapping(value = "/visit_veter/analyse/{visitDate}/{visitId}", method = RequestMethod.POST)
	@ResponseBody
	public BasicResponse uploadAnalayse(@PathVariable("visitDate") String visitDate,@PathVariable("visitId") String visitId,
			@RequestParam("analyse") MultipartFile analyse) {

		try {
            System.out.println("analyse");
			byte[] bytes = analyse.getBytes();
			// Creating the directory to store file
			String rootPath = path_analyses;
			File dir = new File(rootPath);
			if (!dir.exists())
				dir.mkdirs();
			// Create the file on server
			File serverFile = new File(dir.getAbsolutePath() + "\\"+ visitId +"_"+ visitDate + ".pdf");
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();
			return new BasicResponse("analyse uploaded", HttpStatus.OK);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);
		}

		    
		   
	}
	
	@RequestMapping(value = "/visit_veter/analyse/{visitDate}/{visitId}", method = RequestMethod.GET)
	@Produces("application/pdf")
	public ResponseEntity<InputStreamResource> getPdfAnalyse(@PathVariable("visitDate") String visitDate,@PathVariable("visitId") String visitId) throws Exception
	{
		InputStream is = null;
		
		try {
			
			//System.out.println("path " + path_traitement);

			// asume that it was a PDF file
			//InputStreamResource inputStreamResource = new InputStreamResource(is);
		FileInfoVisit fileInfoVisit = new FileInfoVisit();
				is = new FileInputStream(new File(path_analyses, visitId +"_"+ visitDate + ".pdf"));
				// asume that it was a PDF file
				HttpHeaders responseHeaders = new HttpHeaders();
				InputStreamResource inputStreamResource = new InputStreamResource(is);
				// responseHeaders.setContentLength(contentLengthOfStream);
				responseHeaders.setContentType(MediaType.valueOf("application/pdf"));
				// just in case you need to support browsers
			fileInfoVisit.setVisitId(visitId);
			fileInfoVisit.setVisitNecropsyNbservationId("analyse");
			fileInfoVisit.setUrl(path_analyses+"\\"+visitId +"_"+ visitDate + ".pdf");
			fileInfoVisit.setName(fileInfoVisit.getVisitId() + String.valueOf(fileInfoVisitRepository.countAll(fileInfoVisit.getVisitId()) + 1));
			jdbcTemplate.update(
					"INSERT INTO public.file_info_visit(\n" +
							"\tname, url, visit_id, visit_necropsy_nbservation_id)\n" +
							"\tVALUES (?, ?, ?, ?);",
					fileInfoVisit.getName(), fileInfoVisit.getUrl(), fileInfoVisit.getVisitId(),
					fileInfoVisit.getVisitNecropsyNbservationId());

				//responseHeaders.put("Content-Disposition",Collections.singletonList(  fileName+ ".pdf"));
		
			return new ResponseEntity<InputStreamResource>(inputStreamResource, responseHeaders, HttpStatus.OK);
		
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}

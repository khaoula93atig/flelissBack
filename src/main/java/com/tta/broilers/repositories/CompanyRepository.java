package com.tta.broilers.repositories;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.tta.broilers.dao.CompanyInterface;
import com.tta.broilers.entities.Company;
import com.tta.broilers.mappers.CompanyRowMapper;
import com.tta.broilers.responses.BasicResponse;
import com.tta.broilers.utils.Utils;

/**
 * @author rym lamouchi
 *
 */
@Repository
public class CompanyRepository implements CompanyInterface {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Company> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from company", new CompanyRowMapper());

	}

	@Override
	public BasicResponse save(MultipartFile fichier,Company company) {
		try {
			String path_traitement = Utils.Logo;
			byte[] bytes = fichier.getBytes();
			// Creating the directory to store file
			String rootPath = path_traitement;
			File dir = new File(rootPath);
			if (!dir.exists())
				dir.mkdirs();
			// Create the file on server
			File serverFile = new File(dir.getAbsolutePath() + "\\" + company.getName() + ".png");
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();
			company.setLogo(dir.getAbsolutePath() + "\\" + company.getName() + ".png");
			// company.setCompanyId(UUID.randomUUID().toString().replace("-", ""));
			company.setCompanyId(Utils.LeftPadString(String.valueOf(countAll() + 1), 4, "0"));
			company.setCreationDate(new Date());

			jdbcTemplate.update(
					"INSERT INTO company( company_id, name, farms_number, address, creation_date, country, "
							+ "   zone, general_manager_name, general_manager_tel, general_manager_email, "
							+ "    annual_production, agreement, integration , logo) "
							+ "  VALUES (?, ?, ?, ?, ?, ?,   ?, ?, ?, ?,  ?, ?, ? , ?);",
					company.getCompanyId(), company.getName(), company.getFarmsNumber(), company.getAddress(),
					company.getCreationDate(), company.getCountry(), company.getZone(), company.getGeneralManageName(),
					company.getGeneralManageTel(), company.getGeneralManageEmail(), company.getAnnualProduction(),
					company.getAgreement(), company.isIntegration(), company.getLogo());
			return new BasicResponse("Company created: " + company.toString(), HttpStatus.OK);
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public BasicResponse update(Company company) {
		try {
			List<Company> toUpdate = getById(company.getCompanyId());
			if (!toUpdate.isEmpty()) {
				jdbcTemplate.update(
						"UPDATE company  SET  name=?, farms_number=?, address=?, creation_date=?, "
								+ "     country=?, zone=?, general_manager_name=?, general_manager_tel=?, "
								+ "     general_manager_email=?, annual_production=?, agreement=?, integration=?"
								+ " WHERE company_id=?;",
						company.getName(), company.getFarmsNumber(), company.getAddress(), company.getCreationDate(),
						company.getCountry(), company.getZone(), company.getGeneralManageName(),
						company.getGeneralManageTel(), company.getGeneralManageEmail(), company.getAnnualProduction(),
						company.getAgreement(), company.isIntegration(), company.getCompanyId());
				return new BasicResponse("Company updated: " + company.toString(), HttpStatus.OK);
			} else {
				return new BasicResponse("Element introuvable!", HttpStatus.BAD_REQUEST);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public List<Company> getById(String id) {

		return jdbcTemplate.query("select * from company where company_id=?", new Object[] { id },
				new CompanyRowMapper());
	}

	@Override
	public long countAll() {
		return jdbcTemplate.queryForObject("select count(*) from company ", Long.class);
	}

	@Override
	public ResponseEntity<InputStreamResource> getImage(String image) throws IOException {
		// TODO Auto-generated method stub
		List<Company> companies=getById(image);
		String logo = companies.get(0).getLogo();
		System.out.println("rootPath "+logo);
		InputStream is = null;
		
		try {
			
			
			// asume that it was a PDF file
			//InputStreamResource inputStreamResource = new InputStreamResource(is);
		
				is = new FileInputStream(new File(logo));
				// asume that it was a PDF file
				HttpHeaders responseHeaders = new HttpHeaders();
				InputStreamResource inputStreamResource = new InputStreamResource(is);
				responseHeaders.setContentType(MediaType.IMAGE_JPEG);
				
			return new ResponseEntity<InputStreamResource>(inputStreamResource, responseHeaders, HttpStatus.OK);
		
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}

package com.tta.broilers.repositories;

import com.tta.broilers.dao.FileInfoVisitInterface;
import com.tta.broilers.entities.Company;
import com.tta.broilers.entities.FileInfoVisit;
import com.tta.broilers.mappers.FileInfoVisitRowMapper;
import com.tta.broilers.responses.BasicResponse;
import com.tta.broilers.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Date;
import java.util.List;

@Repository
public class FileInfoVisitRepository implements FileInfoVisitInterface {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public BasicResponse save(MultipartFile file , FileInfoVisit fileEntite) {
        try {
            System.out.println(fileEntite);
            String path_traitement = Utils.Analyse;
            byte[] bytes = file.getBytes();
            // Creating the directory to store file
            String rootPath = path_traitement;
            File dir = new File(rootPath);
            if (!dir.exists())
                dir.mkdirs();
            // Create the file on server
            File serverFile = new File(dir.getAbsolutePath() + "\\" + fileEntite.getVisitId() + ".png");
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
            stream.write(bytes);
            stream.close();
            fileEntite.setUrl(dir.getAbsolutePath() + "\\" + fileEntite.getVisitId() + ".png");
            fileEntite.setName(fileEntite.getVisitId() + String.valueOf(countAll(fileEntite.getVisitId()) + 1));
            jdbcTemplate.update(
                    "INSERT INTO public.file_info_visit(\n" +
                            "\tname, url, visit_id, visit_necropsy_nbservation_id)\n" +
                            "\tVALUES (?, ?, ?, ?);",
                    fileEntite.getName(), fileEntite.getUrl(), fileEntite.getVisitId(),
                    fileEntite.getVisitNecropsyNbservationId());
            return new BasicResponse("file add: " + ' ', HttpStatus.OK);
        } catch (org.springframework.dao.DuplicateKeyException ex) {
            ex.printStackTrace();
            return new BasicResponse("file existant!", HttpStatus.BAD_REQUEST);

        } catch (Exception ex) {
            return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

        }
    }

    @Override
    public List<FileInfoVisit> getByVisitId(String visitId, String visitNecropsyNbservationId) {
        String req = "select * from file_info_visit \n" +
                "where visit_id=? and visit_necropsy_nbservation_id=?";
        return jdbcTemplate.query(req , new Object[]{visitId , visitNecropsyNbservationId}, new FileInfoVisitRowMapper());
    }

    @Override
    public ResponseEntity<InputStreamResource> getImage(String image) throws IOException {
        List<FileInfoVisit> fileInfoVisits=getByName(image);
        String url = fileInfoVisits.get(0).getUrl();
        System.out.println("rootPath "+url);
        InputStream is = null;

        try {

            is = new FileInputStream(new File(url));
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

    @Override
    public List<FileInfoVisit> getByName(String name) {
        String req = "select * from file_info_visit where name=?;";
        return jdbcTemplate.query(req,new Object[]{name} ,new FileInfoVisitRowMapper() );
    }

    @Override
    public List<FileInfoVisit> getByVisit(String visitId) {
        String req = "select * from file_info_visit where visit_id=?;";
        return jdbcTemplate.query(req,new Object[]{visitId} ,new FileInfoVisitRowMapper() );
    }

    public long countAll(String visitId) {
        return jdbcTemplate.queryForObject("select count(*) from file_info_visit where visit_id=?",
        new Object[] { visitId }, Long.class);
    }
}


package com.tta.broilers.dao;

import com.tta.broilers.entities.Company;
import com.tta.broilers.entities.FileInfoVisit;
import com.tta.broilers.responses.BasicResponse;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileInfoVisitInterface {
    public BasicResponse save(MultipartFile file , FileInfoVisit fileEntite);
    public List<FileInfoVisit> getByVisitId(String visitId , String visitNecropsyNbservationId);
    ResponseEntity<InputStreamResource> getImage(String image)	throws IOException;

    public List<FileInfoVisit> getByName(String name);
    public List<FileInfoVisit> getByVisit(String visitId);
}

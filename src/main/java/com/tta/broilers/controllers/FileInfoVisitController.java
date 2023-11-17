package com.tta.broilers.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tta.broilers.dao.CompanyInterface;
import com.tta.broilers.dao.FileInfoVisitInterface;
import com.tta.broilers.entities.Company;
import com.tta.broilers.entities.FileInfoVisit;
import com.tta.broilers.responses.BasicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/fileVisit")
public class FileInfoVisitController {
    @Autowired
    FileInfoVisitInterface fileInfoVisitInterface;
    @PostMapping("/save")
    public BasicResponse save(@RequestPart("fichier") MultipartFile fichier, @RequestPart("fileEntite") String fileEntite) throws JsonMappingException, JsonProcessingException {
        System.out.println(fileEntite);
        FileInfoVisit fileInfoVisit = new ObjectMapper().readValue(fileEntite, FileInfoVisit.class);
        return fileInfoVisitInterface.save(fichier,fileInfoVisit);
    }

    @GetMapping("/filesVisitNecropsy/{visitId}/{visitNecropsyNbservationId}")
    public List<FileInfoVisit> getFilesByVisit(@PathVariable("visitId") String visitId , @PathVariable("visitNecropsyNbservationId") String visitNecropsyNbservationId){
        return fileInfoVisitInterface.getByVisitId(visitId, visitNecropsyNbservationId);
    }

    @GetMapping("/analyseVisit/{visitId}")
    public List<FileInfoVisit> getAnalysesOfVisit(@PathVariable("visitId") String visitId){
        return fileInfoVisitInterface.getByVisit(visitId);
    }

    @GetMapping("/image/{name}")
    public ResponseEntity<InputStreamResource> getPathByFileNameInteretCou(@PathVariable("name") String name)
            throws IOException {
        return fileInfoVisitInterface.getImage(name);
    }

}

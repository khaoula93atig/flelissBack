package com.tta.broilers.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;


public class FileInfoVisit {
    @Id
    private String name;
    @JsonProperty("url")
    private String url;
    @JsonProperty("visitId")
    private String visitId;
    @JsonProperty("visitNecropsyNbservationId")
    private String visitNecropsyNbservationId;
    

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }

    public String getVisitNecropsyNbservationId() {
        return visitNecropsyNbservationId;
    }

    public void setVisitNecropsyNbservationId(String visitNecropsyNbservationId) {
        this.visitNecropsyNbservationId = visitNecropsyNbservationId;
    }

    @Override
    public String toString() {
        return "FileInfoVisit{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", visitId='" + visitId + '\'' +
                ", visitNecropsyNbservationId='" + visitNecropsyNbservationId + '\'' +
                '}';
    }
}

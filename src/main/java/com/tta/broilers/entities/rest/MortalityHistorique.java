package com.tta.broilers.entities.rest;
import java.util.Date;

public class MortalityHistorique {
    private Long measure ;
    private int ageFlock;
    private Date visitDate;

    public void setMeasure(Long measure) {
        this.measure = measure;
    }

    public Long getMeasure() {
        return measure;
    }

    public int getAgeFlock() {
        return ageFlock;
    }

    public void setAgeFlock(int ageFlock) {
        this.ageFlock = ageFlock;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    @Override
    public String toString() {
        return "MortalityHistorique{" +
                "measure=" + measure +
                ", ageFlock=" + ageFlock +
                ", visitDate=" + visitDate +
                '}';
    }
}

package com.tta.broilers.entities.rest;

public class FeedWeightweekly {
    private Double average;
    private Double totalFinisherFeed;
    private Double totalGrowerFeed;
    private Double totalStarterFeed;

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public Double getTotalFinisherFeed() {
        return totalFinisherFeed;
    }

    public void setTotalFinisherFeed(Double totalFinisherFeed) {
        this.totalFinisherFeed = totalFinisherFeed;
    }

    public Double getTotalGrowerFeed() {
        return totalGrowerFeed;
    }

    public void setTotalGrowerFeed(Double totalGrowerFeed) {
        this.totalGrowerFeed = totalGrowerFeed;
    }

    public Double getTotalStarterFeed() {
        return totalStarterFeed;
    }

    public void setTotalStarterFeed(Double totalStarterFeed) {
        this.totalStarterFeed = totalStarterFeed;
    }
}

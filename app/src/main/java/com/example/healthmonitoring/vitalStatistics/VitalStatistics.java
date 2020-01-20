package com.example.healthmonitoring.vitalStatistics;

import java.util.Date;

public class VitalStatistics {
    private double weight;
    private int numberSteps;
    private Date measurementDate;

    public VitalStatistics(double weight, int numberSteps, Date measurementDate) {
        this.weight = weight;
        this.numberSteps = numberSteps;
        this.measurementDate = measurementDate;
    }
}

package com.example.healthmonitoring.pressure;

import java.util.Date;

public class Pressure {
    private int topPressure;
    private int lowerPressure;
    private int pulse;
    private boolean tachycardia;
    private Date measurementDate;

    public Pressure(int topPressure, int lowerPressure, int pulse, boolean tachycardia,
                    Date measurementDate) {
        this.topPressure = topPressure;
        this.lowerPressure = lowerPressure;
        this.pulse = pulse;
        this.tachycardia = tachycardia;
        this.measurementDate = measurementDate;
    }

}

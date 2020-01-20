package com.example.healthmonitoring.pressure;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PressureManager {
    List<Pressure> pressureList = new ArrayList<>();


    public boolean addPressure(int topPressure, int lowerPressure, int pulse, boolean tachycardia) {
        Pressure pressure = new Pressure(topPressure, lowerPressure, pulse, tachycardia, new Date());

        return pressureList.add(pressure);
    }
}

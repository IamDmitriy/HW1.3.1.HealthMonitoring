package com.example.healthmonitoring.vitalStatistics;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VitalStatisticsManager {
    List<VitalStatistics> vitalStatisticsList = new ArrayList<>();

    public boolean addVitalStatistics (double weight, int numberSteps) {
        VitalStatistics vitalStatistics = new VitalStatistics(weight, numberSteps, new Date());

        return vitalStatisticsList.add(vitalStatistics);
    }


}

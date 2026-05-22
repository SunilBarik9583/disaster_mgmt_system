package com.smartrelif.disasteroptimizerdms.ai;


import com.smartrelif.disasteroptimizerdms.model.DisasterReport;

public class ResourceOptimizer {

    public static void allocate(DisasterReport report) {
        report.setFoodAllocated(report.getAffectedPopulation() * 3);
        report.setMedicalKits(report.getAffectedPopulation() / 4);
        report.setRescueTeams(report.getSeverityLevel() * 3);
        report.setShelters(report.getAffectedPopulation() / 40);
    }
}


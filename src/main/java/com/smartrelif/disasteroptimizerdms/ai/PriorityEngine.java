package com.smartrelif.disasteroptimizerdms.ai;



import com.smartrelif.disasteroptimizerdms.model.*;

public class PriorityEngine {

    public static double calculateScore(DisasterReport report) {

        double score = 0;

        score += report.getAffectedPopulation() * 0.4;
        score += report.getSeverityLevel() * 80;
        score += report.getVulnerablePopulation() * 0.3;
        score += report.getInfrastructureDamage() * 60;

        if (report.getSeverityLevel() >= 8) {
            score += 600;
        }

        return score;
    }

    public static PriorityLevel classify(double score) {
        if (score > 9000) return PriorityLevel.CRITICAL;
        if (score > 5000) return PriorityLevel.HIGH;
        return PriorityLevel.MODERATE;
    }
}


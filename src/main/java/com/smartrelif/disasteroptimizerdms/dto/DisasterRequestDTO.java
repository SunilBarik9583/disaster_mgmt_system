package com.smartrelif.disasteroptimizerdms.dto;



public class DisasterRequestDTO {

    private String location;
    private String disasterType;
    private int affectedPopulation;
    private int severityLevel;
    private int vulnerablePopulation;
    private int infrastructureDamage;

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getDisasterType() { return disasterType; }
    public void setDisasterType(String disasterType) { this.disasterType = disasterType; }

    public int getAffectedPopulation() { return affectedPopulation; }
    public void setAffectedPopulation(int affectedPopulation) { this.affectedPopulation = affectedPopulation; }

    public int getSeverityLevel() { return severityLevel; }
    public void setSeverityLevel(int severityLevel) { this.severityLevel = severityLevel; }

    public int getVulnerablePopulation() { return vulnerablePopulation; }
    public void setVulnerablePopulation(int vulnerablePopulation) { this.vulnerablePopulation = vulnerablePopulation; }

    public int getInfrastructureDamage() { return infrastructureDamage; }
    public void setInfrastructureDamage(int infrastructureDamage) { this.infrastructureDamage = infrastructureDamage; }
}


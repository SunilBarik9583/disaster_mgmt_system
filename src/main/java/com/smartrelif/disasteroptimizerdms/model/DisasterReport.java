package com.smartrelif.disasteroptimizerdms.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "disaster_report")
public class DisasterReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String disasterType;

    private int affectedPopulation;
    private int severityLevel;
    private int vulnerablePopulation;
    private int infrastructureDamage;

    private double priorityScore;

    @Enumerated(EnumType.STRING)
    private PriorityLevel priorityLevel;

    private int foodAllocated;
    private int medicalKits;
    private int rescueTeams;
    private int shelters;

    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    // -------- GETTERS & SETTERS --------

    public Long getId() { return id; }

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

    public double getPriorityScore() { return priorityScore; }
    public void setPriorityScore(double priorityScore) { this.priorityScore = priorityScore; }

    public PriorityLevel getPriorityLevel() { return priorityLevel; }
    public void setPriorityLevel(PriorityLevel priorityLevel) { this.priorityLevel = priorityLevel; }

    public int getFoodAllocated() { return foodAllocated; }
    public void setFoodAllocated(int foodAllocated) { this.foodAllocated = foodAllocated; }

    public int getMedicalKits() { return medicalKits; }
    public void setMedicalKits(int medicalKits) { this.medicalKits = medicalKits; }

    public int getRescueTeams() { return rescueTeams; }
    public void setRescueTeams(int rescueTeams) { this.rescueTeams = rescueTeams; }

    public int getShelters() { return shelters; }
    public void setShelters(int shelters) { this.shelters = shelters; }

    public LocalDateTime getCreatedAt() { return createdAt; }
}

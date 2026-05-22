package com.smartrelif.disasteroptimizerdms.dto;



import com.smartrelif.disasteroptimizerdms.model.PriorityLevel;

public class DisasterResponseDTO {

    private double priorityScore;
    private PriorityLevel priorityLevel;
    private int foodAllocated;
    private int medicalKits;
    private int rescueTeams;
    private int shelters;

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
}


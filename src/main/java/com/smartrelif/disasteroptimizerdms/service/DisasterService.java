package com.smartrelif.disasteroptimizerdms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.smartrelif.disasteroptimizerdms.ai.PriorityEngine;
import com.smartrelif.disasteroptimizerdms.ai.ResourceOptimizer;
import com.smartrelif.disasteroptimizerdms.dto.DisasterRequestDTO;
import com.smartrelif.disasteroptimizerdms.dto.DisasterResponseDTO;
import com.smartrelif.disasteroptimizerdms.model.DisasterReport;
import com.smartrelif.disasteroptimizerdms.repository.DisasterRepository;

@Service
public class DisasterService {

	//pagination
	public Page<DisasterReport> getPaginatedReports(int page, int size) {

	    Pageable pageable = PageRequest.of(page, size);

	    return repository.findAll(pageable);
	}
	
	
    @Autowired
    private DisasterRepository repository;

    public DisasterResponseDTO process(DisasterRequestDTO request) {

        DisasterReport report = new DisasterReport();

        report.setLocation(request.getLocation());
        report.setDisasterType(request.getDisasterType());
        report.setAffectedPopulation(request.getAffectedPopulation());
        report.setSeverityLevel(request.getSeverityLevel());
        report.setVulnerablePopulation(request.getVulnerablePopulation());
        report.setInfrastructureDamage(request.getInfrastructureDamage());

        double score = PriorityEngine.calculateScore(report);
        report.setPriorityScore(score);
        report.setPriorityLevel(PriorityEngine.classify(score));

        ResourceOptimizer.allocate(report);

        repository.save(report);

        DisasterResponseDTO response = new DisasterResponseDTO();
        response.setPriorityScore(report.getPriorityScore());
        response.setPriorityLevel(report.getPriorityLevel());
        response.setFoodAllocated(report.getFoodAllocated());
        response.setMedicalKits(report.getMedicalKits());
        response.setRescueTeams(report.getRescueTeams());
        response.setShelters(report.getShelters());

        return response;
    }

    public List<DisasterReport> getAllReports() {
        return repository.findAll();
    }
}

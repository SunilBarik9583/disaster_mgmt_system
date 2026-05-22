package com.smartrelif.disasteroptimizerdms.controller;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;
import com.smartrelif.disasteroptimizerdms.dto.*;
import com.smartrelif.disasteroptimizerdms.model.DisasterReport;
import com.smartrelif.disasteroptimizerdms.service.DisasterService;

@RestController
@RequestMapping("/api/disaster")
@CrossOrigin
public class DisasterController {

	@GetMapping("/paginated")
	public Page<DisasterReport> getPaginated(
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "5") int size) {

	    return service.getPaginatedReports(page, size);
	}
    @Autowired
    private DisasterService service;

    @PostMapping("/report")
    public DisasterResponseDTO create(@RequestBody DisasterRequestDTO request) {
        return service.process(request);
    }

    @GetMapping("/all")
    public List<DisasterReport> getAll() {
        return service.getAllReports();
    }

    @GetMapping("/health")
    public String health() {
        return "SmartRelief AI Disaster Optimizer Running Successfully!";
    }
}

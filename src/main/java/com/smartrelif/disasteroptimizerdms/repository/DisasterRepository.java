package com.smartrelif.disasteroptimizerdms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smartrelif.disasteroptimizerdms.model.DisasterReport;

public interface DisasterRepository extends JpaRepository<DisasterReport, Long> {
}


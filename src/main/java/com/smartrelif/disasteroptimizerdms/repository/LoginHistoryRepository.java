package com.smartrelif.disasteroptimizerdms.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import com.smartrelif.disasteroptimizerdms.model.LoginHistory;

public interface LoginHistoryRepository
        extends JpaRepository<LoginHistory, Long> {
}

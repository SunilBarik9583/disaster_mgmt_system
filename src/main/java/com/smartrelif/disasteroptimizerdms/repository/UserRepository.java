package com.smartrelif.disasteroptimizerdms.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import com.smartrelif.disasteroptimizerdms.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}

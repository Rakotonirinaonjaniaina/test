package com.example.prog4.repository;

import com.example.prog4.model.EmployeeCNAPS;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeCNAPSRepository extends JpaRepository<EmployeeCNAPS, Long> {
    EmployeeCNAPS findByCnapsNumber(String cnapsNumber);
}

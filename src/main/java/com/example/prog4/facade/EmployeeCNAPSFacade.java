package com.example.prog4.facade;

import com.example.prog4.model.EmployeeCNAPS;
import com.example.prog4.repository.EmployeeCNAPSRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeCNAPSFacade {
    private final EmployeeCNAPSRepository employeeCNAPSRepository;

    public EmployeeCNAPSFacade(EmployeeCNAPSRepository employeeCNAPSRepository) {
        this.employeeCNAPSRepository = employeeCNAPSRepository;
    }

    public EmployeeCNAPS getEmployeeCNAPSByCnapsNumber(String cnapsNumber) {
        return employeeCNAPSRepository.findByCnapsNumber(cnapsNumber);
    }

}

package com.mna.app.service.impl;

import com.mna.app.domain.entity.Employee;
import com.mna.app.service.EmployeeService;
import com.mna.app.service.HealthInsuranceService;
import com.mna.app.service.OnboardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class OnboardServiceImpl implements OnboardService {

    private final EmployeeService employeeService;

    private final HealthInsuranceService healthInsuranceService;

    @Autowired
    public OnboardServiceImpl(EmployeeService employeeService, HealthInsuranceService healthInsuranceService) {
        this.employeeService = employeeService;
        this.healthInsuranceService = healthInsuranceService;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void registerEmployee(Employee employee) {
        employeeService.saveEmployee(employee);
        healthInsuranceService.createInsurance(employee);
        log.info("Employee onboarded successfully!");
    }
}

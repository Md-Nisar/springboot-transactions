package com.mna.app.service.impl;

import com.mna.app.domain.dao.HealthInsuranceDao;
import com.mna.app.domain.entity.Employee;
import com.mna.app.domain.entity.HealthInsurance;
import com.mna.app.service.HealthInsuranceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class HealthInsuranceServiceImpl implements HealthInsuranceService {

    private final HealthInsuranceDao healthInsuranceDao;

    @Value("${service.health-insurance.active}")
    private boolean isServiceEnabled;

    public HealthInsuranceServiceImpl(HealthInsuranceDao healthInsuranceDao) {
        this.healthInsuranceDao = healthInsuranceDao;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void createInsurance(Employee employee) {

        if (!isServiceEnabled) {
            throw new RuntimeException("Health Insurance Service is disabled!");
        }

        HealthInsurance insurance = HealthInsurance.builder()
                .employeeName(employee.getName())
                .amount(100000.00)
                .build();

        healthInsuranceDao.save(insurance);
        log.info("Health Insurance created successfully!");
    }
}

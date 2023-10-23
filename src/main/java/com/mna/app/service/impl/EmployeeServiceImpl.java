package com.mna.app.service.impl;

import com.mna.app.domain.dao.EmployeeDao;
import com.mna.app.domain.entity.Employee;
import com.mna.app.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;

    @Value("${service.employee.active}")
    private boolean isServiceEnabled;

    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveEmployee(Employee employee) {
        employeeDao.save(employee);
        log.info("Employee saved successfully!");
    }
}

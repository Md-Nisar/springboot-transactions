package com.mna.app;

import com.mna.app.base.util.EmployeeUtils;
import com.mna.app.domain.entity.Employee;
import com.mna.app.service.EmployeeService;
import com.mna.app.service.HealthInsuranceService;
import com.mna.app.service.OnboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootTransactionsApplication implements CommandLineRunner {

    @Autowired
   private EmployeeService employeeService;

    @Autowired
   private  HealthInsuranceService healthInsuranceService;

    @Autowired
   private  OnboardService onboardService;


    public static void main(String[] args) {
        SpringApplication.run(SpringbootTransactionsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Employee employee = Employee.builder()
                .name(EmployeeUtils.generateRandomName())
                .build();

        // employeeService.saveEmployee(employee);
        // healthInsuranceService.createInsurance(employee);
        onboardService.registerEmployee(employee);

    }


}

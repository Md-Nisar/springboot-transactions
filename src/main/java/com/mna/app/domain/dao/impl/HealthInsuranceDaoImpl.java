package com.mna.app.domain.dao.impl;

import com.mna.app.domain.dao.HealthInsuranceDao;
import com.mna.app.domain.entity.HealthInsurance;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class HealthInsuranceDaoImpl extends JdbcDaoSupport implements HealthInsuranceDao {

    @Autowired
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    private void init() {
        super.setDataSource(dataSource);
        this.jdbcTemplate = super.getJdbcTemplate();
    }

    @Override
    public void save(HealthInsurance healthInsurance) {
        String sql = "INSERT INTO HEALTH_INSURANCE (emp_name, amount) VALUES (?, ?)";
        jdbcTemplate.update(sql, healthInsurance.getEmployeeName(), healthInsurance.getAmount());
    }
}


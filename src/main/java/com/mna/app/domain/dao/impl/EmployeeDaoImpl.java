package com.mna.app.domain.dao.impl;

import com.mna.app.domain.dao.EmployeeDao;
import com.mna.app.domain.entity.Employee;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class EmployeeDaoImpl extends JdbcDaoSupport implements  EmployeeDao {

    @Autowired
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    private void init() {
        super.setDataSource(dataSource);
        this.jdbcTemplate = super.getJdbcTemplate();
    }

    @Override
    public void save(Employee employee) {
        String sql = "INSERT INTO EMPLOYEE (name) VALUES (?)";
        jdbcTemplate.update(sql, employee.getName());
    }
}


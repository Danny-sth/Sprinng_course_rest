package com.dannykudinov.spring.rest.service;

import com.dannykudinov.spring.rest.dao.EmployeeDAO;
import com.dannykudinov.spring.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        List<Employee> empList = employeeDAO.getAllEmployees();
        return empList;
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeDAO.saveOrUpdateEmployee(employee);
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        Employee employee = employeeDAO.getEmployee(id);
        return employee;
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }
}

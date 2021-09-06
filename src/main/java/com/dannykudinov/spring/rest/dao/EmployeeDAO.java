package com.dannykudinov.spring.rest.dao;

import com.dannykudinov.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> getAllEmployees();

    public void saveOrUpdateEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void deleteEmployee(int id);
}

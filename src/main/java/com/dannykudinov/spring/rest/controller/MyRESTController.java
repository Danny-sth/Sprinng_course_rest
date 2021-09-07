package com.dannykudinov.spring.rest.controller;

import com.dannykudinov.spring.rest.entity.Employee;
import com.dannykudinov.spring.rest.exception_handling.NoSuchEmployeeException;
import com.dannykudinov.spring.rest.service.EmployeeService;
import com.dannykudinov.spring.rest.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService = new EmployeeServiceImpl();

    @GetMapping("/employees")
    public List<Employee> showEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);

        if (employee == null) {
            throw new NoSuchEmployeeException("There is no employee with ID = " +
                    id + " in Database");
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee postEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        if (employee == null) {
            throw new NoSuchEmployeeException("There is no employee with ID = "
                    + id + " in Database");
        }
        employeeService.deleteEmployee(id);
        return "Employee with ID = " + id + " was deleted.";
    }
}

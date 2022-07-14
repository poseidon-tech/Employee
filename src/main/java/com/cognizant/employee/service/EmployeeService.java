package com.cognizant.employee.service;

import com.cognizant.employee.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();
    Employee addEmployee(Employee employee);
    Employee deleteEmployee(int id);
    Employee updateEmployee(int id,Employee employee);
    Employee getEmployeeById(int id);
}

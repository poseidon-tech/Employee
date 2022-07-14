package com.cognizant.employee.controller;

import com.cognizant.employee.model.Employee;
import com.cognizant.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/employees")
public class EmployeeResource {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    @GetMapping
    public List<Employee> getEmployees()
    {
        return employeeService.getEmployees();
    }
    @GetMapping("{id}")
    public Employee getEmployee(@PathVariable int id)
    {
        return employeeService.getEmployeeById(id);

    }
    @PutMapping("{id}")
    public Employee updateEmployee(@PathVariable int id,@RequestBody Employee employee)
    {
        return employeeService.updateEmployee(id,employee);
    }
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee)

    {
       return  employeeService.addEmployee(employee);
    }
    @DeleteMapping("{id}")
    public Employee deleteEmployee(@PathVariable int id)
    {
        return employeeService.deleteEmployee(id);
    }



}

package com.cognizant.employee.service;

import com.cognizant.employee.model.Employee;
import com.cognizant.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public List<Employee> getEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        repository.save(employee);
        return employee;
    }

    @Override
    public Employee deleteEmployee(int id) {
        Employee employee=repository.findById(id).get();
        repository.deleteById(id);
        return employee;
    }

    @Override
    public Employee updateEmployee(int id,Employee employee) {
        Optional<Employee> optEmp=repository.findById(id);
        if(!optEmp.isPresent())
        {
            throw new RuntimeException("Employee with id "+id+" does  not exist");
        }
        Employee emp=optEmp.get();
        if(employee.getName()!=null)
        {
            emp.setName(employee.getName());
        }
        if(employee.getGender()!=null)
        {
            emp.setGender(employee.getGender());
        }
        if(employee.getAge()!=0)
        {
            emp.setAge(employee.getAge());
        }
        if(employee.getSalary()!=0)
        {
            emp.setSalary(employee.getSalary());
        }
        repository.save(emp);
        return emp;
    }

    @Override
    public Employee getEmployeeById(int id) {

        return repository.findById(id).orElseThrow(()->new RuntimeException("Employee with the "+id+" does not exist "));
    }
}

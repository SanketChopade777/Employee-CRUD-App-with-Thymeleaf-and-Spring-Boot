package com.example.demo.services;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRespository employeeRepository;

    // Create or Update employee
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Get all employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get employee by ID
    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    // Update employee
    public Employee updateEmployee(int id, Employee newData) {
        return employeeRepository.findById(id).map(emp -> {
            emp.setFirstName(newData.getFirstName());
            emp.setLastName(newData.getLastName());
            return employeeRepository.save(emp);
        }).orElseGet(() -> {
            newData.setId(id);
            return employeeRepository.save(newData);
        });
    }

    // Delete employee
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}

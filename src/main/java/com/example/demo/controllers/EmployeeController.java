package com.example.demo.controllers;

import com.example.demo.entity.Employee;
import com.example.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.print.Printable;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Show registration form
    @GetMapping("/getForm")
    public ModelAndView getRegistrationForm() {
        Map<String, Object> model = new HashMap<>();
        model.put("displaykaro", "Enter details");
        model.put("employee", new Employee());
        return new ModelAndView("register", model);
    }

    // Save employee (Register)
    @PostMapping("/register")
    public ModelAndView registerEmployee(@ModelAttribute Employee employee) {
        employeeService.saveEmployee(employee);
        return new ModelAndView("redirect:/getForm");
    }

    // Show update form for a specific employee
    @GetMapping("/edit/{id}")
    public ModelAndView editEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployeeById(id).orElse(new Employee());
        Map<String, Object> model = new HashMap<>();
        model.put("employee", employee);
        model.put("displaykaro", "Update Employee");
        return new ModelAndView("update-form", model);
    }

    // Update employee using POST (since HTML forms can't use PUT)
    @PostMapping("/update/{id}")
    public ModelAndView updateEmployee(@PathVariable int id, @ModelAttribute Employee updatedEmployee) {
        employeeService.updateEmployee(id, updatedEmployee);
        return new ModelAndView("redirect:/employees");
    }

    // View all employees
    @GetMapping("/employees")
    public ModelAndView getAllEmployees() {
        List<Employee> employeeList = employeeService.getAllEmployees();
        System.out.println("Employee List: " + employeeList);  // Verify the list content
        
        Map<String, Object> model = new HashMap<>();
        model.put("employeeList", employeeList);  // Correct attribute name passed to model
        
        return new ModelAndView("employees", model);  // Return the employees.html view
    }


    // Delete employee
    @GetMapping("/delete/{id}")
    public ModelAndView deleteEmployee(@PathVariable int id, RedirectAttributes redirectAttributes) {
        employeeService.deleteEmployee(id);
        redirectAttributes.addFlashAttribute("message", "Data is Deleted!");
        return new ModelAndView("redirect:/employees");
    }
}

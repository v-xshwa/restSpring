package com.buildwithvishwa.personal.RESTAPIs.controller;

import com.buildwithvishwa.personal.RESTAPIs.dto.EmployeeDto;
import com.buildwithvishwa.personal.RESTAPIs.service.impl.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    @GetMapping("/employees")
    public List<EmployeeDto> getEmployee(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/employees/{id}")
    public EmployeeDto getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

}

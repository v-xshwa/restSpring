package com.buildwithvishwa.personal.RESTAPIs.controller;

import com.buildwithvishwa.personal.RESTAPIs.dto.EmployeeDto;
import com.buildwithvishwa.personal.RESTAPIs.dto.NewEmployeeDto;
import com.buildwithvishwa.personal.RESTAPIs.service.EmployeeService;
import com.buildwithvishwa.personal.RESTAPIs.service.impl.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/employees")
    public ResponseEntity<EmployeeDto> createNewEmployee(@RequestBody NewEmployeeDto newEmployeeDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createNewEmployee(newEmployeeDto));
    }

}

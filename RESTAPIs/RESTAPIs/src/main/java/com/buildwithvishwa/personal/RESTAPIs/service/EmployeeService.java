package com.buildwithvishwa.personal.RESTAPIs.service;

import com.buildwithvishwa.personal.RESTAPIs.dto.EmployeeDto;
import com.buildwithvishwa.personal.RESTAPIs.dto.NewEmployeeDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> getAllEmployee();
    EmployeeDto getEmployeeById(Long id);
    EmployeeDto createNewEmployee(NewEmployeeDto newEmployeeDto);
}

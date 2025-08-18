package com.buildwithvishwa.personal.RESTAPIs.service;

import com.buildwithvishwa.personal.RESTAPIs.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> getAllEmployee();
    EmployeeDto getEmployeeById(Long id);
}

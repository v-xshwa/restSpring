package com.buildwithvishwa.personal.RESTAPIs.service;

import com.buildwithvishwa.personal.RESTAPIs.dto.EmployeeDto;
import com.buildwithvishwa.personal.RESTAPIs.dto.NewEmployeeDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    List<EmployeeDto> getAllEmployee();
    EmployeeDto getEmployeeById(Long id);
    EmployeeDto createNewEmployee(NewEmployeeDto newEmployeeDto);
    void deleteStudentById(Long id);
    EmployeeDto updateEmployeeById(Long id, NewEmployeeDto newEmployeeDto);
    EmployeeDto updateEmployeePartial(Long id, Map<String,Object> data);
}

package com.buildwithvishwa.personal.RESTAPIs.service.impl;

import com.buildwithvishwa.personal.RESTAPIs.dto.EmployeeDto;
import com.buildwithvishwa.personal.RESTAPIs.entity.Employee;
import com.buildwithvishwa.personal.RESTAPIs.repository.EmployeeRepo;
import com.buildwithvishwa.personal.RESTAPIs.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employees = employeeRepo.findAll();
        return employees.stream().map(employee -> new EmployeeDto(employee.getId(),employee.getName(),employee.getEmail())).toList();
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with ID: "+id));
        return new EmployeeDto(employee.getId(),employee.getName(),employee.getEmail());
    }
}

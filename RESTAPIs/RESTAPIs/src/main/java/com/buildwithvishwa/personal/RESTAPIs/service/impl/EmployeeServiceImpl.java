package com.buildwithvishwa.personal.RESTAPIs.service.impl;

import com.buildwithvishwa.personal.RESTAPIs.dto.EmployeeDto;
import com.buildwithvishwa.personal.RESTAPIs.dto.NewEmployeeDto;
import com.buildwithvishwa.personal.RESTAPIs.entity.Employee;
import com.buildwithvishwa.personal.RESTAPIs.repository.EmployeeRepo;
import com.buildwithvishwa.personal.RESTAPIs.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;

import java.util.Map;
import java.util.Optional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employees = employeeRepo.findAll();
        return employees.stream().map(employee -> new EmployeeDto(employee.getId(),employee.getName(),employee.getEmail())).toList();
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with ID: "+id));
        return modelMapper.map(employee,EmployeeDto.class);
    }
    @Override
    public EmployeeDto createNewEmployee(NewEmployeeDto newEmployeeDto) {
        Employee newEmployee = modelMapper.map(newEmployeeDto,Employee.class);
        Employee employee = employeeRepo.save(newEmployee);
        return modelMapper.map(employee,EmployeeDto.class);
    }

    @Override
    public void deleteStudentById(Long id) {
        if(!employeeRepo.existsById(id)){
            throw new IllegalArgumentException("No Employee with this Id "+id);
        }
        employeeRepo.deleteById(id);
    }

    @Override
    public EmployeeDto updateEmployeeById(Long id, NewEmployeeDto newEmployeeDto) {
        Employee employee = employeeRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("No Employee with the given id"));
        modelMapper.map(newEmployeeDto,employee);
        employeeRepo.save(employee);
        return modelMapper.map(employee,EmployeeDto.class);
    }

    @Override
    public EmployeeDto updateEmployeePartial(Long id, Map<String, Object> data) {
        Employee employee = employeeRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("No Employee with the given id"));

        data.forEach((key,value) ->{
            switch (key){
                case "name" :
                    employee.setName((String) value);
                    break;
                case "email":
                    employee.setEmail((String) value);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid Key");
            }
        });
        Employee newEmployee = employeeRepo.save(employee);
        return modelMapper.map(newEmployee,EmployeeDto.class);
    }
}

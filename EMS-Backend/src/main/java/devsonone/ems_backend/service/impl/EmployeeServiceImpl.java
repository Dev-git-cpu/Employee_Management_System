package devsonone.ems_backend.service.impl;

import devsonone.ems_backend.dto.EmployeeDto;
import devsonone.ems_backend.entity.Employee;
import devsonone.ems_backend.exception.ResourceNotFoundException;
import devsonone.ems_backend.mapper.EmployeeMapper;
import devsonone.ems_backend.repository.EmployeeRepository;
import devsonone.ems_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto dto) {
        Employee employee = EmployeeMapper.mapToEmployee(dto);
       Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee is not exist with given id : "+ employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
       List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee -> EmployeeMapper.mapToEmployeeDto(employee)))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee) {
       Employee employee = employeeRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee not exist with given id : "+employeeId));
        employee.setFirstName(updateEmployee.getFirstName());
        employee.setLastName(updateEmployee.getLastName());
        employee.setEmail(updateEmployee.getEmail());
       Employee updateEmployeeObj = employeeRepository.save(employee);
       return EmployeeMapper.mapToEmployeeDto(updateEmployeeObj);

    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                ()-> new ResourceNotFoundException("Employee not exist with given id : "+employeeId));
employeeRepository.deleteById(employeeId);
    }

}

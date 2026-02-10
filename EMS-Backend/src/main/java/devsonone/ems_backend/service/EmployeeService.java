package devsonone.ems_backend.service;

import devsonone.ems_backend.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto dto);

    EmployeeDto getEmployee(Long employeeId);

    List<EmployeeDto> getAllEmployee();

    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee);

    void deleteEmployee(Long employeeId);


}

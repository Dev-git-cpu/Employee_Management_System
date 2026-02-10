package devsonone.ems_backend.mapper;

import devsonone.ems_backend.dto.EmployeeDto;
import devsonone.ems_backend.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()

        );
    }

    public static Employee mapToEmployee(EmployeeDto dto){
        return new Employee(
          dto.getId(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getEmail()
        );
    }
}

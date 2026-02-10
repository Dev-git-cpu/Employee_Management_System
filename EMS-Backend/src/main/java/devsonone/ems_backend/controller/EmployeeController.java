package devsonone.ems_backend.controller;

import devsonone.ems_backend.dto.EmployeeDto;
import devsonone.ems_backend.entity.Employee;
import devsonone.ems_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
     EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") Long employeeId){
EmployeeDto employeeDto = employeeService.getEmployee(employeeId);
return ResponseEntity.ok(employeeDto);

    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
List<EmployeeDto> employees = employeeService.getAllEmployee();
return ResponseEntity.ok(employees);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,@RequestBody EmployeeDto updateEmployee){
       EmployeeDto employeeDto = employeeService.updateEmployee(employeeId,updateEmployee);
return ResponseEntity.ok(employeeDto);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee delete successfully.");
    }
}

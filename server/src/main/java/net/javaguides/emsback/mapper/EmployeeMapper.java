package net.javaguides.emsback.mapper;

import net.javaguides.emsback.dto.EmployeeDTO;
import net.javaguides.emsback.entity.Employee;

public class EmployeeMapper {
    public  static EmployeeDTO mapToEmployeeDTO (Employee employee){
        return new EmployeeDTO(
                employee.getId(),
                employee.getName(),
                employee.getEmail()
        );
    }

    public static Employee mapToEmployee(EmployeeDTO employeeDTO){
        return new Employee(
                employeeDTO.getId(),
                employeeDTO.getName(),
                employeeDTO.getEmail()
        );
    }
}

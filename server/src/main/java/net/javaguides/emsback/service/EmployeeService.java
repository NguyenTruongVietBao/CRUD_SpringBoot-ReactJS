package net.javaguides.emsback.service;

import net.javaguides.emsback.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO createEmployee (EmployeeDTO employeeDTO);

    EmployeeDTO getEmployeeById (Integer employeeId);

    List<EmployeeDTO> getAllEmployee();

    EmployeeDTO updateEmployee (Integer employeeId, EmployeeDTO updatedEmployee);

    void deleteEmployee (Integer employeeId);
}

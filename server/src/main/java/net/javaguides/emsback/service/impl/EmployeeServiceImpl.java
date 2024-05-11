package net.javaguides.emsback.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.emsback.dto.EmployeeDTO;
import net.javaguides.emsback.entity.Employee;
import net.javaguides.emsback.exception.ResourceNotFoundException;
import net.javaguides.emsback.mapper.EmployeeMapper;
import net.javaguides.emsback.repository.EmployeeRepository;
import net.javaguides.emsback.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDTO(savedEmployee);
    }

    @Override
    public EmployeeDTO getEmployeeById(Integer employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Not exits"+employeeId));
        return EmployeeMapper.mapToEmployeeDTO(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(
                (employee) -> EmployeeMapper.mapToEmployeeDTO(employee)).collect(Collectors.toList()
        );
    }

    @Override
    public EmployeeDTO updateEmployee(Integer employeeId, EmployeeDTO updatedEmployee) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Not exits"+employeeId));
        employee.setName(updatedEmployee.getName());
        employee.setEmail(updatedEmployee.getEmail());
        Employee updatedEmployeeObj = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDTO(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Integer employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Not exits"+employeeId));
        employeeRepository.deleteById(employeeId);
    }

}

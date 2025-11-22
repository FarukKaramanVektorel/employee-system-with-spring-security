package com.security.spring_security.service;

import com.security.spring_security.data.dto.employee.EmployeeRequestDto;
import com.security.spring_security.data.dto.employee.EmployeeResponseDto;
import com.security.spring_security.data.mapper.EmployeeMapper;
import com.security.spring_security.data.model.Department;
import com.security.spring_security.data.model.Employee;
import com.security.spring_security.data.model.Role;
import com.security.spring_security.repository.DepartmentRepository;
import com.security.spring_security.repository.EmployeeRepository;
import com.security.spring_security.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final RoleRepository roleRepository;

    public EmployeeResponseDto createEmployee(EmployeeRequestDto dto) {
        Department department = departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() -> new RuntimeException(("Department not found")));
        List<Role> roles = roleRepository.findAllById(dto.getRoleIds());
        if (roles.size() != dto.getRoleIds().size()) {
            throw new RuntimeException(("Some roles not found"));
        }
        Employee employee = EmployeeMapper.dtoToEntity(dto, department, roles);
        Employee employeSaved = employeeRepository.save(employee);

        return EmployeeMapper.dtoToDto(employeSaved);
    }

    @Transactional(readOnly = true)
    public List<EmployeeResponseDto> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(EmployeeMapper::dtoToDto)
                .toList();
    }
    @Transactional(readOnly = true)
    public EmployeeResponseDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(("Employee not found")));
        return  EmployeeMapper.dtoToDto(employee);
    }

    public EmployeeResponseDto updateEmployee(EmployeeRequestDto dto, Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(("Employee not found")));

        Department department=departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() -> new RuntimeException(("Department not found")));
        List<Role> roles = roleRepository.findAllById(dto.getRoleIds());
        if (roles.size() != dto.getRoleIds().size()) {
            throw new RuntimeException(("Some roles not found"));
        }
        EmployeeMapper.dtoToEntity(dto, department, roles);
        Employee saved=employeeRepository.save(employee);
        return EmployeeMapper.dtoToDto(saved);
    }

    public void deleteEmployee(Long id) {
        if(!employeeRepository.existsById(id)) {
            throw new RuntimeException(("Employee not found"));
        }
        employeeRepository.deleteById(id);
    }
}

package com.security.spring_security.data.mapper;

import com.security.spring_security.data.dto.employee.EmployeeRequestDto;
import com.security.spring_security.data.dto.employee.EmployeeResponseDto;
import com.security.spring_security.data.dto.role.RoleResponseDto;
import com.security.spring_security.data.model.Department;
import com.security.spring_security.data.model.Employee;
import com.security.spring_security.data.model.Role;

import java.util.List;

public class EmployeeMapper {
    public static Employee dtoToEntity(EmployeeRequestDto d, Department dept, List<Role> role) {
        if (d == null) return null;
        return Employee.builder().email(d.getEmail())
                .phone(d.getPhone())
                .email(d.getEmail())
                .firstName(d.getFirstName())
                .lastName(d.getLastName())
                .salary(d.getSalary())
                .hireDate(d.getHireDate())
                .status(d.getStatus())
                .roles(role)
                .department(dept)
                .build();
    }

    public static Employee dtoToEntity(EmployeeResponseDto d, Department dept, List<Role> role) {
        if (d == null) return null;
        return Employee.builder().email(d.getEmail())
                .id(d.getId())
                .phone(d.getPhone())
                .email(d.getEmail())
                .firstName(d.getFirstName())
                .lastName(d.getLastName())
                .salary(d.getSalary())
                .hireDate(d.getHireDate())
                .status(d.getStatus())
                .roles(role)
                .department(dept)
                .build();
    }

    public static EmployeeResponseDto dtoToDto(Employee e) {
        if (e == null) return null;
        return EmployeeResponseDto.builder()
                .id(e.getId())
                .firstName(e.getFirstName())
                .lastName(e.getLastName())
                .email(e.getEmail())
                .hireDate(e.getHireDate())
                .status(e.getStatus())
                .salary(e.getSalary())
                .departmentName(e.getDepartment() != null ? e.getDepartment().getName() : null)
                .departmentId(e.getDepartment() != null ? e.getDepartment().getId() : null)
                .roles(
                        e.getRoles().stream()
                                .map(r -> RoleResponseDto.builder().id(r.getId()).name(r.getName()).build()).toList()
                )
                .build();
    }
}

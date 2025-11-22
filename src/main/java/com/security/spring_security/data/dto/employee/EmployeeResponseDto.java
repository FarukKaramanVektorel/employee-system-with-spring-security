package com.security.spring_security.data.dto.employee;

import com.security.spring_security.data.dto.role.RoleResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private LocalDate hireDate;
    private String status;
    private Double salary;
    private String departmentName;
    private Long departmentId;
    private List<RoleResponseDto> roles;
}

package com.security.spring_security.data.dto.employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeSimpleDto {
    private long id;
    private String firstName;
    private String lastName;
}

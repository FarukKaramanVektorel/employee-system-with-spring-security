package com.security.spring_security.controller;

import com.security.spring_security.data.dto.employee.EmployeeRequestDto;
import com.security.spring_security.data.dto.employee.EmployeeResponseDto;
import com.security.spring_security.data.model.Employee;
import com.security.spring_security.repository.EmployeeRepository;
import com.security.spring_security.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employes")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeResponseDto> addEmployee(@RequestBody EmployeeRequestDto dto) {
        EmployeeResponseDto resp=employeeService.createEmployee(dto);
        return new  ResponseEntity<>(resp, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponseDto>> getAllEmployees() {
        List<EmployeeResponseDto> resp=employeeService.getAllEmployees();
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> getEmployee(@PathVariable Long id) {
        EmployeeResponseDto resp=employeeService.getEmployeeById(id);
        return ResponseEntity.ok(resp);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> updateEmployee(
            @RequestBody EmployeeRequestDto dto, @PathVariable Long id) {
        EmployeeResponseDto resp=employeeService.updateEmployee(dto, id);
        return ResponseEntity.ok(resp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}

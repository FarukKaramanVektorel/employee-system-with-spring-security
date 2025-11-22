package com.security.spring_security.controller;

import com.security.spring_security.data.dto.department.DepartmentRequestDto;
import com.security.spring_security.data.dto.department.DepartmentResponseDto;
import com.security.spring_security.data.model.Department;
import com.security.spring_security.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<List<DepartmentResponseDto>> findAll(){
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @PostMapping
    public ResponseEntity<DepartmentResponseDto> create(@RequestBody DepartmentRequestDto dto){
        DepartmentResponseDto departmentResponseDto = departmentService.createDepartment(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentResponseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResponseDto> findById(@PathVariable Long id){
        return ResponseEntity.ok(departmentService.getDepartmentById(id));
    }

    @PutMapping
    public ResponseEntity<DepartmentResponseDto> update(
            @RequestBody DepartmentRequestDto dto, @PathVariable Long id){
        DepartmentResponseDto departmentResponseDto = departmentService.updateDepartment(dto, id);
        return ResponseEntity.ok(departmentResponseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DepartmentResponseDto> delete(@PathVariable Long id){
        departmentService.deleteDepartmentById(id);
        return ResponseEntity.noContent().build();
    }
}

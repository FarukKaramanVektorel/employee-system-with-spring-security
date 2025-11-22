package com.security.spring_security.service;

import com.security.spring_security.data.dto.department.DepartmentRequestDto;
import com.security.spring_security.data.dto.department.DepartmentResponseDto;
import com.security.spring_security.data.mapper.DepartmentMapper;
import com.security.spring_security.data.model.Department;
import com.security.spring_security.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentResponseDto createDepartment(DepartmentRequestDto dto) {
        Department department = Department.builder().name(dto.getName()).build();
        return DepartmentMapper.entityToRespDto(departmentRepository.save(department));
    }
    @Transactional(readOnly = true)
    public List<DepartmentResponseDto> getAllDepartments() {
        return departmentRepository.findAll()
                .stream().map(DepartmentMapper::entityToRespDto).toList();
    }

    @Transactional(readOnly = true)
    public DepartmentResponseDto getDepartmentById(Long id) {
        Department department=departmentRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Department not found!"));
        return DepartmentMapper.entityToRespDto(department);
    }

    public DepartmentResponseDto updateDepartment(DepartmentRequestDto dto, Long id) {
        Department department=departmentRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Department not found!"));
        department.setName(dto.getName());
        return DepartmentMapper.entityToRespDto(departmentRepository.save(department));
    }

    public void deleteDepartmentById(Long id) {
        if(!departmentRepository.existsById(id)){
            throw new RuntimeException("Department not found!");
        }
        departmentRepository.deleteById(id);
    }
}

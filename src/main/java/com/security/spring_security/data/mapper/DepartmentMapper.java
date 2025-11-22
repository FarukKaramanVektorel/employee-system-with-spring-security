package com.security.spring_security.data.mapper;

import com.security.spring_security.data.dto.department.DepartmentRequestDto;
import com.security.spring_security.data.dto.department.DepartmentResponseDto;
import com.security.spring_security.data.model.Department;
import com.security.spring_security.data.model.Employee;

public class DepartmentMapper {

    public static DepartmentRequestDto entityToReqDto(Department d){
        if(d==null)return null;
        DepartmentRequestDto dto=new DepartmentRequestDto();
        dto.setId(d.getId());
        dto.setName(d.getName());
        return dto;
    }
    public static Department reqToEntity(DepartmentRequestDto d){
        if(d==null)return null;
        Department entity=new Department();
        entity.setId(d.getId());
        entity.setName(d.getName());
        return entity;
    }

    public static DepartmentResponseDto entityToRespDto(Department d){
        if(d==null)return null;
        DepartmentResponseDto dto=new DepartmentResponseDto();
        dto.setId(d.getId());
        dto.setName(d.getName());
        return dto;
    }
    public static Department respToEntity(DepartmentResponseDto d){
        if(d==null)return null;
        Department entity=new Department();
        entity.setId(d.getId());
        entity.setName(d.getName());
        return entity;
    }
}

package com.security.spring_security.data.mapper;

import com.security.spring_security.data.dto.role.RoleRequestDto;
import com.security.spring_security.data.dto.role.RoleResponseDto;
import com.security.spring_security.data.model.Role;

public class RoleMapper {
    public static RoleResponseDto entityToRespDto(Role e) {
        if (e == null) return null;
        return RoleResponseDto.builder().id(e.getId()).name(e.getName()).build();
    }

    public static RoleRequestDto entityToReqDto(Role e) {
        if (e == null) return null;
        return RoleRequestDto.builder().id(e.getId()).name(e.getName()).build();
    }

    public static Role dtoToEntity(RoleResponseDto r) {
        if (r == null) return null;
        return Role.builder().id(r.getId()).name(r.getName()).build();
    }

    public static Role dtoToEntity(RoleRequestDto r) {
        if (r == null) return null;
        return Role.builder().id(r.getId()).name(r.getName()).build();
    }
}

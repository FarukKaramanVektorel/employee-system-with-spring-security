package com.security.spring_security.service;

import com.security.spring_security.data.dto.role.RoleRequestDto;
import com.security.spring_security.data.dto.role.RoleResponseDto;
import com.security.spring_security.data.mapper.RoleMapper;
import com.security.spring_security.data.model.Role;
import com.security.spring_security.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleResponseDto createRole(RoleRequestDto roleRequestDto){
        Role role = new Role();
        role.setName(roleRequestDto.getName());
        return RoleMapper.entityToRespDto(roleRepository.save(role));
    }
    @Transactional(readOnly = true)
    public List<RoleResponseDto> getAllRoles(){
        return roleRepository.findAll().stream().map(RoleMapper::entityToRespDto).toList();
    }
    @Transactional(readOnly = true)
    public RoleResponseDto getRoleById(Long id){
        Role role=roleRepository.findById(id).orElseThrow(()->new RuntimeException("Role not found"));

        return RoleMapper.entityToRespDto(role);
    }


    public RoleResponseDto updateRole(RoleRequestDto roleRequestDto,Long id){
        Role role=roleRepository.findById(id).orElseThrow(()->new RuntimeException("Role not found"));
        role.setName(roleRequestDto.getName());
        return RoleMapper.entityToRespDto(roleRepository.save(role));
    }
    public void deleteRoleById(Long id){
        if(!roleRepository.existsById(id)){
            throw new RuntimeException("Role not found!");
        }
        roleRepository.deleteById(id);
    }
}

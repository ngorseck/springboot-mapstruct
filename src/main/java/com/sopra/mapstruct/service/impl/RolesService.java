package com.sopra.mapstruct.service.impl;

import com.sopra.mapstruct.dao.IRolesDao;
import com.sopra.mapstruct.dto.RolesDto;
import com.sopra.mapstruct.mapper.RolesMapper;
import com.sopra.mapstruct.repository.RolesRepository;
import com.sopra.mapstruct.service.IRolesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RolesService implements IRolesService {

    private IRolesDao rolesDao;
    private RolesMapper rolesMapper;
    @Override
    public RolesDto save(RolesDto rolesDto) {
        return rolesMapper.rolesEntityToRolesDto(
                rolesDao.save(
                        rolesMapper.rolesDtoToRolesEntity(rolesDto)
                )
        );
    }
}

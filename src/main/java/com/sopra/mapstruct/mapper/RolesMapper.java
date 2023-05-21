package com.sopra.mapstruct.mapper;

import com.sopra.mapstruct.dto.RolesDto;
import com.sopra.mapstruct.dto.UsersDto;
import com.sopra.mapstruct.entities.RolesEntity;
import com.sopra.mapstruct.entities.UsersEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface RolesMapper {

    RolesEntity rolesDtoToRolesEntity (RolesDto rolesDto);
    List<RolesEntity> rolesDtoListToRolesEntityList (List<RolesDto> rolesDtos);
    List<RolesDto> rolesEntityListToRolesDtoList (List<RolesEntity> rolesEntities);
    RolesDto rolesEntityToRolesDto (RolesEntity rolesEntity);
}

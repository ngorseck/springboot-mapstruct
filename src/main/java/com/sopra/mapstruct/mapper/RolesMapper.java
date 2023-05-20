package com.sopra.mapstruct.mapper;

import com.sopra.mapstruct.dto.RolesDto;
import com.sopra.mapstruct.dto.UsersDto;
import com.sopra.mapstruct.entities.RolesEntity;
import com.sopra.mapstruct.entities.UsersEntity;
import org.mapstruct.Mapper;

@Mapper
public interface RolesMapper {

    RolesEntity rolesDtoToRolesEntity (RolesDto rolesDto);
    RolesDto rolesEntityToRolesDto (RolesEntity rolesEntity);
}

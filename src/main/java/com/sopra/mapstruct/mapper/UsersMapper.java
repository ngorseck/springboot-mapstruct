package com.sopra.mapstruct.mapper;

import com.sopra.mapstruct.dto.UsersDto;
import com.sopra.mapstruct.entities.UsersEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper (componentModel = "spring", uses = {RolesMapper.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UsersMapper {

    UsersEntity usersDtoToUsersEntity (UsersDto usersDto);
    UsersDto usersEntityToUsersDto (UsersEntity usersEntity);
}

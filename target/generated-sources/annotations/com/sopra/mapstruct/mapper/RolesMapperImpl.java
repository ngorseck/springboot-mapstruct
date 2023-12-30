package com.sopra.mapstruct.mapper;

import com.sopra.mapstruct.dto.RolesDto;
import com.sopra.mapstruct.entities.RolesEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-30T06:05:26+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.9 (OpenLogic)"
)
@Component
public class RolesMapperImpl implements RolesMapper {

    @Override
    public RolesEntity rolesDtoToRolesEntity(RolesDto rolesDto) {
        if ( rolesDto == null ) {
            return null;
        }

        RolesEntity rolesEntity = new RolesEntity();

        rolesEntity.setId( rolesDto.getId() );
        rolesEntity.setName( rolesDto.getName() );

        return rolesEntity;
    }

    @Override
    public List<RolesEntity> rolesDtoListToRolesEntityList(List<RolesDto> rolesDtos) {
        if ( rolesDtos == null ) {
            return null;
        }

        List<RolesEntity> list = new ArrayList<RolesEntity>( rolesDtos.size() );
        for ( RolesDto rolesDto : rolesDtos ) {
            list.add( rolesDtoToRolesEntity( rolesDto ) );
        }

        return list;
    }

    @Override
    public List<RolesDto> rolesEntityListToRolesDtoList(List<RolesEntity> rolesEntities) {
        if ( rolesEntities == null ) {
            return null;
        }

        List<RolesDto> list = new ArrayList<RolesDto>( rolesEntities.size() );
        for ( RolesEntity rolesEntity : rolesEntities ) {
            list.add( rolesEntityToRolesDto( rolesEntity ) );
        }

        return list;
    }

    @Override
    public RolesDto rolesEntityToRolesDto(RolesEntity rolesEntity) {
        if ( rolesEntity == null ) {
            return null;
        }

        RolesDto rolesDto = new RolesDto();

        rolesDto.setId( rolesEntity.getId() );
        rolesDto.setName( rolesEntity.getName() );

        return rolesDto;
    }
}

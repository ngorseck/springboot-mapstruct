package com.sopra.mapstruct.mapper;

import com.sopra.mapstruct.dto.RolesDto;
import com.sopra.mapstruct.entities.RolesEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-20T21:34:52+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
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

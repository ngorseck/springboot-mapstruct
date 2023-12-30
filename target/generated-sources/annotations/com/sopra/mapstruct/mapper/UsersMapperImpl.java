package com.sopra.mapstruct.mapper;

import com.sopra.mapstruct.dto.UsersDto;
import com.sopra.mapstruct.entities.UsersEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-30T06:05:27+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.9 (OpenLogic)"
)
@Component
public class UsersMapperImpl implements UsersMapper {

    @Override
    public UsersEntity usersDtoToUsersEntity(UsersDto usersDto) {
        if ( usersDto == null ) {
            return null;
        }

        UsersEntity usersEntity = new UsersEntity();

        usersEntity.setId( usersDto.getId() );
        usersEntity.setFullName( usersDto.getFullName() );
        usersEntity.setEmail( usersDto.getEmail() );

        return usersEntity;
    }

    @Override
    public UsersDto usersEntityToUsersDto(UsersEntity usersEntity) {
        if ( usersEntity == null ) {
            return null;
        }

        UsersDto usersDto = new UsersDto();

        usersDto.setId( usersEntity.getId() );
        usersDto.setFullName( usersEntity.getFullName() );
        usersDto.setEmail( usersEntity.getEmail() );

        return usersDto;
    }
}

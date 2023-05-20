package com.sopra.mapstruct.mapper;

import com.sopra.mapstruct.dto.ProductsDto;
import com.sopra.mapstruct.entities.ProductsEntity;
import com.sopra.mapstruct.entities.UsersEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-20T21:34:52+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class ProductsMapperImpl implements ProductsMapper {

    @Override
    public ProductsEntity productsDtoToProductsEntity(ProductsDto productsDto) {
        if ( productsDto == null ) {
            return null;
        }

        ProductsEntity productsEntity = new ProductsEntity();

        productsEntity.setUsersEntity( productsDtoToUsersEntity( productsDto ) );
        productsEntity.setRef( productsDto.getRef() );
        productsEntity.setName( productsDto.getName() );

        return productsEntity;
    }

    @Override
    public ProductsDto productsEntityToProductsDto(ProductsEntity productsEntity) {
        if ( productsEntity == null ) {
            return null;
        }

        ProductsDto productsDto = new ProductsDto();

        productsDto.setIdUser( productsEntityUsersEntityId( productsEntity ) );
        productsDto.setRef( productsEntity.getRef() );
        productsDto.setName( productsEntity.getName() );

        return productsDto;
    }

    protected UsersEntity productsDtoToUsersEntity(ProductsDto productsDto) {
        if ( productsDto == null ) {
            return null;
        }

        UsersEntity usersEntity = new UsersEntity();

        usersEntity.setId( productsDto.getIdUser() );

        return usersEntity;
    }

    private int productsEntityUsersEntityId(ProductsEntity productsEntity) {
        if ( productsEntity == null ) {
            return 0;
        }
        UsersEntity usersEntity = productsEntity.getUsersEntity();
        if ( usersEntity == null ) {
            return 0;
        }
        int id = usersEntity.getId();
        return id;
    }
}

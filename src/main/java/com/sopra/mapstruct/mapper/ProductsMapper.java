package com.sopra.mapstruct.mapper;

import com.sopra.mapstruct.dto.ProductsDto;
import com.sopra.mapstruct.entities.ProductsEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = {UsersMapper.class,},
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProductsMapper {

    /**
     * The annotation helpe to map idUser witch is in ProductsDto to usersEntity.id in ProductsEntity
     * @param productsDto
     * @return productsEntity
     */
    @Mapping(target = "usersEntity.id", source = "idUser")
    ProductsEntity productsDtoToProductsEntity (ProductsDto productsDto);

    /**
     * The annotation helpe to map usersEntity.id witch is in ProductsEntity to idUser in ProductsDto
     * @param productsEntity
     * @return productsDto
     */
    @Mapping(target = "idUser", source = "usersEntity.id")
    ProductsDto productsEntityToProductsDto (ProductsEntity productsEntity);
}

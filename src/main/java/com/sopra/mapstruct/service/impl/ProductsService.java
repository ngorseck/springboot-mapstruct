package com.sopra.mapstruct.service.impl;

import com.sopra.mapstruct.dto.ProductsDto;
import com.sopra.mapstruct.entities.ProductsEntity;
import com.sopra.mapstruct.mapper.ProductsMapper;
import com.sopra.mapstruct.repository.ProductsRepository;
import com.sopra.mapstruct.service.IProductsService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductsService implements IProductsService {

    private ProductsMapper productsMapper;
    private ProductsRepository productsRepository;

    public ProductsService(ProductsMapper productsMapper, ProductsRepository productsRepository) {
        this.productsMapper = productsMapper;
        this.productsRepository = productsRepository;
    }

    @Override
    public ProductsDto save(ProductsDto productsDto) {

        log.info("===============INFO DTO================");
        log.info(productsDto.getRef() + "  " + productsDto.getName() + " " + productsDto.getIdUser());
        log.info("===============INFO DTO TO ENTITY================");
        ProductsEntity productsEntity = productsMapper.productsDtoToProductsEntity(productsDto);
        log.info(productsEntity.getRef() + "  " + productsEntity.getName() + " " + productsEntity.getUsersEntity().getId());
        log.info("===============INFO ENTITY TO DTO================");
        productsDto = productsMapper.productsEntityToProductsDto(productsEntity);
        log.info(productsDto.getRef() + "  " + productsDto.getName() + " " + productsDto.getIdUser());

        return productsMapper.productsEntityToProductsDto(
                productsRepository.save(
                        productsMapper.productsDtoToProductsEntity(productsDto)
                )
        );
    }

    @Override
    public List<ProductsDto> getAndOrderByUserEmail() {
        return productsMapper.productsEntityListToProductsDtoList(productsRepository.search());
    }
}

package com.sopra.mapstruct.service;

import com.sopra.mapstruct.dto.ProductsDto;

import java.util.List;

public interface IProductsService {

    ProductsDto save (ProductsDto productsDto);

    List<ProductsDto> getAndOrderByUserEmail();
}

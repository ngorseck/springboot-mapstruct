package com.sopra.mapstruct.service.impl;

import com.sopra.mapstruct.dto.ProductsDto;
import com.sopra.mapstruct.dto.UsersDto;
import com.sopra.mapstruct.service.IProductsService;
import com.sopra.mapstruct.service.IUsersService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductsServiceTest {
    @Mock
    private IProductsService productsService;
    @Mock
    private IUsersService usersService;

    @Test
    void saveOK() {

        UsersDto usersDto = new UsersDto();
        usersDto.setId(1);
        usersDto.setFullName("Ngor SECK");

        when(usersService.save(any())).thenReturn(usersDto);
        Assertions.assertNotNull(usersService.save(usersDto));

        ProductsDto productsDto = new ProductsDto();
        productsDto.setRef("2324");
        productsDto.setName("milk");
        productsDto.setIdUser(1);

        when(productsService.save(any())).thenReturn(productsDto);
        Assertions.assertNotNull(productsService.save(productsDto));
    }
}
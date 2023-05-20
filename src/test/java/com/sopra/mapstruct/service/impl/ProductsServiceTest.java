package com.sopra.mapstruct.service.impl;

import com.sopra.mapstruct.dto.ProductsDto;
import com.sopra.mapstruct.dto.UsersDto;
import com.sopra.mapstruct.service.IProductsService;
import com.sopra.mapstruct.service.IUsersService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductsServiceTest {

    @Autowired
    private IProductsService productsService;
    @Autowired
    private IUsersService usersService;
    @Test
    void save() {

        UsersDto usersDto = new UsersDto();
        usersDto.setId(1);
        usersDto.setFullName("Ngor SECK");
        Assertions.assertNotNull(usersService.save(usersDto));

        ProductsDto productsDto = new ProductsDto();
        productsDto.setRef("2324");
        productsDto.setName("milk");
        productsDto.setIdUser(1);
        Assertions.assertNotNull(productsService.save(productsDto));

        /**
         * ID USER = 2 does not exist
         */
        productsDto.setIdUser(2);
        Assertions.assertThrows(Exception.class, () -> productsService.save(productsDto));
    }
}
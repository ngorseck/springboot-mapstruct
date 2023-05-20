package com.sopra.mapstruct.service.impl;

import com.sopra.mapstruct.dto.RolesDto;
import com.sopra.mapstruct.dto.UsersDto;
import com.sopra.mapstruct.service.IRolesService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class RolesServiceTest {

    @Autowired
    private IRolesService rolesService;

    @Test
    void save() {

        RolesDto rolesDto = new RolesDto();
        rolesDto.setId(1);
        rolesDto.setName("ROLE_USER");

        Assertions.assertNotNull(rolesService.save(rolesDto));
    }
}
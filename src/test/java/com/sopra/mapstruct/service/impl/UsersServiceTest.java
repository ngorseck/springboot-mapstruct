package com.sopra.mapstruct.service.impl;

import com.sopra.mapstruct.dto.RolesDto;
import com.sopra.mapstruct.dto.UsersDto;
import com.sopra.mapstruct.service.IRolesService;
import com.sopra.mapstruct.service.IUsersService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class UsersServiceTest {

    @Autowired
    private IUsersService usersService;
    @Autowired
    private IRolesService rolesService;
    @Test
    void save() {

        UsersDto usersDto = new UsersDto();
        usersDto.setId(1);
        usersDto.setFullName("Ngor SECK");

        Assertions.assertNotNull(usersService.save(usersDto));
    }

    @Test
    void find() {
        List<RolesDto> rolesDtos = new ArrayList<>();

        RolesDto rolesDto = new RolesDto();
        rolesDto.setId(1);
        rolesDto.setName("ROLE_USER");
        Assertions.assertNotNull(rolesService.save(rolesDto));
        rolesDtos.add(rolesDto);

        rolesDto = new RolesDto();
        rolesDto.setId(2);
        rolesDto.setName("ROLE_ADMIN");
        Assertions.assertNotNull(rolesService.save(rolesDto));
        rolesDtos.add(rolesDto);

        rolesDto = new RolesDto();
        rolesDto.setId(3);
        rolesDto.setName("ROLE_TECH");
        Assertions.assertNotNull(rolesService.save(rolesDto));
        rolesDtos.add(rolesDto);

        UsersDto usersDto = new UsersDto();
        usersDto.setId(1);
        usersDto.setFullName("Ngor SECK");
        usersDto.setRolesDtos(rolesDtos);
        UsersDto usersDto1 = usersService.save(usersDto);
        Assertions.assertNotNull(usersDto1);

        log.info("====================INFO USER==============");
        log.info(usersDto1.getFullName() + usersDto1.getRolesDtos());
    }
}
package com.sopra.mapstruct.service.impl;

import com.sopra.mapstruct.dto.RolesDto;
import com.sopra.mapstruct.dto.UsersDto;
import com.sopra.mapstruct.service.IRolesService;
import com.sopra.mapstruct.service.IUsersService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@Slf4j
class UsersServiceTest {

    @Mock
    private IUsersService usersService;
    @Mock
    private IRolesService rolesService;
    @Test
    void saveUserWithoutRoles() {

        UsersDto usersDto = new UsersDto();
        usersDto.setId(1);
        usersDto.setFullName("Ngor SECK");

        when(usersService.save(any())).thenReturn(usersDto);
        Assertions.assertNotNull(usersService.save(usersDto));
    }

    @Test
    void saveUserWithRoles() {
        List<RolesDto> rolesDtos = new ArrayList<>();

        RolesDto rolesDto = new RolesDto();
        rolesDto.setId(1);
        rolesDto.setName("ROLE_USER");
        when(rolesService.save(any())).thenReturn(rolesDto);
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
        when(usersService.save(any())).thenReturn(usersDto);
        UsersDto usersDto1 = usersService.save(usersDto);
        Assertions.assertNotNull(usersDto1);

        log.info("====================INFO USER==============");
        log.info(usersDto1.getFullName() + usersDto1.getRolesDtos());
    }
}
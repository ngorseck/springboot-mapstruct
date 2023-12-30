package com.sopra.mapstruct.service.impl;

import com.sopra.mapstruct.dto.RolesDto;
import com.sopra.mapstruct.service.IRolesService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RolesServiceTest {

    @Mock
    private IRolesService rolesService;

    @Test
    void save() {

        RolesDto rolesDto = new RolesDto();
        rolesDto.setId(1);
        rolesDto.setName("ROLE_USER");

        when(rolesService.save(any())).thenReturn(rolesDto);
        Assertions.assertNotNull(rolesService.save(rolesDto));
    }
}
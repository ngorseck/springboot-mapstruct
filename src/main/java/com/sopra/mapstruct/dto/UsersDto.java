package com.sopra.mapstruct.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsersDto {
    @NotNull(message = "id can not be null")
    private int id;
    @NotNull (message = "fullName can not be null")
    private String fullName;
    private List<RolesDto> rolesDtos = new ArrayList<>();
}

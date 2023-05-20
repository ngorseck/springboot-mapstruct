package com.sopra.mapstruct.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RolesDto {
    @NotNull(message = "id can not be null")
    private int id;
    @NotNull (message = "name can not be null")
    private String name;
}

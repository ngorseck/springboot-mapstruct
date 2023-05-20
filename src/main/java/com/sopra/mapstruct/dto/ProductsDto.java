package com.sopra.mapstruct.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductsDto {

    @NotNull (message = "ref can not be null")
    private String ref;
    @NotNull (message = "name can not be null")
    private String name;
    @NotNull (message = "id of user can not be null")
    private int idUser;
}

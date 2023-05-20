package com.sopra.mapstruct.entities;

import com.sopra.mapstruct.dto.RolesDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class UsersEntity {
    @Id
    private int id;
    private String fullName;
    @OneToMany (mappedBy = "usersEntity")
    private List<ProductsEntity> productsEntities;
    @ManyToMany
    private List<RolesEntity> rolesEntities;
}

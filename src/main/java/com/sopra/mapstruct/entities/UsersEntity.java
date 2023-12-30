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
    private String email;
    @OneToMany (mappedBy = "usersEntity", fetch = FetchType.LAZY)
    private List<ProductsEntity> productsEntities;
    @ManyToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable (name="users_roles",
            joinColumns = @JoinColumn(name="users_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="roles_id", referencedColumnName="id"))
    private List<RolesEntity> rolesEntities;
}

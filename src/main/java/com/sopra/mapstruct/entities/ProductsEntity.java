package com.sopra.mapstruct.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "products")
public class ProductsEntity {
    @Id
    private String ref;
    private String name;
    @ManyToOne
    @JoinColumn (name = "user_id", nullable = false)
    private UsersEntity usersEntity;
}

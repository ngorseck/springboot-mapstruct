package com.sopra.mapstruct.repository;

import com.sopra.mapstruct.entities.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<ProductsEntity, String> {
}

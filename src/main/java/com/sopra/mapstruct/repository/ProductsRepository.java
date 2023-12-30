package com.sopra.mapstruct.repository;

import com.sopra.mapstruct.entities.ProductsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.util.StringUtils;

import java.util.List;

public interface ProductsRepository extends JpaRepository<ProductsEntity, String> , JpaSpecificationExecutor<ProductsEntity> {


  default List<ProductsEntity> search() {

    // Specifications pour le select :
    var specifications = Specification.where(SearchProductsSpecification.select());

    return findAll(specifications);
  }

  default Page<ProductsEntity> search(ProductsCriteria productsCriteria, Pageable pageable) {

    // Specifications pour le select :
    var specifications = Specification.where(SearchProductsSpecification.select());

    // Specifications pour l'email
    if (StringUtils.hasText(productsCriteria.getNameProduct())) {
      specifications = specifications.and( //
              SearchProductsSpecification.containsLabel(productsCriteria.getNameProduct())  //
      );
    }

    return findAll(specifications, pageable);
  }
}

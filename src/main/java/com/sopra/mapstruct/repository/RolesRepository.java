package com.sopra.mapstruct.repository;

import com.sopra.mapstruct.entities.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<RolesEntity, Integer> {
}

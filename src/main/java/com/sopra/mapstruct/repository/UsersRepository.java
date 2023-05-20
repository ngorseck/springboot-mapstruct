package com.sopra.mapstruct.repository;

import com.sopra.mapstruct.entities.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UsersEntity, Integer> {
}

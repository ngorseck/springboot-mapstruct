package com.sopra.mapstruct.dao.impl;

import com.sopra.mapstruct.dao.IRolesDao;
import com.sopra.mapstruct.entities.RolesEntity;
import com.sopra.mapstruct.repository.RolesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class RolesDao implements IRolesDao {
  private RolesRepository rolesRepository;
  @Override
  public RolesEntity save(RolesEntity rolesEntity) {
    return rolesRepository.save(rolesEntity);
  }
}

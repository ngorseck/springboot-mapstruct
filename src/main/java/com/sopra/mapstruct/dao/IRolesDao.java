package com.sopra.mapstruct.dao;

import com.sopra.mapstruct.dto.RolesDto;
import com.sopra.mapstruct.entities.RolesEntity;

public interface IRolesDao {
  RolesEntity save (RolesEntity rolesEntity);
}

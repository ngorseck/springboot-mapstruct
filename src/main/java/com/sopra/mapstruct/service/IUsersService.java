package com.sopra.mapstruct.service;

import com.sopra.mapstruct.dto.UsersDto;

import java.util.List;
import java.util.Optional;

public interface IUsersService {

    UsersDto save (UsersDto usersDto);
    UsersDto update (UsersDto usersDto);
    UsersDto find (int idUser);
    List<UsersDto> findAll ();
}

package com.sopra.mapstruct.service;

import com.sopra.mapstruct.dto.UsersDto;

import java.util.Optional;

public interface IUsersService {

    UsersDto save (UsersDto usersDto);
    UsersDto find (int idUser);
}

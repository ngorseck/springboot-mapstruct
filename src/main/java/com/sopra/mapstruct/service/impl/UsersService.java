package com.sopra.mapstruct.service.impl;

import com.sopra.mapstruct.dto.UsersDto;
import com.sopra.mapstruct.entities.UsersEntity;
import com.sopra.mapstruct.mapper.UsersMapper;
import com.sopra.mapstruct.repository.UsersRepository;
import com.sopra.mapstruct.service.IUsersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UsersService implements IUsersService {

    private UsersRepository usersRepository;
    private UsersMapper usersMapper;

    @Override
    public UsersDto save(UsersDto usersDto) {
        return usersMapper.usersEntityToUsersDto(
                usersRepository.save(
                        usersMapper.usersDtoToUsersEntity(usersDto)
                )
        );
    }

    @Override
    public UsersDto find(int idUser) {
        Optional<UsersEntity> usersEntity = usersRepository.findById(idUser);
        if(usersEntity.isPresent()) {
            return usersMapper.usersEntityToUsersDto(usersEntity.get());
        }
        return null;
    }
}

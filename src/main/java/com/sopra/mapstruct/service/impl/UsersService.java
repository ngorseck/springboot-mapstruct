package com.sopra.mapstruct.service.impl;

import com.sopra.mapstruct.dto.RolesDto;
import com.sopra.mapstruct.dto.UsersDto;
import com.sopra.mapstruct.entities.UsersEntity;
import com.sopra.mapstruct.mapper.RolesMapper;
import com.sopra.mapstruct.mapper.UsersMapper;
import com.sopra.mapstruct.repository.UsersRepository;
import com.sopra.mapstruct.service.IUsersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UsersService implements IUsersService {

    private UsersRepository usersRepository;
    private UsersMapper usersMapper;
    private RolesMapper rolesMapper;

    @Override
    public UsersDto save(UsersDto usersDto) {
        if (find(usersDto.getId()) == null) {
            UsersEntity usersEntity = usersMapper.usersDtoToUsersEntity(usersDto);
            if (!usersDto.getRolesDtos().isEmpty()) {
                usersEntity.setRolesEntities(
                        rolesMapper.rolesDtoListToRolesEntityList(usersDto.getRolesDtos())
                );
            }
            return usersMapper.usersEntityToUsersDto(
                    usersRepository.save(
                            usersEntity
                    )
            );
        }

        return  usersMapper.usersEntityToUsersDto(
                usersRepository.save(
                        usersMapper.usersDtoToUsersEntity(usersDto)
                )
        );
    }

    @Override
    public UsersDto update(UsersDto usersDto) {
        UsersEntity usersEntityUpdate = usersMapper.usersDtoToUsersEntity(find(usersDto.getId()));
        if (find(usersDto.getId()) != null) {
            UsersEntity usersEntity = usersMapper.usersDtoToUsersEntity(usersDto);
            if (!usersDto.getRolesDtos().isEmpty()) {
                usersEntity.setRolesEntities(
                        rolesMapper.rolesDtoListToRolesEntityList(usersDto.getRolesDtos())
                );
            }
            /**
             * setting datas of updating user
             */
            usersEntityUpdate.setFullName(usersEntity.getFullName());
            usersEntityUpdate.setRolesEntities((usersEntity.getRolesEntities()));
            return usersMapper.usersEntityToUsersDto(
                    usersRepository.save(
                            usersEntityUpdate
                    )
            );
        }
        return null;
    }

    @Override
    public UsersDto find(int idUser) {
        Optional<UsersEntity> usersEntity = usersRepository.findById(idUser);
        if(usersEntity.isPresent()) {
            return usersMapper.usersEntityToUsersDto(usersEntity.get());
        }
        return null;
    }

    @Override
    public List<UsersDto> findAll() {
        List<UsersDto> usersDtos = new ArrayList<>();
        usersRepository.findAll().stream()
                .forEach(usersEntity -> {
                    List<RolesDto> rolesDtos = rolesMapper.rolesEntityListToRolesDtoList(
                            usersEntity.getRolesEntities()
                    );
                    UsersDto usersDto = usersMapper.usersEntityToUsersDto(usersEntity);
                    usersDto.setRolesDtos(rolesDtos);
                    usersDtos.add(usersDto);
                });

        return usersDtos;
    }
}

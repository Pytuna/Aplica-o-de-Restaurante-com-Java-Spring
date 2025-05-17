package com.example.demo.service.impl;

import java.util.Objects;
import com.example.demo.exception.BadRequestException;
import org.springframework.stereotype.Service;
import com.example.demo.dto.UserDto;
import com.example.demo.exception.NotFoundException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.UserType;
import com.example.demo.model.Users;
import com.example.demo.repository.UserTypeRepository;
import com.example.demo.repository.UsersRepository;
import com.example.demo.service.UserService;
import lombok.var;

@Service
public class UserServiceImpl implements UserService {

    private final UsersRepository usersRepository;
    private final UserTypeRepository userTypeRepository;

    public UserServiceImpl(UsersRepository usersRepository, UserTypeRepository userTypeRepository) {
        this.userTypeRepository = userTypeRepository;
        this.usersRepository = usersRepository;
    }

    @Override
    public Users create(UserDto dto) {
        if (Objects.nonNull(dto.getId())) {
            throw new BadRequestException("id deve ser nulo");
        }
        var userTypeOpt = userTypeRepository.findById(dto.getUserTypeId());
        if (userTypeOpt.isEmpty()) {
            throw new NotFoundException("usertypeId não encontrado");
        }
        UserType userType = userTypeOpt.get();
        Users user = UserMapper.fromDtoToEntity(dto, userType, null);
        return usersRepository.save(user);
    }
}

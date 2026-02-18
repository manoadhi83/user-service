package com.manoa.user_service.service.impl;

import com.manoa.user_service.dao.UserRepository;
import com.manoa.user_service.dto.UserDto;
import com.manoa.user_service.entity.User;
import com.manoa.user_service.mapper.UserMapper;
import com.manoa.user_service.service.UserService;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDto addUser(UserDto dto) {
        if(dto != null) {
            User user = userRepository.save(UserMapper.INSTANCE.toUser(dto));
            return  UserMapper.INSTANCE.toUserDto(user);
        }
        return null;
    }

    @Override
    public List<UserDto> getUsers() {
        return userRepository.findAll().stream().map(UserMapper.INSTANCE::toUserDto).toList();
    }

    @Override
    public UserDto getUserByUserName(String name) {
        Optional<User> user = userRepository.findUserByUserName(name);
        return user.map(UserMapper.INSTANCE::toUserDto).orElse(null);
    }

    @Override
    public UserDto getUserById(Long id) {
        return userRepository.findById(id).map(UserMapper.INSTANCE::toUserDto).orElse(null);
    }

    @Override
    public void deleteUserByUserName(String name) {
        Optional<User> user = userRepository.findUserByUserName(name);
        user.ifPresent(value -> userRepository.delete(value));
    }
}

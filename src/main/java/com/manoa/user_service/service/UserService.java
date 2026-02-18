package com.manoa.user_service.service;

import com.manoa.user_service.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto addUser(UserDto dto);

    List<UserDto> getUsers();

    UserDto getUserByUserName(String name);

    UserDto getUserById(Long id);

    void deleteUserByUserName(String name);
}

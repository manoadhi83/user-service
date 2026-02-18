package com.manoa.user_service.controller;

import com.manoa.user_service.dto.UserDto;
import com.manoa.user_service.service.UserService;
import org.apache.http.protocol.HTTP;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto dto) {
        return new ResponseEntity<>(userService.addUser(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{userName}")
    public ResponseEntity<Void> deleteByUserName(@PathVariable String userName) {
        userService.deleteUserByUserName(userName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}


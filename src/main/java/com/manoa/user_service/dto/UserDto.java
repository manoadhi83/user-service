package com.manoa.user_service.dto;

public record UserDto(Long id, String userName, String password, String address, String city) {
}

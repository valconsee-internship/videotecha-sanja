package com.project.videotecha.mapper;

import com.project.videotecha.dto.RegistrationDataDto;
import com.project.videotecha.dto.UserDto;
import com.project.videotecha.model.Role;
import com.project.videotecha.model.User;

import java.util.Collection;
import java.util.List;

public final class UserMapper {
    private UserMapper() { }

    public static User mapRegistrationDataDtoToUser(RegistrationDataDto registrationData, Role role) {
        User newUser = new User();
        newUser.setFirstName(registrationData.getFirstName());
        newUser.setLastName(registrationData.getLastName());
        newUser.setEmail(registrationData.getEmail());
        newUser.setPassword(registrationData.getPassword());
        newUser.setRole(role);
        return newUser;
    }

    public static UserDto mapUserToUserDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        return dto;
    }

    public static List<UserDto> mapToDtos(Collection<User> users) {
        return users
                .stream()
                .map(UserMapper::mapUserToUserDto)
                .toList();
    }
}

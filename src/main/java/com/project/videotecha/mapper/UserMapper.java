package com.project.videotecha.mapper;

import com.project.videotecha.dto.RegistrationDataDto;
import com.project.videotecha.dto.UserDto;
import com.project.videotecha.model.User;
import com.project.videotecha.model.enums.UserType;

public final class UserMapper {
    private UserMapper() { }

    public static User mapRegistrationDataDtoToUser(RegistrationDataDto registrationData) {
        User newUser = new User();
        newUser.setFirstName(registrationData.getFirstName());
        newUser.setLastName(registrationData.getLastName());
        newUser.setEmail(registrationData.getEmail());
        newUser.setPassword(registrationData.getPassword());
        newUser.setUserType(UserType.valueOf(registrationData.getUserTypeName()));
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
}

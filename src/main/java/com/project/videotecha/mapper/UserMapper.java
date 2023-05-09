package com.project.videotecha.mapper;

import com.project.videotecha.dto.RegistrationDataDto;
import com.project.videotecha.model.User;
import com.project.videotecha.model.enums.UserType;

public class UserMapper {
    public static User mapRegistrationDataDtoToUser(RegistrationDataDto registrationData) {
        User newUser = new User();
        newUser.setFirstName(registrationData.getFirstName());
        newUser.setLastName(registrationData.getLastName());
        newUser.setEmail(registrationData.getEmail());
        newUser.setPassword(registrationData.getPassword());
        if (registrationData.getUserTypeName().equals("ADMIN")) {
            newUser.setUserType(UserType.ADMIN);
        } else {
            newUser.setUserType(UserType.REGISTERED);
        }
        return newUser;
    }
}

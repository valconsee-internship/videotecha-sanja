package com.project.videotecha.controller.api;

import com.project.videotecha.dto.ExceptionDto;
import com.project.videotecha.dto.RegistrationDataDto;
import com.project.videotecha.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthenticationControllerApi {

    @Operation(summary = "Register user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))}),
            @ApiResponse(responseCode = "400", description = "User registration failure.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))})
    })
    UserDto registerUser(RegistrationDataDto registrationData);

}

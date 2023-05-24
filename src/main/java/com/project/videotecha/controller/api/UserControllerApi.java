package com.project.videotecha.controller.api;

import com.project.videotecha.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.Collection;

public interface UserControllerApi {

    @Operation(summary = "Find all users.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Users found.",
                    content = { @Content(mediaType = "application/json")})
    })
     Collection<UserDto> getAll();

}

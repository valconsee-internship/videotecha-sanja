package com.project.videotecha.controller.api;

import com.project.videotecha.dto.ExceptionDto;
import com.project.videotecha.dto.TheaterDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

public interface TheaterControllerApi {

    @Operation(summary = "Find all theaters.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Theaters found.",
                    content = { @Content(mediaType = "application/json")})
    })
    List<TheaterDto> getAll();

    @Operation(summary = "Find theater by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Theater with requested id found.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = TheaterDto.class))}),
            @ApiResponse(responseCode = "404", description = "Theater with this id not found.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))})
    })
    TheaterDto getById(@Parameter(description = "Id of theater to be found") Long id);

}

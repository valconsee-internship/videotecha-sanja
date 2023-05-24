package com.project.videotecha.controller.api;

import com.project.videotecha.dto.ExceptionDto;
import com.project.videotecha.dto.ReservationCreationDto;
import com.project.videotecha.dto.ReservationDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;

public interface ReservationControllerApi {

    @Operation(summary = "Create reservation.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Reservation created.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ReservationDto.class))})
    })
    ReservationDto create(@Valid @RequestBody ReservationCreationDto dto);

    @Operation(summary = "Update reservation.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reservation updated."),
            @ApiResponse(responseCode = "400", description = "Update reservation failure.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))}),
            @ApiResponse(responseCode = "404", description = "Reservation with this id not found.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))})
    })
    void cancel(@Parameter(description = "Id of reservation for updating") Long id);

}

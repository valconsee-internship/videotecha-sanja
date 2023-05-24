package com.project.videotecha.controller.api;

import com.project.videotecha.dto.ExceptionDto;
import com.project.videotecha.dto.MovieDto;
import com.project.videotecha.dto.ProjectionCreationDto;
import com.project.videotecha.dto.ProjectionDto;
import com.project.videotecha.dto.ReservationDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

public interface ProjectionControllerApi {

    @Operation(summary = "Create projection.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Projection created.",
                content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ProjectionDto.class))})
    })
    ProjectionDto create(ProjectionCreationDto dto);

    @Operation(summary = "Delete projection.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Projection deleted."),
            @ApiResponse(responseCode = "400", description = "Business rule exception.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))}),
            @ApiResponse(responseCode = "404", description = "Projection with this id not found.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))})
    })
    void delete(@Parameter(description = "Id of projection for deleting") Long id);

    @Operation(summary = "Find projection by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Projection with requested id found.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ProjectionDto.class))}),
            @ApiResponse(responseCode = "404", description = "Projection with this id not found.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))})
    })
    ProjectionDto getById(@Parameter(description = "Id of projection to be found") Long id);

    @Operation(summary = "Find projections with available seats.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Requested projections found.",
                    content = { @Content(mediaType = "application/json") })
    })
    public List<ProjectionDto> getProjectionsWithAvailableSeats();

}

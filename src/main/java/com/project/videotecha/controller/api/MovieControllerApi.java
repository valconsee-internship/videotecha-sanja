package com.project.videotecha.controller.api;

import com.project.videotecha.dto.ExceptionDto;
import com.project.videotecha.dto.MovieCreationDto;
import com.project.videotecha.dto.MovieDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

public interface MovieControllerApi {

    @Operation(summary = "Create movie.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Movie created.",
                content = { @Content(mediaType = "application/json", schema = @Schema(implementation = MovieDto.class))})
    })
    MovieDto create(MovieCreationDto movieCreationDto);

    @Operation(summary = "Update movie.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Movie updated.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = MovieDto.class))}),
            @ApiResponse(responseCode = "400", description = "Business rule exception.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))}),
            @ApiResponse(responseCode = "404", description = "Movie with this id not found.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))})
    })
    MovieDto update(MovieDto movieDto);

    @Operation(summary = "Delete movie.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Movie deleted."),
            @ApiResponse(responseCode = "400", description = "Business rule exception.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))}),
            @ApiResponse(responseCode = "404", description = "Movie with this id not found.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))})
    })
    void delete(@Parameter(description = "Id of movie for deleting") Long id);

    @Operation(summary = "Find movie by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Movie with requested id found.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = MovieDto.class))}),
            @ApiResponse(responseCode = "404", description = "Movie with this id not found.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))})
    })
    MovieDto getById(@Parameter(description = "Id of movie to be found") Long id);


    @Operation(summary = "Find all movies.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Movies found.",
                    content = { @Content(mediaType = "application/json")})
    })
    List<MovieDto> getAll();

}

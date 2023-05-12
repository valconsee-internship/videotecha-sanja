package com.project.videotecha.mapper;

import com.project.videotecha.dto.ProjectionDto;
import com.project.videotecha.model.Projection;

public class ProjectionMapper {

    private ProjectionMapper() {
    }

    public static ProjectionDto mapToDto(Projection projection) {
        ProjectionDto dto = new ProjectionDto(projection);
        dto.setMovie(MovieMapper.mapToDto(projection.getMovie()));
        dto.setTheater(TheaterMapper.mapToTheaterDto(projection.getTheater()));
        return dto;
    }
}

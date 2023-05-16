package com.project.videotecha.mapper;

import com.project.videotecha.dto.ProjectionDto;
import com.project.videotecha.model.Projection;

import java.util.List;

public class ProjectionMapper {

    private ProjectionMapper() {
    }

    public static ProjectionDto mapProjectionToProjectionDto(Projection projection) {
        ProjectionDto dto = new ProjectionDto(projection);
        dto.setMovie(MovieMapper.mapToDto(projection.getMovie()));
        dto.setTheater(TheaterMapper.mapToTheaterDto(projection.getTheater()));
        return dto;
    }

    public static List<ProjectionDto> mapProjectionToProjectionDtos(List<Projection> availableProjections) {
        return availableProjections.stream().map(ProjectionMapper::mapProjectionToProjectionDto).toList();
    }
}

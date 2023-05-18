package com.project.videotecha.mapper;

import com.project.videotecha.dto.ProjectionDto;
import com.project.videotecha.model.Projection;

import java.util.List;

public final class ProjectionMapper {

    private ProjectionMapper() {
    }

    public static ProjectionDto mapProjectionToProjectionDto(Projection projection) {
        ProjectionDto dto = new ProjectionDto();
        dto.setId(projection.getId());
        dto.setStart(projection.getStart());
        dto.setTicketPrice(projection.getTicketPrice());
        dto.setAvailableSeats(projection.getAvailableSeats());
        dto.setMovie(MovieMapper.mapToDto(projection.getMovie()));
        dto.setTheater(TheaterMapper.mapToTheaterDto(projection.getTheater()));
        return dto;
    }

    public static List<ProjectionDto> mapProjectionToProjectionDtos(List<Projection> availableProjections) {
        return availableProjections.stream().map(ProjectionMapper::mapProjectionToProjectionDto).toList();
    }
}

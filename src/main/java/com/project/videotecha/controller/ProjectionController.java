package com.project.videotecha.controller;

import com.project.videotecha.dto.ProjectionCreationDto;
import com.project.videotecha.dto.ProjectionDto;
import com.project.videotecha.mapper.ProjectionMapper;
import com.project.videotecha.service.ProjectionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("projections")
public class ProjectionController {
    private final ProjectionService projectionService;

    public ProjectionController(ProjectionService projectionService) {
        this.projectionService = projectionService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectionDto create(@RequestBody ProjectionCreationDto dto) {
        return ProjectionMapper.mapProjectionToProjectionDto(projectionService.create(dto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        projectionService.delete(id);
    }

    @GetMapping("/{id}")
    public ProjectionDto getById(@PathVariable Long id) {
        return ProjectionMapper.mapProjectionToProjectionDto(projectionService.getById(id));
    }

    @GetMapping("/available")
    public List<ProjectionDto> getProjectionsWithAvailableSeats() {
        return ProjectionMapper.mapProjectionToProjectionDtos(projectionService.getAvailableProjections());
    }
}

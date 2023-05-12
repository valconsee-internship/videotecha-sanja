package com.project.videotecha.controller;

import com.project.videotecha.dto.ProjectionCreationDto;
import com.project.videotecha.dto.ProjectionDto;
import com.project.videotecha.mapper.ProjectionMapper;
import com.project.videotecha.service.ProjectionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/projections")
public class ProjectionController {

    private final ProjectionService projectionService;

    public ProjectionController(ProjectionService projectionService) {
        this.projectionService = projectionService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectionDto create(@RequestBody ProjectionCreationDto dto) {
        return ProjectionMapper.mapToDto(projectionService.create(dto));
    }
}

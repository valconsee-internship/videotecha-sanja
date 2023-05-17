package com.project.videotecha.service;

import com.project.videotecha.dto.ProjectionCreationDto;
import com.project.videotecha.model.Projection;

import java.util.List;

public interface ProjectionService {
    Projection create(ProjectionCreationDto dto);

    void delete(Long id);

    Projection getById(Long id);

    List<Projection> getAvailableProjections();
}

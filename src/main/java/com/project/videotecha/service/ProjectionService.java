package com.project.videotecha.service;

import com.project.videotecha.dto.ProjectionCreationDto;
import com.project.videotecha.model.Projection;

public interface ProjectionService {
    Projection create(ProjectionCreationDto dto);
}

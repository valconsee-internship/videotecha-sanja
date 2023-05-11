package com.project.videotecha.service;

import com.project.videotecha.model.Theater;

import java.util.List;

public interface TheaterService {
    List<Theater> getAll();

    Theater getById(Long id);
}

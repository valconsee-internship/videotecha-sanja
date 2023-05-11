package com.project.videotecha.service.impl;

import com.project.videotecha.model.Theater;
import com.project.videotecha.repository.TheaterRepository;
import com.project.videotecha.service.TheaterService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterServiceImpl implements TheaterService {
    private final TheaterRepository theaterRepository;

    public TheaterServiceImpl(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }

    @Override
    public List<Theater> getAll() {
        return theaterRepository.findAll();
    }

    @Override
    public Theater getById(Long id) {
        return theaterRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Theater with ID " + id + " not found"));
    }
}
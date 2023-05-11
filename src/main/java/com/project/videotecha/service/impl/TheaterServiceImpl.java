package com.project.videotecha.service.impl;

import com.project.videotecha.model.Theater;
import com.project.videotecha.repository.TheaterRepository;
import com.project.videotecha.service.TheaterService;
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
}

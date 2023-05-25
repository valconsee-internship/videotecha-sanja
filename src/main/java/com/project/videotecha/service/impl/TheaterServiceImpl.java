package com.project.videotecha.service.impl;

import com.project.videotecha.exception.EntityNotFoundException;
import com.project.videotecha.model.Theater;
import com.project.videotecha.repository.TheaterRepository;
import com.project.videotecha.service.TheaterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import static java.lang.String.format;

@Service
public class TheaterServiceImpl implements TheaterService {
    private static final Logger logger = LoggerFactory.getLogger(TheaterServiceImpl.class);
    private final TheaterRepository theaterRepository;

    public TheaterServiceImpl(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }

    @Override
    public List<Theater> getAll() {
        logger.info("Fetching list of all theaters!");
        return theaterRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Theater getById(Long id) {
        return theaterRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(format("Theater with ID %s not found", id)));
    }
}

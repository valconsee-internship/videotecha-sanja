package com.project.videotecha.service.impl;

import com.project.videotecha.dto.ProjectionCreationDto;
import com.project.videotecha.model.Projection;
import com.project.videotecha.repository.ProjectionRepository;
import com.project.videotecha.service.MovieService;
import com.project.videotecha.service.ProjectionService;
import com.project.videotecha.service.TheaterService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProjectionServiceImpl implements ProjectionService {
    private final ProjectionRepository projectionRepository;
    private final MovieService movieService;
    private final TheaterService theaterService;

    public ProjectionServiceImpl(ProjectionRepository projectionRepository, MovieService movieService,
                                 TheaterService theaterService) {
        this.projectionRepository = projectionRepository;
        this.movieService = movieService;
        this.theaterService = theaterService;
    }

    @Override
    @Transactional
    public Projection create(ProjectionCreationDto dto) {
        Projection projection = new Projection(dto.getStart(), dto.getTicketPrice(),
                movieService.getById(dto.getMovieId()), theaterService.getById(dto.getTheaterId()));
        if (iOverlappingWithExistingProjections(projection)) {
            throw new RuntimeException("Projection is overlapping with existing projections");
        }
        return projectionRepository.save(projection);
    }

    private boolean iOverlappingWithExistingProjections(Projection projection) {
        List<Projection> theaterProjections = projectionRepository.findByTheaterIdAndDeletedFalse(projection.getTheater().getId());
        for (Projection p : theaterProjections) {
            LocalDateTime end = p.getStart().plusMinutes(p.getMovie().getLength());
            if (projection.getStart().isBefore(end) && projection.getEnd().isAfter(p.getStart())) {
                return true;
            }
        }
        return false;
    }
}

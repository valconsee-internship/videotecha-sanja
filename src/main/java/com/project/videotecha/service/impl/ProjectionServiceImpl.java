package com.project.videotecha.service.impl;

import com.project.videotecha.dto.ProjectionCreationDto;
import com.project.videotecha.model.Movie;
import com.project.videotecha.model.Projection;
import com.project.videotecha.model.Theater;
import com.project.videotecha.repository.ProjectionRepository;
import com.project.videotecha.service.MovieService;
import com.project.videotecha.service.ProjectionService;
import com.project.videotecha.service.TheaterService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        Movie movie = movieService.getById(dto.getMovieId());
        Theater theater = theaterService.getById(dto.getTheaterId());
        Projection projection = new Projection(dto.getStart(), dto.getTicketPrice(), movie, theater);
        if (isOverlappingWithExistingProjections(projection)) {
            throw new RuntimeException("Projection is overlapping with existing projections");
        }
        return projectionRepository.save(projection);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Projection projection = projectionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found projection with ID " + id));
        projection.setDeleted(true);
        projectionRepository.save(projection);
    }

    @Override
    public Projection getById(Long id) {
        return projectionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found projection with ID " + id));
    }

    @Override
    public List<Projection> getAvailableProjections() {
        return projectionRepository.findAvailableProjections()
                .stream()
                .filter(p -> !p.getDeleted() && !movieService.hasPassed(p))
                .toList();
    }

    private boolean isOverlappingWithExistingProjections(Projection projection) {
        List<Projection> theaterProjections = projectionRepository.findByTheaterIdAndDeletedFalse(projection.getTheater().getId());
        return theaterProjections
                .stream()
                .anyMatch(p -> projection.getStart().isBefore(p.getEnd()) && projection.getEnd().isAfter(p.getStart()));
    }
}

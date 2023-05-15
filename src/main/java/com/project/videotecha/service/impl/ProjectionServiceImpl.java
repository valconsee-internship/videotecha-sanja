package com.project.videotecha.service.impl;

import com.project.videotecha.dto.ProjectionCreationDto;
import com.project.videotecha.model.Projection;
import com.project.videotecha.repository.ProjectionRepository;
import com.project.videotecha.service.MovieService;
import com.project.videotecha.service.ProjectionService;
import com.project.videotecha.service.TheaterService;
import jakarta.persistence.EntityNotFoundException;
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
        return projectionRepository.findAvailableProjections();
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

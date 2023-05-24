package com.project.videotecha.service.impl;

import com.project.videotecha.dto.EmailDetailDto;
import com.project.videotecha.dto.ProjectionCreationDto;
import com.project.videotecha.exception.EmailNotSentException;
import com.project.videotecha.exception.EntityNotFoundException;
import com.project.videotecha.exception.OverlappingWithExistingProjectionsException;
import com.project.videotecha.model.Movie;
import com.project.videotecha.model.Projection;
import com.project.videotecha.model.Reservation;
import com.project.videotecha.model.Theater;
import com.project.videotecha.model.User;
import com.project.videotecha.repository.ProjectionRepository;
import com.project.videotecha.service.EmailService;
import com.project.videotecha.service.MovieService;
import com.project.videotecha.service.ProjectionService;
import com.project.videotecha.service.TheaterService;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

@Service
public class ProjectionServiceImpl implements ProjectionService {
    private final ProjectionRepository projectionRepository;
    private final MovieService movieService;
    private final TheaterService theaterService;
    private final EmailService emailService;

    public static final String DATE_FORMAT = "HH:mm:ss yyyy-MM-dd";

    public ProjectionServiceImpl(ProjectionRepository projectionRepository, MovieService movieService,
                                 TheaterService theaterService, EmailService emailService) {
        this.projectionRepository = projectionRepository;
        this.movieService = movieService;
        this.theaterService = theaterService;
        this.emailService = emailService;
    }

    @Override
    @Transactional
    public Projection create(ProjectionCreationDto dto) {
        Movie movie = movieService.getById(dto.getMovieId());
        Theater theater = theaterService.getById(dto.getTheaterId());
        Projection projection = new Projection(dto.getStart(), dto.getTicketPrice(), movie, theater);
        if (isOverlappingWithExistingProjections(projection)) {
            throw new OverlappingWithExistingProjectionsException("Projection is overlapping with existing projections");
        }
        return projectionRepository.save(projection);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Projection projection = getById(id);
        projection.setDeleted(true);

        sendCancellationInfoEmail(projection);

        projectionRepository.save(projection);
    }

    @Override
    public Projection getById(Long id) {
        return projectionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(format("Not found projection with ID %s", id)));
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

    private void sendCancellationInfoEmail(Projection projection) {
        List<User> usersAlreadyReceivedEmail = new ArrayList<>();
        for (Reservation r: projection.getReservations()) {
            r.setCanceled(true);
            User emailRecipient = r.getUser();

            if (usersAlreadyReceivedEmail.contains(emailRecipient)) {
                continue;
            }

            EmailDetailDto emailDetailDto = gatherEmailDetail(projection, emailRecipient);
            try {
                emailService.sendEmail(emailDetailDto);
                usersAlreadyReceivedEmail.add(r.getUser());
            } catch (MessagingException e) {
                // TODO: Log the exception when logging gets implemented
                throw new EmailNotSentException("Email of user: " + r.getUser().getEmail() + "could not be sent");
            }
        }
    }

    private EmailDetailDto gatherEmailDetail(Projection projection, User recipient) {
        String movieName = projection.getMovie().getName();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        String movieStart = projection.getStart().format(formatter);

        return new EmailDetailDto(movieName, movieStart, recipient.getEmail());
    }

}

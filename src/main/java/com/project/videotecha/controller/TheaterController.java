package com.project.videotecha.controller;

import com.project.videotecha.controller.api.TheaterControllerApi;
import com.project.videotecha.dto.TheaterDto;
import com.project.videotecha.mapper.TheaterMapper;
import com.project.videotecha.service.TheaterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("theaters")
public class TheaterController implements TheaterControllerApi {
    private final TheaterService theaterService;

    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    @GetMapping
    public List<TheaterDto> getAll() {
        return TheaterMapper.mapToTheaterDtos(theaterService.getAll());
    }

    @GetMapping("/{id}")
    public TheaterDto getById(@PathVariable Long id) {
        return TheaterMapper.mapToTheaterDto(theaterService.getById(id));
    }
}

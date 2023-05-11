package com.project.videotecha.controller;

import com.project.videotecha.dto.TheaterDto;
import com.project.videotecha.mapper.TheaterMapper;
import com.project.videotecha.service.TheaterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/theaters")
public class TheaterController {
    private final TheaterService theaterService;

    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    @GetMapping
    public List<TheaterDto> getAll() {
        return TheaterMapper.mapToTheaterDtos(theaterService.getAll());
    }
}

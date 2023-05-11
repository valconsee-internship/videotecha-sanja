package com.project.videotecha.mapper;

import com.project.videotecha.dto.TheaterDto;
import com.project.videotecha.model.Theater;

import java.util.ArrayList;
import java.util.List;

public class TheaterMapper {

    private TheaterMapper() {
    }

    public static List<TheaterDto> mapToTheaterDtos(List<Theater> theaters) {
        List<TheaterDto> theaterDtos = new ArrayList<>();
        for (Theater t : theaters) {
            theaterDtos.add(mapToTheaterDto(t));
        }
        return theaterDtos;
    }

    public static TheaterDto mapToTheaterDto(Theater theater) {
        return new TheaterDto(theater);
    }

}

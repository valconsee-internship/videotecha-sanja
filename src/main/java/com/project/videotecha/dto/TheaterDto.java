package com.project.videotecha.dto;

import com.project.videotecha.model.Theater;

public class TheaterDto {
    private Long id;
    private String name;
    private Integer capacity;

    public TheaterDto() {
    }

    public TheaterDto(Theater t) {
        this.id = t.getId();
        this.name = t.getName();
        this.capacity = t.getCapacity();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}

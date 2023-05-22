package com.project.videotecha.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name is required")
    private String name;
    @Min(value = 1)
    private int capacity;
    @OneToMany(mappedBy = "theater")
    private List<Projection> projections = new ArrayList<>();

    public Theater() {
    }

    public Theater(Long id, String name, int capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.projections = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Projection> getProjections() {
        return projections;
    }
}

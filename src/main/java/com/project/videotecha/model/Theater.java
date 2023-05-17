package com.project.videotecha.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer capacity;
    @OneToMany(mappedBy = "theater")
    private List<Projection> projections = new ArrayList<>();

    public Theater() {
    }

    public Theater(Long id, String name, Integer capacity) {
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

    public Integer getCapacity() {
        return capacity;
    }

    public List<Projection> getProjections() {
        return projections;
    }
}

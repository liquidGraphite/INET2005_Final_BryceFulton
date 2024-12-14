package com.example.fitnessclub.model;

import jakarta.persistence.*;

@Entity
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String specialization;

    @Enumerated(EnumType.STRING)
    private Shift shift;

    // Default constructor
    public Trainer() {
    }

    // All-args constructor
    public Trainer(Long id, String name, String specialization, Shift shift) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.shift = shift;
    }

    // Getters and Setters
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

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }
}
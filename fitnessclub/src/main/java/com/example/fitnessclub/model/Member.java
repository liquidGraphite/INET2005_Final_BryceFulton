package com.example.fitnessclub.model;

import jakarta.persistence.*;


@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private Boolean active = true;
    @Column(name = "assigned_trainer_id")
    private Long assignedTrainerId;

    // Default constructor
    public Member() {
    }

    // All-args constructor
    public Member(Long id, String name, String email, Boolean active, Long assignedTrainerId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.active = active;
        this.assignedTrainerId = assignedTrainerId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Long getAssignedTrainerId() {
        return assignedTrainerId;
    }

    public void setAssignedTrainerId(Long assignedTrainerId) {
        this.assignedTrainerId = assignedTrainerId;
    }
}
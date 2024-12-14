package com.example.fitnessclub.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long trainerId;
    private Long memberId;
    private LocalDate date;
    private String timeSlot;
    private String sessionType;

    // Default constructor (JPA requirement)
    public Schedule() {
    }

    // All-args constructor (optional, but helpful)
    public Schedule(Long id, Long trainerId, Long memberId, LocalDate date, String timeSlot, String sessionType) {
        this.id = id;
        this.trainerId = trainerId;
        this.memberId = memberId;
        this.date = date;
        this.timeSlot = timeSlot;
        this.sessionType = sessionType;
    }

    // Getters and setters for each field
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getTrainerId() {
        return trainerId;
    }
    public void setTrainerId(Long trainerId) {
        this.trainerId = trainerId;
    }

    public Long getMemberId() {
        return memberId;
    }
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTimeSlot() {
        return timeSlot;
    }
    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getSessionType() {
        return sessionType;
    }
    public void setSessionType(String sessionType) {
        this.sessionType = sessionType;
    }
}

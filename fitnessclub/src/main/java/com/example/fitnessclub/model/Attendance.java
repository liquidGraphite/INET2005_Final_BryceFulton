package com.example.fitnessclub.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long memberId;
    private LocalDate date;
    private Boolean present; // note: Boolean or boolean both work

    // Default constructor
    public Attendance() {
    }

    // All-args constructor
    public Attendance(Long id, Long memberId, LocalDate date, Boolean present) {
        this.id = id;
        this.memberId = memberId;
        this.date = date;
        this.present = present;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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

    public Boolean getPresent() {
        return present;
    }
    public void setPresent(Boolean present) {
        this.present = present;
    }
}

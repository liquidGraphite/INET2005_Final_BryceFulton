package com.example.fitnessclub.controller;

import com.example.fitnessclub.model.Attendance;
import com.example.fitnessclub.model.Schedule;
import com.example.fitnessclub.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/trainer")
public class TrainerController {

    @Autowired
    private TrainerService trainerService;

    @GetMapping("/{trainerId}/schedule")
    @PreAuthorize("hasAnyRole('TRAINER','ADMIN')")
    public List<Schedule> getSchedule(@PathVariable Long trainerId) {
        return trainerService.getTrainerSchedule(trainerId);
    }

    @PostMapping("/{trainerId}/attendance")
    @PreAuthorize("hasAnyRole('TRAINER','ADMIN')")
    public Attendance markAttendance(@PathVariable Long trainerId,
                                     @RequestParam Long memberId,
                                     @RequestParam boolean present) {
        // In a real scenario, you might check if the trainerId is authorized for that member
        return trainerService.markAttendance(memberId, LocalDate.now(), present);
    }
}

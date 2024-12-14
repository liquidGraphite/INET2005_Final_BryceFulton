package com.example.fitnessclub.service;

import com.example.fitnessclub.model.Attendance;
import com.example.fitnessclub.model.Schedule;
import com.example.fitnessclub.repository.AttendanceRepository;
import com.example.fitnessclub.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainerService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    public List<Schedule> getTrainerSchedule(Long trainerId) {
        return scheduleRepository.findAll()
                .stream()
                .filter(s -> s.getTrainerId().equals(trainerId))
                .collect(Collectors.toList());
    }

    public Attendance markAttendance(Long memberId, LocalDate date, boolean present) {
        Attendance att = new Attendance();
        att.setMemberId(memberId);
        att.setDate(date);
        att.setPresent(present);
        return attendanceRepository.save(att);
    }
}

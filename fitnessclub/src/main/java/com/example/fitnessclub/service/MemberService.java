package com.example.fitnessclub.service;

import com.example.fitnessclub.model.Schedule;
import com.example.fitnessclub.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    public List<Schedule> getMemberSchedule(Long memberId) {
        return scheduleRepository.findAll()
                .stream()
                .filter(s -> s.getMemberId().equals(memberId))
                .collect(Collectors.toList());
    }
}
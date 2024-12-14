package com.example.fitnessclub.controller;

import com.example.fitnessclub.model.Schedule;
import com.example.fitnessclub.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/{memberId}/schedule")
    @PreAuthorize("hasAnyRole('MEMBER','ADMIN')")
    public List<Schedule> getSchedule(@PathVariable Long memberId) {
        return memberService.getMemberSchedule(memberId);
    }
}
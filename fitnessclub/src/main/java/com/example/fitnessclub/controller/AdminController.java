package com.example.fitnessclub.controller;

import com.example.fitnessclub.model.Member;
import com.example.fitnessclub.model.Shift;
import com.example.fitnessclub.model.Trainer;
import com.example.fitnessclub.service.AdminService;
import com.example.fitnessclub.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private MemberRepository memberRepository;

    @PostMapping("/members")
    @PreAuthorize("hasRole('ADMIN')")
    public Member addMember(@RequestBody Member member) {
        return adminService.addMember(member);
    }

    @DeleteMapping("/members/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
        adminService.deleteMember(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/members/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Member updateMember(@PathVariable Long id, @RequestBody Member member) {
        return adminService.updateMember(id, member);
    }

    @PostMapping("/trainers")
    @PreAuthorize("hasRole('ADMIN')")
    public Trainer addTrainer(@RequestBody Trainer trainer) {
        return adminService.addTrainer(trainer);
    }

    @DeleteMapping("/trainers/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteTrainer(@PathVariable Long id) {
        adminService.deleteTrainer(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/trainers/{id}/shift")
    @PreAuthorize("hasRole('ADMIN')")
    public Trainer updateTrainerShift(@PathVariable Long id, @RequestParam Shift shift) {
        return adminService.updateTrainerShift(id, shift);
    }

    @GetMapping("/members")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }
}

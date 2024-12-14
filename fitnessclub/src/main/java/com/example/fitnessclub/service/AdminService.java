package com.example.fitnessclub.service;

import com.example.fitnessclub.model.Member;
import com.example.fitnessclub.model.Shift;
import com.example.fitnessclub.model.Trainer;
import com.example.fitnessclub.repository.MemberRepository;
import com.example.fitnessclub.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.*;

@Service
public class AdminService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private TrainerRepository trainerRepository;

    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    public void deleteMember(Long memberId) {
        memberRepository.deleteById(memberId);
    }

    public Member updateMember(Long memberId, Member updatedData) {
        return memberRepository.findById(memberId)
                .map(m -> {
                    m.setName(updatedData.getName());
                    m.setEmail(updatedData.getEmail());
                    m.setActive(updatedData.getActive());
                    m.setAssignedTrainerId(updatedData.getAssignedTrainerId());
                    return memberRepository.save(m);
                }).orElseThrow(() -> new RuntimeException("Member not found"));
    }

    public Trainer addTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }

    public void deleteTrainer(Long trainerId) {
        trainerRepository.deleteById(trainerId);
    }

    public Trainer updateTrainerShift(Long trainerId, Shift newShift) {
        return trainerRepository.findById(trainerId).map(t -> {
            t.setShift(newShift);
            return trainerRepository.save(t);
        }).orElseThrow(() -> new RuntimeException("Trainer not found"));
    }
}
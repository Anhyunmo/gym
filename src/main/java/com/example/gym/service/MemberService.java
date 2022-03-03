package com.example.gym.service;

import com.example.gym.domain.Member;
import com.example.gym.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public List<Member> findAll(){
        return memberRepository.findAll();
    }

    public Member findById(int id){
        return memberRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public Member saveMember(Member member){
        return memberRepository.save(member);
    }

    public void deleteMember(int id){
        memberRepository.deleteById(id);
    }
}

package com.example.gym.service;

import com.example.gym.domain.Member;
import com.example.gym.repository.MemberRepository;
import com.example.gym.util.EncryptHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    EncryptHelper encryptHelper;

    public List<Member> findAll(){
        return memberRepository.findAll();
    }

    public Member findById(int id){
        return memberRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public Member findByEmail(String email){
        return memberRepository.findByEmail(email).orElseThrow(NoSuchElementException::new);
    }

    public Member saveMember(Member member){
        if(member.getPassword() != null){
            member.setPassword(encryptHelper.encrypt(member.getPassword()));
        }
        return memberRepository.save(member);
    }

    public void deleteMember(int id){
        memberRepository.deleteById(id);
    }
}

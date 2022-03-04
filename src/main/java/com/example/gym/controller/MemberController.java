package com.example.gym.controller;

import com.example.gym.domain.Member;
import com.example.gym.dto.MemberUpsertDTO;
import com.example.gym.mapper.MemberMapper;
import com.example.gym.service.MemberService;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping
    public List<Member> getList(){
        return memberService.findAll();
    }

    @GetMapping("/{id}")
    public Member getList(@PathVariable("id") int id){
        return memberService.findById(id);
    }

//    @PostMapping
//    public Member setInsertMember(@Valid @RequestBody MemberUpsertDTO req){
//            Member member = MemberMapper.INSTANCE.insertRequestToMember(req);
//            return memberService.saveMember(member);
//    }

    @PutMapping("/{id}")
    public Member setUpdateGym(@PathVariable("id") int id, @Valid @RequestBody MemberUpsertDTO req){
        Member member = memberService.findById(id);
        MemberMapper.INSTANCE.updateRequestToMember(req, member);
        return memberService.saveMember(member);
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable("id") int id){
        memberService.deleteMember(id);
    }


}

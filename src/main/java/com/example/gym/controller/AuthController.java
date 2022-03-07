package com.example.gym.controller;

import com.example.gym.config.JwtTokenProvider;
import com.example.gym.domain.Member;
import com.example.gym.dto.MemberLoginDTO;
import com.example.gym.dto.MemberUpsertDTO;
import com.example.gym.mapper.MemberMapper;
import com.example.gym.service.AuthService;
import com.example.gym.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseCookie;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    MemberService memberService;

    @Autowired
    AuthService authService;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @PostMapping("/join")
    public Member memberJoin(@Valid @RequestBody MemberUpsertDTO req){
        Member member = MemberMapper.INSTANCE.insertRequestToMember(req);
        return memberService.saveMember(member);
    }

    @PostMapping("/login")
    public String loginMember(@Valid @RequestBody MemberLoginDTO req , HttpServletResponse response) {
        Member member = authService.validUserId(req.getEmail());
        authService.validPassword(req.getPassword(), member.getPassword());

        String accessToken = jwtTokenProvider.createToken(member.getId(), member.getEmail(), member.getName());

        ResponseCookie cookie = ResponseCookie.from("X-AUTH-TOKEN", accessToken)
                .domain("localhost")
                .sameSite("Lax")
                .maxAge(30 * 60)
                .build();

        response.addHeader("Set-Cookie", cookie.toString());

        return accessToken;
    }

}

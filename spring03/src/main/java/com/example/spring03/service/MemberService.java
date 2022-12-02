package com.example.spring03.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.spring03.domain.Member;
import com.example.spring03.dto.MemberRegisterDto;
import com.example.spring03.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    
    public String checkUsername(String username) {
        log.info("checkUsername(username={})", username);
        
        Optional<Member> result = memberRepository.findByUsername(username);
        if (result.isPresent()) { // 일치하는 username이 있는 경우.
            return "nok"; // 회원 가입에서 사용할 수 없는 아이디.
        } else { // 일치하는 username이 없는 경우.
            return "ok"; // 회원 가입에서 사용할 수 있는 아이디.
        }
    }
    
    // return 타입 void로 해도 상관 없음..!
    public Member registerMember(MemberRegisterDto dto) {
        log.info("registerMember(dto= {})", dto);
        
        Member entity = memberRepository.save(dto.toEntity());
        log.info("entity = {}", entity);
        
        return entity;
    }
    
}

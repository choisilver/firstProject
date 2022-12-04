package com.example.spring03.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.spring03.domain.Member;
import com.example.spring03.dto.MemberSecurityDto;
import com.example.spring03.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class CustomUserDetailsSevice implements UserDetailsService {

	private final MemberRepository memberRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Member> entity = memberRepository.findByUsername(username);
		
		if(entity.isPresent()) {
			log.info(username+" : username 로그인");
			return MemberSecurityDto.fromEntity(entity.get());
		}else {
			throw new UsernameNotFoundException(username+ ": not found!");
		}
		
		
	}
	
	
	
	
	
}

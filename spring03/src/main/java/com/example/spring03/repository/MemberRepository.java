package com.example.spring03.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring03.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {

    // 사용자 로그인 아이디(username)가 일치하는 사용자 정보 검색
    @EntityGraph(attributePaths = "roles") //  roles가 members, members_roles와 연관있다는 것을 알려주기 위해 적어주기.
    Optional<Member> findByUsername(String username);
    
}

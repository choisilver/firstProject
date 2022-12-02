package com.example.spring03.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.spring03.domain.Post;

// JpaRepository<엔터티 클래스 타입, PK 데이터 타입>을 상속하는 인터페이스를 선언.
// -> 기본적인 CRUD(Create, Read, Update, Delete)에 필요한 메서드들이 자동으로 생성.
// -> JpaRepository를 상속하는 인터페이스는 스프링 컨텍스트에서 bean으로 자동 관리됨.
// @Repository 필요 없음.
public interface PostRepository extends JpaRepository<Post, Integer> {
    
    // select * from POSTS order by ID desc
    List<Post> findByOrderByIdDesc();

    // 제목 검색:
    // select * from POSTS where lower(TITLE) like ? order by ID desc
    List<Post> findByTitleIgnoreCaseContainingOrderByIdDesc(String title);
    
    // 내용 검색:
    // select * from POSTS where lower(CONTNENT) like ? order by ID desc
    List<Post> findByContentIgnoreCaseContainingOrderByIdDesc(String content);
    
    // 작성자 검색:
    // select * from POSTS where lower(AUTHOR) like ? order by ID desc
    List<Post> findByAuthorIgnoreCaseContainingOrderByIdDesc(String author);
    
    // 제목 + 내용 검색:
    // select * from POSTS 
    // where lower(TITLE) like ?1 or lower(content) like ?2
    // order by ID desc
    List<Post> findByTitleIgnoreCaseContainingOrContentIgnoreCaseContainingOrderByIdDesc(String title, String content);
    
    // JPQL(Java Persistence Query Language)
    @Query(
        "select p from POSTS p "
        + " where lower(p.title) like lower('%' || :keyword || '%') "
        + " or lower(p.content) like lower('%' || :keyword || '%') "
        + " order by p.id desc"
    )
    List<Post> searchByKeyword(@Param(value = "keyword") String keyword);
    
}

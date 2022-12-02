package com.example.spring03.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.spring03.domain.Post;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class PostRepositoryTests2 {

    @Autowired
    private PostRepository postRepository;
    
    @Test
    public void testUpdate() {
        // DB table update: 
        // (1) id로 수정할 엔터티 검색
        Post entity = postRepository.findById(3).get();
        log.info("수정 전: {} | {} | {}", 
                entity, entity.getCreatedTime(), entity.getModifiedTime());
        
        // (2) 엔터티를 수정
        entity.update("update 테스트", "Spring Data JPA를 사용한 DB 테이블 업데이트");
        log.info("수정 후: {} | {} | {}",
                entity, entity.getCreatedTime(), entity.getModifiedTime());
        
        // (3) 수정한 엔터티를 postRepository.save(entity) 메서드 호출
        postRepository.save(entity); // DB에  수정 내용 반영(select -> update -> commit)
        log.info("save 후: {} | {} | {}",
                entity, entity.getCreatedTime(), entity.getModifiedTime());        
    }
    
    @Test
    public void testDelete() {
        // delete from POSTS where id = 13
        postRepository.deleteById(13);
    }
    
}

package edu.web.jsp02.domain;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j

public class PostTest {
    // slf4j 사용하기 위해서
//    private static final Logger log = LoggerFactory.getLogger(PostTest.class);
    
    @Test
    public void testPostBuilder() {
        // Builder 패턴을 이용한 객체 생성 테스트
        // 생성자를 직접 호출 할 수 있지만 어떤 컬럼이 null인지 알아보기 어렵고 문서확인, 순서 중요. 
        // Builder 패턴은 메서드 이름만으로도 확인할 수 있음.
        
        Post post = Post.builder()
                .id(10)
                .title("Builder 테스트")
                .content("Builder 테스트 확인하기")
                .author("admin")
                .createdTime(LocalDateTime.now())
                .modifiedTime(LocalDateTime.now())
                .build();
        Assertions.assertNotNull(post);
        log.info(post.toString());
        
        // 만들어진 객체의 id값이 동일한지 
        Assertions.assertEquals(10,post.getId());
        Assertions.assertEquals("Builder 테스트", post.getTitle());
        
    }
    
    

}

package edu.web.jsp02.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.web.jsp02.domain.Post;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SearchTest {
    
    private PostDao postDao = PostDaoImpl.getInstance();

    @Test
    public void test() {
        List<Post> list = postDao.selectByKeyword("t", "te");
        
        for(Post p : list) {
            Assertions.assertTrue(p.getTitle().toLowerCase().contains("te"));
            // -> argument가 true이면 단위 테스트 성공, false이면 단위 테스트 실패.
            log.info(p.toString());
            
        }
        
        list = postDao.selectByKeyword("c", "TEST");
        for(Post p : list) {
            // 가져온 결과에 내가 원하는 값이 들어있는지 확인. 눈으로 확인 못하니깐..!.
            Assertions.assertTrue(p.getContent().toLowerCase().contains("test")); // 출력이 아닌 JUnit 창에서 확인할 수 있음.
            // -> argument가 true이면 단위 테스트 성공, false이면 단위 테스트 실패.
            log.info(p.toString()); // sysout의 경우는 Object를 사용할 수 있지만, log의 경우는 toString으로 바꿔야함. 
        }
        
        list = postDao.selectByKeyword("tc", "test");
        for(Post p : list) {
            Assertions.assertTrue(
                    p.getTitle().toLowerCase().contains("test") ||
                    p.getContent().toLowerCase().contains("test")
            );
            log.info(p.toString());
        }
        
        list = postDao.selectByKeyword("a", "aD");
        for(Post p : list ) {
            Assertions.assertTrue(p.getAuthor().toLowerCase().contains("ad"));
            log.info(p.toString());
        }
        
        
        
    }
    
}

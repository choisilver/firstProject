package edu.web.jsp02.service;

import java.util.List;

import edu.web.jsp02.domain.Post;
import edu.web.jsp02.dto.PostCreateDto;
import edu.web.jsp02.dto.PostUpdateDto;

public interface PostService {

    public List<Post> read(); // 포스트 전체 목록 읽어오기
    public int create(PostCreateDto dto); // 포스트 작성하기 
    public Post read(Integer id); // id(포스트번호)가 일치하는 포스트 한개 읽어오기
    public int delete(Integer id); // id(포스트 번호)가 일치하는 포스트 1개 삭제
    public int update(Post post);
    public int update(PostUpdateDto dto); // 선생님은 DTO 사용해서 타입이 다름 id가 일치하는 포스트의 제목/내용 업데이트
    public List<Post> search(String type, String keyword); // 타입별로 키워드를 검색 서비스 
    
    
    
}

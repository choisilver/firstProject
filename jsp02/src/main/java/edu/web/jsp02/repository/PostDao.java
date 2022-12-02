package edu.web.jsp02.repository;

import java.util.List;

import edu.web.jsp02.domain.Post;

public interface PostDao {

    public List<Post> select();
    
    public int insert(Post entity); // DB에 insert, id title content 

    public Post selectById(Integer id);

    public int delete(Integer id); // id를 이용해서 레코드 삭제

    public int update(Post entity);
    
    public List<Post> selectByKeyword(String type, String keyword); // 각 메서드를 만들지 말고, 타입과 키워드를 받을 수 있는 메서드 생성


    
    
}

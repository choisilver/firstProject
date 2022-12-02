package edu.web.jsp02.repository;

import java.util.List;

import edu.web.jsp02.domain.User;

public interface UserDao {

    // 전체 회원 목록 읽기
    public List<User> read();
    // 과제
    public int create(User entity);
    public User read(Integer id);
    public int delete(Integer id);
    public int update(User user);
    public int usernameCheck(String username);
    
    // 수업 
    public int insert(User entity);
    public User selectByUsernameAndPassword(User user);
    
    
}

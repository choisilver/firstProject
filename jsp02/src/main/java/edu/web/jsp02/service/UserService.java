package edu.web.jsp02.service;

import java.util.List;

import edu.web.jsp02.domain.User;
import edu.web.jsp02.dto.UserSignUpDto;

public interface UserService {
    
    public List<User> read();

    public int create(UserSignUpDto dto);

    public User read(Integer id);

    public int delete(Integer id);

    public int update(User user);
    
    public int usernameCheck(String username);

    // 수업 
    public int signUp(UserSignUpDto dto);

    public User signIn(String username, String password);
    
}

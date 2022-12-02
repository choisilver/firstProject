package edu.web.jsp02.service;

import java.util.ArrayList;
import java.util.List;

import edu.web.jsp02.domain.User;
import edu.web.jsp02.dto.UserSignUpDto;
import edu.web.jsp02.repository.UserDao;
import edu.web.jsp02.repository.UserDaoImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserServiceImpl implements UserService {
// singleton

    private static UserServiceImpl instance = null;

    public static UserServiceImpl getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }

    // userdaoImple 생성, 초기화
    private UserDao dao;

    private UserServiceImpl() {
        dao = UserDaoImpl.getInstance();
    }

    @Override
    public List<User> read() {
        log.info("service read() 호출");

        return dao.read();
    }

    @Override
    public int create(UserSignUpDto dto) {
        // 생성된 회원의 개수가 반환됨
        log.info("service create()");

        return dao.create(dto.toEntity());
    }

    /**
     * ID를 통해 객체 하나 읽기
     */
    @Override
    public User read(Integer id) {
        log.info("user read(id)");
        return dao.read(id);
    }

    @Override
    public int delete(Integer id) {
        log.info("delete id = {}", id);
        return dao.delete(id);
    }

    @Override
    public int update(User user) {
        log.info("user update={}", user);

        return dao.update(user);
    }

    @Override
    public int usernameCheck(String username) {
        return dao.usernameCheck(username);
    }

    @Override
    public int signUp(UserSignUpDto dto) {
        log.info("signUp (dto= {})" , dto);
        
        return dao.insert(dto.toEntity());
        
    }
    @Override
        public User signIn(String username, String password) {
        log.info("signIn(username ={}, password={})", username,password);
        
        User user = User.builder().username(username).password(password).build();
        
        return dao.selectByUsernameAndPassword(user);
        }
}

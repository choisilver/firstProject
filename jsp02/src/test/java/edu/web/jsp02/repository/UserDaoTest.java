package edu.web.jsp02.repository;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserDaoTest {
    private UserDao dao = UserDaoImpl.getInstance();
    
    @Test
    public void testName(){
        
        int result = dao.usernameCheck("bb");
        log.info(result+"");
    }
    
    
}

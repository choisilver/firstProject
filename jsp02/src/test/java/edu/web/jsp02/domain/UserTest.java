package edu.web.jsp02.domain;

import org.junit.jupiter.api.Test;

import edu.web.jsp02.repository.UserDaoImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserTest {
    
    @Test
    public void userTest() {
        // 읽기, builder
        
        UserDaoImpl dao = UserDaoImpl.getInstance();
        
        log.info(dao.read().toString());
        
    }

}

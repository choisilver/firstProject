package edu.web.jsp02.hikaricp;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

// DBCP(Database Connection Pool) - DataSource 데이터를 저장할 수 있는 공간
// HikariCP 라이브러리 테스트 

public class DbcpTest {
    
    // Log4j2 기능을 구현한 Slf4j의 로깅 기능을 사용.
    private final Logger log = LoggerFactory.getLogger(DbcpTest.class);
    
    @Test
    public void testHikariCP() throws SQLException {
        // HikariCP 설정을 위한 객체 생성.
        HikariConfig config = new HikariConfig();
        
        
        // Connection Pool (Data Source) 생성을 위한 환경설정 세팅.
        config.setDriverClassName("oracle.jdbc.OracleDriver"); // 연결을 맺기 위한 DB 드라이버. import한 문장 찾아서 보기
        config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe"); // DB 서버 URL
        config.setUsername("scott");  // 접속 계정
        config.setPassword("tiger");  // 접속 비밀번호
        
        config.addDataSourceProperty("cachePrepStmt", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        
        // 위의 설정들을 갖는 Connection Pool(Data Source) 객체 생성
        HikariDataSource ds = new HikariDataSource(config); // 설정 정보를 갖고 있는 데이터 소스가 오라클과 연결
        Assertions.assertNotNull(ds); // DataSource는 null이 되면 안됨.
        System.out.println(ds);
        log.info("ds = {}", ds); // 문자열 템플링 기능
        
        // Connection Pool(Data Source)에서 Connection 객체를 빌려옴.
        Connection conn = ds.getConnection();
        Assertions.assertNotNull(conn); // Connection은 null이 되면 안됨.
        System.out.println(conn);
        log.info("conn = {}" , conn);
        
        // 사용했던 Connection을 Connection Pool(Data Source)에 반환.
        conn.close();
        
        
        
        
        
    }

}

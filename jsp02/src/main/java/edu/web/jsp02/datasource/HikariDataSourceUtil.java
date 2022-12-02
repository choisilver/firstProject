package edu.web.jsp02.datasource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

// HikariCP 라이브러리를 사용한 DataSource를 이용할 수 있느 유틸리티 클래스.
// -> Singleton 패턴
public class HikariDataSourceUtil {

    private static HikariDataSourceUtil instance = null;
    
    private HikariDataSource ds; // connection을 할 수 있음. dao에서 해야함. 그러니깐 dao 클래스에서 사용할 수 있도록 생성, 리턴을 해야함.
    
    private HikariDataSourceUtil() {
        // HikarlCP을 사용하기 위한 설정(configuration)
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("oracle.jdbc.OracleDriver");
        config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
        config.setUsername("scott");
        config.setPassword("tiger");
        
        config.addDataSourceProperty("cachePrepStmt", "true");
        config.addDataSourceProperty("prepStmtChachSize", "250");
        config.addDataSourceProperty("prepStmtChachLimit", "2048");
        
        // HikariDataSource 객체 생성.
        ds = new HikariDataSource(config);
        
        
    }
    // singleton
    public static HikariDataSourceUtil getInstance() {
        if(instance== null) {
            instance = new HikariDataSourceUtil();
        }
        
        return instance;
    }
    
    
    public HikariDataSource getDataSource() {
        
        return ds;
    }
    
    
    
    
    
    
    
    
}

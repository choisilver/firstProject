package edu.web.jsp02.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zaxxer.hikari.HikariDataSource;

import edu.web.jsp02.datasource.HikariDataSourceUtil;
import edu.web.jsp02.domain.User;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserDaoImpl implements UserDao {
// singleton, ds연결
    private HikariDataSource ds;
    private static UserDaoImpl instance = null;

    private UserDaoImpl() {
        ds = HikariDataSourceUtil.getInstance().getDataSource();
    }

    public static UserDaoImpl getInstance() {
        if (instance == null) {
            instance = new UserDaoImpl();
        }
        return instance;
    }

    
    @Override
    public int insert(User entity) {
        log.info("insert(entity = {})", entity);
        
        int result = 0; // DB 테이블에 insert한 결과를 저장할 변수
        
        try {
            @Cleanup
            Connection conn = ds.getConnection();
            @Cleanup
            PreparedStatement stmt = conn.prepareStatement(SQL_CREATE);
            log.info(SQL_CREATE);
            
            // prepared statement의 바인딩 파라미터(binding parameter ) 값들을 세팅 
            stmt.setString(1,entity.getUsername() );
            stmt.setString(2, entity.getPassword());
            stmt.setString(3, entity.getEmail());
            
            // SQL 실행
            result = stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return result;
    }
    
    private static final  String SQL_SELECT_BY_USERNAME_AND_PASSWORD = 
            "select * from USERS where USERNAME = ? and PASSWORD = ?";
    
    @Override
        public User selectByUsernameAndPassword(User user) {
        log.info("ByUsernameAndPassword{}", user);
        User entity = null; // DB에서 select한 결과를 저장할 객체
        try {
            @Cleanup
            Connection conn = ds.getConnection();
            @Cleanup
            PreparedStatement stmt = conn.prepareStatement(SQL_SELECT_BY_USERNAME_AND_PASSWORD);
            log.info(SQL_SELECT_BY_USERNAME_AND_PASSWORD);
            
            stmt.setString(1,user.getUsername());
            stmt.setString(2,user.getPassword());
            @Cleanup
            ResultSet rs =stmt.executeQuery();
            if(rs.next()) {
                Integer id =rs.getInt("ID");
                String username = rs.getString("USERNAME");
                String password = rs.getString("PASSWORD");
                String email = rs.getString("EMAIL");
                int points = rs.getInt("POINTS");
                
                entity= User.builder()
                        .id(id).username(username).password(password)
                        .email(email).points(points)
                        .build();
                
               //  entity = userSelect(rs);
                
            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        return entity;
        }
    
    
    
    
    
    
    
    
    // sql 문장
    public static final String SQL_SELECT = "select * from USERS order by ID desc";
    public static final String SQL_CREATE = "insert into USERS (USERNAME, PASSWORD, EMAIL) " + "values (?, ? , ?)";
    public static final String SQL_SELECT_BY_ID = "select * from USERS where ID = ? ";
    private static String SQL_DELETE ="delete from USERS where ID =?";
    private static String SQL_UPDATE= "update USERS set USERNAME=?, PASSWORD=?, EMAIL=?, POINTS=? "
            + "where ID =?";
    private static String SQL_SELECT_BY_NAME = "select * from USERS where USERNAME = ? ";
    
    
    // select 메서드
    private User userSelect(ResultSet rs) throws SQLException {
        Integer id = rs.getInt("ID");
        String username = rs.getString("USERNAME");
        String password = rs.getString("PASSWORD");
        String email = rs.getString("EMAIL");
        Integer points = rs.getInt("POINTS");

        User entity = User.builder().id(id).username(username).password(password).email(email).points(points).build();

        return entity;
    }

    @Override
    public List<User> read() {
        List<User> list = new ArrayList<>();
        // ds 연결됨
        try {
            @Cleanup
            Connection conn = ds.getConnection();
            @Cleanup
            PreparedStatement stmt = conn.prepareStatement(SQL_SELECT);
            @Cleanup
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                User user = userSelect(rs);
                list.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public User read(Integer id) {
        log.info("회원가입한 걸 아이디로 상세 보기 할거얌 read(id)");
        User user = null;
        try {
            @Cleanup
            Connection conn = ds.getConnection();
            @Cleanup
            PreparedStatement stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, id);
            @Cleanup
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                user = userSelect(rs);
            }

            log.info("읽은 값 볼거야 user= {}", user);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public int create(User entity) {
        log.info("dao create()");
        log.info(entity.toString());
        int result = 0;
        try {
            @Cleanup
            Connection conn = ds.getConnection();
            PreparedStatement stmt = conn.prepareStatement(SQL_CREATE);
            stmt.setString(1, entity.getUsername());
            stmt.setString(2, entity.getPassword());
            stmt.setString(3, entity.getEmail());

            result = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }


    @Override
    public int delete(Integer id) {
        int result = 0;
        log.info("delete id ={}", id);
        try {
            @Cleanup
            Connection conn = ds.getConnection();
            @Cleanup
            PreparedStatement stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id);
            result=stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    

    @Override
        public int update(User user) {
            int result =0;
            log.info("dao update ={}",user);
        
        try {
            @Cleanup
            Connection conn = ds.getConnection();
            @Cleanup
            PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1,  user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEmail());
            stmt.setInt(4, user.getPoints());
            stmt.setInt(5, user.getId());
            
            result= stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        return result;
        }

    @Override
        public int usernameCheck(String username) {
        int result = 0;
        
        try {
            
            @Cleanup
            Connection conn = ds.getConnection();
            @Cleanup
            PreparedStatement stmt = conn.prepareStatement(SQL_SELECT_BY_NAME);
            stmt.setString(1, username);
            @Cleanup
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) { // 존재함. 1 만들면 안됨
     
                log.info(username);
                result =1;
            }else { 
                 result= 0;
            }

            log.info(result+" ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return result;
        }
    

    
    
}

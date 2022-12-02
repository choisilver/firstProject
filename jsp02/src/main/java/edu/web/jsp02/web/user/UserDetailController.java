package edu.web.jsp02.web.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.jsp02.domain.User;
import edu.web.jsp02.service.UserService;
import edu.web.jsp02.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * Servlet implementation class UserDetailController
 */
@Slf4j
@WebServlet(name = "userDetailController", urlPatterns = { "/user/detail" })
public class UserDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserService userService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDetailController() {
        userService = UserServiceImpl.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // 상세보기 클릭은 doGet
	    log.info("detail doGet()");
	    Integer id = Integer.valueOf(request.getParameter("id"));
	    log.info("id= {}",id);
	    // sql를 통해서 객체를 가져와야 함
	    
	    User user = userService.read(id);
	    log.info("컨트롤러에서 user 읽을 거야 user ={}",user);
	    // request 객체 자체만 넣으면 됨
	    request.setAttribute("user", user);
	    
	    // forward로 보냄 
	    request.getRequestDispatcher("/WEB-INF/user/detail.jsp").forward(request, response);
	    
	    
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

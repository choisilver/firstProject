package edu.web.jsp02.web.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.jsp02.dto.UserSignUpDto;
import edu.web.jsp02.service.UserService;
import edu.web.jsp02.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * Servlet implementation class UserCreateController
 */
@Slf4j
@WebServlet(name = "userCreateController", urlPatterns = { "/user/create" })
public class UserCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCreateController() {
        userService = UserServiceImpl.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    log.info("회원 추가 doGet()");
	       request.setAttribute("check", false);
	    request.getRequestDispatcher("/WEB-INF/user/create.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    log.info("회원 가입 버튼 클릭 doPost()");
	    String username = request.getParameter("username");
	    String password = request.getParameter("pw");
	    String email = request.getParameter("email");
	    
	    // username을 비교할 수 있는 코드 필요. 1과 0을 내보냄. 그리고 그걸 false, true로
	    
	    int usernameCheck = userService.usernameCheck(username);
	    if(usernameCheck==1) {
	        response.sendRedirect("/jsp02/user/create?duplicate=true");
	        // redirect는 request.setAttribute를 읽지못함.
	        
	    }else {
	        
	        UserSignUpDto dto = UserSignUpDto.builder()
	                .username(username).password(password).email(email)
	                .build();
	        userService.create(dto);
	        
	        response.sendRedirect("/jsp02/user/list");
	        
	    }

	    

	    
	    
	}

}

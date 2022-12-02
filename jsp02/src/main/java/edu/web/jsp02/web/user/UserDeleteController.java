package edu.web.jsp02.web.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.jsp02.service.UserService;
import edu.web.jsp02.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * Servlet implementation class UserDeleteController
 */
@Slf4j
@WebServlet(name = "userDeleteController", urlPatterns = { "/user/delete" })
public class UserDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserService userService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDeleteController() {
        userService = UserServiceImpl.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   log.info("delete doGet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    log.info("doPOST");
	    Integer id = Integer.valueOf(request.getParameter("id"));
	    log.info("id={}",id);
	    
	    int result = userService.delete(id);
	    response.sendRedirect("/jsp02/user/list");
	}

}

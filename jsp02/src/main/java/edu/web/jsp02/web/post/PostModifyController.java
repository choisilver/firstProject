package edu.web.jsp02.web.post;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.jsp02.domain.Post;
import edu.web.jsp02.dto.PostUpdateDto;
import edu.web.jsp02.service.PostService;
import edu.web.jsp02.service.PostServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * Servlet implementation class PostModifyController
 */
@Slf4j
@WebServlet(name = "postModifyController", urlPatterns = { "/post/modify" })
public class PostModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PostService postService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostModifyController() {
        postService = PostServiceImpl.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("doGet()");
        // 요청 파라미터 id(포스트번호) 찾기.
        Integer id = Integer.valueOf(request.getParameter("id"));
        log.info("id={}",id);
        
        // id(포스트번호)로 레코드 찾기
        Post post = postService.read(id);
        
        // 뷰에 전달하기
        request.setAttribute("post", post);
        request.getRequestDispatcher("/WEB-INF/post/modify.jsp")
            .forward(request, response);
        
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO : 포스트 (제목 또는 내용 수정)
        log.info("doPost()호출!! ");
        
        // 요청 파라미터 분석
        Integer id=Integer.valueOf(request.getParameter("id")); // 아이디를 받음
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        
        
//        Post postUpdate=Post.builder().id(id).title(title).content(content).build();
//        postService.update(postUpdate);
        
        
        // postServict 객체에게 전달할 DTO 생성
        PostUpdateDto dto = PostUpdateDto.builder().id(id).title(title).content(content).build();
        
        int result = postService.update(dto);
        log.info("post update result = {} ", result);
        
        // redirect로 보낼 때는 query값까지 보내면 됨.
        // 상세보기 이동 (Redirect) 
        response.sendRedirect("/jsp02/post/detail?id="+id);
        // PRG (Post- Redirect - Get) 패턴 
        
        
    }

}

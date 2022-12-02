package edu.web.jsp02.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@Slf4j
@WebFilter(filterName = "encodingFilter", urlPatterns = { "/*" }) // 
public class EncodingFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public EncodingFilter() {
        log.trace("EncodingFilter 생성자 호출 ");
    }

	/**
	 * @see Filter#destroy()
	 */
    @Override
	public void destroy() { 
        // Filter 객체가 소멸될때 WAS에서 호출하는 메서드.
        log.trace("destory() 호출");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
    @Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 클라이언트에서 온 요청을 Servlet(controller)로 전달하기 전에 실행할 코드들.
		// place your code here
        log.info("doFilter 호출 전");
        
        // 모든 요청의 인코딩 값을 UTF-8로 설정.
        ((HttpServletRequest) request).setCharacterEncoding("UTF-8"); // 모든 서블릿 클래스 만들때 인코딩 할 필요가 없음.
        
		// pass the request along the filter chain
		chain.doFilter(request, response); // 요청을 처리할 Servlet(controller)로 요청을 전달. 또는 request.sendRedirect()등으로 다른 주소로 보낼 수 있음.
		
		// Servlet 클래스의 메서드(doGet, doPost)가 종료된 후에 실행할 코드들.
		log.trace("doFilter 호출 후");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
    @Override
	public void init(FilterConfig fConfig) throws ServletException {
        // WAS가 Filter 객체를 생성하고 초기화할때 호출하는 메서드.
        log.trace("init() 호출");
    }

}

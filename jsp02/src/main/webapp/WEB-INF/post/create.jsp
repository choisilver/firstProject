<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP 2</title>
</head>
<body>
    <div>
        <h1>포스트 작성 페이지</h1>
        
        <nav>
            <Ul>
                <%-- 로그인 정보가 있으면 --%>
                <c:if test="${ not empty signInUser }">
                    <li>
                        <span>${ signInUser }</span>
                        <c:url var="signOutPage" value="/user/signout"></c:url>
                        <a href="${signOutPage }">로그아웃</a>
                    </li>
                
                </c:if>
                
                <li>
                    <c:url var="mainPage" value="/"></c:url>
                    <a href="${mainPage }"> 메인페이지</a>
                </li>
                <li>
                    <c:url var="postListPage" value="/post"></c:url>
                    <a href="${postListPage }">목록 페이지</a> <!-- core 태그를 이용할 수 있음. -->
                </li>
            </Ul>
        </nav>
        
        <main>
            <!-- form의 action 속성: 요청을 보내는 주소. 생략된 경우는 현재 페이지로 요청을 보냄. -->
            <form method="post">
                <div>
                    <input type="text" name="title"  placeholder="제목" required="required" autofocus />
                </div>
                <div>
                    <textarea rows="5" cols="40" name="content" placeholder="내용" required="required" ></textarea>
                </div>
                <div>
                    <%-- 작성자 input은 로그인한 사용자 아이디로 세팅.
                        type을 hidden으로 바꾸면 작성자는 보이진 않지만 name을 통해서 값은 전달됨.  개발자도구로는 확인이 됨.
                     --%>
                    <input type="hidden" name="author" value="${ signInUser }" readonly />
                </div>
                <div>
                    <input type="submit" value="작성완료" />
                </div>
                <div></div>
    
            </form>
        </main>
        
        
    </div>

</body>
</html>
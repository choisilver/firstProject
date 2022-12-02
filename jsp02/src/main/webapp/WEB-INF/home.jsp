<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>MVC</title>
</head>
<body>
    
<div>
    <div>
        <h1>메인 페이지</h1>
    </div>

    <div>
        <ul>
        <%-- 로그인 정보가 있는 경우  --%>
            <%-- EL not empty 연산자: null이 아니고, 문자열이 빈문자열이 아닌 경우. (not null && !"")  --%>
            <c:if test="${ not empty signInUser }">
                <li>
                    <c:url var="signOutPage" value="/user/signout"></c:url>
                    <span>${ signInUser }</span>
                    <a href="${signOutPage }">로그아웃</a>
                </li>    
            </c:if>
            <%-- 로그인 정보가 없는 경우 --%>
            <c:if test="${ empty signInUser }">
                <li>
                    <c:url var="signInPage" value="/user/signin"></c:url>
                    <a href="${ signInPage}">로그인</a>
                </li>
                <li>
                    <c:url var="signUpPage" value="/user/signup"></c:url>
                    <a href="${ signUpPage }">회원가입</a>
                </li>
            </c:if>        
        
        
            <li>
                <c:url var="postList" value="/post" ></c:url>
                <a href="${ postList }">포스트 전체 목록</a>
            </li>
            <li>
                <c:url var="userList" value="/user/list" ></c:url>
                <a href="${ userList }">회원 전체 목록</a>
            </li>
            
            
            
        </ul>
    </div>


</div>
    


</body>
</html>
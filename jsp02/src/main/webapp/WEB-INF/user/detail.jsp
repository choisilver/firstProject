<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>USER</title>
</head>
<body>
<h1>회원 정보 보기</h1>
    <ul>
        <li>
        <c:url var="listPage" value="/user/list" ></c:url>
            <a href="${listPage }">회원 전체 목록 보기</a>
        </li>
        <li>
            <c:url var="updatePage" value="/user/modify">
            <c:param name="id" value="${user.id }"></c:param>
            </c:url>
            <a href="${updatePage }">수정</a>
        </li>
    </ul>


    <div>
    
        <form method="post">
            <div>
                <label for="id" >회원 번호</label>
                <input id="id" name="id" type="text" value="${user.id }" readonly />
            </div>
            <div>
                <label for="username" >id</label>
                <input id="username" name="username" type="text"  value="${ user.username }" readonly/>
            </div>
            <div>
                <label for="pw" >password</label>
                <input id="pw" name="pw" type="text"  value="${ user.password }" readonly/>
            </div>
            <div>
                <label for="email" >email</label>
                <input id="email" name="email" type="text"  value="${ user.email }" readonly/>
            </div>
            <div>
                <label for="points" >포인트</label>
                <input id="points" name="email" type="text" value="${ user.points }" readonly/>
            </div>
            

        </form>
        
        
    </div>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>USER </title>
    </head>
        <link 
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
        rel="stylesheet" 
        integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
        crossorigin="anonymous">
    

<body>
    <h1>list</h1>
    
    <ul>
        <li>
            <c:url var="main" value="/" ></c:url>
            <a href="${main }">메인으로...</a>
        </li>
        <li>
            <c:url var="join" value="/user/create" ></c:url>
            <a href="${join }"> 회원 추가 하기</a>
        </li>
        
        
    </ul>
    
    
    
<%-- 번호, 네임, 이메일만 보이기 --%>
    <table  class="table table-hover" >
        <thead>
            <tr>
                <th>id</th>
                <th>username</th>
                <th>email</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${ users }" var="u">
            
                    <c:url var="detailPage" value="/user/modify">
                        <c:param name="id" value="${u.id }"></c:param>
                    </c:url>
            <tr onclick="location.href='${ detailPage }'">
                <td >${u.id }</td>
                <td>
                   ${ u.username }
                </td>
                <td>${ u.email }</td>
            </tr>
            </c:forEach>
        
        </tbody>
    
    </table>
    
</body>
</html>
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
<h1>회원 추가</h1>
    <div>
        <form method="post">
            <div>
                <label>id</label>
                <input name="username" type="text"  required autofocus placeholder="아이디" />
       
            </div>
            <div>
                <label>password</label>
                <input name="pw" type="text"  required  placeholder="비밀번호" />
            </div>
            <div>
                <label>email</label>
                <input name="email" type="text"  required   placeholder="이메일"/>
            </div>
            
            <div>
            <input id="btnCreate" type="submit" value="회원 가입" >
            </div>
        </form>
        
        
    </div>
<script >
    <c:if test="${ param.duplicate }">
    alert('중복 아이디');
    </c:if>

</script>

</body>
</html>
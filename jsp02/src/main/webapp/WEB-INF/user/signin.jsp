<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
<title>JSP 2</title>
</head>
<body>
<div>
    <div>
        <h1>로그인</h1>
    </div>    
    
    <div>
        <form method="post" >
            <div>
                <label for="username">아이디</label>
                <input id="username" type="text" name="username" placeholder="아이디" required autofocus>
            </div>
            <div>
                <label for="pw">비밀번호</label>
                <input id="pw" type="password" name="password" placeholder="비밀번호" required >
            </div>
            <div>
                <input type="submit" value="로그인" />
            </div>
            
            
        </form>
    </div>
    
</div>

</body>
</html>
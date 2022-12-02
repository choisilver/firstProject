<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>USER</title>
</head>
<body>
<h1>회원 추가</h1>
    <div>
    <button>삭제</button>
    <button>수정</button>
        <form method="post">
            <div>
                <label>회원 번호</label>
                <input name="id" type="text"  />
            </div>
            <div>
                <label>id</label>
                <input name="username" type="text"  />
            </div>
            <div>
                <label>password</label>
                <input name="pw" type="text"  />
            </div>
            <div>
                <label>email</label>
                <input name="email" type="text"  />
            </div>
            <div>
                <label>포인트</label>
                <input name="points" type="text"  />
            </div>
            
            <div>
            <input type="submit" value="회원 가입" >
            </div>
        </form>
        
        
    </div>


</body>
</html>
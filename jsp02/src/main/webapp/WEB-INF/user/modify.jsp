<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>USER</title>
</head>
        <link 
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
        rel="stylesheet" 
        integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
        crossorigin="anonymous">

<body>
<h1>회원 정보 수정하기 </h1>
    <ul>
        <li>
        <c:url var="listPage" value="/user/list" ></c:url>
            <a href="${listPage }">회원 전체 목록 보기</a>
        </li>

    </ul>


    <div>
    
    
        <form id="userForm" >
            <div>
                <label for="id" class="col-sm-2 col-form-label" >회원 번호</label>
                <input id="id" name="id" type="text" value="${user.id }" readonly />
            </div>
            <div>
                <label for="username"  class="col-sm-2 col-form-label">id</label>
                <input id="username" name="username" type="text"  value="${ user.username }"  autofocus/>
            </div>
            <div>
                <label for="pw" >password</label>
                <input id="pw" name="password" type="text"  value="${ user.password }" />
            </div>
            <div>
                <label for="email" >email</label>
                <input id="email" name="email" type="text"  value="${ user.email }" />
            </div>
            <div>
                <label for="points" >포인트</label>
                <input id="points" name="points" type="text" value="${ user.points }" />
            </div>
            
        <button id="btnUpdate" >수정</button>
        <button id="btnDelete">삭제</button>

        </form>
        
        <c:url var="delete" value="/user/delete"></c:url>
        <c:url var="modify" value="/user/modify"></c:url>
        
    </div>

    <script >
    const btnDelete = document.querySelector('#btnDelete');
    const btnUpdate=document.querySelector('#btnUpdate');
    const form = document.querySelector('#userForm');
    
    
    btnDelete.addEventListener('click', function(event){
        event.preventDefault();
        
        const check = confirm('아이디 ' +'${user.username}'+' 회원을  삭제하시겠습니까?');
        
        
        if(check){
        	console.log("확인")
            form.action = '${ delete }';
            form.method = 'post';
            form.submit();
        }
    });
    
    btnUpdate.addEventListener('click', function(event){
    	event.preventDefault();
    	const username = document.querySelector('#username').value;
    	const password = document.querySelector('#pw').value;
    	const email = document.querySelector('#email').value;
    	const points = document.querySelector('#points').value;

    	if(username==''|| password==''|| email=='' || points==''){
    		alter('값을 모두 입력하시오');
    		return;
    	}
    	
    	const check = confirm(' 정보를 수정하시겠습니까?');
    	
    	if(check){
    		form.action = '${modify}';
    		form.method = 'post';
    		form.submit();
    		
    	}
    	
    	
    	
    })
    

    
    
    </script>
</body>
</html>
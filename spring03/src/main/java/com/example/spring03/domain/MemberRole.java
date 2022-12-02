package com.example.spring03.domain;

// 사용자(회원)의 역할(권한) - 일반사용자, 관리자
// -> Spring Security에서 사용됨.
public enum MemberRole {
    // enum: 상수를 정의하는 클래스
    // 생성자를 호출하는 법이 다름.
    USER("ROLE_USER"), // = 0, enum에서 생성자 호출하는 법! ("ROLE_USER"라는 문자열을 저장하는 상수가 됨!)
    ADMIN("ROLE_ADMIN"); // = 1
    
    // 필드(멤버 변수)
    private String role;
    
    // 생성자
    MemberRole(String role) {
        this.role = role;
    }
    
    // getter 메서드
    public String getRole() {
        return this.role;
    }
    
    
    
}

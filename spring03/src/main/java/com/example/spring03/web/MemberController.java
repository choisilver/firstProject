package com.example.spring03.web;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.spring03.dto.MemberRegisterDto;
import com.example.spring03.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller // 안 붙여주면 Dispatcher Servlet이 사용 못함
@RequestMapping("/member") // 다른 설정이 없는 경우 GET/POST/PUT/DELETE 모든 방식의 요청을 처리.
public class MemberController {
    
    private final MemberService memberService;
    
    @GetMapping("/signup") // GET 방식의 /member/signup 요청을 처리하는 메서드.
    public void signUp() {
        log.info("signUp() GET");
        // 컨트롤러 메서드의 리턴 타입이 void일 때 뷰의 이름은 요청 주소와 동일.
        // templates/member/signup.html
    }
    
    @GetMapping("/checkid")
    @ResponseBody 
    // -> 컨트롤러 메서드가 리턴하는 값이 뷰의 이름이 아니라 클라이언트로 직접 전송되는 데이터인 경우.
    // -> Ajax 요청 처리에 대한 응답을 리턴할 때.
    public ResponseEntity<String> checkUsername(String username) {
        log.info("checkUsername(username={})", username);
        
        String result = memberService.checkUsername(username);
                
        return ResponseEntity.ok(result);
    }
    
    @PostMapping("/signup")
    public String signUp(MemberRegisterDto dto) {
        log.info("signUp(dto={}) POST", dto);
        
        memberService.registerMember(dto); 
        
        return "redirect:/"; // 회원 가입 성공 후 이동(redirect)
    }
    
}

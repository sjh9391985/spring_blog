package com.springboot.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 인증이 안된 사용자들이 출입할 수 있는 경로를 /auth/** 허용
// 그냥 주소가 '/' 일 경우 index.jsp 허용
// static dir 이하에 있는 /js/**, /css/**, /image/** 허용을 해줍니다.
// 즉, 인증이 필요없는곳에 auth를 붙입니다.

@Controller
public class UserController {

    @GetMapping("/auth/joinForm")
    public String joinForm(){ return "user/joinForm"; }

    @GetMapping("/auth/loginForm")
    public String loginForm(){
        return "user/loginForm";
    }
}

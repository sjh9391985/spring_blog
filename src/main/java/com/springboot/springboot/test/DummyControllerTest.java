package com.springboot.springboot.test;

import com.springboot.springboot.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyControllerTest {

    // 회원가입 테스트 코드
    @PostMapping("/dummy/join")
    public String join(User user){ //key = value 형태의 데이터를 주고받는 모양입니다.
        System.out.println("username: " + user.getUsername());
        System.out.println("password: " + user.getPassword());
        System.out.println("email: " + user.getEmail());
        return "회원가입 완료되었습니다.";

    }

}

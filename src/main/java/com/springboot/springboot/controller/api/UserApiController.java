package com.springboot.springboot.controller.api;

import com.springboot.springboot.dto.ResponseDto;
import com.springboot.springboot.model.RoleType;
import com.springboot.springboot.model.User;
import com.springboot.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserApiController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/user")
    public ResponseDto<Integer> save(@RequestBody User user){
        System.out.println("userApiController");
        user.setRole(RoleType.USER);
        userService.join(user); // 1이면 성공, -1이면 실패
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }

//    @PostMapping("/api/user/login")
//    public ResponseDto<Integer> login(@RequestBody User user HttpSession httpSession;){
//        System.out.println("login ing@~");
//        User principal = userService.login(user);
//
//        if(principal!=null){
//            httpSession.setAttribute("principal", principal);
//        }
//        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
//    }

}
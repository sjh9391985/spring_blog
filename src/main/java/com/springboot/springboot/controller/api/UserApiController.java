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

@RestController
public class UserApiController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/user")
    public ResponseDto<Integer> save(@RequestBody User user){
        System.out.println("userApiController");
        user.setRole(RoleType.USER);
        int result = userService.join(user); // 1이면 성공, -1이면 실패

        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }

}

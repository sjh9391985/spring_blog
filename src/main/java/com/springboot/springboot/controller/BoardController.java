package com.springboot.springboot.controller;

import com.springboot.springboot.config.auth.PrincipalDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping({"","/"})
    public String index(){ //컨트롤러에서 세션을 어떻게 찾는지?

        // WEB-INF/view/{retrun}.jsp
        return "index";
    }
}

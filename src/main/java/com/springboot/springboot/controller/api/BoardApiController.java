package com.springboot.springboot.controller.api;

import com.springboot.springboot.config.auth.PrincipalDetail;
import com.springboot.springboot.dto.ResponseDto;
import com.springboot.springboot.model.Board;
import com.springboot.springboot.model.User;
import com.springboot.springboot.service.BoardService;
import com.springboot.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardApiController {

    @Autowired
    private BoardService boardService;


    @PostMapping("/api/board")
    public ResponseDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principal){
        boardService.write(board, principal.getUser());
        // 정상 작동 시 OK 응답이 돌아옴.
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }



}
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
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/api/board/{id}")
    public ResponseDto<Integer> deleteById(@PathVariable int id){
         boardService.deleteList(id);
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }

    @PutMapping("/api/board/{id}")
    public ResponseDto<Integer> update(@PathVariable int id, @RequestBody Board board){
        System.out.print("update id : " + id);
        System.out.print("update board title : " + board.getTitle());
        System.out.print("update board content : " + board.getContent());
        boardService.update(id, board);
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }
}
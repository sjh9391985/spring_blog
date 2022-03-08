package com.springboot.springboot.controller;

import com.springboot.springboot.config.auth.PrincipalDetail;
import com.springboot.springboot.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    //컨트롤러에서 세션을 어떻게 찾는지?
    @GetMapping({"","/"})
    public String index(Model model, @PageableDefault(size=3, sort="id", direction = Sort.Direction.DESC) Pageable pageable){
        model.addAttribute("boards", boardService.writingList(pageable)); //index라는 페이지로 boards item이 넘어갑니다. 해당 index 페이지로 model의 정보를 들고이동합니다.
        // WEB-INF/view/{retrun}.jsp
        return "index"; // return 경우 viewResolver 작동합니다.
    }

    @GetMapping("/board/saveForm")
    public String board(){
        return "/board/saveForm";
    }

    @GetMapping("/board/{id}")
    public String findById(@PathVariable int id, Model model){
        model.addAttribute("board", boardService.detailWriting(id));
        return "board/detail";
    }

    @GetMapping("/board/{id}/updateForm")
    public String updateForm(@PathVariable int id, Model model){
        model.addAttribute("board", boardService.detailWriting(id));

        return "/board/updateForm";
    }
}

package com.springboot.springboot.service;

import com.springboot.springboot.model.Board;
import com.springboot.springboot.model.RoleType;
import com.springboot.springboot.model.User;
import com.springboot.springboot.repository.BoardRepository;
import com.springboot.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Transactional
    // 전체 성공시 commit , 실패시 rollback
    public void write(Board board, User user){ // title, content 2개만 받음
        board.setCount(0);
        board.setUser(user);
        boardRepository.save(board);
    }

    @Transactional(readOnly = true)
    public Page<Board> writingList(Pageable pageable){
        return boardRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Board detailWriting(int id){
        return boardRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("글 상세보기 실패 : 아이디를 찾을 수 없습니다.");
                });
    }

    @Transactional
    public void deleteList(int id){
        boardRepository.deleteById(id);
    }

}

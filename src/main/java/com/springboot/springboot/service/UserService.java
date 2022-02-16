package com.springboot.springboot.service;

import com.springboot.springboot.model.User;
import com.springboot.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    // 전체 성공시 commit , 실패시 rollback
    public void join(User user){
            userRepository.save(user);
    }

//    @Transactional
//    public User login(User user){
//        return userRepository
//    }


}

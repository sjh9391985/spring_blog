package com.springboot.springboot.service;

import com.springboot.springboot.model.User;
import com.springboot.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    // 전체 성공시 commit , 실패시 rollback
    public void join(User user){
            userRepository.save(user);
    }

//    @Transactional(readOnly = true) // select 시 transaction이 시작이 됩니다. 해당 서비스가 종료될 때 까지 정합성을 유지 할 수 있습니다.
//    public User login(User user){
//        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
//    }

}

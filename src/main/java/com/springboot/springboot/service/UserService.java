package com.springboot.springboot.service;

import com.springboot.springboot.model.RoleType;
import com.springboot.springboot.model.User;
import com.springboot.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired // DI 주입이 됩니다.
    private BCryptPasswordEncoder encoder;

    @Transactional
    // 전체 성공시 commit , 실패시 rollback
    public void join(User user){
        String rawPassword = user.getPassword(); // raw 패스워드
        String encPassword = encoder.encode(rawPassword); // hash 화 된 패스워드.
        user.setPassword(encPassword);
        user.setRole(RoleType.USER);
        userRepository.save(user);
    }

//    @Transactional(readOnly = true) // select 시 transaction이 시작이 됩니다. 해당 서비스가 종료될 때 까지 정합성을 유지 할 수 있습니다.
//    public User login(User user){
//        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
//    }

}

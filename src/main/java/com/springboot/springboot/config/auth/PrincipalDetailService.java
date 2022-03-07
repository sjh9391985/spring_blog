package com.springboot.springboot.config.auth;

import com.springboot.springboot.model.User;
import com.springboot.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service // @Service 붙여야지 Bean 등록이 됩니다.
public class PrincipalDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    // spring 로그인 요청을 가로챌때 username, password 변수 2개를 가로채는데, password 처리는 알아서 해줍니다. 해당 username이 DB에 있는지 확인해서 return 해주면됩니다.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User principal = userRepository.findByUsername(username)
                .orElseThrow(()->{
                    return new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다.: " + username);
                });
        return new PrincipalDetail(principal); // 시큐리티 세션에 유저정보가 저장이 됩니다.
    }
}

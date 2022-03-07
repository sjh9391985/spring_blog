package com.springboot.springboot.config.auth;


import com.springboot.springboot.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

// spring security가 로그인 요청을 가로채서 로그인 진행 후 완료가 되면 UserDetails 타입의 오브젝트를 스프링 시큐리티의 고유한 세션 저장소에 저장을 합니다.
// 그때 저장되는것이 PrincipalDetail 입니다.
public class PrincipalDetail implements UserDetails {

    // composition: 객체를 품고 있는것.
    private User user;

    public PrincipalDetail(User user){
        this.user = user;
    }

    // 계정의 password 리턴합니다.
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    // 계정의 username 리턴합니다.
    @Override
    public String getUsername() {
        return user.getUsername();
    }

    // 계정이 만료되지 않았는지 리턴합니다. (true: 만료안됨)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 계정이 잠겨있지 않았는지 리턴합니다. (true: 잠기지 않음)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 비밀번호가 만료되지 않았는지 리턴합니다. (true: 만료안됨)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 계정 활성화가 되어있는지 리턴합니다. (true: 활성화)
    @Override
    public boolean isEnabled() {
        return true;
    }

    // 계정 권한을 리턴합니다. ()
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> collectors = new ArrayList<>();
//        collectors.add(new GrantedAuthority() {
//            @Override
//            public String getAuthority() {
//                return "ROLE_"+user.getRole(); // ROLE_USER
//            }
//        });

        // 위의 식을 lamda 식으로 표현했습니다.
        collectors.add(() -> {
            return "ROLE_"+user.getRole();
        });

        return collectors;
    }
}
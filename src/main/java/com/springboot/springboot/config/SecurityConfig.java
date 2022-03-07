package com.springboot.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration // 빈 등록: 스프링 컨테이너에서 객체를 관리할 수 있게 하는 것입니다.[IOC로 관리를 합니다.]
@EnableWebSecurity // 시큐리티라는 필터를 추가하는 것 입니다. = 스프링 시큐리티가 활성화는 되어 있는 어떤 설정을 해당 파일에서 한다는 뜻 입니다.[시큐리티 필터등록]
@EnableGlobalMethodSecurity(prePostEnabled = true) //특정 주소로 접근을 하면 권한 및 인증을 미리 체크한다는 뜻 입니다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean //IOC 관리가 됩니다.
    public BCryptPasswordEncoder encodePWD(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http    // req 올 경우
                .csrf().disable() //csrf token 비활성화
                .authorizeRequests()
                .antMatchers("/", "/auth/**", "/js/**", "/css/**", "/image/**" )
                .permitAll() // "/auth/**" 의 요청주소로 들어온것은 허가가능
                .anyRequest()
                .authenticated()// 위 주소외에 들어온것은 인증이 필요합니다.
            .and()
                .formLogin()
                .loginPage("/auth/loginForm");
    }
}

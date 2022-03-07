package com.springboot.springboot.config;

import com.springboot.springboot.config.auth.PrincipalDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration // 빈 등록: 스프링 컨테이너에서 객체를 관리할 수 있게 하는 것입니다.[IOC로 관리를 합니다.]
@EnableWebSecurity // 시큐리티라는 필터를 추가하는 것 입니다. = 스프링 시큐리티가 활성화는 되어 있는 어떤 설정을 해당 파일에서 한다는 뜻 입니다.[시큐리티 필터등록]
@EnableGlobalMethodSecurity(prePostEnabled = true) //특정 주소로 접근을 하면 권한 및 인증을 미리 체크한다는 뜻 입니다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PrincipalDetailService principalDetailService;

    @Bean //IOC 관리가 됩니다.
    public BCryptPasswordEncoder encodePWD(){
        return new BCryptPasswordEncoder();
    }

    // 시큐리티가 대신 로그인을 해주는데 password를 가로채기 하는데 해당 password가 어떤것으로 hash가 되어서 회원가입이 되었는지 알아야 같은 hash로 암호화해서 DB에 있는 hash랑 비교할 수 있음.
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
        System.out.println("pwd : " +   auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD()));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http    // req 올 경우
                .csrf().disable() //csrf token 비활성화 (테스트 시)
                .authorizeRequests()
                .antMatchers("/", "/auth/**", "/js/**", "/css/**", "/image/**" )
                .permitAll() // "/auth/**" 의 요청주소로 들어온것은 허가가능
                .anyRequest()
                .authenticated()// 위 주소외에 들어온것은 인증이 필요합니다.
                .and()
                .formLogin().loginPage("/auth/loginForm")
                .loginProcessingUrl("/auth/loginProc") // 해당주소로 spring security가 login을 가로챕니다. 대신 로그인 해줍니다.
                .defaultSuccessUrl("/");
                // .failureUrl("/fail") 로그인 실패시 이동하는 주소


    }
}

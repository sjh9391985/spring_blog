package com.springboot.springboot.test;

import org.springframework.web.bind.annotation.*;

//@Controller : 사용자가 요청 시 HTML 파일을 응답해줌.

@RestController // 사용자가 요청 시 데이터를 응답해주는 어노테이션
public class HttpControllerTest {

    private static final String TAG = "HttpControllerTest : ";

    @GetMapping("http/lombok")
    public String lombokTest(){
        // 모델의 생성자가 빌더 패턴일 경우 넣고 싶은 것만 넣어서 사용가능합니다.
        // 또한 순서를 지킬 필요도 크게 없습니다.
        Member m = Member.builder().id(1).username("ssar").password("1234").build();
        System.out.println(TAG + "getter: " +m.getUsername() );
        m.setUsername("cos");
        System.out.println(TAG + "setter: " +m.getUsername());
        return "lombok test  완료";
    }

    // 인터넷 브라우저 요청은 GET 요청만 할 수 있다, POST, PUT, DELETE는 할 수 없습니다.
    // get 방식은 querystring 방식 사용가능
    // http://localhost:8080/http/get
    @GetMapping("/http/get")
    public String getTest(Member m){
        System.out.println(TAG + "getter" +m.getId() );
        m.setId(5000);
        System.out.println(TAG + "setter" +m.getId());

        return "get request id: " + m.getId() +", get request username: " + m.getUsername() + ", get request email: " + m.getEmail();
    }

    // http://localhost:8080/http/post
    @PostMapping("/http/post") //RequestBody : body로 받는 것은 @RequestBody를 붙여줍니다. [text/plain 으로 보낼경우]
    public String postTest(@RequestBody Member m){
        return "post request id: " + m.getId() +", post request username: " + m.getUsername() + ", post request email: " + m.getEmail();
    }

    // http://localhost:8080/http/put
    @PutMapping("/http/put")
    public String putTest(@RequestBody Member m){
        return "put request id: " + m.getId() +", put request username: " + m.getUsername() + ", put request email: " + m.getEmail();
    }

    // http://localhost:8080/http/delete
    @DeleteMapping("/http/delete")
    public String deleteTest(){
        return "delete request";
    }


}

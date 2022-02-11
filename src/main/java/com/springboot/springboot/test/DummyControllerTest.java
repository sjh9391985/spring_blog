package com.springboot.springboot.test;

import com.springboot.springboot.model.RoleType;
import com.springboot.springboot.model.User;
import com.springboot.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Supplier;

@RestController // data를 return 해주고 있는 controller
public class DummyControllerTest {

    // 의존성 주입(DI)
    @Autowired // DummyControllerTest가 메모리에 뜰 때 UserRepository도 같이 메모리에 뜹니다.
    private UserRepository userRepository;

    // - save() 메소드 특성
    // 1. save 함수는 id를 전달하지 않는 경우, insert를 실행합니다.
    // 2. save 함수는 id를 전달 후 해당 id에 대한 데이터가 있으면 update를 해줍니다.
    // 3. save 함수는 id를 전달 후 해당 id에 대한 데이터가 없으면 insert를 해줍니다.

    @PutMapping("/dummy/user/{id}")                                              // MessageConverter의 Jackson 라이브러리가 변환해서 받아줍니다.
    public User updateUser(@PathVariable int id, @RequestBody User requestUser){ // json 데이터를 요청했는데 spring이 자바 오브젝트로 반환해서 보내줌.

        // password, email 수정
        System.out.println("id: "+id);
        System.out.println("password: "+ requestUser.getPassword());
        System.out.println("email: "+requestUser.getEmail());

        User user = userRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("수정에 실패하였습니다.");
        });

        user.setPassword(requestUser.getPassword());
        user.setEmail(requestUser.getEmail());

        userRepository.save(user);

        return null;

    }

    @GetMapping("/dummy/users")
    public List<User> list(){
        // findAll(): 전체가 리턴이 됩니다.
        return userRepository.findAll();
    }

    //한 페이지당 2건의 데이터를 리턴 받아 볼 예정
    @GetMapping("/dummy/user")                  // 한 페이지당 데이터를 1개씩 가져옵니다. (ex. size = 1)
    public Page<User> pageList(@PageableDefault(size=1, sort="id", direction = Sort.Direction.DESC) Pageable pageable){

        Page<User> users = userRepository.findAll(pageable);

        // List user 를 return 받고 싶을 경우에는
        // List<User> users = userRepository.findAll(pageable).getContent(); <- 수정을 해주면 됩니다.
        // user 정보만 하나씩 받을 경우 List<User> users = users.getContent(); 방법도 있습니다.

        return users;
    }

    // 회원가입 테스트 코드
    @PostMapping("/dummy/join")
    public String join(User user){ //key = value 형태의 데이터를 주고받는 모양입니다.
        System.out.println("username: " + user.getUsername());
        System.out.println("password: " + user.getPassword());
        System.out.println("email: " + user.getEmail());

        user.setRole(RoleType.USER);
        userRepository.save(user); // user 객체를 집어넣기만 하면 회원가입이 이뤄집니다!
        return "회원가입 완료되었습니다.";
    }

    // {id} 주소로 파라미터를 전달 받을 수 있습니다.
    // ex) http:localhost:8000/blog/dummy/user/3
    @GetMapping("/dummy/user/{id}")
    public User detail(@PathVariable int id){

        // 정상적인 Id 넘버를 검색하지 않을 경우에는 orElseGet 구문이 실행되서 빈 객체를 넣어줍니다.
        /*
        User user = userRepository.findById(id).orElseGet(new Supplier<User>() {
            @Override
            public User get() {
                return null;
            }
        });*/
        User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
            @Override
            public IllegalArgumentException get() {
                return new IllegalArgumentException("ID 가 " + id +"인 유저는 없습니다. ");
            }
        });

        // user 객체는 java object
        // 요청: 웹브라우저
        // 변환: (웹브라우저가 이해하기 쉬운 데이터 => JSON DATA)
        // 스프링부트 = MessageConverter 가 응답시에 자동으로 작동합니다.
        // 만약 자바 오브젝트를 return 시 messageConventer가 Jackson 라이브러리를 호출해서 user 오브젝트를 JSON 으로 변환해서 브라우저에게 던져줍니다.
        return user;

    }

}

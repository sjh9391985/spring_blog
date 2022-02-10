package com.springboot.springboot.test;

import lombok.*;

// 모델을 만들 경우 변수는 Private로 작성해야합니다. set/get 메소드를 통해서 접근을 해야 합니다.
// - @Getter
// - @Setter
// - @Data: Getter와 Setter를 만들고 싶으면 @Data 를 사용해주면 됩니다.
// - @AllArgsConstructor: 생성자를 만들고 싶을 경우에 사용하는 어노테이션입니다.
// - @RequiredArgsConstructor: final 붙은 변수에 대한 constructor를 만들어 줍니다.
@Data
// @AllArgsConstructor // 전체 생성자
@NoArgsConstructor // 빈 생성자
public class Member {
    private int id;
    private String username;
    private String password;
    private String email;

    @Builder // 빌더패턴을 사용할 경우 넣고 싶은 것만 사용가능합니다.
    public Member(int id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    //
//    public Member(int id, String username, String password, String email) {
//        this.id = id;
//        this.username = username;
//        this.password = password;
//        this.email = email;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
}

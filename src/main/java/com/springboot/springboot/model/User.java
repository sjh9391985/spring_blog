package com.springboot.springboot.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
// ORM 은 Object를 테이블로 매핑해주는 역할을 합니다.
@Entity // User model 이 스프링 부트 프로젝트가 실행될 때 읽어서 자동으로 mysql에 테이블이 생성됩니다.
public class User {

    // Long type 은 많은 유저가 있을 경우 사용.
    @Id // primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 해당 프로젝트에서 연결된 데이터베이스의 넘버링 전략을 따라갑니다.
    private Long id; // 시퀀스, auto-increment

    @Column(nullable = false, length = 30)
    private String username;

    @Column(nullable = false, length = 100) // 암호화 된 비밀번호를 데이터베이스에 넣기 위해서 길게 잡는다.
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

    @ColumnDefault("'user'")
    private String role; //Enum을 쓰는게 좋다. admin, user, manager 을 통해 권한을 준다.

    @CreationTimestamp // 시간이 자동 입력
    private Timestamp createDate;

}

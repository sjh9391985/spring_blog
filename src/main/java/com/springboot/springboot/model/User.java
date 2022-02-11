package com.springboot.springboot.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
// ORM 은 Object를 테이블로 매핑해주는 역할을 합니다.
@Entity // User model 이 스프링 부트 프로젝트가 실행될 때 읽어서 자동으로 mysql에 테이블이 생성됩니다.
//@DynamicInsert Insert 시 null 인 값들은 제외시켜서 INSERT 시켜줍니다.
public class User {

    // Long type 은 많은 유저가 있을 경우 사용.
    @Id // primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 해당 프로젝트에서 연결된 데이터베이스의 넘버링 전략을 따라갑니다.
    private int id; // 시퀀스, auto-increment

    @Column(nullable = false, length = 30, unique = true)
    private String username; //중복된 username이 들어가서는 안됩니다.[unique한 value 여야한다?...-> 사용자 이름은 중복이 될 수 있지 않을까?]

    @Column(nullable = false, length = 100) // 암호화 된 비밀번호를 데이터베이스에 넣기 위해서 길게 잡는다.
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

    //@ColumnDefault("'user'")
    @Enumerated(EnumType.STRING) // DB는 ROLETYPE란게 없으므로 해당 타입이 String 이란것을 명시해줘야한다.
    private RoleType role; //Enum을 쓰는게 좋다. ADMIN, USER, MANAGER 을 통해 권한을 준다.

    @CreationTimestamp // 시간이 자동 입력
    private Timestamp createDate;

}

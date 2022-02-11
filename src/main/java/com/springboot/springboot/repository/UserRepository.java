package com.springboot.springboot.repository;

import com.springboot.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


// DAO
// 자동으로 bean 등록이 가능합니다. @Repository를 생략 가능합니다.
// 상속받은 해당 JPARepository는 User table을 관리해주며, User table의 pk는 Integer 입니다.
public interface UserRepository extends JpaRepository<User, Integer> {}

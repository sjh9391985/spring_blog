package com.springboot.springboot.repository;

import com.springboot.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


// DAO
// 자동으로 bean 등록이 가능합니다. @Repository를 생략 가능합니다.
// 상속받은 해당 JPARepository는 User table을 관리해주며, User table의 pk는 Integer 입니다.
public interface UserRepository extends JpaRepository<User, Integer> {

    // JPA Naming 전략
    // SELECT * FROM user WHERE username = ? AND password =?; 쿼리가 실행이 됩니다.
    User findByUsernameAndPassword(String username, String password);

    // native query를 사용가능합니다.
    // @Query(value="SELECT * FROM user WHERE username=?1 AND password=?2", nativeQuery = true)
    // User login(String username, String password)

}

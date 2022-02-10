package com.springboot.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Reply {

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라 갑니다.
    private int id; //Auto_increment;

    @Column(nullable = false, length = 200)
    private String content;

    // 하나의 게시글에 여러개의 답변을 달 수 있습니다. // OneToOne 일 경우 하나의 게시글에 하나의 답변만 달 수 있습니다...
    @ManyToOne
    @JoinColumn(name="boardId")
    private Board board;

    // 하나의 유저는 여러개의 답변을 가질 수 있습니다.
    @ManyToOne // 여러개의 답변을 하나의 유저가 가질 수 있습니다.
    @JoinColumn(name="userId")
    private User user;

    @CreationTimestamp
    private Timestamp createDate;
}

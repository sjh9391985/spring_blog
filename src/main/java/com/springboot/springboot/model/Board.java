package com.springboot.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity // 데이터 매핑 어노테이션을 명시되게 해주는 것이 좋다.
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob
    private String content; // summen note 라이브러리 사용

    @ColumnDefault("0")
    private int count; // 조회수

    @ManyToOne(fetch = FetchType.EAGER) // Board가 many, One은 user를 의미합니다. 하나의 사용자가 여러개의 게시글을 사용할 수 있음.
    @JoinColumn(name="userId")
    private User user;

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY) // 하나의 게시글은 여러개의 답변을 가집니다. mappedBy가 있다면 연관관계의 주인이 아닙니다.(foreign key가 아닙니다.)
    private List<Reply> reply;

    @CreationTimestamp
    private Timestamp createDate;

}
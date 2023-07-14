package com.sparta.bucketlistproj.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//git hub test
@Entity
@Getter
@Setter
@Table(name = "bucket")
@NoArgsConstructor
public class Bucket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "content", nullable = false)
    private String content;
    @Column(name = "image_url", nullable = false)
    private String imageurl;
    @Column(name = "finish_check", nullable = false)
    private boolean finishCheck;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="author")
    private User user;

}

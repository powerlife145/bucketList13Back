package com.sparta.bucketlistproj.entity;


import com.sparta.bucketlistproj.dto.BucketRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

//    @Column(name = "image_url", nullable = false)
//    private String imageurl;

    @Column(name = "finish_check", nullable = false)
    private Boolean finishCheck;

    public Bucket(BucketRequestDto bucketRequestDto) {
        this.content = bucketRequestDto.getContent();
        this.finishCheck=bucketRequestDto.getFinish_check();
    }
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="author")
//    private User user;

}

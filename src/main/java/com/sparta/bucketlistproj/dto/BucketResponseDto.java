package com.sparta.bucketlistproj.dto;

import com.sparta.bucketlistproj.entity.Bucket;
import lombok.Getter;
import org.springframework.data.jpa.repository.JpaRepository;

@Getter
public class BucketResponseDto {
    private Long id;
    private String content;
    private Boolean finish_check;


    public BucketResponseDto(Bucket bucket){
        this.id=bucket.getId();
        this.content=bucket.getContent();
        this.finish_check=bucket.getFinishCheck();
    }
}

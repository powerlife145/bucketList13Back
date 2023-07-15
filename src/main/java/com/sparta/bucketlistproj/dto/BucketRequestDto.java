package com.sparta.bucketlistproj.dto;

import lombok.Getter;

@Getter
public class BucketRequestDto {
    private Long id;
    private String content;
    private Boolean finish_check;
}

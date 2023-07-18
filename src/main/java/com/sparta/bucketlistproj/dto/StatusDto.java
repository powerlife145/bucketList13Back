package com.sparta.bucketlistproj.dto;

import lombok.Getter;

@Getter
public class StatusDto {
    private String msg;
    private int statusCode;

    public StatusDto(String msg, int statusCode){
        this.msg=msg;
        this.statusCode=statusCode;
    }
}

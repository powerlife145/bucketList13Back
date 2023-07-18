package com.sparta.bucketlistproj.dto;

import lombok.Getter;

@Getter
public class ErrorDto {
    private String errorMessage;
    private int errorCode;

    public ErrorDto(String errorMessage, int errorCode){
        this.errorMessage=errorMessage;
        this.errorCode=errorCode;
    }
}

package com.sparta.bucketlistproj.controller;


import com.sparta.bucketlistproj.dto.BucketRequestDto;
import com.sparta.bucketlistproj.dto.BucketResponseDto;
import com.sparta.bucketlistproj.service.BucketService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BucketController {

    private final BucketService BucketService;

    @PostMapping("/post")
    public ResponseEntity<?> createSale(@RequestBody BucketRequestDto BucketRequestDto){
        return BucketService.createBucket(BucketRequestDto);
    }



    //추가 테스트용입니다.
    @GetMapping("/post/test")
    public ResponseEntity<?> getBucketTest(){
        return BucketService.getBucket();
    }

    @GetMapping("/post")
    public ResponseEntity<?> getBucket(){
        return  BucketService.getBucket();
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<?> getBucketById(@PathVariable Long id){
        return BucketService.getBucketById(id);
    }

    //수정
//    @PutMapping("/post/{id}")
//    public Long updateBucket(@PathVariable Long id, @RequestBody BucketRequestDto BucketRequestDto){
//        return BucketService.updatdBucket(id, bucketRequestDto);
//    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity<?> deleteBucket(@PathVariable Long id){
        return BucketService.deleteBucket(id);
    }

}

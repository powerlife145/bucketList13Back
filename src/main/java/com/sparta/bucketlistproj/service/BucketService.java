package com.sparta.bucketlistproj.service;

import com.sparta.bucketlistproj.dto.BucketRequestDto;
import com.sparta.bucketlistproj.dto.BucketResponseDto;
import com.sparta.bucketlistproj.entity.Bucket;
import com.sparta.bucketlistproj.repository.BucketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ssl.SslBundleKey;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BucketService {

    private final BucketRepository bucketRepository;

    @Autowired
    public BucketService(BucketRepository bucketRepository) {
        this.bucketRepository = bucketRepository;
    }


    //버킷 작성 저장
    public BucketResponseDto createBucket(BucketRequestDto bucketRequestDto) {
        Bucket bucket = new Bucket(bucketRequestDto);
        Bucket saveBucket = bucketRepository.save(bucket);
        BucketResponseDto bucketResponseDto = new BucketResponseDto(saveBucket);
        return bucketResponseDto;

//        if(!saveBucket.getContent().isEmpty()){
//        }else
//
//
    }

    //전체 조회
    public List<BucketResponseDto> getBucket() {
        return bucketRepository.findAllByOrderById().stream().map(BucketResponseDto::new).toList();
    }

    //선택 조회
    public BucketResponseDto getBucketById(Long id) {
        Bucket bucket = bucketRepository.findById(id).orElseThrow(()->new IllegalArgumentException("버킷 없음"));
        return new BucketResponseDto(bucket);
    }


    //버킷 삭제
    public Long deleteBucket(Long id) {
        Bucket bucket = findBucket(id);
        bucketRepository.delete(bucket);
        return id;
    }

    private Bucket findBucket(Long id) {
        return bucketRepository.findById(id).orElseThrow(()->new IllegalArgumentException("버킷 없음"));
    }
}

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

    public BucketResponseDto createBucket(BucketRequestDto bucketRequestDto) {
        Bucket bucket = new Bucket(bucketRequestDto);
        Bucket saveBucket = bucketRepository.save(bucket);

        BucketResponseDto bucketResponseDto = new BucketResponseDto(saveBucket);
        return bucketResponseDto;
    }

    public List<BucketResponseDto> getBucket() {
        return bucketRepository.findAllByOrderById().stream().map(BucketResponseDto::new).toList();
    }

    public BucketResponseDto getBucketById(Long id) {
        Bucket bucket = bucketRepository.findById(id).orElseThrow(()->new IllegalArgumentException("버킷 없음"));
        return new BucketResponseDto(bucket);
    }


    public Long deleteBucket(Long id) {
        Bucket bucket = findBucket(id);
        bucketRepository.delete(bucket);
        return id;
    }

    private Bucket findBucket(Long id) {
        return bucketRepository.findById(id).orElseThrow(()->new IllegalArgumentException("버킷 없음"));
    }
}

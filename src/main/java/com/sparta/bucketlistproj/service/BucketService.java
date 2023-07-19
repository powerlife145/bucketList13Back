package com.sparta.bucketlistproj.service;

import com.sparta.bucketlistproj.dto.BucketRequestDto;
import com.sparta.bucketlistproj.dto.BucketResponseDto;
import com.sparta.bucketlistproj.dto.ErrorDto;
import com.sparta.bucketlistproj.dto.StatusDto;
import com.sparta.bucketlistproj.entity.Bucket;
import com.sparta.bucketlistproj.repository.BucketRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BucketService {

    private final BucketRepository bucketRepository;

    @Autowired
    public BucketService(BucketRepository bucketRepository) {
        this.bucketRepository = bucketRepository;
    }


    //버킷 작성 저장
    public ResponseEntity<?> createBucket(BucketRequestDto bucketRequestDto) {
        Bucket bucket = new Bucket(bucketRequestDto);
        Bucket saveBucket = bucketRepository.save(bucket);

        if(saveBucket.getContent().isEmpty()){
            ErrorDto errorDto = new ErrorDto("No content found", HttpStatus.BAD_REQUEST.value());
            return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
        }
        else {
            BucketResponseDto bucketResponseDto = new BucketResponseDto(saveBucket);
            return new ResponseEntity<>(bucketResponseDto, HttpStatus.OK);
        }
    }

    //전체 조회
    public ResponseEntity<?> getBucket() {
        List<BucketResponseDto> buckets =bucketRepository.findAllByOrderById().stream().map(BucketResponseDto::new).toList();
        if(buckets.isEmpty()){
            ErrorDto errorDto = new ErrorDto("Bad Request",HttpStatus.BAD_REQUEST.value());
            return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
        }
        Map<String, Object> response = new HashMap<>();
        response.put("postList", buckets);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    //선택 조회
    public ResponseEntity<?> getBucketById(Long id) {
        Optional<Bucket> bucket = bucketRepository.findById(id);
        if(!bucket.isPresent()){
            ErrorDto errorDto = new ErrorDto("Not post found with id"+id , HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
        }
        BucketResponseDto bucketResponseDto = new BucketResponseDto(bucket.get());
        return new ResponseEntity<>(bucketResponseDto, HttpStatus.OK);
    }


    //버킷 삭제
    public ResponseEntity<?> deleteBucket(Long id) {
        try {
            Bucket bucket =bucketRepository.findById(id).orElseThrow(()->new IllegalArgumentException("게시글이 없음."));
            bucketRepository.delete(bucket);
            StatusDto statusDto = new StatusDto("게시글 삭제 성공", HttpStatus.OK.value());
            return new ResponseEntity<>(statusDto, HttpStatus.OK);
        }catch (IllegalArgumentException e){
            ErrorDto errorDto = new ErrorDto("Not post found with id"+id , HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
        }
    }

    private Bucket findBucket(Long id) {
        return bucketRepository.findById(id).orElseThrow(()->new IllegalArgumentException("버킷 없음"));
    }
}

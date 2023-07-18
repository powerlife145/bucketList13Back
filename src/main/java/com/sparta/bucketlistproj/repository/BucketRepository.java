package com.sparta.bucketlistproj.repository;

import com.sparta.bucketlistproj.entity.Bucket;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BucketRepository extends JpaRepository<Bucket, Long> {
    List<Bucket> findAllByOrderById();
}

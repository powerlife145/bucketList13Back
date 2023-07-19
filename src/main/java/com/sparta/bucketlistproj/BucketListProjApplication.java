package com.sparta.bucketlistproj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
public class BucketListProjApplication {
	public static void main(String[] args) {
		SpringApplication.run(BucketListProjApplication.class, args);
	}
}

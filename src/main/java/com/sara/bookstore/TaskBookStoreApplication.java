package com.sara.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TaskBookStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskBookStoreApplication.class, args);
    }

}

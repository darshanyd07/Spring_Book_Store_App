package com.example.spring_book_store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBookStoreApplication {

    public static void main(String[] args) {
        System.out.println("------------ Welcome In Book Store -----------");
        SpringApplication.run(SpringBookStoreApplication.class, args);
    }

}

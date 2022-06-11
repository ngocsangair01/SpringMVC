package com.example.buoi3;

import com.github.slugify.Slugify;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Buoi3Application {

    @Bean
    public Slugify slugify(){
        return new Slugify();
    }
    public static void main(String[] args) {
        SpringApplication.run(Buoi3Application.class, args);
    }

}

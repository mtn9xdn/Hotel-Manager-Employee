package com.hotelmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableJpaRepositories(basePackages ="com.hotelmanager.repository")
@EnableSpringDataWebSupport
@EnableJpaAuditing
@SpringBootApplication
public class HotelManagerApplication implements WebMvcConfigurer {
    public static void main(String[] args) {
        SpringApplication.run(HotelManagerApplication.class, args);
    }
}

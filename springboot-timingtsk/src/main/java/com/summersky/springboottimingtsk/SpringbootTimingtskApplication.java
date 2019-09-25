package com.summersky.springboottimingtsk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringbootTimingtskApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTimingtskApplication.class, args);
    }

}

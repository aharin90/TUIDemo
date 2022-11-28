package com.example.tuidemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class TuiDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TuiDemoApplication.class, args);

//        String ssss ??= String.format("user with username '%s' - Not found", "ssss");
//        System.out.println(ssss);
    }
}

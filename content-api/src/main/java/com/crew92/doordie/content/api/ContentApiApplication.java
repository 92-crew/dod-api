package com.crew92.doordie.content.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ContentApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContentApiApplication.class, args);
    }

}

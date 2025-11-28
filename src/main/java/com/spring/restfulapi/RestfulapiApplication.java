package com.spring.restfulapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestfulapiApplication {

	public static void main(String[] args) {

        SpringApplication.run(RestfulapiApplication.class, args);
	}

    @Bean
    @Scope
    RestTemplate createTemplate(){
        return  new RestTemplate();
    }
}
